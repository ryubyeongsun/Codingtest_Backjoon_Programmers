import java.util.*;

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            int total = 0;

            for (int i = 1; i < N - 1; i++) {
                int left = i - 1;
                int right = i + 1;

                if (!(arr[left] < arr[i] && arr[i] > arr[right])) continue;

                int up = 1, down = 1;

                while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
                    up++;
                    left--;
                }
                while (right + 1 < N && arr[right] > arr[right + 1]) {
                    down++;
                    right++;
                }

                total += up * down;
            }

            System.out.println("#" + test_case + " " + total);
        }
        sc.close();
    }
}
