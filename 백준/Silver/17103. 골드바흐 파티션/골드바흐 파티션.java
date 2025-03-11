import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int max = 1000000;
		boolean arr[] = new boolean[max+1];

		for(int i=2; i<arr.length; i++){
			arr[i] = true;
		}
		for(int i=2; i*i<arr.length; i++){
			if(arr[i]){
			for(int j=i*i; j<arr.length; j+=i){
					arr[j] = false;
			}
		}
	}

		for(int i=0; i<n; i++){
			int a = Integer.parseInt(br.readLine());
            int sum = 0;
			for(int j=2; j<=a/2; j++){
				int k = a-j;
				if(arr[j] && arr[k]){
					sum++;
				}
			}
			System.out.println(sum);
		}
		
	}
	
}
        

