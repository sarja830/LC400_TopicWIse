package Stack;

public class ScoreofParentheses856 {
    public static void main(String[] args) {
        ScoreofParentheses856 a = new ScoreofParentheses856();
        a.scoreOfParentheses("()");
    }

    public int scoreOfParentheses(String s) {
        int score = 0;
        int stack=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                stack++;
            else
            {
                stack--;
                if(s.charAt(i-1)=='(')
                    score=score+(int)Math.pow(2,stack);
            }
        }
        return score;
    }

}
