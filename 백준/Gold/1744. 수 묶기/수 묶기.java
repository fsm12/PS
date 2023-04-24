import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> N (N은 50보다 작은 자연수)
 * N> 수열의 각 수
 * => 수를 합이 최대가 나오게 묶었을 때 합
 * 
 * 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다
 * 최대가 되게 하는 프로그램
 * 
 * sol) 그리디
 * 큰수끼리 곱함, 음수는 음수끼리 곱해져야함
 * 1은 곱하기보단 더하기가 이득
 */

public class Main{
	static int N, ans;
	static List<Integer> p_list, n_list;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		p_list = new ArrayList<>();
		n_list = new ArrayList<>();
		for(int n=0; n<N; n++) {
			int val = Integer.parseInt(br.readLine());
			if(val>0)
				p_list.add(val);
			else
				n_list.add(val);
		}

		Collections.sort(p_list, Collections.reverseOrder());
		Collections.sort(n_list);
		
		for(int n=0; n<p_list.size(); n++) {
			int cur = p_list.get(n);
			if(n < p_list.size()-1) {
				int nxt = p_list.get(n+1);
				if(cur==1 || nxt==1) {
					ans += cur + nxt;
				}else {
					ans += cur * nxt;
				}
				n+=1;
			}
			else {
				ans += cur;
			}
		}
		
		for(int n=0; n<n_list.size(); n++) {
			if(n < n_list.size()-1) {
				ans += n_list.get(n) * n_list.get(n+1);
				n+=1;
			}
			else {
				ans += n_list.get(n);
			}
		}
		
		bw.append(ans+"");
		bw.flush();
	}
}