import java.util.*;
import java.io.*;

public class Main {
    

    public static class Node implements Comparable<Node>{
        String word;
        
        Node(String word){
            this.word = word;
        }
        @Override
        public int compareTo(Node o){
            if(this.word.length() != o.word.length()){
                return this.word.length() - o.word.length();
            }
            return this.word.compareTo(o.word);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<Node> ts  = new TreeSet<>();

        for(int i=0; i<N; i++){
            String word = br.readLine();
            ts.add(new Node(word));

        }
        for(Node n : ts){
            System.out.println(n.word);
        }

    }

}
