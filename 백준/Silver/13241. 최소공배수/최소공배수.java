import java.util.*;
import java.io.*;

public class Main {
	static long A,B,gcd_;
	
    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        gcd_ = gcd(A,B);
        
        System.out.println(gcd_ * (A/gcd_) * (B/gcd_));
    }
    
    public static long gcd(long a, long b) {
    	if(b==0) {
    		return a;
    	}
    	return gcd(b, a%b);
    }
}