class Solution {
    public int[] solution(String[] park, String[] routes) {
        int sx = 0, sy=0;
        char[][] board = new char[park.length][park[0].length()];
        
        
        for (int i=0; i<park.length; i++){
            for (int j=0; j<park[0].length(); j++){
                board[i][j] = park[i].charAt(j);
                if (park[i].charAt(j) == 'S'){
                    sx = j; sy=i;
                }
            }
        }
        
        String[] dir = new String[routes.length];
        int[] space = new int[routes.length];
        
        for (int i=0; i<routes.length; i++){
            dir[i] = routes[i].split(" ")[0];
            space[i] = Integer.parseInt(routes[i].split(" ")[1]);
        }
        
        char now = 0;
        int nx = sx; int ny = sy;
        
        for (int i=0; i<routes.length; i++){
            for (int j=1; j<=space[i]; j++){
                
                switch (dir[i]){
                    case "E":
                        if(sx+space[i]>=park[0].length()) 
                            break;
                        now = board[sy][sx+j];
                        nx = sx+j; break;
                    case "W":
                        if(sx-space[i] < 0) break;
                        now = board[sy][sx-j];
                        nx = sx-j; break;
                    case "S":
                        if(sy+space[i]>=park.length) break;
                        now = board[sy+j][sx];
                        ny = sy+j; break;
                    case "N":
                        if(sy-space[i]<0) break;
                        now = board[sy-j][sx];
                        ny = sy-j; break;
                }
                if (now == 'X'){
                    nx = sx;
                    ny = sy; 
                    break;
                }
                System.out.println(nx+" "+ny+" "+sx+" "+sy);
            }
        
            if(now != 'X') {
            	sx = nx;
            	sy = ny;
        	}  
        }
        
        int[] answer = new int[]{sy, sx};  
        
        return answer;
    }
}