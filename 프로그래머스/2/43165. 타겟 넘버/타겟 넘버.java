	
class Solution {
    static int size; 
    static int num;
    static int an;
    static int[]nums;
    public int solution(int[] numbers, int target) {
        size = numbers.length;
        nums = numbers.clone();
        num = target;
        an = 0;

        dfs(0,0);
        
       
        return an;
    }
    public static void dfs(int depth, int cur){

        if(depth==size){
            if(cur==num){
                an++;
            }
            return;
        }

          dfs(depth+1,cur+nums[depth]);
          dfs(depth+1,cur-nums[depth]);
    }
}