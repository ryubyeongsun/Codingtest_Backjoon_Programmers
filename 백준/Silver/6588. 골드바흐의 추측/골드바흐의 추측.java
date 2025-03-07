import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean sosu[] = new boolean[1000001];
        for(int i=2; i<sosu.length; i++){
            sosu[i] = check(i);
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                return;
            }
            boolean found = false;

            for(int i=3; i<=n/2; i+=2){
                int b = n-i;
                if(sosu[i] && sosu[b]){
                    System.out.println(n+" = " + i + " + " + b);
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Goldbach's conjecture is wrong.");           
             }
        }
 
 }
    public static boolean check(int a){
        if(a<2) return false;
        for(int i=2; i*i<=a; i++){
            if(a%i==0) {return false;}
        }
        return true;
    }
}