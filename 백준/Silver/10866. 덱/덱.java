
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] argc)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front":
                    int fnum = Integer.parseInt(st.nextToken());
                    list.addFirst(fnum);
                    break;
                case "push_back":
                    int bnum = Integer.parseInt(st.nextToken());
                    list.addLast(bnum);
                    break;
                case "pop_front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.getFirst());
                        list.removeFirst();
                    }
                    break;
                case "pop_back":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(list.getLast());
                        list.removeLast();
                    }
                    break;
                case "size":
                    System.out.println(list.size());
                    break;
                case "empty":
                    if(list.isEmpty()){
                        System.out.println(1);
                    }else{ System.out.println(0); }
                    break;
                case "front":
                    if(list.isEmpty()){
                        System.out.println(-1);
                    }else{
                    System.out.println(list.getFirst());
                    }
                    break;
                case "back":
                    if(list.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(list.getLast());
                }
                    break;

            }
        }


    }
}
