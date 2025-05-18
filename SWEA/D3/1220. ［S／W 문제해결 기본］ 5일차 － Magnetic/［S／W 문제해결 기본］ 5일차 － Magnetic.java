import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int test_case = 1; test_case <= 10; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
         
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int col = 0; col < n; col++) {
                boolean found = false;
                for (int row = 0; row < n; row++) {
                    if (arr[row][col] == 1) {
                        found = true;
                    } else if (arr[row][col] == 2) {
                        if (found) {
                            count++;
                            found = false; 
                        }
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
