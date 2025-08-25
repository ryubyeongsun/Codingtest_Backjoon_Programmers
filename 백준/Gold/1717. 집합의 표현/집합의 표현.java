import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int p[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        p = new int[n+1];
        for(int i=1; i<=n; i++){
            p[i] = i;
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                union(a, b);
            }else if(op == 1){
                int pa = find(a);
                int pb = find(b);

                if(pa == pb){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            } 

        }

    }
    public static int find(int a){
        if(p[a]==a) return a;
        else{
            return p[a] = find(p[a]);
        }


    }
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        p[pa] = pb;

    }
}
