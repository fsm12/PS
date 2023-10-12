import java.io.*;
import java.util.*;

/*
 * 5의 개수를 파악하려면 5의 거듭제곱들로 나누었을 때 의 몫을 구하면 됨
 * 
 */
public class Main {
	static int N,cnt=0,l,r;
	static boolean possi=false;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        N = Integer.parseInt(br.readLine());
        
        l=1;
        r=N*5;
        while(l<=r){
            int mid = (l+r)/2;
            if(N<solve(mid)){
                r=mid-1;
            }else if(solve(mid)==N){
                r=mid-1;
                possi=true;
            }else{
                l = mid+1;
            }
        }
        System.out.println(possi?l:-1);
    }
 
    private static int solve(int mid){
        int cnt=0;
        for(int i=5; i<=mid; i*=5){
            cnt+=(mid/i);
        }
        return cnt;
    }
}