
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = 0;
        for(int i=0; i<n; i++){
            int a = Integer.parseInt(st.nextToken());
            if(check(a)){
                result++;
            }
        }
        System.out.println(result);
 
 }
    public static boolean check(int a){
        if(a <2) return false;
        for(int i=2; i*i<=a; i++){
            if(a%i == 0){
                return false;
            }
        }
        return true;
    }

}