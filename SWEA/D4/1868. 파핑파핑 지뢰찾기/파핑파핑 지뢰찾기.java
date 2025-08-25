import java.util.*;
import java.io.*;


class Solution
{
    static int N;
    static char arr[][];
    static int dx[] = {-1,1,0,0,-1,-1,1,1};
    static int dy[] = {0,0,-1,1,-1,1,-1,1};
    static int map[][];
    static boolean visit[][];
    static int min;
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
            arr = new char[N][N];
            map = new int[N][N];
            visit = new boolean[N][N];
            min = 0;

            for(int i=0; i<N; i++){
                String word = br.readLine();
                for(int j=0; j<N; j++){
                    arr[i][j] = word.charAt(j);
                }
            }

            chk();
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] == 0 && !visit[i][j] && arr[i][j] != '*'){
                        bfs(i, j);
                        min++;
                    }
                }
            }
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] != '*' && !visit[i][j]){
                        min++;
                    }
                }
            }
            System.out.println("#" + test_case + " " + min);

		}
	}
    public static void chk(){

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j] == '*'){
                    map[i][j] = -1;
                    continue;
                }

                int count = 0;
                for(int k=0; k<8; k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx>=0 && ny>=0 && nx<N && ny<N){
                        if(arr[nx][ny] == '*'){
                            count++;
                        }
                    }
                    
                }
                map[i][j] = count;
            }
        }

    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            if(map[cx][cy] == 0){
                for(int k=0; k<8; k++){
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];

                    if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && arr[nx][ny] != '*'){
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

}