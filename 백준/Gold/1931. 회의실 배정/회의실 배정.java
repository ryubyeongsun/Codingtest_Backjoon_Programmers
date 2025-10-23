import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (!map.containsKey(end)) {
                map.put(end, new ArrayList<>());
            }
            map.get(end).add(start);
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int endTime = 0;
        int count = 0;

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int end = entry.getKey();
            List<Integer> starts = entry.getValue();

            for (int start : starts) {
                if (start >= endTime) {
                    count++;
                    endTime = end;
                }
            }
        }

        System.out.println(count);
    }
}