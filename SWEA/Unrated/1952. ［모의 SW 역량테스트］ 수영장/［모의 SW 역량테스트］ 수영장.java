import java.io.*;
import java.util.*;

class Solution {
    static int[] days; // 1일권, 1개월권, 3개월권, 1년권
    static int[] month; // 1월~12월 수영일
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days = new int[4];
            for(int i=0; i<4; i++){
                days[i] = Integer.parseInt(st.nextToken());
            }

            month = new int[13]; // 1~12월, 0번은 사용 안함
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=12; i++){
                month[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            dfs(1, 0); // 1월부터 시작, 누적 요금 0
            System.out.println("#" + test_case + " " + min);
        }
    }

    static void dfs(int m, int price){
        if(m > 12){
            min = Math.min(min, price);
            return;
        }

        if(month[m] == 0){ // 수영 안 하는 달이면 패스
            dfs(m+1, price);
            return;
        }

        // 1일권
        dfs(m+1, price + days[0]*month[m]);
        // 1개월권
        dfs(m+1, price + days[1]);
        // 3개월권
        dfs(m+3, price + days[2]);
        // 1년권
        dfs(13, price + days[3]);
    }
}
