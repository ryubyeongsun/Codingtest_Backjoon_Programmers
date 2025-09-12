import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean errorBt[] = new boolean[10];

        if (M > 0) { 
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                int ch = Integer.parseInt(st.nextToken());
                errorBt[ch] = true;
            }
        }

        int answer = Math.abs(N - 100); 

        for (int i = 0; i <= 1000000; i++) {
            int num = i;
            boolean possible = true;
            int len = 0;

            if(num == 0) {
                if(errorBt[0]) continue;
                len = 1;
            } else {
                while(num > 0) {
                    int digit = num % 10;
                    if(errorBt[digit]) {
                        possible = false;
                        break;
                    }
                    len++;
                    num /= 10;
                }
            }

            if(possible){
                int press = len + Math.abs(N - i);
                answer = Math.min(answer, press);
            }
        }

        System.out.println(answer);
    }
}
