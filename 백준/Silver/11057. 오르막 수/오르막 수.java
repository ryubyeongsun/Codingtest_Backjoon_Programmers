import java.io.*;


class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int dp[][] = new int[num+1][10];
		
		for(int i=0; i<10; i++){
			dp[1][i] = 1;
		}


		for(int i=2; i<=num; i++){
			for(int j=0; j<10; j++){
				for(int k=0; k<=j; k++){
					dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007 ;
				}
			}

		}
		int sum = 0;

		for(int i=0; i<10; i++){
			sum = (sum + dp[num][i]) % 10007;
		}
		
		System.out.println(sum);
		

	}
}