import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	
		int S = Integer.parseInt(st.nextToken());	
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[N];
		for(int i=0; i<N; i++){
			int A = Integer.parseInt(st.nextToken());
			arr[i] = (S-A < 0) ? -(S-A) : S-A;
		}
		int max = arr[0];
	
		for(int i=0; i<N; i++){
			max = gcd(max, arr[i]);
		}
		System.out.println(max);


	}
	public static int gcd(int a, int b){
		while(b!=0){
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
        

