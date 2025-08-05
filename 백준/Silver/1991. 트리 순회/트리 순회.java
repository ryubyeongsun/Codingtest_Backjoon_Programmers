import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Character> list[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            list[root-'A'].add(left); 
            list[root-'A'].add(right); 
        }

            sb = new StringBuilder();
            pre_dfs('A');
            System.out.println(sb);

            sb = new StringBuilder();
            in_dfs('A');
            System.out.println(sb);
            sb = new StringBuilder();

            pos_dfs('A');
            sb.append('A');
            System.out.println(sb);
           
        

    }
    public static void pre_dfs(char a){
        if(a=='.') return;
        sb.append(a);
        if(list[a-'A'].get(0) == '.' && list[a-'A'].get(1)=='.'){
            return;
        }
        
        
        for(char n : list[a-'A']){
            pre_dfs(n);
        }
    }
    public static void in_dfs(char a){
        if(a=='.') return;

        in_dfs(list[a-'A'].get(0));
        sb.append(a);
        in_dfs(list[a-'A'].get(1));

    }

    public static void pos_dfs(char a){

        for(char n : list[a-'A']){
            if(n!='.'){
                pos_dfs(n);
                sb.append(n);
            }
          
        }
    }

}
