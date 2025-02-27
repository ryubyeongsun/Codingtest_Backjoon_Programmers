
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int max[] = new int[1000001];
        int arr[] = new int[num];
        int result[] = new int[num];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<num; i++){
            int num_all = Integer.parseInt(st.nextToken());
            arr[i] = num_all;
            max[num_all]++;
            result[i] = -1;
        }
        for(int i=0; i<num; i++){

            while (!stack.isEmpty() && max[arr[stack.peek()]]<max[arr[i]] ) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i); 
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            stb.append(result[i]).append(" ");
        }
        System.out.println(stb);

    }
}