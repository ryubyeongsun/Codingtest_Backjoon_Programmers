import java.io.*;
import java.util.*;

public class Main {
    static int N, startX, startY, moveTime, fishSize = 2, eatCnt;
    static int map[][], dist[][];
    static boolean visit[][];
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};

    // bfs에서 찾은 먹을 물고기 위치와 거리
    static int eatX, eatY, minDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startX = i;
                    startY = j;
                    map[i][j] = 0; // 아기 상어 위치는 빈 칸으로
                }
            }
        }

        while (true) {
            dist = new int[N][N];
            visit = new boolean[N][N];

            // 초기화
            eatX = -1;
            eatY = -1;
            minDist = Integer.MAX_VALUE;

            bfs(startX, startY);

            // 먹을 물고기가 없는 경우 종료
            if (eatX == -1) break;

            // 이동 및 먹기 처리
            moveTime += minDist;
            startX = eatX;
            startY = eatY;
            map[startX][startY] = 0;
            eatCnt++;
            if (eatCnt == fishSize) {
                fishSize++;
                eatCnt = 0;
            }
        }

        System.out.println(moveTime);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        visit[r][c] = true;
        q.offer(new int[]{r, c});

        while (!q.isEmpty()) {
            int cur[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (map[nx][ny] > fishSize) continue; // 못 지나감

                dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                visit[nx][ny] = true;
                q.offer(new int[]{nx, ny});

                // 먹을 수 있는 물고기라면 갱신
                if (map[nx][ny] != 0 && map[nx][ny] < fishSize) {
                    if (dist[nx][ny] < minDist) {
                        minDist = dist[nx][ny];
                        eatX = nx;
                        eatY = ny;
                    } else if (dist[nx][ny] == minDist) {
                        if (nx < eatX || (nx == eatX && ny < eatY)) {
                            eatX = nx;
                            eatY = ny;
                        }
                    }
                }
            }
        }
    }
}
