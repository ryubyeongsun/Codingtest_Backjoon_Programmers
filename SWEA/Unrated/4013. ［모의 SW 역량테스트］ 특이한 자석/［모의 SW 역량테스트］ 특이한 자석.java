import java.util.*;
import java.io.*;

class Solution
{
	static int arr[][];
	static int info[][];
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = Integer.parseInt(br.readLine());

			arr = new int[5][8];

			for(int i=1; i<=4; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			info = new int[K][2];
			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				info[i][0] = Integer.parseInt(st.nextToken()); 
				info[i][1] = Integer.parseInt(st.nextToken()); 
				rotate(info[i]);
			}
			int sum = 0;

            if (arr[1][0] == 1) sum += 1;
            if (arr[2][0] == 1) sum += 2;
            if (arr[3][0] == 1) sum += 4;
            if (arr[4][0] == 1) sum += 8;
			
			System.out.println("#" + test_case + " " + sum);

			
		}
	}
	public static void rotate(int n[]){
		int rotateChk[] = new int[5];
		int a = n[0];
		int b = n[1];
		rotateChk[a] = b;
		
		for(int i=a; i>1; i--){
			if(arr[i][6] != arr[i-1][2]){
				rotateChk[i-1] = -rotateChk[i];
			}else break;
		}
		for(int i=a; i<4; i++){
			if(arr[i][2] != arr[i+1][6]){
				rotateChk[i+1] = -rotateChk[i];
			}else break;
		}

		for(int i=1; i<=4; i++){
			if(rotateChk[i]==1){
				int temp = arr[i][7];
				for(int j=7; j>0; j--){
					arr[i][j] = arr[i][j-1];
				}
				arr[i][0] = temp;
			}else if(rotateChk[i]==-1){
				int temp = arr[i][0];
				for(int j=1; j<8; j++){
					arr[i][j-1] = arr[i][j];
				}
				arr[i][7] = temp;
			}

		}

		
		

	}
}