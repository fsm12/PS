
/*
inp_today : 오늘날짜 문자열
            "2022.05.19"
inp_terms : 약관의 유효기간을 담은 1차원 문자열 배열
            ["A 6", "B 12", ...] // 약관종류 유효기간
            길이는 최대 20
inp_privacies : 수집된 개인 정보를 담은 1차원 문자열 배열
                ["2021.05.02 A", "2021.07.01 B", ...] // 날짜 약관종류
                길이는 최대 100

2021년 1월 5일 => 12달 후 => 2022년 1월 4일까지 보관 가능
모든달은 28일까지

=> 파기해야 할 개인정보의 번호를 오름파순으로 1차원 배열에 담아 return

풀이)
오늘로부터 inp_terms에 속한 기한을 다 계산해서 A의 마감일은 언제이다로 매핑
위에서 매핑한 값을 inp_privacies와 비교해서 term < privacies 이면 해당 번호 추가 => 어떤 약관인지를 바로 가져와야 하므로 탐색에 유용한 해시맵 사용

ㄴ 날짜를 연산할 때 y, m, d 따로 가져오는 것보다 d로 통합해서 가져오는 것이 이득
*/


import java.util.*;

class Solution {
    public int[] solution(String inp_today, String[] inp_terms, String[] inp_privacies) {
        Map <String, String> map = new HashMap<>();
        
        for (String terms : inp_terms) {
            map.put(terms.split(" ")[0], terms.split(" ")[1]);
        }

        int ty = Integer.parseInt(inp_today.split("\\.")[0]);
        int tm = Integer.parseInt(inp_today.split("\\.")[1]);
        int td = Integer.parseInt(inp_today.split("\\.")[2]);
        
        List<Integer> ans_list = new ArrayList<>();
        for (int p=0; p < inp_privacies.length; p++) {
            String pastDate = inp_privacies[p].split(" ")[0];
            
            int valid_gap = Integer.parseInt(map.get(inp_privacies[p].split(" ")[1]))*28;
            int tp_gap = (ty - Integer.parseInt(pastDate.split("\\.")[0]))*28*12
                + (tm - Integer.parseInt(pastDate.split("\\.")[1]))*28
                + (td - Integer.parseInt(pastDate.split("\\.")[2]));

            if (tp_gap >= valid_gap) {
                ans_list.add(p+1);
            }
        }
        
        int[] answer = new int[ans_list.size()];
        int idx = 0;
        for(int ans : ans_list){
            answer[idx++] = ans;
        }
        return answer;
    }
}