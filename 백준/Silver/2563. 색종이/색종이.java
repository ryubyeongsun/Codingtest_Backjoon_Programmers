import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[100][100];
        int sum=0;
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            for(int j=a; j<a+10; j++){
                for(int k=b; k<b+10; k++){
                    arr[k][j]=1;
                }


            }

        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j]==1){
                    sum+=arr[i][j];
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }   

}