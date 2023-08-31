import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new String[N];
		for(int n=0; n<N; n++) {
			arr[n] = br.readLine();
		}
		
		Arrays.sort(arr, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        });
		
		StringBuilder sb = new StringBuilder();
		String prev = "";
		for(int n=0; n<N; n++) {
			if(prev.equals(arr[n]))
				continue;
			sb.append(arr[n]).append("\n");
			prev = arr[n];
		}
		System.out.println(sb.toString());
	}
}