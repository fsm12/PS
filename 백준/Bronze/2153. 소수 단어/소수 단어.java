import java.util.*;
import java.io.*;

public class Main{
    static String input;
    static int num=0;
    static boolean[] isNotPrime; // 52*20 = 1040

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        isNotPrime = new boolean[1041];

        for (int i = 2; i < 1041; i++) {
            if(!isNotPrime[i]){
                for (int j = 2; i*j < 1041; j++) {
                    isNotPrime[i*j] = true;
                }
            }
        }
        //System.out.println(Arrays.toString(isNotPrime));

        input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i))){
                num= num+input.charAt(i)-'A'+27;
            }else{
                num= num+input.charAt(i)-'a'+1;
            }
        }
        System.out.println(isNotPrime[num]?"It is not a prime word.":"It is a prime word.");
    }
}