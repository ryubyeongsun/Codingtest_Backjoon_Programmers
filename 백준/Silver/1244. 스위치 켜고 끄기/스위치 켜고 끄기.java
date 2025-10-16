import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int getNum = Integer.parseInt(st.nextToken());
            int left = getNum-1;
            int right = getNum+1;

            if(sex==1){
                for(int j = getNum; j<=N; j+=getNum){
                    arr[j] = arr[j] == 1 ? 0 : 1;
                }
            }else{
                while (true) {
                    if(left < 1 || right>N ){
                        left++;
                        right--;
                        break;
                    } 
                    if(arr[left] != arr[right]){
                        left++;
                        right--;
                        break;
                    } 
                    if(arr[left] == arr[right]){
                        left--;
                        right++;
                    }

                }

                for(int k = left; k<=right; k++){
                    arr[k] = arr[k] == 1 ? 0 : 1;
                }

            }
        
        }

        for(int i=1; i<=N; i++){
            System.out.print(arr[i] + " ");
            if(i%20==0){
                System.out.println();
            }
        }
    }
}
