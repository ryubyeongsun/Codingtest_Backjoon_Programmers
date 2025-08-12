
import java.util.*;
import java.io.*;

class Solution
{
    static int N;
    static int K;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int max;
    
	public static void main(String args[]) throws IOException
	{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T= Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int high = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    high = Math.max(high, arr[i][j]);
                }
            }

            max = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(arr[i][j] == high){
                        visit = new boolean[N][N];
                        dfs( i,j,1,false);
                    }
                }
            }

            bw.write("#" + test_case + " " + max + "\n");
		}
        bw.close();
        br.close();
	}
    public static void dfs(int x, int y, int len, boolean chk ){

        
        max = Math.max(max, len);


        visit[x][y] =true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny]){
                if(arr[nx][ny] < arr[x][y]){
                    dfs(nx,ny, len+1,chk);
                }else if(!chk && arr[nx][ny]-K < arr[x][y]){
                    int ori = arr[nx][ny];
                    arr[nx][ny] = arr[x][y] - 1; 
                    dfs(nx,ny, len+1,true);
                    arr[nx][ny] = ori;
                }
            }
        }
        visit[x][y] = false;


    }
}