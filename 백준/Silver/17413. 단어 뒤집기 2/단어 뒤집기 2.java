
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder result = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        boolean dis = false;

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(ch == '<'){
                result.append(rev.reverse());
                result.append(ch);
                dis = true;
                rev.setLength(0);
            }else if( ch == '>'){
                result.append(rev);
                result.append(ch);
                rev.setLength(0);
                dis = false;

            }else if(ch == ' '){
                if(dis){
                    rev.append(ch);
                }else{
                    result.append(rev.reverse());
                    result.append(ch);
                    rev.setLength(0);
                }
                

            }else{
                rev.append(ch);
            }

        }
        if(rev.length()>0){
            result.append(rev.reverse());
            
        }

        System.out.println(result); 
    }
}
