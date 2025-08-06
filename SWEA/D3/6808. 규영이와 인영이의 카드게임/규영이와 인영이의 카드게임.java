import java.util.*;
import java.io.*;

class Solution
{   
    static int gyu[];
    static int iny[];
    static int winP;
    static int loseP;
    static boolean[] visit;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            gyu = new int[9];
            boolean chk[] = new boolean[19];
            visit = new boolean[9];
            winP = 0;
            loseP = 0;

            for(int i=0; i<9; i++){
                gyu[i] = Integer.parseInt(st.nextToken());
                chk[gyu[i]] = true;
            }

            iny = new int[9];
            int count = 0;
            for(int i=1; i<19; i++){
                if(!chk[i]){
                    iny[count++] = i;
                }
            }

            dfs(0, 0, 0);
            bw.write("#" + test_case + " " + winP + " " + loseP);
            bw.newLine();
		}
        bw.close();
        br.close();
	}

    public static void dfs(int gyuP, int inyP, int round){
        if(round==9) {
            if(gyuP>inyP) winP++;
            else loseP++;
            return;
        }
        for(int i=0; i<9; i++){
            if(!visit[i]){
                visit[i] = true;
                int cur_gyu = gyu[round];
                int cur_iny = iny[i];

                if(cur_gyu>cur_iny){
                    dfs(gyuP+cur_gyu+cur_iny, inyP, round+1);
                }else{
                    dfs(gyuP, inyP+cur_gyu+cur_iny , round+1);
                }
                visit[i] = false;
            }
        }

    }
}