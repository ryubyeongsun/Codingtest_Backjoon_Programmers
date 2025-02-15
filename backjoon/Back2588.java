package backjoon;
import java.util.*;

public class Back2588 {

    public static void main(String[] argc){
        Scanner s = new Scanner(System.in);

        String a = s.next();
        String b = s.next();
        int first = Integer.parseInt(a)* (b.charAt(2)-'0');
        int two = Integer.parseInt(a)* (b.charAt(1)-'0');
        int three = Integer.parseInt(a)* (b.charAt(0)-'0');
        int result = Integer.parseInt(a)*Integer.parseInt(b);

        System.out.println(first);
        System.out.println(two);
        System.out.println(three);
        System.out.println(result);
    }
    
}
