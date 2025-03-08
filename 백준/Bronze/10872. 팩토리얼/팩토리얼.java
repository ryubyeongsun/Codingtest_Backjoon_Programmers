import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum = 1;

        for(int i=n; i>0; i--){
            sum*=i;
            if (n == 0){
                sum = 1;
            }
        }
        System.out.println(sum);
 
 }
}