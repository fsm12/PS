import java.util.*;
import java.io.*;

public class Main{
    static int N, X, point, pointR, sum, cnt=0;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        point = 0;
        pointR = N-1;

        arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        X = Integer.parseInt(br.readLine());
        while(point < N && pointR >= 0){
            sum = arr.get(point) + arr.get(pointR);
            if(sum < X){
                point++;
            }else if(X < sum || point == pointR){
                pointR--;
            }else{
                cnt++;
                point++;
            }
        }
        System.out.println(cnt/2);
    }
}