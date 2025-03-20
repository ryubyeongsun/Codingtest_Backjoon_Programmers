import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P[] = new int[num+1];
		for(int i=0; i<num; i++){
			P[i+1] = Integer.parseInt(st.nextToken());
		}
		int min[] = new int[num+1];
	
		for(int i=1; i<=num; i++){
			min[i] = P[i];
			for(int j=1; j<=i; j++){
				min[i] = Math.min(min[i] , min[i-j] + P[j] );
			}
		}
		System.out.println(min[num]);
	}
	
}
        

