package backjoon;
import java.util.*;

public class Back10828 {
    public static void main(String[] argc){

        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int arr[] = new int[10000];
        int a =0;
        int prev = 0;
        for(int i=0; i<num; i++){
            String word = s.next();

            if(word.equals("push")){
                int count = s.nextInt();
                arr[a] = count;
                a++; 
            }else if(word.equals("pop")){
                if(a==0){
                    System.out.println(-1);
                }else{
                System.out.println(arr[a-1]);
                arr[a-1]=0;
                a--;
                }
            }else if( word.equals("top")){
                if(a==0){
                    System.out.println(-1);
                }else{
                    System.out.println(arr[a-1]);
                }
            }else if(word.equals("size")){
                System.out.println(a);
            }else if(word.equals("empty")){
                if(a == 0){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }
        }
        
    }
}
