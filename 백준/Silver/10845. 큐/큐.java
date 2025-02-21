
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] argc) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int back = 0;
        int front = 0;
        
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push": 
                    int num = Integer.parseInt(st.nextToken());
                    arr[back] = num;
                    back++;
                    break;
                case "pop":
                    if(front == back){
                        System.out.println(-1);
                    }else{
                    System.out.println(arr[front]);
                    arr[front] = 0;
                    front++;
                    }
                    break;
                case "size":
                    System.out.println(back-front);
                    break;
                case "empty":
                    if(front == back){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(front == back){
                        System.out.println(-1);
                    }else{
                        System.out.println(arr[front]);
                    }
                    break;
                case "back" : 
                    if(front == back){
                        System.out.println(-1);
                    }else{
                        System.out.println(arr[back-1]);
                    }
                    break;
                
            }

        }

    }
}
