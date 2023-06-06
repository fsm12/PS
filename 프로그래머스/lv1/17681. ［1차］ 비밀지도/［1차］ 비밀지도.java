/*
한곳이라도 벽이면 벽, 둘다 공백이면 공백으로 해독 => OR 연산

*/

// class Solution {
//     public String[] solution(int N, int[] arr1, int[] arr2) {
//         String[] answer = new String[N];
//         for(int n=0; n<N; n++){
//             answer[n] = Integer.toBinaryString(arr1[n] | arr2[n]).replace("1","#").replace("0"," ");
//             System.out.println(arr1[n] | arr2[n]);
//         }

//         return answer;
//     }
// }

class Solution {
    public String[] solution(int N, int[] arr1, int[] arr2) {
        String[] answer = new String[N];
        for(int n=0; n<N; n++){
            String binary_str = Integer.toBinaryString(arr1[n] | arr2[n]).replace("1","#").replace("0"," ");
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N-binary_str.length(); i++){
                sb.insert(0," ");
            }
            sb.append(binary_str);
            
            answer[n] = sb.toString();
        }
        return answer;
    }
}