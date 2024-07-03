import java.io.*;
import java.util.*;

/*
 * 세로 N, 가로 M
 * 
 * 왼쪽 위 좌표는 0,0
 * 
 * 목적 : 집터 내의 땅의 높이를 일정하게 바꾸는 것
 * 
 * 작업은 2가지 중 하나 선택 가능
 * 1. (i,j) 가장 위 블록 제거하여 가방에 넣기 [2초 소요]
 * 2. 블록을 꺼내서 (i,j) 가장 위에 놓기 [1초 소요]
 * 
 * => 땅 고르기 작업에 걸리는 최소시간 & 땅의 높이 출력

 * 
 * 같은 개수라면 블록을 꺼내는 것이 효율적임
 * 
 * 그러면 블록을 꺼냈을 때 가능한 초를 구한 후 [땅 높이의 평균] 근처의 높이로 맞출 때
 * 더 최소값을 구하면 되지 않을까?
 * 
 */


public class Main {
	static int N,M,B;
	
    public static void main(String[] args) throws Exception{
    	// System.setIn(new FileInputStream("input.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	B = Integer.parseInt(st.nextToken());
    	
    	int[][] map = new int[N][M];
    	int maxHeight = 0;
    	int minHeight = 501;
    	for(int n=0; n<N; n++) {
    		st = new StringTokenizer(br.readLine());
    		for(int m=0; m<M; m++) {
    			map[n][m] = Integer.parseInt(st.nextToken());
    			maxHeight = Math.max(maxHeight, map[n][m]);
    			minHeight = Math.min(minHeight, map[n][m]);
    		}
    	}
    	
    	int ansTime=Integer.MAX_VALUE, ansHeight=Integer.MAX_VALUE;
    	for(int i=0; i<=501; i++) {
    		int curTime = 0;
    		int possiCnt = B;
    		for(int n=0; n<N; n++) {
        		for(int m=0; m<M; m++) {
        			if(map[n][m] < i) {
        				curTime += i - map[n][m];
        				possiCnt -= (i-map[n][m]);
        			}else if(i < map[n][m]) {
        				curTime += 2* (map[n][m] - i);
        				possiCnt += (map[n][m] - i);
        			}
        		}
        	}
            
            // 이게 없어서 틀렸나?
            if(possiCnt < 0) break;
            
            
    		if(0<=possiCnt && curTime <= ansTime) {
    			ansTime = curTime;
    			ansHeight = i;
    		}
    	}
    	
    	System.out.println(ansTime+" "+ansHeight);

    }
}
