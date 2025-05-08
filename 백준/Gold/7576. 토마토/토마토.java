import java.io.*;
import java.util.*;

class Main{
    static int arr[][];
    static Queue<int []> q = new LinkedList<>();
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int count = 0;
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==1){
                    q.add(new int[] {i,j});
                }
            }
        }
        bfs();
        
        int result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result,arr[i][j]);
                
            }
        }
        
        if( result == 1){
            System.out.println(0);
        }else{
            System.out.println(result-1);
        }


        
    }

    static void bfs(){
        
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny<0 || nx>arr.length-1 || ny>arr[0].length-1){continue;}
            
                if(arr[nx][ny]==0){
                    arr[nx][ny] = arr[x][y] + 1;
                    q.add(new int[] {nx,ny});
                }

            }
        }
        

    }
    
}