import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] argc) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		
		BigInteger decimal = new BigInteger(num, 8);
		String result = decimal.toString(2);

		System.out.println(result);
		
	}
	
}
        

