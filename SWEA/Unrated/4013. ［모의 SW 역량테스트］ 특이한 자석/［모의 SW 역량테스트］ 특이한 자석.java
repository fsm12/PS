import java.io.*;
import java.util.*;

public class Solution {
	static int K;
	static int res; 
	static int magnet[][];
	static int dir[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			res = 0;
			K = Integer.parseInt(br.readLine());
			magnet = new int[5][8];
			dir = new int[5]; 
			for (int i = 1; i < 5; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
                
				dir[num] = d;
				setDirLeft(num - 1); 
				setDirRight(num + 1);
				moveMagnet(); 
			}
            
			for (int i = 1; i < 5; i++) {
				if (magnet[i][0] == 1)
					res += Math.pow(2, i - 1);
			}
			System.out.println("#" + t + " " + res);
		}
	}

	private static void moveMagnet() {
		for (int i = 1; i < 5; i++) {
			int d = dir[i];
            
			if (d == 0) continue;
			else if (d == 1) {
				magnet = Circle(i, magnet);
			} else if (d == -1) {
				magnet = ReverseCircle(i, magnet);
			}
		}

	}

	private static int[][] ReverseCircle(int num, int[][] magnet) {
		int data[] = copy(magnet[num]);
        
		for (int i = 0; i < 8; i++) {
			magnet[num][i] = data[(i + 1 + 8) % 8];
		}
		return magnet;

	}

	private static int[][] Circle(int num, int[][] magnet) {
		int data[] = copy(magnet[num]);
        
		for (int i = 0; i < 8; i++) {
			magnet[num][i] = data[(i - 1 + 8) % 8];
		}
		return magnet;
	}

	private static int[] copy(int[] arr) { 
		int[] tmp = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			tmp[i] = arr[i];
		return tmp;
	}

	private static void setDirLeft(int num) {
		if (num == 0)
			return;
        
		if (dir[num + 1] == 0)
			dir[num] = 0;
		else if (magnet[num + 1][6] == magnet[num][2])
			dir[num] = 0;
		else
			dir[num] = dir[num + 1] == -1 ? 1 : -1; 

		setDirLeft(num - 1);
	}

	private static void setDirRight(int num) {
		if (num > 4)
			return;
        
		if (dir[num - 1] == 0) 
			dir[num] = 0;
		else if (magnet[num - 1][2] == magnet[num][6]) { 
			dir[num] = 0;
		} else {
			dir[num] = dir[num - 1] == -1 ? 1 : -1; 
		}
		setDirRight(num + 1);
	}
}