class Solution {
    public String solution(int a, int b) {
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] d = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int day = b;
        for(int i=0; i<a-1; i++){
            day += days[i];
        }
        return d[day%7];
    }
}