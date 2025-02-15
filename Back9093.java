import java.util.*;

public class Back9093{
    public static void main(String[] argc){

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        for(int i=0; i<n; i++){
            String word = s.nextLine();
            String arr[] = word.split(" ");
            StringBuilder rw = new StringBuilder();

            for(String w : arr){
                rw.append(new StringBuilder(w).reverse()).append(" ");
            }
            System.out.println(rw);
        }

    }
}