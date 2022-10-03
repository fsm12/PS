import java.util.*;
import java.io.*;

public class Main {
    static int N,area=0,maxHeightPosition=0;
    static List<Pillar> pillars;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pillars = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pillars.add(new Pillar(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        Collections.sort(pillars);

        // 진행하면서 이때까지의 기둥 중 가장 높은 기둥의 객체를 담음
        Pillar highestPillar = pillars.get(0);
        // 시작점 -> 끝점 이동
        for (int i = 1; i < pillars.size(); i++) {
            Pillar curPillar = pillars.get(i);
            // 가장 높았던 기둥의 높이보다 더 큰 기둥이 나타난다면
            if (highestPillar.height <= curPillar.height) {
                // 큰 높이가 나타나기 전까지의 위치까지, 작은 높이로 이어져야 하므로 면적을 구할 수 있음
                area += (curPillar.position - highestPillar.position) * highestPillar.height;
                highestPillar = curPillar;
                maxHeightPosition = i;
            }
        }

        // 끝점 -> 시작점 이동 (위와 같은 과정 그대로)
        highestPillar = pillars.get(pillars.size() - 1);
        for (int i = 1; i < pillars.size() - maxHeightPosition; i++) {
            Pillar currentCol = pillars.get(pillars.size() - 1 - i);
            if (highestPillar.height <= currentCol.height) {
                area += (highestPillar.position - currentCol.position) * highestPillar.height;
                highestPillar = currentCol;
            }
        }

        // 가장 높았던 기둥의 면적을 마지막으로 추가
        area += pillars.get(maxHeightPosition).height;
        System.out.println(area);
    }
}
class Pillar implements Comparable<Pillar>{
    int position;
    int height;

    public Pillar(int position, int height) {
        this.position = position;
        this.height = height;
    }

    @Override
    public int compareTo(Pillar o) {
        // position 으로 오름차순하도록 기준 설정정
       return position-o.position;
    }

    @Override
    public String toString() {
        return "Pillar{" +
                "position=" + position +
                ", height=" + height +
                '}';
    }
}