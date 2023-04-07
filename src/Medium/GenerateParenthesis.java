package Medium;

import java.util.*;

public class GenerateParenthesis {
    public List<String> generateParenthesis1(int n){
        // dfs
        Set<String> strSet = new HashSet<>();
        boolean[] checked = new boolean[n*2];
        char[] parArr = new char[n*2];
        for(int i=0; i<n; i++){
            parArr[i*2] = '(';
            parArr[i*2+1] = ')';
        }
        char[] combi = new char[n*2];
        int count = 0;

        dfs1(n, count, checked, strSet, combi, parArr);

        List<String> li = new ArrayList<String>(strSet);

        return li;
    }

    private void dfs1(int n, int count, boolean[] checked, Set<String> strSet, char[] combi, char[] parArr){
        if(count == n*2){
            if(isValidPar(combi)){
                StringBuilder sb = new StringBuilder("");
                for(int i=0; i<combi.length; i++){
                    sb.append(combi[i]);
                }
                strSet.add(sb.toString());
            }
        } else{
            for(int i=0; i<n*2; i++){
                if(!checked[i]){
                    combi[count] = parArr[i];
                    checked[i] = true;
                    dfs1(n, count+1, checked, strSet, combi, parArr);
                    checked[i] = false;
                }
            }
        }
    }

    private boolean isValidPar(char[] combi){
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<combi.length; i++){
            if(st.size()>0){
                if(combi[i] == '(') st.add('(');
                else st.pop();
            } else{
                if(combi[i] =='(') st.add('(');
                else return false;
            }
        }

        if(st.size() == 0) return true;
        else return false;
    }

    StringBuilder sb = new StringBuilder("(");
    ArrayList<String> result = new ArrayList<>();

    public List<String> generateParenthesis2(int n){
        dfs2(1,1,0,n);
        return result;
    }

    private void dfs2(int depth, int leftParCount, int rightParCount, int n){
        if(depth == 2*n){
            // when the parenthesis is done
            result.add(sb.toString());
        }

        if(leftParCount<n){
            sb.append("(");
            dfs2(depth+1,leftParCount+1, rightParCount, n);
            sb.setLength(sb.length()-1);
        }

        if(rightParCount<leftParCount && rightParCount<n){
            sb.append(")");
            dfs2(depth+1, leftParCount, rightParCount+1, n);
            sb.setLength(sb.length()-1);
        }
    }





    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> result1 = gp.generateParenthesis1(4);
        // time limit exceed from 6

//        for(String s: result1){
//            System.out.println(s);
//        }

        List<String> result2 = gp.generateParenthesis2(6);
        for(String s: result2){
            System.out.println(s);
        }
    }
}
