import java.util.*;
import java.io.*;

class Solution
{
	static class Atom implements Comparable<Atom>{
		int x,y,dir,e;

		public Atom(int x, int y, int dir, int e){
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}

		@Override
		public int compareTo(Atom o){
			// x좌표 작은 순, x좌표 같다면 y좌표가 작은 순
			return this.x<o.x ? -1 : (this.x != o.x ? Integer.compare(this.x, o.x) : Integer.compare(this.y, o.y));

		}
	}

	static class Pair implements Comparable<Pair>{ // 충돌리스트에 담을 충돌하는 두 원자와 그때의 시간 정보.
		int i,j,time;

		public Pair(int i, int j, int time){
			super();
			this.i = i;
			this.j = j;
			this.time = time;
		}
		@Override
		public int compareTo(Pair o){
			return Integer.compare(this.time, o.time);
		}

	}

	static int N;
	static ArrayList<Atom> list;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for(int i=0; i<N; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2; // 나누었을때 실수 사용하지 않도록 2배로 좌표키우기
				int y = Integer.parseInt(st.nextToken())*2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x, y, d, e));
			}
			System.out.println("#"+test_case+" " + makeBoomPair());

		}
	}

	public static int makeBoomPair(){
		// 원자리스트를 좌표기준으로 정렬
		Collections.sort(list);
		ArrayList<Pair> boomList = new ArrayList<>();
		// 원자 2개씩 조합 생성
		for(int i=0; i<N; i++){ // 선택할 첫번째 원자
			for(int j=i+1; j<N; j++){ // 선택할 두번째 원자
				Atom a = list.get(i);
				Atom b = list.get(j);

				// 같은 x좌표를 갖는 원자들이 만날 때
				if(a.x==b.x){
					if(a.dir==0 && b.dir==1){
						boomList.add(new Pair(i, j, Math.abs(a.y-b.y)/2));
					}
				}
				// 같은 y좌표를 갖는 원자들이 만날 때
				if(a.y==b.y){
					if(a.dir==3 && b.dir==2){
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)/2));
					}
				}
				// / 대각선 라인에 있는 대상들이 만날 때
				if(a.x-a.y==b.x-b.y){
					if(a.dir==3 && b.dir==1 || a.dir==0 && b.dir==2){
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)));
					}
				}
				// \ 대각선 라인에 있는 대상들이 만날 때
				if(a.x+a.y==b.x+b.y){
					if(a.dir==1 && b.dir==2 || a.dir==3 && b.dir==0){
						boomList.add(new Pair(i, j, Math.abs(a.x-b.x)));
					}
				}
			}
		}

		return getTotalEnerger(boomList);

	}
	public static int getTotalEnerger(ArrayList<Pair> boomList){
		Collections.sort(boomList); // 터지는 시간 기준 오름차순 정렬
		int INF = Integer.MAX_VALUE;
		int boomTimes[] = new int[N];
		Arrays.fill(boomTimes, INF);
		int sum = 0;

		for(Pair p : boomList){
			
			if(boomTimes[p.i] < p.time || boomTimes[p.j] < p.time) continue;
			
			if(boomTimes[p.i] == INF) {
				boomTimes[p.i] = p.time;
				sum += list.get(p.i).e;
			}
			if(boomTimes[p.j] == INF) {
				boomTimes[p.j] = p.time;
				sum += list.get(p.j).e;
			}
		}

		return sum;
	}
}