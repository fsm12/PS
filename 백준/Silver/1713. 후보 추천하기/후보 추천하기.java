import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N,totalRecomm;

    public static void main(String[] args) throws IOException {
        ArrayList<Photo> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        totalRecomm = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<totalRecomm;i++) {
            int student = Integer.parseInt(st.nextToken());
            if(list.size()<N) {
                boolean flag = false;
                for(int j=0;j<list.size();j++) {
                    if(list.get(j).num==student) {
                        list.get(j).cnt++;
                        flag = true; break;
                    }
                }
                if(!flag) list.add(new Photo(student,1,i));
            }
            else {
                Collections.sort(list);
                boolean flag = false;
                for(int j=0;j<list.size();j++) {
                    if(list.get(j).num==student) {
                        list.get(j).cnt++;
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    list.remove(0);
                    list.add(new Photo(student,1, i));
                }
            }
        }

        for(int i=0;i<list.size();i++) {
            answer.add(list.get(i).num);
        }

        Collections.sort(answer);

        for(int i=0;i<answer.size();i++) sb.append(answer.get(i)+" ");

        System.out.println(sb.toString());
    }
}

class Photo implements Comparable<Photo>{
    int num;
    int cnt;
    int time;

    public Photo(int num, int cnt, int time) {
        this.num = num;
        this.cnt = cnt;
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public int getCnt() {
        return cnt;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Photo o) {
        if(this.cnt == o.cnt)
            return this.time - o.time;
        else if(this.cnt < o.cnt)
            return -1;
        else
            return 1;
    }
}