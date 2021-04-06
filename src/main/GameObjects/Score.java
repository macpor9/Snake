package GameObjects;

import java.util.Comparator;

public class Score {
    private String nickname;
    private int score;

    public Score(String nickname, int score){
        this.nickname = nickname;
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String getNickname(){
        return nickname;
    }

    public static class MyComparator implements Comparator<Score> {

        @Override
        public int compare(Score o1, Score o2) {
            return o2.score-o1.score;
        }
    }
}
