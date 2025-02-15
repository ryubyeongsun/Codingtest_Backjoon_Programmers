package backjoon;
import java.util.*;

public class Back2563{
    public static void main(String[] argc){

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[][] = new int[100][100];
        for(int i=0; i<n; i++){

            int a=s.nextInt();
            int b=s.nextInt();
            for(int k=a; k<a+10; k++){
                for(int j=b; j<b+10; j++){
                    arr[k][j] = 1;
                }
            }

        }
        int sum=0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] ==1){
                    sum+=arr[i][j];
                }
            }
        }
        
        System.out.print(sum);

    }
}