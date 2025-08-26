import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] people;          
    static List<Integer>[] adj;   
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        people = new int[N+1]; 
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int to = Integer.parseInt(st.nextToken());
                adj[i].add(to); 
            }
        }

        for (int mask = 1; mask < (1<<N)-1; mask++) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();

            for (int j = 1; j <= N; j++) {
                if ((mask & (1 << (j-1))) != 0) groupA.add(j); 
                else groupB.add(j);
            }

            if (isConnected(groupA) && isConnected(groupB)) {
                int popA = getPopulation(groupA);
                int popB = getPopulation(groupB);
                minDiff = Math.min(minDiff, Math.abs(popA - popB));
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;

        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(group.get(0));
        visited[group.get(0)] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    cnt++;
                    q.add(next);
                }
            }
        }
        return cnt == group.size();
    }

    static int getPopulation(List<Integer> group) {
        int sum = 0;
        for (int g : group) sum += people[g];
        return sum;
    }
}
