import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[] = new int[num+1];
        if(num % 2 == 1){
            System.out.println(0);
            return;
        }
        arr[0] = 1;
        arr[2] = 3;
        

        for(int i=4; i<=num; i+=2){
            arr[i] = arr[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                arr[i] = arr[i] + arr[j] * 2;
            }
            

        }
        System.out.println(arr[num]);

    }
}
