import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start = Math.min(N,M)/2;

        for(int i=0; i<R; i++) {
            for(int j=0; j<start; j++) {
                int lay_s = j;
                int row = N - 1 - j;
                int col = M - 1 - j;

                int brr = arr[lay_s][lay_s]; 

                // left ←
                for (int l = lay_s; l < col; l++)
                    arr[lay_s][l] = arr[lay_s][l+1];
                // top ↑
                for (int r = lay_s; r < row; r++)
                    arr[r][col] = arr[r+1][col];
                // right →
                for (int b = col; b > lay_s; b--)
                    arr[row][b] = arr[row][b-1];
                // bottom ↓
                for (int b = row; b > lay_s + 1; b--)
                    arr[b][lay_s] = arr[b-1][lay_s];

                arr[lay_s + 1][lay_s] = brr; 

            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}



