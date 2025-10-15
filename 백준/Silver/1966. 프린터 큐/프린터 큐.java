import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            ArrayList<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                q.offer(k);
                list.add(k);
            }

            int count = 0;
            ArrayList<Integer> copy = new ArrayList<>(list);
            copy.set(m, -1);

            while (true) {
                int z = q.peek();
                boolean chk = false;

                for(int j=0; j<list.size(); j++){
                    if(list.get(j) > z){
                        chk=true;
                        break;
                    }
                }

                if (chk) {
                    q.poll();
                    q.offer(z);
                    int tmp1 = list.remove(0);
                    list.add(tmp1);
                    int tmp2 = copy.remove(0);
                    copy.add(tmp2);
                } else { 
                    q.poll();
                    list.remove(0);
                    int removed = copy.remove(0);
                    count++;

                    if (removed == -1) { 
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
