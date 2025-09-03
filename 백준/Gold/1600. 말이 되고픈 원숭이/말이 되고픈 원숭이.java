import java.util.*;
import java.io.*;

public class Main {
    static int K, W, H;
    static int[][] arr;
    static boolean[][][] visit;
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};
    static int[] horseX = {-2, -2, -1, -1, 2, 2, 1, 1}; 
    static int[] horseY = {1, -1, -2, 2, -1, 1, -2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        visit = new boolean[H][W][K+1];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{0, 0, 0, 0});
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], k = cur[2], dist = cur[3];

            if (x == H-1 && y == W-1) return dist;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (arr[nx][ny] == 1) continue;
                if (visit[nx][ny][k]) continue;

                visit[nx][ny][k] = true;
                q.offer(new int[]{nx, ny, k, dist+1});
            }

            if (k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + horseX[i];
                    int ny = y + horseY[i];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if (arr[nx][ny] == 1) continue;
                    if (visit[nx][ny][k+1]) continue;

                    visit[nx][ny][k+1] = true;
                    q.offer(new int[]{nx, ny, k+1, dist+1});
                }
                
            }
        }

        return -1; 
    }
}
