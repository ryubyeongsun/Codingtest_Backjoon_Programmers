import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();

            if(!list.contains(word)){
                list.add(word);            
            }
        }


        int ans1 = 0;
        int ans2 = 0;
        int max = 0;

        for(int i=0; i<N; i++){
            String str1 = list.get(i);
            for(int j=i+1; j<N; j++){
                int count = 0;
                String str2 = list.get(j);
                int size = Math.min(str1.length(), str2.length());
                for(int k=0; k<size; k++){
                    if(str1.charAt(k) == str2.charAt(k)){
                        count++;
                    }else{
                        break;
                    }
                }
                if(max<count){
                    ans1 = i;
                    ans2 = j;
                    max = count;
                }

            }
        }
        
        System.out.println(list.get(ans1));
        System.out.println(list.get(ans2));

    }
}
