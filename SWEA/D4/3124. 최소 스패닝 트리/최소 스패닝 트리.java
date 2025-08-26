import java.util.*;
import java.io.*;

class Solution
{
    static int V;
    static int p[];
    
    public static class Edge implements Comparable<Edge>{
        int x,y,w;

        Edge(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.w, o.w);
        }

    }

	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            p = new int[V+1];

            for(int i=1; i<=V; i++){
                p[i] = i;
            }

            List<Edge> list = new LinkedList<>();

            for(int i=1; i<=E; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list.add(new Edge(x, y, e));
            }

            Collections.sort(list);

            int cnt = 0;
            long sum = 0;
            for(Edge e : list){
                if(union(e.x, e.y)){
                    sum+=e.w;
                    if(++cnt == V-1)break;
                }
            }
            System.out.println("#" + test_case + " " + sum);
			
		}
	}
    public static int find(int a){
        if(p[a]==a) return a;
        else{
            return p[a] = find(p[a]);
        }
    }
    public static boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa==pb) return false;

        p[pa] = pb;
        return true;
        
    }
}