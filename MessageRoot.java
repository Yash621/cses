import java.util.ArrayList;
import java.util.Scanner;

public class MessageRoot {

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

		ArrayList<Integer> path = new ArrayList<>();

		dfs(b, g, n, 1, "", 0);

		if (min == Integer.MAX_VALUE) {
			System.out.println("IMPOSSIBLE");
		} else {

			System.out.println(min + 1);
			System.out.println(pat + n);
		}

	}

	public static int min = Integer.MAX_VALUE;
	public static String pat = "";

	public static void dfs(boolean[] b, ArrayList<ArrayList<Integer>> g, int n, int node, String path, int len) {

		b[node] = true;

		if (len < min && node == n) {
			b[node] = false;
			min = len;
			pat = path;
			return;
		}

		for (int j = 0; j < g.get(node).size(); j++) {

			if (!b[g.get(node).get(j)]) {

				dfs(b, g, n, g.get(node).get(j), path + node + " ", len + 1);
			}

		}

		b[node] = false;
	}

}
