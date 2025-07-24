import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int sort[] = new int[N];
        int cbin[] = new int[8001]; // -4000 ~ 4000 → 0 ~ 8000 음수도 포함!!
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sort[i] = arr[i];
            sum += arr[i];
            cbin[arr[i] + 4000]++;
        }

        Arrays.sort(sort);

        // 산술평균 (반올림)
        System.out.println(Math.round((double) sum / N));

        // 중앙값
        System.out.println(sort[N / 2]);

        // 최빈값
        int max = 0;
        for (int i = 0; i < 8001; i++) {
            if (cbin[i] > max) {
                max = cbin[i];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (cbin[i] == max) {
                list.add(i - 4000);
            }
        }

        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            Collections.sort(list);
            System.out.println(list.get(1)); // 두 번째로 작은 값
        }

        // 범위
        System.out.println(sort[N - 1] - sort[0]);
    }
}
