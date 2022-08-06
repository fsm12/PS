import java.io.*;
import java.util.*;

public class Main{
    static int i=0;
    static int[] origin = {1,1,2,2,2,8};

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()){
            System.out.print((origin[i]-Integer.parseInt(st.nextToken()))+" ");
            i+=1;
        }
    }
}