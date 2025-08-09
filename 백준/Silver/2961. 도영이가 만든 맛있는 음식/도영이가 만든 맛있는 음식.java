
/**
 * 아이디어:
 *  1. DFS에서 매 재료를 "선택"하면
 *    - 신맛은 곱하기 연산 (초기값 1)
 *    - 쓴맛은 더하기 연산 (초기값 0)
 *    - 선택한 재료 개수(count) +1
 * 
 * 2. DFS에서 매 재료를 "선택하지 않음"하면
 *    - 신맛, 쓴맛, count는 그대로 유지
 * 
 * 3. 재귀 종료 조건:
 *    - 모든 재료(idx == N)를 확인한 시점에서,
 *      선택한 재료가 1개 이상(count > 0)일 때만
 *      |신맛 - 쓴맛| 값을 계산해 최소값 갱신
 */

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] srr, brr;
    static int mindiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        srr = new int[N];
        brr = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            srr[i] = Integer.parseInt(st.nextToken()); // 신맛
            brr[i] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        dfs(0, 1, 0, 0); // idx, 신맛곱, 쓴맛합, 선택개수
        System.out.println(mindiff);
    }

    public static void dfs(int idx, int s, int b, int count) {
        if (idx == N) {
            if (count > 0) { // 공집합 제외
                mindiff = Math.min(mindiff, Math.abs(s - b));
            }
            return;
        }

        // 현재 재료 선택
        dfs(idx + 1, s * srr[idx], b + brr[idx], count + 1);

        // 현재 재료 선택 안 함
        dfs(idx + 1, s, b, count);
    }
}
