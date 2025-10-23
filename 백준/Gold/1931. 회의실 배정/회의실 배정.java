import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        TreeMap<Integer, List<Integer>> endTimeMap = new TreeMap<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            endTimeMap.putIfAbsent(end, new ArrayList<>());
            endTimeMap.get(end).add(start);
        }
        
        int count = 0;
        int lastEnd = 0;
        
        for (int endTime : endTimeMap.keySet()) {
            List<Integer> startTimes = endTimeMap.get(endTime);
            Collections.sort(startTimes);
            
            for (int start : startTimes) {
                if (start >= lastEnd) {
                    count++;
                    lastEnd = endTime;
                }
            }
        }
        
        System.out.println(count);
    }
}