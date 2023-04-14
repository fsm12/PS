import java.util.*;
import java.io.*;

/*
 * 1 초	256 MB
 * 
 * [입력]
 * 1> 세로 길이 H과 2차원 세계의 가로 길이 W (1 ≤ w, W ≤ 500)
 * 1> 블록이 쌓인 높이를 의미하는 0이상 H이하의 정수가 2차원 세계의 맨 왼쪽 위치부터 차례대로 W개
 * => 고이는 빗물의 총량
 * 
 * 바닥은 항상 막혀있다
 * 현재 인덱스 기준으로 좌측의 최댓값, 우측의 최댓값이 물을 허용할 수 있는 높이임
 * 그리고 이 둘의 최솟값만큼 물이 차오를 수 있음
 * 
 */

public class Main{
	static int H,W,maxL,maxR,ans;
	static int[] heights;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		heights = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int w=0; w<W; w++) {
			heights[w] = Integer.parseInt(st.nextToken());
		}
		
		for(int w=1; w<W-1; w++) {
			maxL = heights[w-1];
			maxR = heights[w+1];
			for(int i=0; i<w; i++) {
				maxL = Math.max(maxL, heights[i]);
			}
			for(int i=w; i<W; i++) {
				maxR = Math.max(maxR, heights[i]);
			}
			
			int minV = Math.min(maxL, maxR);
			if(heights[w] < minV) {
				ans += minV - heights[w];
			}
		}
		System.out.println(ans);
	}
}