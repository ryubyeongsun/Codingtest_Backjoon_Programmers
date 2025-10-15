import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int found = 0;

        while (true) {
            String s = Integer.toString(num);

            if (s.contains("666")) {
                found++;
                if (found == N) {
                    System.out.println(num);
                    break;
                }
            }

            num++;
        }
    }
}
