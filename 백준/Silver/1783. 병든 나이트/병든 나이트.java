import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());  
        int M = Integer.parseInt(st.nextToken());  
        
        int max = 0;

        if (N == 1) {
            // 이동 불가능
            max = 1;
        } else if (N == 2) {
            // (−1,+2), (+1,+2) 이동만 가능
            max = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) {
                // 이동 방법이 제한됨
                max = Math.min(4, M);
            } else {
                // 자유롭게 이동 가능
                max = M - 2;
            }
        }
    
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        
    }
}

