import java.io.*;
import java.util.*;

public class Main {
    static int k,r,c;
    static int map[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int horseX[] = {-2,-2,-1,-1,2,2,1,1};
    static int horseY[] = {-1,1,-2,2,-1,1,-2,2};
    static boolean visit[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[r][c][k+1];
        System.out.println(bfs(0,0,k));

    }
    public static int bfs(int x, int y, int k){
        Queue<int []> q = new LinkedList<>();
        visit[x][y][k] = true;
        q.offer(new int[]{x,y,k,0});

        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int k1 = cur[2];
            int len = cur[3];

            if(cur[0] == r-1 && cur[1] == c-1) return len;

            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || ny<0 || nx>=r || ny>=c || visit[nx][ny][k1]) continue;
                if(map[nx][ny] == 1 ) continue;

                visit[nx][ny][k1] = true;
                q.offer(new int[]{nx,ny,k1,len+1});

            }

            if(k1>0){
                for(int i=0; i<8; i++){
                    int nx = cur[0] + horseX[i];
                    int ny = cur[1] + horseY[i];

                    if(nx<0 || ny<0 || nx>=r || ny>=c || visit[nx][ny][k1-1]) continue;
                    if(map[nx][ny]==1) continue;
                    visit[nx][ny][k1-1] = true;
                    q.offer(new int[]{nx,ny,k1-1,len+1});

                }

            }
        


        }
        return -1;
    }

}
