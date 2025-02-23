
import java.util.*;
public class Main {
    public static void main(String[] argc){
        Scanner s = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = s.nextInt();

        for(int i=0; i<n; i++){
            String cmd = s.next();
            switch (cmd) {
                case "push_front":
                    int fnum = s.nextInt();
                    list.addFirst(fnum);
                    break;
                case "push_back":
                    int bnum = s.nextInt();
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
