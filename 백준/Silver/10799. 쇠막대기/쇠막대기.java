import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                stack.push(ch);
            } else {
                stack.pop();

                if(str.charAt(i - 1) == '('){
                    sum += stack.size();
                } else {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
