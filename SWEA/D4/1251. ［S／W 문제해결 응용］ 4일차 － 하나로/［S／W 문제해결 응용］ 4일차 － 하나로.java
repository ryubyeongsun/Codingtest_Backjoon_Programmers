import java.io.*;
import java.util.*;

public class Solution {
    static int[] p;
    
    static class Edge implements Comparable<Edge> {
        int from, to;
        long cost;

        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] x = new int[N];
            int[] y = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) x[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) y[i] = Integer.parseInt(st.nextToken());

            double E = Double.parseDouble(br.readLine());

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    long dist = (long)(x[i]-x[j])*(x[i]-x[j]) + (long)(y[i]-y[j])*(y[i]-y[j]);
                    edges.add(new Edge(i, j, dist));
                }
            }

            Collections.sort(edges);

            p = new int[N];
            for (int i = 0; i < N; i++) p[i] = i;

            long sum = 0;
            int cnt = 0;
            for (Edge e : edges) {
                if (union(e.from, e.to)) {
                    sum += e.cost;
                    if (++cnt == N-1) break;
                }
            }

            long result = Math.round(sum * E); 
            System.out.println("#" + tc + " " + result);
        }
    }

    static int find(int a) {
        if (p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    static boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        p[pa] = pb;
        return true;
    }
}
