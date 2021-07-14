
import java.util.ArrayList;

import java.util.Scanner;

public class RoundTrip {

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
		boolean x = false;
		for (int i = 1; i < n + 1; i++) {

			if (!b[i]) {

				x = dfs(g, b, i + "", i, 0, i, 1);
				b[i] = true;

				if (x) {

					break;

				}

			}

		}

		if (x) {

			System.out.println(pathn);
			System.out.println(s);

		} else {

			System.out.println("IMPOSSIBLE");
		}

	}

	public static String s = "";
	public static int pathn = 0;

	public static boolean dfs(ArrayList<ArrayList<Integer>> g, boolean[] v, String path, int node, int p, int root,
			int nodes) {

		if (node != root) {

			v[node] = true;

		}

		boolean x = false;

		for (int i = 0; i < g.get(node).size(); i++) {

			if (node == root && nodes > 2 && g.get(node).get(i) != p) {

				s = path;
				pathn = nodes;

				return true;

			} else if (g.get(node).get(i) != p) {

				if (!v[g.get(node).get(i)]) {
					x = dfs(g, v, path + " " + g.get(node).get(i), g.get(node).get(i), node, root, nodes + 1);
				}

				if (x == true) {

					return true;
				}

			}

		}

		if (node != root) {

			v[node] = false;

		}

		return x;

	}

}
