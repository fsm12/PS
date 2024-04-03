import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        CustomHeap q = new CustomHeap();

        for(int i=0; i<operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int val = Integer.parseInt(st.nextToken());
            if(command.equals("I")){
                q.push(val);
            }else{
                switch (val){
                    case 1 : 
                        q.removeMax();
                        break;
                    case -1: 
                        q.removeMin();
                        break;
                }
            }
        }
        return new int[]{q.getMaxValue(),q.getMinValue()};
    }
}

class CustomHeap {
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;

    public CustomHeap(){
        leftHeap = new PriorityQueue<>(10,Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }


    public void push(int v){
        leftHeap.add(v);
    }

    public void removeMax(){

        while(!rightHeap.isEmpty()){
            leftHeap.add(rightHeap.poll());
        }

        leftHeap.poll();
    }

    public void removeMin(){

        while(!leftHeap.isEmpty()){
            rightHeap.add(leftHeap.poll());
        }

        rightHeap.poll();
    }

    public int getMaxValue(){

        if(leftHeap.size() == 0 && rightHeap.size() == 0)
            return 0;

        while(!rightHeap.isEmpty()){
            leftHeap.add(rightHeap.poll());
        }

        return leftHeap.peek();
    }

    public int getMinValue(){

        if(leftHeap.size() == 0 && rightHeap.size() == 0)
            return 0;

        while(!leftHeap.isEmpty()){
            rightHeap.add(leftHeap.poll());
        }

        return rightHeap.peek();
    }

}