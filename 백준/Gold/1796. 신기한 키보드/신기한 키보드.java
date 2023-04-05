import java.util.*;
import java.io.*;

/*
 * 2 초	128 MB
 * 
 * [입력]
 * 1> LCD창에 쓰여 있는 문자열 S (S는 길이는 50보다 작거나 같으)
 * => 문자열 S에 쓰여 있는 문자를 알파벳 순서대로 출력하고자 할 때, 키를 누르는 횟수의 최솟값
 * 
 * [문제]
 * LCD창에는 문자열 S가 쓰여 있다. 
 * 커서는 문자열의 가장 왼쪽 글자에 위치
 * 버튼 세 개는 왼쪽, 오른쪽, 엔터키
 * 
 * 엔터키는 문자열을 컴퓨터에 전송해서 컴퓨터 화면에 출력하는 역할
 * 문자열이 화면에 출력되면, 그 문자는 빈 칸으로 변함
 * 
 * [예제]
 * aaa => ERERE
 * ba => RELE
 * abba => ERRRELELE
 * acbbc => ERRERERELLLE
 * 
 * sol) 그리디?
 * 고른 문자로부터 가장 가까운 다음 문자를 택한다 => 항상 최적?은 아닌것 같음
 * 
 * sol) dp..
 * 우선 엔터는 알파벳 글자수만큼 눌러야함 => 따져야하는건 방향키
 * 같은 알파벳을 선택할때는 지그재그로 선택하지 않고 한 방향을 택하는 것이 나음 (어짜피 가장 먼 알파벳도 출력하기위해 도달해야하므로)
 * 
 * dp[i][j] : i번째 알파벳이 j번째 커서에 있을 때의 키 입력 최솟값
 * 1. 현재 커서에서 방문해야하는 알파벳의 최소인덱스부터 방문하고 최대인덱스로 갈때 눌러야할 방향키의 수 + 엔터 수(해당 알파벳의 개수)
 * 2. 현재 커서에서 방문해야하는 알파벳의 최대인덱스부터 방문하고 최소인덱스로 갈때 눌러야할 방향키의 수 + 엔터 수(해당 알파벳의 개수)
 * 의 최솟값으로 정의할 수 있음
 * 
 * 이전에 어떻게 방문했는지에 따라 뒤의 결과가 달라지므로 재귀 + dp로 구현
 * 
 */

public class Main {
	static String s;
	static int[] alpha_cnt, low_idx, high_idx;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();

		low_idx = new int[26];
		high_idx = new int[26];
		for(int i = 0; i < 26; i++) {
			low_idx[i] = Integer.MAX_VALUE;
			high_idx[i] = Integer.MIN_VALUE;
		}

		alpha_cnt = new int[26];
		for (int j = 0; j < s.length(); j++) {
			alpha_cnt[s.charAt(j) - 'a']++;
			low_idx[s.charAt(j) - 'a'] = Math.min(low_idx[s.charAt(j) - 'a'], j);
			high_idx[s.charAt(j) - 'a'] = Math.max(high_idx[s.charAt(j) - 'a'], j);
		}

		dp = new int[26][s.length()];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < s.length(); j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dfs(0, 0));
	}

	public static int dfs(int now, int cursor) {
		if (now == 26) {
			return 0;
		}

		if (dp[now][cursor] != -1)
			return dp[now][cursor];

		dp[now][cursor] = Integer.MAX_VALUE;
		
		if (alpha_cnt[now] > 0) {
			int low = low_idx[now];
			int high = high_idx[now];
			dp[now][cursor] = Math.min(dp[now][cursor], dfs(now + 1, high) + Math.abs(cursor - low) + Math.abs(low - high) + alpha_cnt[now]);
			dp[now][cursor] = Math.min(dp[now][cursor], dfs(now + 1, low) + Math.abs(cursor - high) + Math.abs(high - low)  + alpha_cnt[now]);
		}
		else {
			dp[now][cursor] = Math.min(dp[now][cursor], dfs(now + 1, cursor));
		}
		
		return dp[now][cursor];
	}
}