
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        StringBuilder stb = new StringBuilder(word);
        String arr[] = new String[word.length()];

        for(int i=0; i<word.length(); i++){
            if( i == 0){
                arr[i] = stb.delete(0, 0).toString();
            }else{
                arr[i] = stb.delete(0, 1).toString();
            }
        }
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);

        }

    }
}