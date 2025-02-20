
import java.util.*;
import java.io.*;
public class Main {           
    public static void main(String[] argc)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine();
        StringBuilder word = new StringBuilder(w);
        int n = Integer.parseInt(br.readLine());
        int connect = w.length();
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) { 
                case "L": 
                    if(connect == 0){
                        break;
                    }else{
                        connect = connect-1;
                    }                                     
                    break;
                case "D":
                    if(connect == word.length()){
                        break;
                    }else{
                        connect = connect+1;
                    }
                    break;
                case "B": 
                    if(connect == 0){
                        break;
                    }else{
                        word.delete(connect-1,connect);
                        connect = connect-1;
                    }
                    break;
                case "P":
                    String ad = st.nextToken();
                    word.insert(connect, ad); 
                    connect = connect + 1;
                    break;
            }
        }
        System.out.println(word.toString());
    }
}
