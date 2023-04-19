import java.util.*;
import java.io.*;

public class Main{
	static int N,M,cnt=1,ans;
	static Map<String, Integer> nameNum;
	static Map<Integer, String> numName;
	static List<String> list;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nameNum = new HashMap<>();
		numName = new HashMap<>();
		for(int n=0; n<N; n++) {
			String name = br.readLine();
			nameNum.put(name, cnt);
			numName.put(cnt, name);
			cnt+=1;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m=0; m<M; m++) {
			String tmp = br.readLine();
			if(isInt(tmp)) {
				sb.append(numName.get(Integer.parseInt(tmp)));
			}else {
				sb.append(nameNum.get(tmp));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isInt(String tmp) {
		try {
			int val = Integer.parseInt(tmp);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}