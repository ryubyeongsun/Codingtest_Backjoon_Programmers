package backjoon;
import java.util.*;

public class Back9012{
    public static void main(String[] argc){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
      
        for(int i=0; i<n; i++){
            String word = s.next();
            boolean a = test(word);
            if(a==true){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
       
    } 
    public static boolean test(String s){
        String arr[] = s.split("");
        int count =0;
        for(int i=0; i<arr.length; i++){
            
            if(arr[i].equals("(")){
                count++;
            }else{
                count--;
                if(count<0){
                    return false;
                }
            }
            
        }
        return count==0;

    }
}