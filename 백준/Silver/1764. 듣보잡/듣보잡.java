import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> list1 = new HashSet<>();
        Set<String> list2 = new HashSet<>();
        Set<String> result = new TreeSet<>();

        for(int i=0; i<n; i++){
            String word = br.readLine();
            list1.add(word);
        }
        for(int i=0; i<m; i++){
            String word = br.readLine();
            list2.add(word);
        }

      for(String w : list1){
        if(list2.contains(w)){
            result.add(w);
        }
      }

    System.out.println(result.size());
    
    for(String w : result){
        System.out.println(w);
    }


    }
}
