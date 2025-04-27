import java.util.*; 
import java.io.*; 

class Main{
    static ArrayList<Integer> [] list;
    static boolean[] visit;
    static boolean success = false;
    public static void main(String[] argc)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[N];
        visit = new boolean[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=0; i<N; i++){
            if(success){
                break;
            }
            dfs(i,1);
        }
        if(success){
            System.out.println("1");
        }else{
            System.out.println("0");
        }

    }
    static void dfs(int num, int dep){
        if(dep == 5){
            success = true;
            return;
        }
        visit[num] = true;

        for(int c : list[num]){
            if(!visit[c]){
                dfs(c,dep+1);
            }
        }
        visit[num] = false;

    }
}