import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FlashCardQuiz {

    // Ayşegül Yıldız
    
    // declare variables
    public static int correct = 0;
    public static Scanner in = new Scanner(System.in);
    private ArrayList<FlashCard> cardList = new ArrayList<>();
    private ArrayList<FlashCard> quizList = new ArrayList<>();
    private Player player;
    public static File file = new File ("turkish_english_words.txt");
    public static Scanner f; 
    

    // constructor
    public FlashCardQuiz(Player player) throws FileNotFoundException 
    {
        this.player = player;
        loadCards();
        initializeQuiz();
    }

    // method to load the card lists
    public void loadCards( )throws FileNotFoundException
    {
        // scanner to read the values from the file
        Scanner f = new Scanner(file);
    
        // read every line from the file with while loop
        // exit when there is no line left to read
        while ( f.hasNextLine())
        {
            String question, answer, line;
            int difficulty;
            line = f.nextLine();
            int i=0;

            // break the line into question and answer variables 
            while ( Character.isLetter(line.charAt(i)))
            {
                i++;
            }
            question = line.substring(0,i);
            int a = i+1;
            while ( Character.isLetter(line.charAt(a)))
            {
                a++;
            }
            answer = line.substring(i+1, a );
            difficulty = 0;
            // create flash card object and add that to cardList array list
            FlashCard card = new FlashCard(question, answer, difficulty);
            cardList.add(card);
        }
        f.close();
    }

    public void initializeQuiz() throws FileNotFoundException 
    {
        // take the wanted number of cards and get random cards from the card list to create quiz list
        System.out.println("Enter the number of flash cards to generate: ");
        int numFlash = in.nextInt();
        Random random = new Random();
        for ( int i = 0; i < numFlash; i++ )
        {
            int index = random.nextInt(cardList.size());
            quizList.add(cardList.get(index));
        }
    }

    public void takeQuiz(  )throws FileNotFoundException 
    {
        Scanner in = new Scanner(System.in);
        int correct = 0;
        int wrong = 0;

        // print the question and get the answer
        for ( int i = 0; i < quizList.size(); i++ )
        {
            System.out.printf("***************\n* %13s \n* %13s \n*  %7s    * \n* %13s \n*************** \n","*", "*", quizList.get(i).getQuestion() ,"*" );
            System.out.print("Answer: ");
            String answer = in.nextLine();
            System.out.println();
            // if the answer is correct print correct and increment the correct value
            if ( answer.equals(quizList.get(i).getAnswer()))
            {
                System.out.println("Correct!");
                correct++;
            }
            // if the answer is wrong print the correct answer and increment the wrong value
            else 
            {
                System.out.println("Wrong Answer");
                System.out.printf("***************\n* %13s \n* %13s \n*  %7s    * \n* %13s \n*************** \n","*", "*", quizList.get(i).getAnswer() ,"*" );
                wrong ++;  
            }
        }
        
        // print the score
        System.out.printf("Your score: %d / %d", correct, correct + wrong);

        player.setHighScore(correct);
        

    }

   
}
    
    


