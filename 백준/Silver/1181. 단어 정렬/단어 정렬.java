import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static Str[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		arr = new Str[N];
		for(int n=0; n<N; n++) {
			arr[n] = new Str(br.readLine());
		}
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		String prev = "";
		for(int n=0; n<N; n++) {
			if(prev.equals(arr[n].str))
				continue;
			sb.append(arr[n].str).append("\n");
			prev = arr[n].str;
		}
		System.out.println(sb.toString());
		
	}
}

class Str implements Comparable<Str>{
	String str;
	
	public Str(String s) {
		this.str = s;
	}
	
    public int compareTo(Str o) {
    	if(this.str.length() == o.str.length()) {
    		return this.str.compareTo(o.str);
    	}
        return this.str.length() - o.str.length(); 
    }
}