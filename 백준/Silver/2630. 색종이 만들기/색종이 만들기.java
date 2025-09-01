import java.util.*;
import java.io.*;


public class Main {

	static int arr[][];
	static int good,bad;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		good = 0;
		bad = 0;
		
		divGo(0,0,N);
		
		System.out.println(good);
		System.out.println(bad);
		
	}
	public static void divGo(int r, int c, int size) {
		
		int sum = 0;
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				sum+=arr[i][j];
			}
		}
		
		if(sum==size*size) {
			bad++;
		}else if(sum == 0) {
			good++;
		}else {
			int div = size/2;
			divGo(r, c, div);
			divGo(r, c+div, div);
			divGo(r+div, c, div);
			divGo(r+div, c+div, div);
			
		}
		
	}

}
