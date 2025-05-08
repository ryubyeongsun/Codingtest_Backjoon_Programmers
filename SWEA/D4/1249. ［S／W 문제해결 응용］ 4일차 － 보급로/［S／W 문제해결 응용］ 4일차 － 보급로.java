import java.util.*;
import java.io.*;

class Solution {
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            num = Integer.parseInt(br.readLine());
            arr = new int[num][num];
            dist = new int[num][num];
            visit = new boolean[num][num];

            for (int i = 0; i < num; i++) {
                String line = br.readLine();
                for (int j = 0; j < num; j++) {
                    arr[i][j] = line.charAt(j) - '0';
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            bfs(0, 0);

            System.out.println("#" + test_case + " " + dist[num - 1][num - 1]);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

              	if (nx < 0 || ny < 0 || nx >= num || ny >= num) { continue; }
                
                    int cost = dist[cx][cy] + arr[nx][ny];
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        q.offer(new int[]{nx, ny});
                    }
                
            }
        }
    }
}
