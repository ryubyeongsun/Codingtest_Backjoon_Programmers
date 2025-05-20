import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			float[] arr = new float[num];

			for(int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				int med = Integer.parseInt(st.nextToken());
				int gimal = Integer.parseInt(st.nextToken());
				int sub = Integer.parseInt(st.nextToken());

				arr[i] = (float)(med * 0.35 + gimal * 0.45 + sub * 0.20);
			}

			float krr = arr[k - 1]; 

			float[] sort = arr.clone();
			Arrays.sort(sort); 
			int z = 0;
			for(int i = num - 1; i >= 0; i--) {
				if(sort[i] == krr) {
					z = num - 1 - i;
					break;
				}
			}

			String[] grade = {"A+", "A0", "A-" , "B+" , "B0", "B-" , "C+", "C0", "C-", "D0"};
			int jug = num / 10;

			String result = grade[z / jug];
			System.out.println("#" + test_case + " " + result);
		}
	}
}
