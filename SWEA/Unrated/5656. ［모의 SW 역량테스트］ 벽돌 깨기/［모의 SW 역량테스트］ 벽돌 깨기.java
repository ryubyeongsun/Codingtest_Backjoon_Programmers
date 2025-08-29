import java.util.*;
import java.io.*;

class Solution
{
    static int N,W,H,min;
    static int arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            min = Integer.MAX_VALUE;
            dfs(arr,0);
            System.out.println("#" + test_case + " " + min);

		}
	}
    public static void dfs(int board[][], int dep){
        
        if(dep==N){
            min = Math.min(min, count(board));
            return;
        }

        for(int c = 0; c<W; c++){
            int copy[][] = copyArr(board);
            dropBall(c, copy);
            dfs(copy, dep+1);
        }

    }

    public static int[][] copyArr(int board[][]){
        int copy[][] = new int[H][W];
        for(int i=0; i<H; i++){
            copy[i] = board[i].clone();
        }
        return copy;

    }

    public static void dropBall(int c, int board[][]){
        
        for(int r=0; r<H; r++){
            if(board[r][c] != 0){
                boom(r,c,board);
                break;
            }

        }
        down(board);
    }
    public static void boom(int r, int c, int board[][]){
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{r,c,board[r][c]});
        board[r][c] = 0;

        while (!dq.isEmpty()) {
            int cur[] = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int range = cur[2];

            for(int i=0; i<4; i++){
                for(int j=1; j<range; j++){
                    int nx = x+dx[i]*j;
                    int ny = y+dy[i]*j;
                    if(nx<0 || ny<0|| nx>=H || ny>=W) continue;
                    if(board[nx][ny] > 0){
                        dq.offer(new int[]{nx,ny,board[nx][ny]});
                        board[nx][ny] = 0;
                    }
                }
            }


        }

    }
    public static void down(int board[][]){
        for(int c=0; c<W; c++){
            Deque<Integer> dq = new ArrayDeque<>();
            for(int r=H-1; r>=0; r--){
                if(board[r][c] > 0){
                    dq.offer(board[r][c]);
                    board[r][c] = 0;
                }
            }
            
            int r = H-1;
            while (!dq.isEmpty()) {
                board[r--][c] = dq.poll();
            }

        }

    }
    public static int count(int board[][]){
        int sum=0;
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(board[i][j] > 0){
                    sum++;
                }
            }
        }
        return sum;
    }
}