import java.io.*;
import java.util.*;

public class Main {
	static int N, ans=1;
	static int[] A, lis;

	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		 
		A = new int[N];
		lis = new int[N];
 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n=0; n<N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
 
		lis[0] = A[0];
		for (int n=1; n<N; n++) {		
			if (lis[ans-1] < A[n]) {
				ans++;
				lis[ans-1] = A[n];
			} else {
				int l=0, r=ans;
				while (l<r) {
					int mid = (l+r)/2;
					if(lis[mid] < A[n]) 
						l = mid + 1;
					else
						r = mid;
				}
				lis[l] = A[n];
			}
		}
		System.out.println(ans);
	}
}
