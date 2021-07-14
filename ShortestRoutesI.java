
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestRoutesI {

	static class pair {

		int s;
		int d;
		int w;

		pair(int s, int d, int w) {

			this.s = s;
			this.d = d;
			this.w = w;

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		ArrayList<ArrayList<pair>> graph = new ArrayList<ArrayList<pair>>();

		for (int i = 0; i <= n; i++) {
			ArrayList<pair> adj1 = new ArrayList<>();
			graph.add(adj1);
		}

		for (int i = 0; i < m; i++) {

			int s = sc.nextInt();
			int d = sc.nextInt();
			int w = sc.nextInt();
			graph.get(s).add(new pair(s, d, w));
		}

		int[] dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[1] = 0;
		boolean[] vis = new boolean[n + 1];
		Arrays.fill(vis, false);
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();

		p.add(1);

		while (p.size() != 0) {

			int src = p.poll();

			for (int i = 0; i < graph.get(src).size(); i++) {

				if (dis[graph.get(src).get(i).d] > dis[src] + graph.get(src).get(i).w) {

					dis[graph.get(src).get(i).d] = Math.min(dis[graph.get(src).get(i).d],
							dis[src] + graph.get(src).get(i).w);
					p.add((graph.get(src).get(i).d));
				}

			}

		}
		for (int i = 1; i <= n; i++) {
			System.out.println(dis[i]);
		}

	}

}
