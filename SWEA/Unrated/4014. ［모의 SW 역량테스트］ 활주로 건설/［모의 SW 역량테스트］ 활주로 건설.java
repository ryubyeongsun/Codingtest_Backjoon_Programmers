import java.util.*;
import java.io.*;

class Solution
{
    static int arr[][];
    static int N,X;
    public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            int total = 0;

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                if(chk(arr[i])) total++;
            }
           
            for(int i=0; i<N; i++){
                int col[] = new int[N];
                for(int j=0; j<N; j++){
                    col[j] = arr[j][i];
                }
                if(chk(col)) total++;

            }
            System.out.println("#" + test_case + " " + total);

        }

	}
    public static boolean chk(int n[]){
        boolean use[] = new boolean[N];    

        for(int i=0; i<N-1; i++){
            if(n[i] == n[i+1]) continue;

            if(Math.abs(n[i] - n[i+1]) > 1) return false;

            if(n[i] - n[i+1] == 1){
                for(int j=i+1; j<=i+X; j++){
                    if(j>=N || n[j] != n[i+1] || use[j]) return false;
                    use[j] = true;
                }

            }else if(n[i+1] - n[i] ==  1){
                for(int j =i; j>i-X; j--){
                    if(j<0 || n[j] != n[i] || use[j]) return false;
                    use[j] = true;
                }

            }

        }
        return true;

    }
  


}

    

    
