import java.util.*;
import java.io.*;

public class Main{
	static int N,cnt;
	static Set<String> set;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		set = new HashSet<>();
		for(int n=0; n<N; n++) {
			String tmp = br.readLine();
			if(tmp.equals("ENTER")) {
				flag = true;
				set = new HashSet<>();
			}else if(flag && !set.contains(tmp)){
				cnt+=1;
				set.add(tmp);
			}
		}
		bw.append(cnt+"");
		bw.flush();		
	}
}