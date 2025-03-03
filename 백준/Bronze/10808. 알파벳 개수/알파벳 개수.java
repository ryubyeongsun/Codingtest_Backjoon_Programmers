
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int arr[] = new int[26];
   

        for(int i = 0; i<word.length(); i++){
            
            arr[word.charAt(i) - 'a']++;

        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }



    }
}