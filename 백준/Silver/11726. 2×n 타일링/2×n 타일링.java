import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num+1];

		arr[1] = 1;
		if(num>1) arr[2] = 2;

		for(int i=3; i<=num; i++){
			arr[i] = (arr[i-1] + arr[i-2]) % 10007;
		}

		System.out.println(arr[num]);
		
	}
	
}
        

