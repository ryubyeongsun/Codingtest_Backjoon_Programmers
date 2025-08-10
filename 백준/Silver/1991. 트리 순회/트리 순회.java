import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Character> word[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        word = new ArrayList[N];

        for(int i=0; i<N; i++){
            word[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
                char node = st.nextToken().charAt(0);
                char left = st.nextToken().charAt(0);
                char right = st.nextToken().charAt(0);
                word[node-'A'].add(left);
                word[node-'A'].add(right);
                
            
        }
        sb = new StringBuilder();
        pre_dfs('A');
        System.out.println(sb);

        sb = new StringBuilder();
        in_dfs('A');
        System.out.println(sb);

        sb = new StringBuilder();
        po_dfs('A');
        System.out.println(sb);

    }

    public static void pre_dfs(char a ){

        if(a == '.') return;

        sb.append(a);
        for(char w : word[a-'A']){
            pre_dfs(w);

        }

    }
    public static void in_dfs(char a){

        if(a=='.'){
            return;
        }

        in_dfs(word[a-'A'].get(0));
        sb.append(a);
        in_dfs((word[a-'A'].get(1)));

    }
    public static void po_dfs(char a){

        if(a=='.') return;


        po_dfs(word[a-'A'].get(0));
        po_dfs(word[a-'A'].get(1));
        sb.append(a);
    }



}
