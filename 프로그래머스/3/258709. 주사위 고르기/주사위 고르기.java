import java.util.*;

class Solution {
    private int N, maxWinCnt, winCnt;
    private List<int[]> diceComb;

    public int[] solution(int[][] dice) {
        N = dice.length;
        diceComb = new ArrayList<>();
        combineDice(0, 0, new int[N/2]);

        int[] ans = {};
        maxWinCnt = 0;
        for (int[] aComb : diceComb) {
            List<Integer> aScores = new ArrayList<>();
            combineScores(0, 0, aComb, aScores, dice); 
            Collections.sort(aScores);

            int[] bComb = getBComb(aComb);
            List<Integer> bScores = new ArrayList<>();
            combineScores(0, 0, bComb, bScores, dice); 
            Collections.sort(bScores);
            
            winCnt = getWinCntOfA(aScores, bScores);
            if (maxWinCnt < winCnt) {
                maxWinCnt = winCnt;
                ans = aComb;
            }
        }

        for (int i=0; i<ans.length; i++) {
            ans[i]++;
        }
        return ans;
    }

    private void combineDice(int start, int cnt, int[] numbers) { 
        if (cnt == N/2) { 
            diceComb.add(numbers.clone()); // numbers.clone()
            return;
        }

        for (int i=start; i<N; i++) {
            numbers[cnt] = i;
            combineDice(i+1, cnt+1, numbers);
        }
    }

    private int[] getBComb(int[] aComb) { 
        boolean[] isA = new boolean[N];
        for (int num : aComb) {
            isA[num] = true; 
        }

        int b = 0;
        int[] bComb = new int[N/2];
        for (int i = 0; i<N; i++) {
            if (!isA[i]) {
                bComb[b] = i;
                b++;
            }
        }

        return bComb;
    }

    private void combineScores(int cnt, int sum, int[] comb, List<Integer> scores, int[][] dice) {
        if (cnt == N/2) {
            scores.add(sum);
            return;
        }

        for (int i = 0; i<6; i++) {
            combineScores(cnt+1, sum+dice[comb[cnt]][i], comb, scores, dice);
        }
    }

    private int getWinCntOfA(List<Integer> aScores, List<Integer> bScores) {
        int winCnt = 0;
        for (int s : aScores) {
            int start = 0;
            int end = bScores.size() - 1;
            while (start<=end) {
                int mid = (start+end)/2;

                if (s>bScores.get(mid)) {
                    start = mid+1;
                } else {
                    end = mid - 1;
                }
            }
            winCnt += start;
        }
        return winCnt;
    }
}