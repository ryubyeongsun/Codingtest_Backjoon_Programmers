import java.util.*;
import java.io.*;

public class Main {
    static int min=Integer.MAX_VALUE;
    static int srr[];
    static int brr[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        N = Integer.parseInt(br.readLine());

        srr =  new int[N];
        brr = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            srr[i] = Integer.parseInt(st.nextToken());
            brr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0,1,0);

        System.out.println(min);

    }

    public static void dfs(int dep, int s, int b){

        if(dep > N-1){
            if(b!=0){
                min = Math.min(min, Math.abs(s-b));
            }
            return;
        }

        dfs(dep+1, s*srr[dep], b+brr[dep]);

        dfs(dep+1, s, b);


    }

}
