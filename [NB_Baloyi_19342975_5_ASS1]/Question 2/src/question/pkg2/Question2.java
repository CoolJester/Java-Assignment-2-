package question.pkg2;

/**
 *
 * @author Ntsako
 */

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Question2 {

    //The scanner object
    static Scanner sc = new Scanner(System.in);
    
    //The variables (global)
    static boolean play;
    static boolean active;
    static String lineBreak = "*********************************";
    static player p1 = new player();
    static player p2 = new player();
    static int userInputOne;
    static String userInputTwo;   
    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    static int playerPlaying = 1;
    
    
    public static void main(String[] args) {  
        
        //Loop used for running one game session
        do{
            //The alphabet
            ArrayList<Character> alphabets = new ArrayList<Character>();
            //Adding the alphabets
            alphabets.add('a');
            alphabets.add('b');
            alphabets.add('c');
            alphabets.add('d');
            alphabets.add('e');
            alphabets.add('f');
            alphabets.add('g');
            alphabets.add('h');
            alphabets.add('i');
            alphabets.add('j');
            alphabets.add('k');
            alphabets.add('l');
            alphabets.add('m');
            alphabets.add('n');
            alphabets.add('o');
            alphabets.add('p');
            alphabets.add('q');
            alphabets.add('r');
            alphabets.add('s');
            alphabets.add('t');
            alphabets.add('u');
            alphabets.add('v');
            alphabets.add('w');
            alphabets.add('x');
            alphabets.add('y');
            alphabets.add('z');

            //Variable used to control the do-while loop for prompt the user for a word
            boolean isWordValid = true;

            //Variable for storing the users word
            String userWord;

            //ArrayList used for alphabets used
            ArrayList<Character> used = new ArrayList<Character>();

            System.out.print("Welcome to the WORD WARS game.\n\nPress (1) to start the game.\nPress any other key to exit the game\nEnter your selection: ");
            userInputOne = sc.nextInt();
            System.out.println(lineBreak);

            clearBuffer();
            if(userInputOne == 1){
                playerPrompt();
                active = true;
            }else{
                active = false;
                System.out.println("Game ended before it even began :(");
                System.exit(0);

            }
            System.out.println("\nLETS PLAY WORD WARS!!!!!!!!\nENTER ??? to end the game when you are unable to make any more words");

            char[] letters  = {};

            //Loop used for prompting each player 
            while(active){
                //Displaying the remaining alphabets
                System.out.print("Alphabet letters left: ");
                for(char el: alphabets){
                    System.out.print(" " + el + " ");
                }

                //Loop used to for getting the word            
                do{
                    System.out.print("\n"+((playerPlaying == 1) ? p1.getPlayerName() : p2.getPlayerName()) + " enter your word: ");
                    userWord = sc.nextLine();
                    userWord.toLowerCase();               

                    //Check if the user input if it is not the sentinal value
                    if (userWord.equals("???")){
                        endGame();
                    }

                    //Converting the word to an array
                    letters  = userWord.toCharArray();

                    //Checking if the word has not been used already
                    boolean temp = false;                
                    for (int x = 0; x < used.size(); x++){
                        for(int y = 0; y < letters.length; y++){
                            if (used.get(x) == letters[y]){
                                temp = true;                            
                            }
                        }
                    }
                    //Prompting the user to enter a new word
                    if (temp){
                        System.out.println("THE WORD YOU ENTERED CONTAINS A LETTER THAT WAS USED ALREADY OR IS INVALID TRY ENTERING ANOTHER WORD");
                        isWordValid = true;
                        //Escaping the do-while loop
                        continue;                    
                    }


                    //Removing the alphabets
                    for(int x = 0; x < alphabets.size(); x++){
                        for(int y = 0; y < letters.length; y++){       
                            if(alphabets.get(x).equals('a') || alphabets.get(x).equals('e') || alphabets.get(x).equals('i') || alphabets.get(x).equals('o') || alphabets.get(x).equals('u')){                        
                            }else if (alphabets.get(x) == letters[y]){
                                alphabets.remove(x);
                            }
                        }
                    }
                    System.out.println("Enter (y) yes if both players agree on the word");     
                    userInputTwo = sc.nextLine();
                    isWordValid = ((!userInputTwo.equalsIgnoreCase("y")));


                }while(isWordValid);

                //Recording the alphabets used
                for (char l: letters){
                    if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u'){
                        continue;
                    }
                    used.add(l);
                }

                //Updating the scores
                if (playerPlaying == 1)
                    p1.setPlayerScore(letters.length);
                else{
                    p2.setPlayerScore(letters.length);
                }
                
                playerSwitch(playerPlaying);
            }
            alphabets.clear();
        }while(play);        
    }   
    //Getting the players names
    public static void playerPrompt(){
        //Resetting the scores
        p1.setPlayerScore(0);
        p2.setPlayerScore(0);
        
        //Prompting for the player's names
        System.out.print("Enter player one name: ");
        p1.setPlayerName(sc.nextLine());
        
        System.out.print("Enter player two name: ");
        p2.setPlayerName(sc.nextLine());            
        
    }   
    
    //Clearing the input buffers
    public static void clearBuffer(){
        sc.nextLine();
    }
    
    //Changing the variable that stores which player is currently playing 
    public static void playerSwitch(int p){        
        playerPlaying = ((p == 1) ? 2 : 1);        
        
    }
    
    //Ending the game, Determining the winner
    public static void endGame(){        
        if (p1.getPlayerScore() > p2.getPlayerScore()){
            System.out.println("WINNER OF THE GAME IS: " + p1.getPlayerName() + " with a score of " + p1.getPlayerScore() +"\nYOUR ARE IN THE HALL OF FAME!!!!\nGAME OVER. THANK YOU FOR PLAYING WORD WARS!!!!!");
        }else if(p1.getPlayerScore() == p2.getPlayerScore()){
            System.out.println("WE HAVE A DRAW WITH A TIE OF " + p1.getPlayerScore() +" Points each\nGAME OVER. THANK YOU FOR PLAYING WORD WARS!!!!!");
        }else{
            System.out.println("WINNER OF THE GAME IS: " + p2.getPlayerName() + " with a score of " + p2.getPlayerScore() +"\nYOUR ARE IN THE HALL OF FAME!!!!\nGAME OVER. THANK YOU FOR PLAYING WORD WARS!!!!!");
        }      
            System.exit(0);
        
    }
    
    
}
