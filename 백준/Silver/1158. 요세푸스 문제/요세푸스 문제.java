
import java.util.*;
public class Main {
    public static void main(String[] argc){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
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
