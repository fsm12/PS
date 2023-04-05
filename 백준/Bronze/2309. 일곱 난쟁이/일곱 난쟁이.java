import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 9> 난쟁이들의 키 (100을 넘지 않는 자연수)
 * => 일곱 난쟁이의 키를 오름차순으로 출력
 * 
 * 일곱 난쟁이의 키의 합이 100이 됨
 * 9C7
 */

public class Main{
	static List<Integer> heights;
	static boolean flag = false;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		heights = new ArrayList<>();
		for(int i=0; i<9; i++) {
			heights.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(heights);
		nCr(9,7,0,0,0,new int[7], new boolean[9]);
	}
	
	public static void nCr(int n, int r, int start, int depth, int sum, int[] arr, boolean[] vis) {
		if(flag)
			return;
		
		if(depth == r) {
			if(sum==100) {
				for(int num : arr) {
					System.out.println(num);
				}
				flag = true;
			}
			return;
		}
		
		for(int i=start; i<n; i++) {
			if(!vis[i]) {
				vis[i] = true;
				arr[depth] = heights.get(i);
				nCr(n,r,i+1,depth+1,sum+heights.get(i),arr,vis);
				vis[i] = false;
			}
		}
	}
}