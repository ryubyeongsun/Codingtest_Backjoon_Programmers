import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
		
		String str=n.nextLine();
		String arr[] =str.split("");
		int sum[] =new int [26];
	
		String[] alpa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
		"n", "o", "p", "q", "r", "s", "t", "u", "v","w", "x", "y", "z"};
		for(int i=0; i<alpa.length; i++){
			sum[i]=-1;
			for(int j=0; j<arr.length; j++){
			if(arr[j].equals(alpa[i])){
				 
				  sum[i]=j;
				  break;
			 }
				
			
	    }
		
		}

		for(int k=0; k<sum.length; k++){
			System.out.print(sum[k]+" ");
		}

	
		
    
        
    }
}
