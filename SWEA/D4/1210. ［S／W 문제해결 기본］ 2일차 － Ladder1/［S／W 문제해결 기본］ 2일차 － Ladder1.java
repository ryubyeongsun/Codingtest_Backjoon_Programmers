import java.util.*;
import java.io.*;
import java.rmi.server.UID;

class Solution {
    static int[][] arr;
    static boolean[][] visit;
    static int[] dx = {0, 0, 1};
    static int[] dy = {-1, 1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine()); 

            arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;

            for (int i = 0; i < 100; i++) {
                if (arr[0][i] == 1) {
                    visit = new boolean[100][100];
                    if (bfs(0, i)) {
                        result = i;
                        break;
                    }
                }
            }
            bw.write("#" + String.valueOf(test_case) + " " + String.valueOf(result));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cx = now[0];
            int cy = now[1];

            for (int i = 0; i < 2; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                        break; 
                    }
                }
            }

            if (q.isEmpty()) {
                int nx = cx + dx[2];
                int ny = cy + dy[2];

                if (nx >= 0 && ny >= 0 && nx < 100 && ny < 100) {
                    if (arr[nx][ny] == 2) return true;

                    if (arr[nx][ny] == 1 && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        return false;
    }
}
