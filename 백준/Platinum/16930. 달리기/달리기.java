import java.io.*;
import java.util.*;

public class Main {

	static int N,M,K,min;
	static char arr[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visit[][];
	static int copy[][];
	static int x1,y1,x2,y2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new char[N+1][M+1];
		visit = new boolean[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String word = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = word.charAt(j-1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		x1 = Integer.parseInt(st.nextToken());
		y1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		y2 = Integer.parseInt(st.nextToken());
		
		copy = new int[N+1][M+1];
		
		
		
		min = Integer.MAX_VALUE;
		robotBfs(x1, y1);
		//dfs(1,x1,y1,copy);
		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=M; j++) {
//				System.out.print(copy[i][j]);
//			}
//			System.out.println();
//		}

		System.out.println(copy[x2][y2] ==0 ? -1 : copy[x2][y2]);

	}
	public static void robotBfs(int r, int c) {
    Queue<int[]> q = new LinkedList<>();
    visit[r][c] = true;
    copy[r][c] = 0;
    q.offer(new int[] {r, c});

    while (!q.isEmpty()) {
        int cur[] = q.poll();
        int cx = cur[0];
        int cy = cur[1];

        // 4방향 탐색
        for (int i = 0; i < 4; i++) {
            // 1칸 ~ K칸까지 이동 가능
            for (int step = 1; step <= K; step++) {
                int nx = cx + dx[i] * step;
                int ny = cy + dy[i] * step;

                // 범위 체크
                if (nx < 1 || ny < 1 || nx > N || ny > M) break;

                // 벽 만나면 그 방향은 중단
                if (arr[nx][ny] == '#') break;

                // 이미 방문했고, 더 짧은 거리로 도달했다면 그 방향도 중단
                if (visit[nx][ny]) {
                    if (copy[nx][ny] < copy[cx][cy] + 1) break;
                    else continue;
                }

                // 방문처리 및 거리 기록
                visit[nx][ny] = true;
                copy[nx][ny] = copy[cx][cy] + 1;
                q.offer(new int[] {nx, ny});

                // (중요) BFS니까 한 번 큐에 넣었으면 그 방향으로 더 멀리 갈 필요 없음
                // → 하지만 step < K면 다른 step도 시도해야 하므로 break 안 함
            }
        }
    }
}

	
//	public static void dfs(int kvalue, int r, int c , int copy[][]) {
//		
//		if(kvalue == K) return;
//		
//		if(r==x2 && c==y2 && copy[x2][y2] >0) {
//			min = Math.min(min, copy[r][c]);
//			return;
//		}
//		
//		
//			for(int j=0; j<4; j++) {
//				int nx = r+dx[j]*kvalue;
//				int ny = c+dy[j]*kvalue;
//				
//				
//				if(nx<1 || ny<1 || nx>N || ny>M || visit[r][c]) continue;
//				
//				if(arr[nx][ny] == '#') continue;
//				
//				copy[nx][ny]  = copy[r][c] + 1;
//				visit[nx][ny] = true;
//				
//				dfs(kvalue+1, nx,ny,copy);
//				dfs(kvalue+1, r, c,copy);
//				
//				copy[nx][ny]  = copy[r][c] - 1;
//				visit[nx][ny] = false;
//				
//				
//			}
//			
//			
//		
//		
//	}

}
