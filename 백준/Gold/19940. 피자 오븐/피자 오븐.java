import java.util.*;
import java.io.*;

/*
 * 
 * 1> T [1,100]
 * T> N [1,10^7]
 * => ADDH, ADDT, MINT, ADDO, MINO 버튼을 누르는 횟수 (사전 순으로 가장 앞서는 방법을 출력)
 * 
 * sol) bfs
 * 60 이상이 필요하면 ADDH를 누르는게 이득임
 * 60까지의 버튼 누르는 경우를 구하고 60단위만큼 ADDH 누르기 
 * 
 */

public class Main{
	static int T,N;
	static Button[] button;
	static boolean[] vis;
	static Queue<Button> q;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		q = new LinkedList<>();
		q.add(new Button(0,0,0,0,0,0));
		
		vis = new boolean[61];
		button = new Button[61];
		while(!q.isEmpty()) {
			Button node = q.poll();
			
			if(0<=node.time && node.time <=60 && !vis[node.time]) {
				vis[node.time] = true;
				button[node.time] = node;
				q.add(new Button(node.ADDH, node.ADDT, node.MINT, node.ADDO, node.MINO+1, node.time-1));
				q.add(new Button(node.ADDH, node.ADDT, node.MINT, node.ADDO+1, node.MINO, node.time+1));
				q.add(new Button(node.ADDH, node.ADDT, node.MINT+1, node.ADDO, node.MINO, node.time-10));
				q.add(new Button(node.ADDH, node.ADDT+1, node.MINT, node.ADDO, node.MINO, node.time+10));
				q.add(new Button(node.ADDH+1, node.ADDT, node.MINT, node.ADDO, node.MINO, node.time+60));
			}
		}
		
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			int M = N/60;
			int R = N%60;
			sb.append(button[R].ADDH + M +" "+ button[R].ADDT +" "+ button[R].MINT +" "+ button[R].ADDO +" "+ button[R].MINO).append("\n");
		}
		System.out.println(sb);
	}
}

class Button{
	int ADDH, ADDT, MINT, ADDO, MINO;
	int time;

	public Button(int ADDH, int ADDT, int MINT, int ADDO, int MINO, int time) {
		this.ADDH = ADDH;
		this.ADDT = ADDT;
		this.MINT = MINT;
		this.ADDO = ADDO;
		this.MINO = MINO;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Button [ADDH=" + ADDH + ", ADDT=" + ADDT + ", MINT=" + MINT + ", ADDO=" + ADDO + ", MINO=" + MINO
				+ ", time=" + time + "]";
	}
}