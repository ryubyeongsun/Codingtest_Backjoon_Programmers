import java.io.*;
import java.util.*;

class Main{
    static int w;
    static int h;
    static int arr[][];
    static boolean[][] visit;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0}; 
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int count;
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
       while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            arr = new int[h][w];
            visit = new boolean[h][w];
    
            if (w == 0 && h == 0) break;
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(arr[i][j]==1 && !visit[i][j]){
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
            count = 0;
       }
    }
    static void dfs(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < h && ny < w) {
                if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                    dfs(nx, ny);
                }

        }
    }
    }
}