import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
			List<Integer> list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i=0; i<num; i++){
				int ori = Integer.parseInt(st.nextToken());
				list.add(ori);

			}
			
			int num2 = Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<num2; i++){
				String cmd = st.nextToken();
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				if(cmd.equals("I")){
					for(int j=0; j<y; j++){
						int s = Integer.parseInt(st.nextToken());
						list.add(x,s);
						x++;
					}
				}
				
			}
			System.out.print("#" + test_case+" ");
			for(int i=0; i<10; i++){
				System.out.print(list.get(i)+ " ");
			}
			System.out.println();

		}
	}
}