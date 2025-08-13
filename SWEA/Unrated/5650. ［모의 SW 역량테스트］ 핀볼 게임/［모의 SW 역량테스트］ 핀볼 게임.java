import java.io.*;
import java.util.*;

public class Solution {
    static int N;
    static int[][] arr;
    static int dx[] = {-1, 1, 0, 0}; 
    static int dy[] = {0, 0, -1, 1};
    static Map<Integer, List<int[]>> wormhole;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N][N];
            wormhole = new HashMap<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if (arr[i][j] >= 6 && arr[i][j] <= 10) {
                        wormhole.putIfAbsent(arr[i][j], new ArrayList<>());
                        wormhole.get(arr[i][j]).add(new int[]{i, j});
                    }
                }
            }

            int maxScore = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0) {
                        for (int dir = 0; dir < 4; dir++) {
                            maxScore = Math.max(maxScore, simulate(i, j, dir));
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + maxScore);
        }
    }

    static int simulate(int sx, int sy, int dir) {
        int x = sx;
        int y = sy;
        int score = 0;

        while (true) {
            x += dx[dir];
            y += dy[dir];

            if (x < 0 || y < 0 || x >= N || y >= N) {
                dir = reverse(dir);
                score++;
                continue;
            }

            if (arr[x][y] == -1) break;

            if (x == sx && y == sy) break;

            if (1 <= arr[x][y] && arr[x][y] <= 5) {
                dir = reflect(dir, arr[x][y]);
                score++;
            }
            else if (arr[x][y] >= 6 && arr[x][y] <= 10) {
                int[] next = getOtherHole(arr[x][y], x, y);
                x = next[0];
                y = next[1];
            }
        }
        return score;
    }

    static int[] getOtherHole(int num, int cx, int cy) {
        List<int[]> list = wormhole.get(num);
        if (list.get(0)[0] == cx && list.get(0)[1] == cy) {
            return list.get(1);
        } else {
            return list.get(0);
        }
    }

    static int reverse(int d) {
        if (d == 0) return 1; 
        if (d == 1) return 0; 
        if (d == 2) return 3; 
        return 2;             
    }

    static int reflect(int dir, int block) {
        switch (block) {
            case 1:
                if (dir == 0) return 1;
                if (dir == 1) return 3;
                if (dir == 2) return 0;
                return 2;
            case 2:
                if (dir == 0) return 3;
                if (dir == 1) return 0;
                if (dir == 2) return 1;
                return 2;
            case 3:
                if (dir == 0) return 2;
                if (dir == 1) return 0;
                if (dir == 2) return 3;
                return 1;
            case 4:
                if (dir == 0) return 1;
                if (dir == 1) return 2;
                if (dir == 2) return 3;
                return 0;
            case 5:
                return reverse(dir);
        }
        return dir;
    }
}
