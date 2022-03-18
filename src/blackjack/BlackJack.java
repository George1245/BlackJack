package blackjack;

import java.util.Scanner;

public class BlackJack {
    static GUI gui = new GUI();
    private static Game game = new Game();
    public static void main(String[] args) {
            Player[] players = new Player[4];


            game.generate();
            game.set_information();


        boolean check = false;
            Scanner input = new Scanner(System.in);
            System.out.println("enter players names");
            for (int i = 0; i < 4; i++) {
                String name = input.next();
                game.players[i].setName(name);
            }
        gui.runGUI( game.cards,game.players[0].cards, game.players[1].cards, game.players[2].cards, game.players[3].cards );
            for (int i = 0; i < 4; i++) {
                while (true) {
                    System.out.println(game.players[i].getName() + " " + "your score now is:" + " " + game.players[i].getScore());

                   //the dealer code:
                    if (i == 3) {
                        if (game.players[0].getScore() > 21 && game.players[1].getScore() > 21 && game.players[2].getScore() > 21) {
                            System.out.println("the dealer won");
                            check = true;
                            break;
                        }
                        if (game.players[3].getScore() > game.update_maxuimem().getScore() && game.players[3].getScore() <= 21) {
                            System.out.println("the dealer won ");
                            check = true;
                            break;
                        }
                        System.out.println(" you are the dealer please choose 1 to hit only");
                        int y = input.nextInt();
                        if (y == 1) {


                            Card card = game.draw_card();
                            game.players[3].addscore(card.getValue());
                            gui.updateDealerHand(card, game.cards);
                            System.out.println("your Score is:" + game.players[3].getScore());
                            if (game.players[3].getScore() > game.update_maxuimem().getScore() && game.players[3].getScore() <= 21) {
                                System.out.println("the dealer won ");
                                check = true;
                                break;
                            }
                            if (game.players[3].getScore() > game.highscore) {
                                game.players[3].count = -1;
                                System.out.println(game.players[i].getName() + " " + "lost game");
                                break;
                            }
                            if (game.players[3].getScore() == game.highscore)
                            {


                                break;
                            }


                        }
                        else {
                            System.out.println(" wrong choose >>you are the dealer please choose 1 only to hit");

                        }

                    }
                     //rest of players code:
                    else{
                    System.out.println("please choose 1 to hit or 2 to stand");
                    int x = input.nextInt();

                    if (x == 1) {


                        Card c = game.draw_card();
                        game.players[i].addscore(c.getValue());
                        gui.updatePlayerHand(c, i);
                        System.out.println("your Score is:" + game.players[i].getScore());
                        if (game.players[i].getScore() > game.highscore) {
                            game.players[i].count = -1;
                            System.out.println(game.players[i].getName() + " " + "lost game");
                            break;
                        }
                        if (game.players[i].getScore() == game.highscore) {

                            game.players[i].count++;
                        }
                        if (game.players[i].count == 1) {
                            System.out.println(game.players[i].getName() + "   your score now is:" + game.players[i].getScore());
                            System.out.println("you have a black jack");
                            break;
                        }
                    } else if (x == 2) {


                        System.out.println(game.players[i].getName() + " " + "Score" + " " + " is:" + game.players[i].getScore());

                        break;
                    } else {
                        System.out.println("your choice is wrong try again");
                    }
                }

                }

            }
            if (!check) {


                if (game.push()) {
                    System.out.println("the game is push");
                } else {
                    System.out.println(game.update_maxuimem().getName() + "  is won");
                }
            }
        }

    }


