import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for(int j = 0; j<n; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long sum=0;
            for(int k=0; k<n-1; k++){ 
                for(int z=k+1; z<n; z++){
                    sum+=gcd(arr[k], arr[z]);
                }
            }
            System.out.println(sum);
        }
    } 
    public static int gcd(int a, int b){
        while (b!=0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }
}
