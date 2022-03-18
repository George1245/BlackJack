package blackjack;

public class Player {
    private String Name;
    private int Score=0;
    Card []cards=new Card[11];
    boolean win;
    boolean lose=false;
    int count=0;
    int dealer_counter;
    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public void addscore (int score)
    {
        this.Score +=score;
    }
    public boolean isLose() {
        return lose;
    }
}


