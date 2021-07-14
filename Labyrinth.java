
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth {

	public static class pair {

		int r = 0;
		int c = 0;
		String path = "";
		int len = 0;

		pair(int r, int c, String path, int len) {

			this.r = r;
			this.c = c;
			this.path = path;
			this.len = 0;
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] grid = new String[n][m];
		int r = 0;
		int c = 0;
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String input = sc.next();
			String[] row = input.split("");
			for (int j = 0; j < m; j++) {
				grid[i][j] = row[j];
				arr[i][j] = Integer.MAX_VALUE;
				if (row[j].equals("A")) {
					r = i;
					c = j;
					arr[i][j] = 0;
				}
			}
		}

		Queue<pair> q = new LinkedList<>();

		pair start = new pair(r, c, "", 0);

		q.add(start);

		boolean[][] b = new boolean[n][m];
		boolean f = false;
		int length = Integer.MAX_VALUE;
		String fPath = "";
		b[r][c] = true;

		while (!q.isEmpty()) {

			pair curr = q.poll();
			int[] opr = { 1, -1, 0, 0 };
			int[] opc = { 0, 0, 1, -1 };

			if (grid[curr.r][curr.c].equals("B") && curr.len < length) {
				f = true;
				length = curr.path.length();
				fPath = curr.path;
			}

			for (int i = 0; i < 4; i++) {

				if (curr.r + opr[i] > n - 1 || curr.c + opc[i] > m - 1 || curr.c + opc[i] < 0 || curr.r + opr[i] < 0) {
					continue;
				}
				if (grid[curr.r + opr[i]][curr.c + opc[i]].equals("#")) {

					arr[curr.r + opr[i]][curr.c + opc[i]] = Integer.MAX_VALUE;

				} else if (arr[curr.r + opr[i]][curr.c + opc[i]] > arr[r][c] + 1) {

					arr[curr.r + opr[i]][curr.c + opc[i]] = arr[r][c] + 1;
					b[curr.r + opr[i]][curr.c + opc[i]] = true;

					if (opr[i] == 1 && opc[i] == 0) {

						pair newcurr = new pair(curr.r + opr[i], curr.c + opc[i], curr.path + "D", curr.len + 1);
						q.add(newcurr);

					} else if (opr[i] == -1 && opc[i] == 0) {

						pair newcurr = new pair(curr.r + opr[i], curr.c + opc[i], curr.path + "U", curr.len + 1);
						q.add(newcurr);

					} else if (opr[i] == 0 && opc[i] == 1) {

						pair newcurr = new pair(curr.r + opr[i], curr.c + opc[i], curr.path + "R", curr.len + 1);
						q.add(newcurr);

					} else {

						pair newcurr = new pair(curr.r + opr[i], curr.c + opc[i], curr.path + "L", curr.len + 1);
						q.add(newcurr);

					}

				}

			}

		}

		System.out.println(f ? "YES" : "NO");
		System.out.println(f ? length : "");
		System.out.println(fPath);

	}

}
