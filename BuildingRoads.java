
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {

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

		for (int i = 1; i <= n; i++) {

			if (b[i] == false) {
				path.add(i);
				count++;
				dfs(b, g, n, i);

			}

		}

		System.out.println(count - 1);

		for (int i = 0; i < path.size() - 1; i++) {

			System.out.println(path.get(i) + " " + path.get(i + 1));

		}

	}

	public static void dfs(boolean[] b, ArrayList<ArrayList<Integer>> g, int n, int node) {

		b[node] = true;

		for (int j = 0; j < g.get(node).size(); j++) {

			if (!b[g.get(node).get(j)]) {
				dfs(b, g, n, g.get(node).get(j));
			}

		}

	}

}
