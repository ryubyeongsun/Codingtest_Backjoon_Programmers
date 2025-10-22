import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static ArrayList<Integer>[] list;
    static boolean[] visit, fn; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            list = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }

            visit = new boolean[N + 1];
            fn = new boolean[N + 1]; 
            count = 0;

            for (int i = 1; i <= N; i++) {
                if (!fn[i]) dfs(i);
            }

            System.out.println(N - count);
        }
    }

    public static void dfs(int x) {
        visit[x] = true;
        int next = list[x].get(0); 

        if (!visit[next]) {
            dfs(next);
        } else if (!fn[next]) {
            count++;
            for (int i = next; i != x; i = list[i].get(0)) {
                count++;
            }
        }

        fn[x] = true; 
    }
}
