class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int ab = brown + yellow;
        
        for(int i=2; i<ab/2; i++){
            int test_b = i;
            if(ab%test_b!=0)
                continue;
            
            int test_a = ab/test_b;
            if(2*test_a + 2*test_b - 4 == brown){
                answer = new int[]{test_a, test_b};
                break;
            }
        }
        return answer;
    }
}