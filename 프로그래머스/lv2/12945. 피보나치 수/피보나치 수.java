class Solution {
    public int solution(int n) {
        return fibo(1,n,0,1)%1234567;
    }
    
    public int fibo(int depth, int desti, int prev, int next){
        if(desti == depth)
            return next;
        return fibo(depth+1, desti, next, (prev+next)%1234567);
    }
}