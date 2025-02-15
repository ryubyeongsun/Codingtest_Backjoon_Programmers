import java.util.*;

public class Back1018{
    public static boolean[][] color;
    public static int min = 64;

    public static void main(String[] argc){

        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        color = new boolean[a][b];

        for(int i=0; i<a; i++){
            String line = s.next();
            for(int j=0; j<b; j++){
                if(line.charAt(j) == 'W'){
                    color[i][j]=true;
                }else{
                    color[i][j]=false;
                }

            }
        }
        int row = a-7;
        int col = b-7;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                find(i,j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y){

        boolean T = color[x][y];
        int row_s = x+8;
        int col_s = y+8;
        int count=0;
        for(int i=x; i<row_s; i++){
            for(int j=y; j<col_s; j++){
                if(T != color[i][j]){
                    count++;
                }
                T = !T;
            }
            T=!T;
        }
        
        count = Math.min(count, 64-count);
        min = Math.min(min, count);

    }



}