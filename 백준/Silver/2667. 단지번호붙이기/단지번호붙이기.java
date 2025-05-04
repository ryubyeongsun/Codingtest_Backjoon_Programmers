import java.io.*;
import java.util.*;

class Main{
    static int arr[][];
    static boolean visit[][];
    static int xarr[] = {-1,1,0,0};
    static int yarr[] = {0,0,-1,1};
    static int sum;
    static int num;
    static ArrayList<Integer> result;

    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        arr = new int[num][num];
        result = new ArrayList<>();

        for(int i=0; i<num; i++){
            String line = br.readLine();
            for(int j=0; j<num; j++){
                arr[i][j] = line.charAt(j) - '0';  
            }

        }
        visit = new boolean[num][num];

        for(int i=0; i<num; i++){
            for(int j=0; j<num; j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                    sum = 0;
                    dfs(i,j);
                    result.add(sum);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i : result){
            System.out.println(i);
        }
        

    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        sum++;

        for(int i=0; i<4; i++){
            int nx = x+xarr[i];
            int ny = y+yarr[i];
            if(nx>=0 && ny>=0 && nx<num && ny<num){
                if(arr[nx][ny] == 1 && !visit[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }

    }
}