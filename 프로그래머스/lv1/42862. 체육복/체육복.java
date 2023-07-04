import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> set_lost = new HashSet<>();
        for(int l : lost){
            set_lost.add(l);
        }
        
        PriorityQueue<Integer> rev = new PriorityQueue<>();
        for(int r : reserve){
            if(set_lost.contains(r)){
                set_lost.remove(r);
                continue;
            }
            rev.add(r);
        }
        
        int ans = n-set_lost.size();
        while(!rev.isEmpty()){
            int stu = rev.poll();
            if(set_lost.contains(stu-1)){       
                ans++;         
                set_lost.remove(stu-1);
                continue;
            }
            
            if(set_lost.contains(stu)){       
                ans++;         
                set_lost.remove(stu);
                continue;
            }
            
            if(set_lost.contains(stu+1)){
                ans++;
                set_lost.remove(stu+1);
                continue;
            }
        }
        return ans;
    }
}