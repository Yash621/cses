import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BuildingTeams {

	public static class pair {

		int a;
		int b;

		pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		pair[] arr = new pair[m];

		for (int i = 0; i < m; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();

			arr[i] = new pair(a, b);
		}

		boolean[] b = new boolean[n + 1];
		int count = 0;
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= n; i++) {
			ArrayList<Integer> adj1 = new ArrayList<>();
			g.add(adj1);
		}

		for (pair i : arr) {

			g.get(i.a).add(i.b);
			g.get(i.b).add(i.a);
		}

		Queue<pair> q = new LinkedList<>();

		int[] counter = new int[n + 1];
		boolean flag = false;
		boolean[] visited = new boolean[n + 1];
		int[] p = new int[n + 1];
		Arrays.fill(p, -1);

		for (int j = 1; j < n + 1; j++) {

			if (flag) {
				break;
			}

			if (!visited[j]) {

				q.add(new pair(j, 0));
				visited[j] = true;
				p[j] = 1;

				while (!q.isEmpty()) {

					if (flag) {
						break;
					}

					pair node = q.poll();

					for (int i = 0; i < g.get(node.a).size(); i++) {

						if (p[g.get(node.a).get(i)] == -1) {

							p[g.get(node.a).get(i)] = (p[node.a] == 1) ? 2 : 1;
							q.add(new pair(g.get(node.a).get(i), 0));
							visited[g.get(node.a).get(i)] = true;

						} else if (p[g.get(node.a).get(i)] == p[node.a]) {

							flag = true;
							break;

						}

					}
				}

			}
		}

		if (flag == true) {

			System.out.println("IMPOSSIBLE");
			for (int i = 1; i < n + 1; i++) {
				System.out.print(p[i] + " ");
			}

		} else {

			for (int i = 1; i < n + 1; i++) {
				System.out.print(p[i] + " ");
			}

		}

	}

}
