
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int num = Integer.parseInt(br.readLine());

       for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = gcd(a,b);
            int c = (a*b) /gcd;
            System.out.println(c);
       }
       
 
 }
 public static int gcd(int a, int b){

    while (b!=0) {
        int temp = a%b;
        a=b;
        b=temp;
    }
    return a;


 }
  
}