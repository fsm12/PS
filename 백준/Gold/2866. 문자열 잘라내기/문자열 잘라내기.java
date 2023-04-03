import java.util.*;
import java.io.*;

/*
 * 1 초	256 MB
 * 
 * [입력]
 * 1> R과 C (2 ≤ R, C ≤ 1000)
 * R> C개의 알파벳 소문자
 * 
 * 만약 가장 위의 행을 지워도 테이블의 열을 읽어서 문자열이 중복되지 않는다면, 
 * 가장 위의 행을 지워주고, count의 개수를 1 증가시키는, 이 과정을 반복
 * 예제 1은, 가장 위의 행을 지우면 a,d,a,t,a,k가 되므로 a가 중복 => 출력
 * 
 * sol)
 * 가장 밑에서부터 확인하면서 중복이 있으면 위로 올라가고 아니라면 현재 cnt를 출력
 * => 중복이었던 문자열만 체크하면 됨
 * 해쉬맵으로 key(인덱스) : val(중복문자열)
 * 구현이..
 * 
 * sol) 
 * 문제에서 요구하는 그대로 구현해도 될듯
 */

public class Main{
	static int R,C,cnt;
	static char[][] map;
	static Set<String> set;
	static String[] arr;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int r=0; r<R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		// arr에 미리  열을 위에서 아래로 읽어서 만든 문자열을 담음
		arr = new String[C];
		for (int c=0; c<C; c++) {
			StringBuilder sb = new StringBuilder();
			for (int r=1; r<R; r++) {
				sb.append(map[r][c]);
			}
			arr[c] = sb+"";
		}
		
		// 집합에 담아두고 겹치면 break
		stop: for(int r=0; r<R; r++) {
			set = new HashSet<>();
			for (int c=0; c<C; c++) {
				String now = arr[c].substring(r);
				if (set.contains(now)) 
					break stop;
				else 
					set.add(now);
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}