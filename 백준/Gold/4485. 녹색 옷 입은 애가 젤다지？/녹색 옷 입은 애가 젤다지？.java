import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dist; 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dist = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

            bfs(0, 0); 
            System.out.println("Problem " + num++ + ": " + dist[N-1][N-1]);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        dist[x][y] = arr[x][y]; 
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                int minDist = dist[cx][cy] + arr[nx][ny];
                if (minDist < dist[nx][ny]) {
                    dist[nx][ny] = minDist;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
