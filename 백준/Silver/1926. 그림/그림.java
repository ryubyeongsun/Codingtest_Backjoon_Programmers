import java.io.*;
import java.util.*;


public class Main{
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int sum = 0;
    static int max =0;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(!visit[i][j] && arr[i][j] == 1){
                  int area =  bfs(i,j);
                    sum++;
                    max=Math.max(max, area);
                }   

            }
        }

        System.out.println(sum);
        System.out.println(max);
    }


    public static int bfs(int a, int b){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[] {a,b});
        visit[a][b] = true;
        int area = 1;

        while (!q.isEmpty()) {
                int poll[] = q.poll();

            for(int i=0; i<4; i++){
                
                int nx = poll[0]+dx[i];
                int ny = poll[1]+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visit[nx][ny] &&arr[nx][ny]==1){
                    q.offer(new int[] {nx,ny});
                    visit[nx][ny] = true;
                    area++;
                }
                
            }

        }

        return area;
    }
}