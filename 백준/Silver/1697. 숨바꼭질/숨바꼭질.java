import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        int v [] = new int[100001];    

        q.add(N);
        v[N] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            int arr[] = {cur-1 , cur+1, cur*2};

            if(cur == K){
                System.out.println(v[K]-1);
                break;
            }
            for(int a : arr){
                if(a>=0 && a<=100000 && v[a] == 0 ){
                    v[a] = v[cur] + 1;
                    q.add(a);
                }
        }

    }
}
}




















