
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[num];
        int result[] = new int[num];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<num; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            result[i] = -1;
        }

        for(int i=0; i<num; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i] ) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        StringBuilder stb = new StringBuilder();
        for(int i=0; i<result.length; i++){
            stb.append(result[i]).append(" ");
        }
        System.out.println(stb);
    }
}