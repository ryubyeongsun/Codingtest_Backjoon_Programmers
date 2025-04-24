import java.io.*;

class Main {
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int div = 1_000_000_000;
        int arr[][] = new int[101][10];
        int num = Integer.parseInt(br.readLine());

        for(int i=1; i<=9; i++){
            arr[1][i] = 1;
        }

        for(int i=2; i<=num; i++){
            for(int j=0; j<=9; j++){
                if(j == 0){
                    arr[i][j] = arr[i-1][1] % div;
                } else if(j == 9){
                    arr[i][j] = arr[i-1][8] % div;
                } else {
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % div;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<=9; i++){
            sum = (sum + arr[num][i]) % div;
        }

        System.out.println(sum);
    }
}
