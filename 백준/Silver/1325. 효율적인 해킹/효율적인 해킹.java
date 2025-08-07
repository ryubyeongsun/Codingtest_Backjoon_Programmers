import java.util.*;
import java.io.*;

class Main{
    static ArrayList<Integer>[] list;
    static boolean [] visit;
    static int count;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i=1; i<=N; i++){
            visit = new boolean[N + 1];
            count = 0;
            dfs(i);
            result.add(count);
        }

        int max = 0;
        for(int i=0; i<N; i++){
            if(max<result.get(i)){
                max = result.get(i);
            }
        }

        ArrayList<Integer> print = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(max==result.get(i)){
                print.add(i+1);
            }
        }

        Collections.sort(print);

        for(int n : print){
            bw.write(n + " ");
        }

        bw.close();
        br.close();
    }
    
    public static void dfs(int a){
        visit[a] = true;

        for(int n : list[a]){
            if(!visit[n]){
                count++;
                dfs(n);

            }
        }

    }
}



