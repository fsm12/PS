import java.util.*;
import java.io.*;

public class Main{
    static int N,M,result=0,count=0;
    static char[] s;
    
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char s[] = br.readLine().toCharArray();

		for(int i=1; i<M-1; i++) {
		if(s[i-1]=='I' && s[i]=='O' && s[i+1]=='I') {
				count++;
				if(count==N) {
					count--;
					result++;
				}
                i++;
			}
			else {
				count = 0;
			}
		}
		System.out.println(result);
    }
}