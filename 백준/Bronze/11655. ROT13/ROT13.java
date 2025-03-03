
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder stb = new StringBuilder();

        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);

            if(ch>= 'A' && ch<='Z'){
                stb.append((char) ((ch-'A'+13)%26 +'A'));
            }else if( ch >= 'a' && ch <= 'z'){
                stb.append((char) ((ch-'a'+13)%26 +'a'));
            }else{
                stb.append(ch);
            }
            
        }
        System.out.println(stb);

    }
}