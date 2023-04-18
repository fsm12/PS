import java.util.*;
import java.io.*;

/*
이모티콘 플러스 서비스 가입자를 최대한 늘리는 것 -> 이모티콘 판매액을 최대한 늘리는 것
n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매
할인율은 10%, 20%, 30%, 40% => 중복순열
이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 가입
*/

class Solution {
    static double[] sales = {0.1, 0.2, 0.3, 0.4};
    
    static class Imoticon{
        double price;
        double percent;
        
        public Imoticon(double price, double percent){
            this.price = price;
            this.percent = percent;
        }
    }
    
    static int maxJoin = Integer.MIN_VALUE, maxPrice = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        // 중복순열 - 이모티콘 할인율 결정
        nPIr(0, new ArrayList<>(), users, emoticons);
        return new int[]{maxJoin, maxPrice};
    }
    
    public static void nPIr(int depth, List<Imoticon> imsi, int[][] users, int[] emoticons){
        if(depth == emoticons.length){
            int total = 0;
            int join = 0;
            // 모든 고객에 대해
            for(int i=0; i<users.length; i++){
                int userPercent = users[i][0];
                int userPrice = users[i][1];
                
                int sum = 0;
                // 이모티콘 구매여부 판단
                for(int j=0; j<imsi.size(); j++){
                    Imoticon cur = imsi.get(j);
                    double curPrice = cur.price;
                    double curPercent = cur.percent;
                    // 사용자가 원하는 할인율 이상을 할인할 경우
                    if(curPercent >= userPercent)
                        sum += curPrice;
                }
                
                // 각 사용자들은 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소 후 가입
                if(sum >= userPrice)
                    join++;
                else{
                    total += sum;
                }

                // 갱신
                if(maxJoin < join){
                    maxPrice = total;
                    maxJoin = join;
                }else if(maxJoin == join && maxPrice < total){
                    maxPrice = total;
                }
            }
            return;
        }

        for(int i=0; i<sales.length; i++){
            imsi.add(new Imoticon(((1-sales[i])*(emoticons[depth])), (100*sales[i])));
            nPIr(depth+1, imsi, users, emoticons);
            imsi.remove(imsi.size()-1);
        }
    }
}