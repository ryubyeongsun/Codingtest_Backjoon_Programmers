import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> list[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    list[i].add(j);
                }
            }
        }

        int arrive[] = new int[M+1];

        visit = new boolean[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            arrive[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arrive[1]);

        boolean chk = true;

        for(int i=1; i<=M; i++){
            if(!visit[arrive[i]]){
                chk=false;
                break;
            }
        }

        System.out.println(chk ? "YES" : "NO");

    }
    
    public static void dfs(int start){
        visit[start] = true;

        for(int n : list[start]){
            if(!visit[n]){
                dfs(n);
            }
        }

    }
}
