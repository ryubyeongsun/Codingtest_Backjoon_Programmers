import java.util.*;
import java.io.*;

class Solution
{
    static int p[];
	public static void main(String args[]) throws IOException
	{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            p = new int[N+1];

            for(int i=1; i<=N; i++){
                p[i] = i;
            }

            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1; i<=N; i++){
                int chk = find(i);
                list.add(chk);
            }

            Set<Integer> set = new HashSet<>();
            for(int i=1; i<=N; i++){
                set.add(find(i));
            }

            System.out.println("#" + test_case + " " + set.size());

		
		}
	}
    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        p[pa] = pb;

    }
    public static int find(int a){
        if(p[a] == a) return a;
        else{
            return p[a] = find(p[a]);
        }
    


    }
}