package backjoon;
import java.util.*;

public class Back2444 {
    public static void main(String[] argc){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=n-i; j>0; j--){
                
                System.out.print(" ");
                
            }
            for(int k=1; k<=i*2-1; k++){
                System.out.print("*");
            }
            System.out.println();
           
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                
                System.out.print(" ");
                
            }
            for(int k=i*2-1; k<=n*2-3; k++){
                System.out.print("*");
            }
            System.out.println();
           
        }
        
        
    }
}
