import java.util.*;
import java.io.*;

/*
 * 2 초	256 MB
 * 
 * [입력]
 * 1> N, M, L, K (1 ≤ N, M ≤ 500,000, 1 ≤ L ≤ 100,000, 1 ≤ K ≤ 100) 
 * 	N은 별똥별이 떨어지는 구역의 가로길이, M은 세로길이, L은 트램펄린의 한 변의 길이, K는 별똥별의 수
 * K> 별똥별이 떨어지는 위치의 좌표 x, y (0 ≤ x ≤ N, 0 ≤ y ≤ M)
 * 
 * sol)
 * 각 좌표 두개씩 잡고 이를 포함하는 L*L 영역에 속하면 카운트 증가
 * 
 */

public class Main{
	static int N,M,L,K,ans = Integer.MIN_VALUE;
	static List<int[]> stars;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        stars = new ArrayList<>();
        for(int k=0 ; k<K ; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[]{x, y});
        }
        
        for(int[] s1: stars){
            for(int[] s2: stars){
                ans = Math.max(ans, area(s1[0], s2[1]));
            }
        }
        System.out.println(K-ans);
    }

    private static int area(int x, int y) {
        int ans = 0;
        for(int[] star:stars){
            if(x<=star[0] && star[0]<=x+L && y<=star[1] && star[1]<=y+L) 
            	ans++;
        }
        return ans;
	}
}