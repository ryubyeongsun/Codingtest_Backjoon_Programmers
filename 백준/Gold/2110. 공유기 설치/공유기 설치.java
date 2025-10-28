import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int home[] = new int[N];

        for(int i=0; i<N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int left = 1;
        int right = home[N-1] - home[0];
        int result = 0;

        while (left<=right) {
            int count = 1;
            int mid = (left+right)/2;
            int last = home[0];

            for(int i=1; i<N; i++){
                if(home[i] - last >=mid){
                    count++;
                    last = home[i];
                }
            }
            
            if(count >= C){
                left = mid + 1;
                result = mid;
            }else{
                right = mid-1;
            }

        }
        System.out.println(result);
    }
}
