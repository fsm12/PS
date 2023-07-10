class Solution {
    public String solution(String new_id) {

        StringBuilder ans = new StringBuilder(new_id.toLowerCase().replaceAll("[^-_.a-z0-9]", "").replaceAll("[.]{2,}", ".").replaceAll("^[.]|[.]$", ""));
        if (ans.length() == 0) { 
            ans.append("a");
        }

        if (ans.length() >= 16) {
            int idx = 15;
            for(int i=14; 0<=i; i--){
                if(ans.charAt(i) != '.')
                    break;
                idx = i;
            }
            ans.delete(idx, ans.length());
        }
            

        System.out.println(ans);
        if (ans.length() <= 2) {
            char c = ans.charAt(ans.length()-1);
            while (ans.length() < 3) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}