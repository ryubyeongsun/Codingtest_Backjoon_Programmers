    /**
     * 메모리: 14328KB
     * 시간: 108ms
     * 난이도: 실버4
     * 아이디어: 
     * VPS=>()괄호 인지 판별하는 문제인데 우선 스택을 사용해 (가 입력 받으면 push하고 )을 받았을때 스택이 비어있으면 VPS가 아니므로
     * boolean 사용해 false를 입력받고 break
     * )을 받았을때 스택이 비어있지 않으면 (이 존재하므로 vps 성립 즉 pop을 해줌. 
     * for문을 모두 실행하고 마지막에 스택이 비어있지 않으면 VPS가 아니므로 false
     * 
     */

    import java.io.*;
    import java.util.*;
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                String str = br.readLine();
                Stack<Character> stack = new Stack<>(); //괄호 VPS를 저장하기 위한 스택 객체를 Character타입으로 생성
                boolean chk = true; //VPS인지 판별하기 위해 boolean 사용
                for(int j=0; j<str.length(); j++){
                    char ch = str.charAt(j); //입력받은 괄호를 문자char로 쪼개어 저장
                    
                    //만약 (이라면 스택에 푸쉬하고 )을 입력받았을때 스택이 비어있으면 VPS가 될 수 없으므로 false 변환후 반환
                    //그게 아니라면 괄호로 인식하고 (을 pop하여 제거
                    if(ch=='('){
                        stack.push(ch);
                    }else if(ch==')'){
                        if(stack.isEmpty()){
                            chk = false;
                            break;
                        }else{
                            stack.pop();
                        }
                    }
                 }
                 // 스택이 비어있지 않아야 VPS가 성립
                 if(!stack.isEmpty()){
                    chk = false;  
                }
                    
                 if(chk){
                    bw.write("YES");
                    bw.newLine();
                 }else{
                    bw.write("NO");
                    bw.newLine();
                 }

                }
                bw.close();
            }

        }

    
    
