    import java.io.*;
    import java.util.*;
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                String str = br.readLine();
                Stack<Character> stack = new Stack<>();
                boolean chk = true;
                for(int j=0; j<str.length(); j++){
                    char ch = str.charAt(j);
                    
                    if(ch=='('){
                        stack.push(ch);
                    }else if(ch==')'){
                        if(stack.isEmpty()){
                            chk = false;
                            break;
                        }else{
                            stack.pop();
                        }
                    }
                 }
                 if(!stack.isEmpty()){
                    chk = false;  
                }
                    
                 if(chk){
                    System.out.println("YES");
                 }else{
                    System.out.println("NO");
                 }

                }
                
            }

        }

    
    
