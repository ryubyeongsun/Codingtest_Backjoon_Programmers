import java.io.*;

class Main {
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long arr[] = new long[91];
        int num = Integer.parseInt(br.readLine());

        arr[1]=1;
        arr[2]=1;
        arr[3]=2;

        for(int i=4; i<=num; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[num]);

    }
}
