import java.util.*;
import java.io.*;

class Solution
{
    static int N,M;
    static char arr[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int devil[][], person[][];

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            devil = new int[N][M];
            person = new int[N][M];
            Queue<int[]> dq = new LinkedList<>();

            int initX=0,initY=0;
            for(int i=0; i<N; i++){
                String word = br.readLine();
                for(int j=0; j<M; j++){
                    arr[i][j] = word.charAt(j);
                    if(arr[i][j] == 'S'){
                        initX = i;
                        initY = j;
                        person[i][j] = 0;
                        devil[i][j] = -1;
                    }else if(arr[i][j] == '*'){
                        devil[i][j] = 0;
                        person[i][j] = -1;
                        dq.offer(new int[]{i,j});
                    }else{
                        devil[i][j] = -1;
                        person[i][j] = -1;
                    }
                    
                }
            }
            devilMove(dq);
            int result = personMove(initX, initY);
            System.out.print("#" + test_case + " ");
            System.out.println(result==-1 ? "GAME OVER" : result);

        }
	}
    public static void devilMove(Queue<int[]> dq){
        while (!dq.isEmpty()) {
            int cur[] = dq.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
                if(arr[nx][ny] == 'X' || arr[nx][ny] == 'D') continue;
                if(devil[nx][ny] != -1) continue;

                devil[nx][ny] = devil[cur[0]][cur[1]] + 1;
                
                dq.offer(new int[]{nx,ny});

            }
            
        }

    }

    public static int personMove(int x,int y){
        Queue<int []> pq = new LinkedList<>();
        pq.offer(new int[] {x,y});

        while (!pq.isEmpty()) {
            int cur[] = pq.poll();

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
            
            if(arr[nx][ny] == 'X') continue;
            if(person[nx][ny] != -1) continue;
            if(arr[nx][ny] == 'D'){
                return person[cur[0]][cur[1]] + 1;
            }
            if(devil[nx][ny] != -1 && person[cur[0]][cur[1]]+1 >= devil[nx][ny]) continue;

            person[nx][ny] = person[cur[0]][cur[1]]+1;
            pq.offer(new int[]{nx,ny});

            }
        }
        return -1;
    }


}