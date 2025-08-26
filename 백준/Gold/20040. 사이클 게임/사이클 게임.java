import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        int result = 0; 
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) { 
                result = i;
                break;
            }
        }

        System.out.println(result); 
    }

    public static int find(int a) {
        if (p[a] == a) return a;
        return p[a] = find(p[a]);
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false; 

        p[pa] = pb;
        return true;
    }
}
