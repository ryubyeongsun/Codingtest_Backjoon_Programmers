package backjoon;
import java.util.*;

public class Back1316 {
    public static Scanner s = new Scanner(System.in);
    public static void main(String[] argc){
        
        int n = s.nextInt();
        int count = 0;
        boolean T;
        for(int i=0; i<n; i++){
            T = check();
            if(T == true){
                count++;
            }
            
        }
            System.out.println(count);
    
    }

    public static boolean check(){

        String str = s.next();
        boolean T[] = new boolean[26];
        int prev = 0;
        
        for(int i=0; i<str.length(); i++){
            int num = str.charAt(i);
            if(num != prev){
              
                if(T[num -'a'] == false){
                    T[num-'a'] = true;
                    prev = num;
                }else{
                    return false;
                }

         }

        

    }
       
    return true;

    }
 

}