import java.io.*;
import java.util.*;

public class Main {
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int[100][100];
        int sum = 0;


        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()); 
            int down = Integer.parseInt(st.nextToken());
            
            for(int a = left; a<left+10; a++){
                for(int b = down; b<down+10; b++){
                    arr[a][b] = 1;
                }

            }
        

        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(arr[i][j] == 1){
                    for(int k=0; k<4; k++){
                        int nx= dx[k] + i;
                        int ny= dy[k] + j;
                        if(nx<0 || ny<0 || nx>99 || ny >99 || arr[nx][ny] == 0){
                            sum++;
                        }
                    }
                }

            }

        }
        System.out.println(sum);

    }
}
