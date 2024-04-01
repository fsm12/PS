import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}