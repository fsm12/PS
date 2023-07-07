class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length, p = 0, moveCnt = 0;
        int[] stack = new int[N*N]; 
        
        int get = 0;
        for(int move : moves){
            for(int i=0; i<N; i++){
                get = board[i][move-1];
                if(get != 0){
                    board[i][move-1] = 0;
                    stack[p++] = get;
                    if(1 < p && get == stack[p-2])
                        p-=2;
                    moveCnt++;
                    break;
                }
            }
        }
        return moveCnt - p;
    }
}