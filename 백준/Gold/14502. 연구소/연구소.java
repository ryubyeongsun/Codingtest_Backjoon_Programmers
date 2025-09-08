import java.util.*;
import java.io.*;

public class Main {
    
    static int N, M, max;
    static int map[][], copy[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copy = new int[N][M];
        
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0);
        System.out.println(max);
    }
    
    public static void dfs(int dep) {
        if(dep == 3) {
            for(int i=0; i<N; i++)
                copy[i] = map[i].clone();
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(copy[i][j] == 2) spreadVirus(i, j);
                }
            }
            
            int safe = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(copy[i][j] == 0) safe++;
                 }
            }
            max = Math.max(max, safe);
            return;
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1; 
                    dfs(dep + 1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    public static void spreadVirus(int x, int y) {
        for(int d=0; d<4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx>=0 && nx<N && ny>=0 && ny<M && copy[nx][ny]==0) {
                copy[nx][ny] = 2;
                spreadVirus(nx, ny);
            }
        }
    }
}
