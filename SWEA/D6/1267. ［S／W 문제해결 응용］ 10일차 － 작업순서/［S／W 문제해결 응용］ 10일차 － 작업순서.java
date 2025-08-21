import java.io.*;
import java.util.*;

class Solution {
    static int V;
    static int E;
    static ArrayList<Integer>[] list;
    static ArrayList<Integer> result;
    static ArrayList<Integer>[] myParent;
    static boolean[] visit;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <= 10; test_case++) { 
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            list = new ArrayList[V + 1];
            myParent = new ArrayList[V + 1];
            result = new ArrayList<>();
            visit = new boolean[V + 1];

            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
                myParent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int arr[] = new int[E*2];
            for (int i = 0; i < E*2 ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < E*2; i+=2) {
                list[arr[i]].add(arr[i+1]);
                myParent[arr[i+1]].add(arr[i]); 
                                            
            }

    
            for (int i = 1; i <= V; i++) {
                if (parentNode(i)) {  
                    bfs(i);
                }
            }

            System.out.print("#" + test_case);
            for (int n : result) {
                System.out.print(" " + n);
            }
            System.out.println();
        }
    }

    public static void bfs(int Pnode) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(Pnode);
        visit[Pnode] = true;
        result.add(Pnode);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int n : list[cur]) {
                boolean chk = true;
                for (int p : myParent[n]) {
                    if (!visit[p]) {
                        chk = false;
                        break;
                    }
                }
                if (chk && !visit[n]) {
                    visit[n] = true;
                    result.add(n);
                    q.offer(n);
                }
            }
        }
    }

    public static boolean parentNode(int chk) {
        return myParent[chk].isEmpty();
    }

}
