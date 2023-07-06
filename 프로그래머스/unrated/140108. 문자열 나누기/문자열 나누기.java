class Solution {
    public int solution(String s) {
        String[] arr = {};
        int idx1 = 0;
        int idx2 = 0;
        int answer = 0;

        for (int i=0; i<s.length(); i++){
            arr = s.split("");
        }

        String first = arr[0];
        for (int i=0; i<arr.length; i++){
            if (idx1 == idx2){
                answer++;
                first = arr[i];
            }
            if (arr[i].equals(first))
                idx1++;
            else 
                idx2++;
        }

        return answer;
    }
}