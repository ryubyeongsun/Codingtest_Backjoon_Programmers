
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        double arr[] = new double[num];
        String post = br.readLine();
        Stack<Double> stack = new Stack<>();    
        double cal = 0;
        for(int i=0; i<num; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        for(int i=0; i<post.length(); i++){
            char ch = post.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                stack.push(arr[ch-'A']);
            }else{
                double b = stack.pop(); 
                double a = stack.pop(); 
                switch (post.charAt(i)) {
                    case '*':
                        cal = a * b;
                        stack.push(cal);
                        break;
                    case '+':
                        cal = a + b;
                        stack.push(cal);
                        break;
                    case '/':
                        cal = a / b;
                        stack.push(cal);
                        break; 
                    case '-':
                        cal = a - b;
                        stack.push(cal);
                        break;     
                }
            }
            
        }
        
        System.out.printf("%.2f", stack.pop());

    }
}