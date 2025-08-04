import java.io.*;
import java.util.*;


public class Main {

        public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> list = new ArrayList<>();

        int sum = 0;
        for(int i=0; i<9; i++){
            list.add(Integer.parseInt(br.readLine()));
            sum+=list.get(i);
        }

        int result = sum-100;
        int oneIndex = 0;
        int twoIndex = 0;

        for(int i=0; i<9; i++){
            for(int j=i+1; j<9; j++){
                if(list.get(i)+list.get(j) == result){
                    oneIndex = i;
                    twoIndex = j;
                    break;
                }
            }
        }
        if(oneIndex > twoIndex){
            list.remove(oneIndex);
            list.remove(twoIndex);
        }else{
            list.remove(twoIndex);
            list.remove(oneIndex);
        }

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            bw.write(String.valueOf(list.get(i)));
            bw.flush();
            bw.newLine();
        }
    }
  
}
