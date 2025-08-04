import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int arr[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String num = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = num.charAt(j)-'0';
            }
        }
        bfs(0,0);

        bw.write(String.valueOf(arr[N-1][M-1]));
        bw.flush();
        bw.close();
        
    }

    public static void bfs(int a, int b){
        Queue<int []> q = new LinkedList<>();
        visit[a][b] = true;
        q.offer(new int[]{a,b});


        while (!q.isEmpty()) {
            int brr[] = q.poll();
           
            for(int i=0; i<4; i++){
                int nx = brr[0]+dx[i];
                int ny = brr[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny] && arr[nx][ny]==1){
                    q.offer(new int[]{nx,ny});
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[brr[0]][brr[1]] + 1;

                }

            }


        }



    }

}