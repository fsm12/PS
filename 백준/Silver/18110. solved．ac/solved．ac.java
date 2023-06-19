import java.util.*;
import java.io.*;

public class Main {
	static int N, num;
	static int[] arr;
	static double sum = 0;
    
    public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

		for(int n=0; n<N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		num = (int) Math.round(N*0.15);
		for(int i=num; i<N-num; i++) {
			sum += arr[i];
		}
		
		bw.append((int)Math.round(sum/(N-num*2))+"");
        bw.flush();
    }
}