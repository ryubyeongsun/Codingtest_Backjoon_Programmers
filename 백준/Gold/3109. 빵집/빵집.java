import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1,0,1};
    static int dy[] = {1,1,1};
    static char arr[][];
    static boolean visit[][];
    static int max=0;
    static int R;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];

        for(int i=0; i<R; i++){
            String word = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = word.charAt(j);
            }
        }

        for(int i=0; i<R; i++){
            if(dfs(i,0)){
                max++;
            }

        }
        bw.write(max+"\n");
        bw.close();
        br.close();
            
    }
    public static boolean dfs(int x, int y){
        visit[x][y] = true;
        if(y == C-1) return true;


        for(int i=0; i<3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=R || ny>=C) continue;
            if(arr[nx][ny] == 'x' || visit[nx][ny]) continue;

            if(dfs(nx,ny)){
                return true;
            }

        }
        return false;

    }
        
}
