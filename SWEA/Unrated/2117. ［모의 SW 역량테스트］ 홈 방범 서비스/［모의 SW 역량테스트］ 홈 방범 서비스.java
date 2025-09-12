import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int map[][] = new int[N][N];
            ArrayList<int []> homePos = new ArrayList<>();

            // 배열 입력
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1){
                        homePos.add(new int[]{i,j});
                    }
                }
            }

            int maxCount = 0;

            int K = N%2==0 ? N+1 : N;
            int cost = K*K + (K-1)*(K-1);

            while(K > 0){
                cost = K*K + (K-1)*(K-1);

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        int count = 0;
                        for(int d=0; d<homePos.size(); d++){
                            if(mandist(homePos, d, i, j, K)){
                                count++;
                            }
                        }

                        if(count * M >= cost){
                            maxCount = Math.max(maxCount, count);
                        }
                    }
                }

                K--; 
            }

            System.out.println("#"+test_case+" "+maxCount);
        }
    }
    public static boolean mandist(ArrayList<int[]> list, int idx, int x, int y, int k){
        int []pos = list.get(idx);
        int r = pos[0];
        int c = pos[1];
        return Math.abs(x-r) + Math.abs(y-c)<k;
    }
}
