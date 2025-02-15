package backjoon;
import java.util.Scanner;

public class Back3003 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int arr[] = new int[6];
        for(int i=0; i<6; i++){
            arr[i]= s.nextInt();
        }

        for(int i=0; i<6; i++){
            switch (i) {
                case 0: arr[0] = 1-arr[0];
                    break;
                case 1: arr[1] = 1-arr[1];
                    break;
                case 2: arr[2] = 2-arr[2];
                    break;
                case 3: arr[3] = 2-arr[3];
                    break;
                case 4: arr[4] = 2-arr[4];
                    break;
                case 5: arr[5] = 8-arr[5];
                    break;
            
                default:
                    break;
            }
        }
        for(int i=0; i<6; i++){
            System.out.print(arr[i]+" ");
        }



    }
}
