import java.util.*;
import java.io.*;

/*

세팅 - gifts 인접리스트로 넣으며 HashMap 세팅



*/

class Solution {
    static int N;
    static Map<String, Integer> nameIdxMap;
    static int[][] maps;
    
    
    public int solution(String[] friends, String[] gifts) {
        int idx=0;
        nameIdxMap = new HashMap<>();
        for(String name : friends){
            nameIdxMap.put(name, idx++);
        }
        N = idx;
        
        maps = new int[N+1][N+1];
        for(String sendGift : gifts){
            StringTokenizer st = new StringTokenizer(sendGift);
            String n1 = st.nextToken();
            String n2 = st.nextToken();
            
            int idx1 = nameIdxMap.get(n1);
            int idx2 = nameIdxMap.get(n2);
            
            maps[idx1][idx2] +=1;
        }
        
        int sum =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sum += maps[i][j];
            }
            maps[i][N] = sum;
            sum = 0;
        }
        
        int[] res = new int[N];
        for(int j=0; j<N; j++){
            for(int i=0; i<N; i++){
                sum += maps[i][j];
            }
            maps[N][j] = sum;
            //res[j] = sum;
            sum = 0;
        }
        
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                // i가 받은게 많음
                if(maps[i][j] < maps[j][i]){
                    //j에게 줘야함
                    res[j] += 1;
                }
                // j가 더 많이 받은 것
                else if(maps[j][i] < maps[i][j]){
                    res[i] += 1;
                }else{
                    int giftStd1 = maps[i][N] - maps[N][i];
                    int giftStd2 = maps[j][N] - maps[N][j];
                    if(giftStd1 < giftStd2){
                        res[j] +=1;
                    }else if(giftStd2 < giftStd1){
                        res[i] +=1;
                    }
                }
            }
        }
        
        int ans = 0;
        for(int i=0; i<N; i++){
            ans = Math.max(res[i], ans);   
        }
        return ans;
    }
}