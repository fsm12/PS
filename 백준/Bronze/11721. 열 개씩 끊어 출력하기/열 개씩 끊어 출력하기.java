import java.util.*;
import java.io.*;

public class Main {
	static String inpt;
	static StringBuilder ans;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		inpt = br.readLine();
		int len = inpt.length();
		
		ans = new StringBuilder();
		
		int i=1; 
		while(i<=len) {
			for(int j=0; j<10; j++) {
				ans.append(inpt.charAt(i-1));
				i++;
				if(len<i)
					break;
			}
			ans.append("\n");
		}
		System.out.println(ans);
	}
}