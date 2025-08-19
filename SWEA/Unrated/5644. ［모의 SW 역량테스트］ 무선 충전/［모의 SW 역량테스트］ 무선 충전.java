/**
 * 메모리: 27,776kb
 * 실행시간: 107ms
 * 문제: swea 5644 무선충전
 * 아이디어:
 * 
 * 
 */

import java.util.*;
import java.io.*;

class Solution {
    static int M, A;
    static int[] arr, brr;
    static int[][] ap; // ap[i] = {row, col, c, p}
    static int[] dx = {0, -1, 0, 1, 0}; 
    static int[] dy = {0, 0, 1, 0, -1}; 

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            arr = new int[M + 1];
            brr = new int[M + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) arr[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) brr[i] = Integer.parseInt(st.nextToken());

            ap = new int[A][4];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); 
                int y = Integer.parseInt(st.nextToken()); 
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                ap[i][0] = y; 
                ap[i][1] = x; 
                ap[i][2] = c; 
                ap[i][3] = p;
            }

            int ans = chk();
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static int chk() {
        int Anx = 1, Any = 1;   
        int Bnx = 10, Bny = 10; 
        int total = 0;

        for (int i = 0; i <= M; i++) {
            Anx += dx[arr[i]];
            Any += dy[arr[i]];
            Bnx += dx[brr[i]];
            Bny += dy[brr[i]];
    

            ArrayList<Integer> listA = new ArrayList<>();
            ArrayList<Integer> listB = new ArrayList<>();

            for (int j = 0; j < A; j++) {
                if ( Math.abs(Anx - ap[j][0]) + Math.abs(Any - ap[j][1]) <= ap[j][2]) {
                    listA.add(j);
                }
                if (Math.abs(Bnx - ap[j][0]) + Math.abs(Bny - ap[j][1]) <= ap[j][2]) {
                    listB.add(j);
                }
            }

            int best = 0;
            if (listA.isEmpty() && listB.isEmpty()) {
                best = 0;
            } else if (listA.isEmpty()) {
                for (int b : listB) best = Math.max(best, ap[b][3]);
            } else if (listB.isEmpty()) {
                for (int a : listA) best = Math.max(best, ap[a][3]);
            } else {
                for (int a : listA) {
                    for (int b : listB) {
                        if (a == b) best = Math.max(best, ap[a][3]); 
                        else best = Math.max(best, ap[a][3] + ap[b][3]);
                    }
                }
            }
            total += best;
        }
        return total;
    }

}
