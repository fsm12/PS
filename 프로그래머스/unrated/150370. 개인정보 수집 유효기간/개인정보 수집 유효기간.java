import java.util.*;

/*
오늘 날짜를 의미하는 문자열 today
약관의 유효기간을 담은 1차원 문자열 배열 terms (약관종류[A~Z] 유효기간[1,100])
수집된 개인정보의 정보를 담은 1차원 문자열 배열 privacies (날짜 약관종류)
=> 파기해야 할 개인정보의 번호를 오름차순으로 1차원 정수 배열에 담아 return

sol)
해쉬맵으로 약관종류 : 유효기간 만들기
privacies를 순회하며 유효기간을 넘겼다면 ans 배열에 담기

*/

class Solution {
    static Map <String, String> map;
    static List<Integer> ans_list;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            map.put(terms[i].split(" ")[0], terms[i].split(" ")[1]);
        }

        ans_list = new ArrayList<>();
        int year = Integer.parseInt(today.split("\\.")[0]);
        int month = Integer.parseInt(today.split("\\.")[1]);
        int day = Integer.parseInt(today.split("\\.")[2]);

        for (int i = 0; i < privacies.length; i++) {
            String date = privacies[i].split(" ")[0];
            int type = Integer.parseInt(map.get(privacies[i].split(" ")[1]))*28;

            int num = (year - Integer.parseInt(date.split("\\.")[0]))*28*12
                    + (month - Integer.parseInt(date.split("\\.")[1]))*28
                    + (day - Integer.parseInt(date.split("\\.")[2]));

            if (num >= type) {
                ans_list.add(i+1);
            }
        }
        
        int[] ans = new int[ans_list.size()];
        for(int i=0; i<ans_list.size(); i++){
            ans[i] = ans_list.get(i);
        }
        return ans;
    }
}