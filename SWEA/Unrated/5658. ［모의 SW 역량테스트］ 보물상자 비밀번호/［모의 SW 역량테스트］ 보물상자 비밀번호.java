import java.util.*;
import java.io.*;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String num = br.readLine();
            int rotate = N / 4;

            Deque<Character> dq = new ArrayDeque<>();
            for(char ch : num.toCharArray()) {
                dq.addLast(ch);
            }
            
            Set<Integer> set = new HashSet<>();

            for(int r=0; r<N; r++) {
                StringBuilder sb = new StringBuilder();
                for(char ch : dq) sb.append(ch);

                for(int j=0; j<4; j++) {
                    String sub = sb.substring(j*rotate, (j+1)*rotate);
                    int value = Integer.parseInt(sub, 16);
                    set.add(value);
                }

                dq.addLast(dq.pollFirst());
            }

            List<Integer> list = new ArrayList<>(set);
            list.sort(Collections.reverseOrder());

            System.out.println("#" + test_case + " " + list.get(K-1));
        }
    }
}
