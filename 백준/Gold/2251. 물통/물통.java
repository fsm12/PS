import java.io.*;
import java.util.*;

/*
 * 브루트포스 : 왜 계속 틀릴까
 */
public class Main {
    static int[] abc;
    static boolean[][][] vis;
    static boolean[] possi;
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        abc = new int[3];
        abc[0] = Integer.parseInt(st.nextToken());
        abc[1] = Integer.parseInt(st.nextToken());
        abc[2] = Integer.parseInt(st.nextToken());
        
        vis = new boolean[abc[0]+1][abc[1]+1][abc[2]+1];
        possi = new boolean[abc[2]+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, abc[2]});
        vis[0][0][abc[2]] = true;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if(cur[0]==0)
        		possi[cur[2]] = true;
        	for(int i=0; i<3; i++) {
        		if(cur[i]==0) // 부울 수 O
        			continue;
        		for(int j=0; j<3; j++) {
        			if(i!=j && cur[j]!=abc[j]) { // 같은 물병 X, 받을 수 O
        				if(cur[i]+cur[j] <= abc[j]) {
        					int add = cur[i];
        					cur[j] += add;
        					cur[i] = 0;
        					if(!vis[cur[0]][cur[1]][cur[2]]) {  // 반복된 경우 X
        			        	vis[cur[0]][cur[1]][cur[2]] = true;
                				q.add(new int[] {cur[0], cur[1], cur[2]});
        					}
            				cur[i] += add;
        					cur[j] -= add;
        				}else {
        					int out = abc[j] - cur[j];
        					cur[i] -= out;
        					cur[j] = abc[j];
        					if(!vis[cur[0]][cur[1]][cur[2]]) { 
        			        	vis[cur[0]][cur[1]][cur[2]] = true;
                				q.add(new int[] {cur[0], cur[1], cur[2]});
        					}
            				cur[j] -= out;
            				cur[i] += out;
        				}
        			}
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<=abc[2]; i++) {
        	if(possi[i])
        		sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}