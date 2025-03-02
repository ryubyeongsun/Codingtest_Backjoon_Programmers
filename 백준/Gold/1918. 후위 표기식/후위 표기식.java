
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            
            switch (ch) {
                case '*': case '/':
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) {
                        stb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '+': case '-' :
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stb.append(stack.pop());
                    }
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    stb.append(ch);
                    break;
            }
        } while (!stack.isEmpty()) {
                stb.append(stack.pop());
            }
            System.out.println(stb);
           
        }
    }

