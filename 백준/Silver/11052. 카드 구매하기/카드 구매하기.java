import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int P[] = new int[num+1];
		int max[] = new int[num+1];

		for(int i=0; i<num; i++){
			P[i+1] = Integer.parseInt(st.nextToken());
		}


		for(int i=1; i<=num; i++){
			for(int j=1; j<=i; j++){
				max[i] = Math.max(max[i], max[i-j] + P[j] );
			}

		}		

		System.out.println(max[num]);
		
	}
	
}
        

