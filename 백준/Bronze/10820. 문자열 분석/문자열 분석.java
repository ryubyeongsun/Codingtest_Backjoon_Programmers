
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word;
        
        while((word = br.readLine()) != null){
            int low = 0;
            int up = 0;
            int num = 0;
            int gap = 0;
            
            for(int j=0; j<word.length(); j++){
                char ch = word.charAt(j);
                if(ch>='a' && ch<='z'){
                    low++;
                }else if(ch>='A' && ch<='Z'){
                    up++;
                }else if(ch == ' '){
                    gap++;
                }else if(ch >= '0' && ch <= '9'){
                    num++;
                }
            }
            System.out.println(low+" "+ up +" "+ num +" "+ gap);
        }


    }
}