
import java.util.*;
public class Main {
    public static void main(String[] argc){
        // ex 4 3 6 8 7 5 2 1
        // push -> 오름차순
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int init = 1;
        int stack_arr[] = new int[n];
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = s.nextInt();

        }
        int top=-1;
        StringBuilder text = new StringBuilder();
        for(int i=0; i<n; i++){
            int target = arr[i];
            
            while (init <= target ) {
                stack_arr[++top] = init++;
                text.append("+\n");
            }   
            
            if( target == stack_arr[top]){
                stack_arr[top] = 0;
                top--;
                text.append("-\n");
            }else{
                System.out.println("NO");
                return;
            }

        }
        System.out.println(text);

    }
}
