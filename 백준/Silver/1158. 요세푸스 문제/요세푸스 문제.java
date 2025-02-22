import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new LinkedList<>();
        StringBuilder arr = new StringBuilder();
        for(int i=0; i<n; i++){
            list.add(i+1);
        }
        int index = 0;
        arr.append("<");
        while(!list.isEmpty()){
            index = (index+k-1) % list.size();
            arr.append(list.remove(index));
            if(list.size() == 0){
            arr.append("");}
            else{
                arr.append(", ");
            }

        }
        arr.append(">");

        System.out.println(arr);

        
        

    }
}
