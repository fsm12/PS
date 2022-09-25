import java.util.*;
import java.io.*;

public class Main{
    static int N,B,H,W,p,min=Integer.MAX_VALUE;
    static long sum=0;
    static Hotel[] hotels;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        hotels = new Hotel[H];
        for (int h = 0; h < H; h++) {
            p = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] possiPersons = new int[W];
            for (int w = 0; w < W; w++) {
                possiPersons[w] = Integer.parseInt(st.nextToken());
            }
            hotels[h] = new Hotel(p,possiPersons);
        }

        // w주까지 돌면서
        for (int w = 0; w < W; w++) {
            int curMin = Integer.MAX_VALUE;
            // 가능한 호텔의 요금을 저장 (최솟값으로)
            for (int h = 0; h < H; h++) {
                if(hotels[h].possiPersons[w]>=N){
                    // 현재 호텔에 묶을때 필요한 N명의 요금과, 전 호텔에 묶을때 필요했던 N명의 요금중 작은값을 저장
                    curMin = Math.min(curMin, hotels[h].p*N);
                }
            }
            min = Math.min(min, curMin);

        }
        System.out.println(min>B?"stay home":min);
    }
}

class Hotel{
    int p;
    int[] possiPersons;

    public Hotel(int p, int[] possiPersons) {
        this.p = p;
        this.possiPersons = possiPersons;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "w=" + p +
                ", possiPersons=" + Arrays.toString(possiPersons) +
                '}';
    }
}