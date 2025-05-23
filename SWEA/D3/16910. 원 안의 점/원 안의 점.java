import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            int n = (int) Math.pow(num, 2);

            for (int x = -num; x <= num; x++) {
                for (int y = -num; y <= num; y++) {
                    if (x * x + y * y <= n) {
                        count++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + count);
        }
    }
}
