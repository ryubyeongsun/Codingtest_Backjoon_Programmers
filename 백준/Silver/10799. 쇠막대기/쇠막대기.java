import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack sk = new Stack<>();
        int num = 0;
        sk.push('(');
        for(int i=1; i<word.length(); i++){
            
            char current = word.charAt(i);
            char prev = word.charAt(i-1);
            if(prev == '('){
                if(current == ')'){
                    sk.pop();
                    num+=sk.size();
                }else{
                    sk.push(current);
                }
            }else if(prev == ')'){
                if(current == '('){
                    sk.push(current);
                }else{
                    sk.pop();
                    num+=1;
                }
            }

        }
        System.out.println(num);

    }
}