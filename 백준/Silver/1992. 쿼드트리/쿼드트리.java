import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int arr[][];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            String num = br.readLine();
            for(int j=0; j<N; j++){
                arr[i][j] = num.charAt(j) - '0';
            }
        }
        sb = new StringBuilder();

        divGo(0, 0, N); 
        
        System.out.println(sb);

    }

    public static void divGo(int r ,int c, int size){
        int sum = 0;        

        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                sum+=arr[i][j];
            }

        }

        if(sum == size*size){
            sb.append("1");
            
        }else if(sum==0){
            sb.append("0");
        }else{
            int div = size/2;
            sb.append("(");
            divGo(r, c, div);
            divGo(r, c+div, div);
            divGo(r+div, c, div);
            divGo(r+div, c+div, div);
            sb.append(")");

        }


    }

}
