package backjoon;
import java.util.*;
public class Back2439 {
    public static void main(String[] argc){

        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int n=a-1;
        for(int i=0; i<a; i++){
            for(int j=0; j<a; j++){
                
                if(j>=n){
                    System.out.print("*");
                }else{System.out.print(" ");}
              
                
            }
            n--;
            System.out.println();
        }
        
    }
}
