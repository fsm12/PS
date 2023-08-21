import java.util.*;
import java.io.*;

public class Main{
	static int N,cnt=0;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            binarySearch(i);
        }
		
		bw.append(String.valueOf(cnt));
		bw.flush();
	}
	
	public static void binarySearch(int idx) {
        int left = 0, right = N-1;
 
        while (left < right) {
            if(left == idx) { 
            	left++;
            }else if(right == idx) {
            	right--;
            }else {
            	if (arr[left] + arr[right] == arr[idx]) {
                    cnt++;
                    return;
                }else if (arr[left] + arr[right] < arr[idx]) {
                	left++;
                }else {
                	right--;
                }
            }
        }
    }
}