
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Monsters {

	static class pair {

		int i;
		int j;

		pair(int i, int j) {
			this.i = i;
			this.j = j;

		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		String[] x = new String[5];
		String[][] grid = new String[n][m];
		ArrayList<pair> monsters = new ArrayList<>();
		pair player = new pair(0, 0);

		for (int i = 0; i < n; i++) {
			String path = sc.next();
			String[] pathtiles = path.split("");
			for (int j = 0; j < m; j++) {
				if (pathtiles[j].equals("M")) {
					monsters.add(new pair(i, j));
				}
				if (pathtiles[j].equals("A")) {
					player.i = i;
					player.j = j;
				}
				grid[i][j] = pathtiles[j];
			}
		}
		if (player.i == 0 || player.i == n - 1 || player.j == 0 || player.j == m - 1) {

			System.out.println("YES");
			System.out.println("0");

		} else {

			pair[][] dist = new pair[n][m];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					dist[i][j] = new pair(Integer.MAX_VALUE, 0);
				}
			}

			boolean[][] v = new boolean[n][m];

			for (int i = 0; i < monsters.size(); i++) {
				dist[monsters.get(i).i][monsters.get(i).j].i = 0;
				dist[monsters.get(i).i][monsters.get(i).j].j = 0;
				v[monsters.get(i).i][monsters.get(i).j] = true;
				bfs(monsters.get(i), dist, v, n, m, grid, player, false);
				for (int j = 0; j < n; j++) {
					Arrays.fill(v[j], false);
				}

			}

			dist[player.i][player.j].i = 0;
			dist[player.i][player.j].j = 0;
			v[player.i][player.j] = true;
			bfs(player, dist, v, n, m, grid, player, true);

			boolean[][] vis = new boolean[n][m];

			path(v, player.i, player.j, n, m, "", vis);

			if (p.equals("")) {

				System.out.println("NO");

			} else {

				System.out.println("YES");
				System.out.println(p.length());
				System.out.println(p);

			}
		}
	}

	public static String p = "";

	public static void bfs(pair source, pair[][] dist, boolean[][] v, int n, int m, String[][] grid, pair player,
			boolean z) {

		Queue<pair> q = new LinkedList<>();

		q.add(source);

		int[] r = { -1, 1, 0, 0 };
		int[] c = { 0, 0, -1, 1 };

		while (!q.isEmpty()) {

			pair s = q.poll();

			for (int i = 0; i < 4; i++) {

				if (!z) {

					if (s.i + r[i] > -1 && s.i + r[i] < n && s.j + c[i] > -1 && s.j + c[i] < m
							&& !grid[s.i + r[i]][s.j + c[i]].equals("#") && !v[s.i + r[i]][s.j + c[i]]
							&& !grid[s.i + r[i]][s.j + c[i]].equals("M")) {

						dist[s.i + r[i]][s.j + c[i]] = new pair(
								Math.min(dist[s.i + r[i]][s.j + c[i]].i, dist[s.i][s.j].j + 1), dist[s.i][s.j].j + 1);

						q.add(new pair(s.i + r[i], s.j + c[i]));
						v[s.i + r[i]][s.j + c[i]] = true;

					}
				} else {

					if (s.i + r[i] > -1 && s.i + r[i] < n && s.j + c[i] > -1 && s.j + c[i] < m
							&& !grid[s.i + r[i]][s.j + c[i]].equals("#") && !v[s.i + r[i]][s.j + c[i]]

							&& dist[s.i + r[i]][s.j + c[i]].i > dist[s.i][s.j].j + 1) {
						dist[s.i + r[i]][s.j + c[i]].i = dist[s.i][s.j].j + 1;
						dist[s.i + r[i]][s.j + c[i]].j = dist[s.i][s.j].j + 1;
						q.add(new pair(s.i + r[i], s.j + c[i]));
						v[s.i + r[i]][s.j + c[i]] = true;

					}

				}

			}

		}

	}

	public static void path(boolean[][] v, int r, int c, int n, int m, String pat, boolean[][] vis) {

		if (r < 0 || c < 0 || r > n - 1 || c > m - 1 || vis[r][c] || !v[r][c]) {

			return;

		}
		vis[r][c] = true;

		if ((r == 0 || r == n - 1 || c == 0 || c == m - 1) && v[r][c] == true) {

			p = pat;
			return;
		}

		path(v, r + 1, c, n, m, pat + "D", vis);
		path(v, r, c + 1, n, m, pat + "R", vis);
		path(v, r - 1, c, n, m, pat + "U", vis);
		path(v, r, c - 1, n, m, pat + "L", vis);

	}

}
