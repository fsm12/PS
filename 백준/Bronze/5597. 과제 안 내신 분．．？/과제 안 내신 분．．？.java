import java.io.*;

public class Main{
    static int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 28; i++) {
            int in = Integer.parseInt(br.readLine());
            arr[in-1] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                System.out.println(i+1);
            }
        }
    }
}