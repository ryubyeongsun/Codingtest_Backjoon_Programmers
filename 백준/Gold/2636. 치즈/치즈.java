import java.util.*;
import java.io.*;

public class Main {
    static int N,M,cheese,time;
    static int map[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1){
                    cheese++;
                }
            }
        }

        int last = 0;

        while (cheese>0) {
            last = cheese;
            bfs();
            time++;
        }

        System.out.println(time);
        System.out.println(last);
	
	}
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        boolean visit[][] = new boolean[N][M];
        q.offer(new int[]{0,0});
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int cur[] = q.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M || visit[nx][ny]) continue;

                visit[nx][ny] = true;

                if(map[nx][ny]==0){
                    q.offer(new int[]{nx,ny});
                }else{
                    map[nx][ny] = 0;
                    cheese--;
                }

            }


        }


    }

}
