class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
		for (int i = 0; i < balls.length; i++) {
			int x = balls[i][0];
			int y = balls[i][1];
			int curlen, len = Integer.MAX_VALUE;

			if (!(startY == y && startX >= x)) {
				curlen = getDistance(startX, startY, x * (-1), y);
				len = curlen < len ? curlen : len;
			}

			if (!(startY == y && startX <= x)) {
				curlen = getDistance(startX, startY, m + (m - x), y);
				len = curlen < len ? curlen : len;
			}

			if (!(startX == x && startY <= y)) {
				curlen = getDistance(startX, startY, x, n + (n - y));
				len = curlen < len ? curlen : len;
			}

			if (!(startX == x && startY >= y)) {
				curlen = getDistance(startX, startY, x, y * (-1));
				len = curlen < len ? curlen : len;
			}
			answer[i] = len;
		}
		return answer;
    }
    
    public int getDistance(int sx, int sy, int tx, int ty) {
		return (int) (Math.pow(sx - tx, 2) + Math.pow(sy - ty, 2));
	}
}