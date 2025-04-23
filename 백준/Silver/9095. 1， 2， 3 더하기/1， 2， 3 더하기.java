import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        for(int i=0; i<num; i++){
            int count = Integer.parseInt(br.readLine());
            int arr[] = new int[11];

            arr[1]=1;
            arr[2]=2; 
            arr[3]=4;

            for(int j=4; j<=count; j++){
                arr[j] = arr[j-1] + arr[j-2] + arr[j-3];
            }
            System.out.println(arr[count]);
        }

    }
}