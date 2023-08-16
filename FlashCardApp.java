import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardApp {
    public static void main(String[] args)  throws FileNotFoundException
    {
        // Ayşegül Yıldız

        // declare variables
        String playerName;
        String playerN;
        ArrayList<Player> players = new ArrayList<>();
        int choice;
    
        // do while loop to get the choice until the user inputs 3
        do
        {
            FlashCardQuiz.in = new Scanner(System.in);
            System.out.print("1 - Play Game \n2 - View Player Information \n3 - Quit \nChoice: ");
            choice = FlashCardQuiz.in.nextInt();
            System.out.println();

            // if user chooses 1 ask for a player name and display the quiz
            if ( choice == 1 )
            {
                System.out.print("Enter player name: ");
                playerName = FlashCardQuiz.in.next();
                System.out.println();
                Player player = new Player(playerName); 
                
                FlashCardQuiz quiz = new FlashCardQuiz(player);
                quiz.takeQuiz();
                player.increaseGamesPlayed();
                player.setHighScore(FlashCardQuiz.correct);
                players.add(player);
                System.out.println();
            }
            // if they choose 2 then check whether that player is already created or not and then display score and games played
            else if ( choice == 2 )
            {
                System.out.print("Player Name: ");
                playerN = FlashCardQuiz.in.next();
                System.out.println();
                Player player = new Player(playerN);
                for ( int i = 0; i < players.size(); i++ )
                {
                    if (players.get(i).equals(player))
                    {
                        System.out.println(players.get(i).toString());
                    }
                }
                System.out.println();
            }
        }while(choice != 3); 
        FlashCardQuiz.in.close();
        
    }
    
}
