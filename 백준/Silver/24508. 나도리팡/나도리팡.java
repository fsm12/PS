import java.io.*;
import java.util.*;

public class Main{
    static int N,K,T;
    // A1, A2, ... , AN을 저장할 배열 생성
    static int[] numberOfNadori;
    static long nadoriSum=0, nadoriMaxSum=0;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 바구니의 수
        K = Integer.parseInt(st.nextToken()); // 나도리가 터질 수 있는 개수
        T = Integer.parseInt(st.nextToken()); // 한 나도리를 옮기는 실행횟수

        numberOfNadori = new int[N+1]; // A1부터 시작하므로
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n < N+1; n++) {
            int num = Integer.parseInt(st.nextToken());
            numberOfNadori[n] = num;
            nadoriSum+=num;
        }
        //밑 과정의 2-1을 위해 미리 오름차순 정렬하기
        Arrays.sort(numberOfNadori);

        if(nadoriSum==0){
            System.out.println("YES");
        }else if(nadoriSum%K!=0){
            //1.바구니에 담긴 전체 나도리의 수가 K개로 나눠떨어지지 않으면 불가능
            System.out.println("NO");
        }else{
            //2. 1의 경우를 만족하지 않는다면 T개의 실행횟수만으로 가능한지 분기점 필요
            //2-1. 실제 실행횟수는 [(바구니에 담긴 전체 나도리의 수)/K]개의 [바구니에 담긴 전체 나도리의 수의 최댓값]들의 합을 [(바구니에 담긴 전체 나도리의 수)/K]로 뺀 값이다.
            long numberOfMax = nadoriSum/K;
            for (long i = N-numberOfMax+1; i < N+1; i++) {
                nadoriMaxSum+=numberOfNadori[(int) i];
            }
            //System.out.println("중간결과\nnadoriSum(바구니에 담긴 전체 나도리의 수) : "+nadoriSum+"\nnadoriMaxSum(바구니에 담긴 전체 나도리의 수의 최댓값 합) : "+nadoriMaxSum+"\nnumberOfMax(최댓값 수) : "+numberOfMax);
            //2-2. 위 실행값이 T와 같거나 크면 YES, 아니라면 NO가 된다.
            if(nadoriSum-nadoriMaxSum<=T){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}