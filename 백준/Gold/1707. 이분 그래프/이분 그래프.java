import java.util.*; 
import java.io.*; 

class Main{
    static ArrayList<Integer>[] list;
    static int [] color;
    static boolean check;
    public static void main(String[] argc)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        
        for(int i=0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V+1];
            color = new int[V+1];
            check = true;
            for(int k=1; k<=V; k++){
                list[k] = new ArrayList<>();
            }
        
            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
                
            }
            for(int z=1; z<=V; z++){
                if(color[z] == 0){
                    dfs(z,1);
                }
            }
            
            System.out.println(check ? "YES" : "NO");
        }

    }
    static void dfs(int num, int cur){
        color[num] = cur;

        for(int n : list[num]){
            if(color[n] == 0){
                dfs(n, -cur);
            }else if(color[n] == color[num]){
                check=false;
            }
        }
    }
}