import java.util.*;
import java.io.*;

/* 문제)
 * 현재 위치부터 앞을 봤을 때 자신과 같거나 큰 기둥의 위치를 반환
 * 
 * 시간복잡도)
 * N은 50만이므로, N^2은 불가.
 * NlogN까지 가능
 * 
 * sol)
 * 1. 앞에서 봤을 때, 뒤에서 봤을 때 최댓값을 각각 저장해서 이를 비교하여 구함
 * => 인덱스 관리가 어려움
 * 2. 각 길이에 대한 개수를 정수형 배열로 저장해서 감소시키며 최댓값 찾기?
 * => 한 길이에 쏠려있으면 시간 복잡도도 비슷할 뿐더러, 최댓값이 항상 답임을 보장하지 않음
 * 3. 스택 이용 (이용)
 * => 전에 들어온 값보다 작은 값이 들어오면 추가하고, 큰 값이 들어오면 해당 값보다 같거나 큰 값을 발견할 때까지 값을 뺌
 */

public class Main{
	static int N, p=1;
	static int[] inp;
	static Point[] stack;

    public static void main(String[] args) throws IOException {
    	// System.setIn(new FileInputStream("input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st= new StringTokenizer(br.readLine());
    	inp = new int[N+1];
    	for(int i=1; i<=N; i++) {
    		inp[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	stack = new Point[N+1];
    	StringBuilder sb = new StringBuilder();
    	sb.append("0 ");
    	stack[p++] = new Point(inp[1], 1);

    	for(int n=2; n<=N; n++) {
    		if(inp[n] < stack[p-1].val) { // 전에 들어온 값이 크다면, 수신할 수 있는 탑이 있는 것
    			sb.append(stack[p-1].idx).append(" "); 
    		}else { // 수신할 수 있는 탑이 아니라면
    			while(p!=1 && stack[p-1].val <= inp[n]) { // 수신가능한 탑을 찾음
    				p-=1;
    			}
    			if(p==1)
    				sb.append("0 ");
    			else
    				sb.append(stack[p-1].idx).append(" ");
    		}
    		stack[p++] = new Point(inp[n], n); // 해당 탑의 인덱스 저장	
    	}
    	System.out.println(sb.toString());
    	
    }
}

class Point{
	int val, idx;
	
	public Point(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}
}