
import java.util.*;
import java.io.*;

class Solution
{
    static int arr[][];
    static int N;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static ArrayList<int []> list;
    static int maxcore;
    static int minlen;
	public static void main(String args[]) throws IOException
	{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            list = new ArrayList<>();

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(i!=0 && j!=0 && i!=N-1 && j!=N-1&& arr[i][j]==1){
                        list.add(new int[]{i,j}); 
                    }
                }
            }
            maxcore=0;
            minlen = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" + test_case + " " + minlen);

		}
	}
    public static void dfs(int index, int countcore, int length){
        
        if(index == list.size()){
            if(maxcore<countcore){
                maxcore = countcore;
                minlen = length;
            }else if(maxcore == countcore){
                minlen = Math.min(minlen, length);
            }
            return;
        }
        int cur[] = list.get(index);

        for(int i=0; i<4; i++){
            ArrayList<int[]> pos = new ArrayList<>();
            boolean chk = true;
            int wirelen = 0;
            int nx = cur[0];
            int ny = cur[1];

            while (true) {
                nx+= dx[i];
                ny+= dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N) break;

                if(arr[nx][ny] !=0){
                    chk = false;
                    break;
                }

                pos.add(new int[]{nx,ny});
                wirelen++;

            }
            if(chk){
                for(int n[] : pos){
                    arr[n[0]][n[1]] = 2;
                }
                dfs(index+1, countcore+1, length+wirelen);
                for(int n[] : pos){
                    arr[n[0]][n[1]] = 0;
                }

            }

        }
        dfs(index+1, countcore, length);


    }
}