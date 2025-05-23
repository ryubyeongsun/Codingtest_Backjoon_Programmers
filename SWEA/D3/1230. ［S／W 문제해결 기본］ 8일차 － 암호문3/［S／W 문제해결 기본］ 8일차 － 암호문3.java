import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<num; i++){
				int a = Integer.parseInt(st.nextToken());
				list.add(a);
			}
			
			int count = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for(int i=0; i<count; i++){
				String cmd = st.nextToken();
				if(cmd.equals("I")){
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++){
					int s = Integer.parseInt(st.nextToken());
					list.add(x++, s);
					
					}
				}else if(cmd.equals("D")){
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++){
						list.remove(x);

					}
				}else if (cmd.equals("A")){
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++){
						int s = Integer.parseInt(st.nextToken());
						list.add(s);
						
					}
				}

			}
			System.out.print("#" + test_case + " ");
			for(int i=0; i<10; i++){
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}
}