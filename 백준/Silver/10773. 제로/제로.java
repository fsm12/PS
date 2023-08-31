import java.util.*;
import java.io.*;

public class Main{
	static int K, sum, p=0;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		arr =  new int[K];
		for(int k=0; k<K; k++) {
			arr[p] = Integer.parseInt(br.readLine());
			if(p!=0 && arr[p]==0) {
				p-=1;
				sum -= arr[p];
				continue;
			}
			sum += arr[p++];
		}
		System.out.print(sum);
	}
}