import java.io.*;
import java.util.*;

class Main{
    static int arr[][];
    static boolean[][] visit;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = line.charAt(j-1) - '0';
            }

        }
        visit = new boolean[N+1][M+1];

        bfs(1,1);

        System.out.println(arr[N][M]);

}
    static void bfs(int a, int b){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a,b});
        visit[a][b] = true;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx<0 || ny<0 || nx > arr.length-1 || ny> arr[0].length-1){
                    continue;
                }
                

                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    arr[nx][ny] = arr[cx][cy] + 1;
                    q.add(new int[] {nx,ny});
                }

            }


        }
    }
    
}