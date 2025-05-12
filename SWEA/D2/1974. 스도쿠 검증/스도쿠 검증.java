import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int arr[][] = new int[9][9];
            
            int result = 1;
            for(int i=0; i<9; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j=0; j<9; j++){
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<9; i++){
                int col[] = new int[10];
                int row[] = new int[10];
            	for(int j=0; j<9; j++){
                    row[arr[i][j]]++;
                    col[arr[j][i]]++;
                	for(int k=1; k<=9; k++){
                    	if (row[k] > 1 || col[k] > 1) {
                        result = 0;
                        break;
                   	 	}
                    }if(result==0) break;
                }
                
            }
            for(int i=0; i<9; i+=3){
            	for(int j=0; j<9; j+=3){
                    int box[] = new int[10];
                	for(int a=i; a<i+3; a++){
                    	for(int b=j; b<j+3; b++){
                        	box[arr[a][b]]++;
                        }
                    }
                    for(int z=1; z<=9; z++){
                    	if(box[z] >1){
                        	result = 0;
                            break;
                        }
                    }if(result == 0) break;
                }if(result == 0) break;
            }
            
			System.out.println("#" + test_case + " " + result);
		}
	}
}