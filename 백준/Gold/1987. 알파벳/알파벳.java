import java.io.*;
import java.util.*;

public class Main{
    static char map[][];
    static int result[][];
    static boolean visit[];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int r,c,max=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[26];


        for(int i=0; i<r; i++){
            String word = br.readLine();
            for(int j=0; j<c; j++){
                map[i][j] = word.charAt(j);
            }
        }

        visit[map[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(max);

    }

    public static void dfs(int x, int y,int count){
        max = Math.max(max, count);

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0 || nx>=r || ny>=c) continue;

            int pos = map[nx][ny] - 'A';
            if(!visit[pos]){
                visit[pos] = true;
                dfs(nx,ny,count+1);
                visit[pos] = false;
            }

        };


    
    }



}
