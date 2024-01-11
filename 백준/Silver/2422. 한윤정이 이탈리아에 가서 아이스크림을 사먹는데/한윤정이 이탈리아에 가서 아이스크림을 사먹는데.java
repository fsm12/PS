import java.util.*;
import java.io.*;

/*
 * 1. 인접리스트로 불가능 간선 제외 모두 세팅 후 조합
 * 2. 조합 구현 후 불가능 조합 제거
 * 3. 3차원 방문배열 선언 및 불가능 조합 모두 true 세팅 후 조합 진행
 * 4. 전체 경우의수 - 불가능 경우의 수 (선택)
 */

public class Main{
	static int N,M,cnt=0;
	static int[] arr;
	static boolean[][][] vis;
	
	public static void main(String[] args) throws Exception{
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		vis = new boolean[N+1][N+1][N+1];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			arr = new int[3];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());

			for(int i=1; i<=N; i++) {
				if(arr[0]==i || arr[1]==i)
					continue;
				arr[2] = i;
				int[] cpyArr = Arrays.copyOf(arr, arr.length);
				Arrays.sort(cpyArr);
				if(!vis[cpyArr[0]][cpyArr[1]][cpyArr[2]]) {
					vis[cpyArr[0]][cpyArr[1]][cpyArr[2]] = true;
					cnt++;
				}
			}
		}
		int ans=1;
		for(int i=N; i>N-3; i--) {
			ans*=i;
		}
		System.out.println(ans/6-cnt);
	}
}