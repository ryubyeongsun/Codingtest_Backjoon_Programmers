import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int a = Integer.parseInt(st.nextToken());
       int b = Integer.parseInt(st.nextToken());
       
       for(int i=a; i<=b; i++){
            if(check(i)){
                System.out.println(i);
            }
       }
 
 }
 public static boolean check(int a){
    if(a<2) return false;
    for(int i=2; i*i<=a; i++){
        if(a%i==0){
            return false;
        }
    }
    return true;
 }
  
}