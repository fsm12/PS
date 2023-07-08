import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] leftHand = new int[]{3,0}, rightHand = new int[]{3,2};
        boolean handFlag = hand.equals("right")?true:false;
        
        Map<Integer, int[]> mid = new HashMap<>();
        for(int m : new int[]{2,5,8,11}){
            mid.put(m==11?0:m, new int[]{m/3, 1});
        }
        
        for(int num : numbers){
            if(num == 1 || num == 4 || num == 7){
                leftHand = new int[]{num/3, 0};
                sb.append("L");
            }else if(num == 3 || num == 6 || num == 9){
                rightHand =  new int[]{num/3-1, 2};
                sb.append("R");
            }else{
                int[] midXY = mid.get(num);
                int leftToMid = Math.abs(midXY[0] - leftHand[0]) + Math.abs(midXY[1] - leftHand[1])
                    , rightToMid = Math.abs(midXY[0] - rightHand[0]) + Math.abs(midXY[1] - rightHand[1]);
                if(leftToMid == rightToMid){
                    if(handFlag){
                        rightHand = midXY;
                        sb.append("R");
                    }else{
                        leftHand = midXY;
                        sb.append("L");
                    }
                }else if(leftToMid < rightToMid){
                    leftHand = midXY;
                    sb.append("L");
                }else{
                    rightHand = midXY;
                    sb.append("R");
                }
            }
        }
        
        return sb.toString();
    }
}