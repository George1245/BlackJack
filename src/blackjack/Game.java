package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    Player[] players = new Player[4];
    Card[] cards = new Card[52];
    final int highscore = 21;


    public void generate() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int value = 0;
            for (int j = 0; j < 13; j++) {
                if (j < 9) {
                    value = j + 1;
                } else {
                    value = 10;
                }
                cards[count] = new Card(i, j, value);
                count++;
            }
        }


    }

    public Card draw_card() {

        Card draw;
        Random rand = new Random();
        int randomchoice = rand.nextInt(52);
        while (cards[randomchoice] == null) {
            randomchoice = rand.nextInt(52);

        }
        draw = cards[randomchoice];
        cards[randomchoice] = null;
        return draw;
    }


    public void set_information() {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            players[i] = new Player();
            players[i].cards[0] = new Card(draw_card());
            players[i].addscore(players[i].cards[0].getValue());
            players[i].cards[1] = new Card(draw_card());
            players[i].addscore(players[i].cards[1].getValue());
        }


    }

    public Player update_maxuimem()
    {
        int count=0;
        int max=0;
        for (int i=0;i<3;i++) {
            if (players[i].getScore()>max&&players[i].getScore()<22)
            {
                max=players[i].getScore();
                count=i;
            }

        }
        return players[count];
    }


    public void dealerwin() {



                if (players[3].getScore() > update_maxuimem().getScore() && players[3].getScore() <= 21) {
                    System.out.println("dealer is win scoring:" + players[3].getScore());
                }




        }
    public boolean push()
    {
        boolean c =false;
        for (int i=0;i<4;i++)
        {
            if(update_maxuimem().getScore()==players[i].getScore())
            {
                if(c)
                {
                    return true;

                }
                c=true;
            }
        }
        return false;
    }
    }





