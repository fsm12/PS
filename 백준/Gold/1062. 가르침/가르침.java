import java.io.*;
import java.util.*;

public class Main{
	static int N, K, max=0;
	static boolean vis[] = new boolean[26];
	static String[] words;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		if(K<5) { // acint는 기본
			System.out.println(0);
            return;
		}else if(K==26) { // 전체단어 사용
			System.out.println(N);
            return;
		}else {
			for(int n=0; n<N; n++) {
                String str = br.readLine();
                words[n] = str.substring(4, str.length()-4);
            }
            K-=5;
            vis['a'-97]=true;
            vis['n'-97]=true;
            vis['t'-97]=true;
            vis['i'-97]=true;
            vis['c'-97]=true;
            dfs(0, 0);
            System.out.println(max);
		}
	}
	
	private static void dfs(int start, int count) {
        if(count == K) {
            int rs = 0;
            for(int i=0; i<N; i++) {
                boolean isTrue = true;
                for(int j=0; j<words[i].length(); j++) {
                    if(!vis[words[i].charAt(j)-97]) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    rs++;
                }
            }
            max = Math.max(max, rs);
            return;
        }
        
        for(int i=start; i<26; i++) {
            if(!vis[i]) {
                vis[i]=true;
                dfs(i, count+1);
                vis[i]=false;
            }
        }
    }
}