import java.io.*;

class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][] = new int[100001][4];
        int div = 1_000_000_009;
        int num = Integer.parseInt(br.readLine());

        arr[1][1]=1;
        arr[1][2]=0;
        arr[1][3]=0;
        arr[2][1]=0;
        arr[2][2]=1;
        arr[2][3]=0;
        arr[3][1]=1;
        arr[3][2]=1;
        arr[3][3]=1;

        for(int i=4; i<=100000; i++){
            arr[i][1] = (arr[i-1][2] + arr[i-1][3]) % div;
            arr[i][2] = (arr[i-2][1] + arr[i-2][3]) % div;
            arr[i][3] = (arr[i-3][1] + arr[i-3][2]) % div;
            
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            int n = Integer.parseInt(br.readLine());
            int result = ((arr[n][1] + arr[n][2]) % div + arr[n][3]) % div;
            sb.append(result).append('\n');

        }
        System.out.print(sb);
    }
}