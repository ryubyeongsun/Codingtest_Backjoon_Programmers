import java.util.*;
import java.io.*;
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) {
            int num = Integer.parseInt(br.readLine()); 
            char[][] arr = new char[100][100];
            int max = 0;

            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = line.charAt(j);
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 99; k >= j; k--) {
                        if (arr[i][j] == arr[i][k]) {
                            boolean chk = true;
                            for (int z = k; z >= j; z--) {
                                if (arr[i][z] != arr[i][j + (k - z)]) {
                                    chk = false;
                                    break;
                                }
                            }
                            if (chk) {
                                max = Math.max(max, k - j + 1);
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 99; k >= j; k--) {
                        if (arr[j][i] == arr[k][i]) {
                            boolean chk = true;
                            for (int z = k; z >= j; z--) {
                                if (arr[z][i] != arr[j + (k - z)][i]) {
                                    chk = false;
                                    break;
                                }
                            }
                            if (chk) {
                                max = Math.max(max, k - j + 1);
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println("#" + num + " " + max);
        }
    }
}
