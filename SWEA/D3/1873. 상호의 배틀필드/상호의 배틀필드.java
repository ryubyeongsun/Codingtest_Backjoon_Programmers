
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			char arr[][] = new char[h][w];
			int x = 0;
			int y = 0;

			
			for(int i=0; i<h; i++){
				String line = br.readLine();
				for(int j=0; j<w; j++){
					arr[i][j] = line.charAt(j);
					if(line.charAt(j) == '<' || line.charAt(j) == '>' || line.charAt(j) == '^' || line.charAt(j) == 'v'){
						x=i;
						y=j;
					}
				}
			}
			
			int num = Integer.parseInt(br.readLine());
			char cmd[] = new char[num];
			String line_2 = br.readLine();
			for(int i=0; i<num; i++){
				cmd[i] = line_2.charAt(i);
			}

			for(int i=0; i<cmd.length; i++){
				switch (cmd[i]) {
					case 'U': 
						if(x-1>=0 && arr[x-1][y] == '.' ){
							arr[x][y] = '.';
							arr[x-1][y] = '^';
							x-=1;
						}else{ arr[x][y] = '^'; }
						break;
					case 'D':
						if( x+1<h && arr[x+1][y] == '.' ){
							arr[x][y] = '.';
							arr[x+1][y] = 'v';
							x+=1;
						}else{ arr[x][y] = 'v'; }
						break;
					case 'L':
						if(y-1>=0 && arr[x][y-1] == '.' ){
							arr[x][y] = '.';
							arr[x][y-1] = '<';
							y-=1;
						}else{ arr[x][y] = '<'; }
						break;
					case 'R':
						if(y+1<w && arr[x][y+1] == '.'){
							arr[x][y] = '.';
							arr[x][y+1] = '>';
							y+=1;
						}else{ arr[x][y] = '>'; }	
						break;
					case 'S':
						if(arr[x][y] == '<' ){
							for(int z=y-1; z>=0; z--){
								if(arr[x][z] == '_' || arr[x][z] == '.'){
									continue;
								}else if(arr[x][z] == '*' ){
									arr[x][z] = '.';
									break;
								}else if(arr[x][z] == '#'){  
									break;
								}
							}

						}
						if(arr[x][y] == '>'){
							for(int z=y+1; z<w; z++){
								if(arr[x][z] == '_' || arr[x][z] == '.'){
									continue;
								}else if(arr[x][z] == '*' ){
									arr[x][z] = '.';
									break;
								}else if(arr[x][z] == '#'){  
									break;
								}
							}

						}
						if(arr[x][y] == '^'){
							for(int z=x-1; z>=0; z--){
								if(arr[z][y] == '_' || arr[z][y] == '.'){
									continue;
								}else if(arr[z][y] == '*' ){
									arr[z][y] = '.';
									break;
								}else if(arr[z][y] == '#'){  
									break;
								}
							}

						}
						if(arr[x][y] == 'v' ){
							for(int z=x+1; z<h; z++){
								if(arr[z][y] == '_' || arr[z][y] == '.'){
									continue;
								}else if(arr[z][y] == '*' ){
									arr[z][y] = '.';
									break;
								}else if(arr[z][y] == '#'){  
									break;
								}
							}

						}
						break;
				}

			}
			System.out.print("#" + test_case +" ");

			for(int i=0; i<h; i++){
				for(int j=0; j<w; j++){
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}


		}
	}
}