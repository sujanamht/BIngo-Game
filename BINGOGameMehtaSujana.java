import java.util.Scanner;
public class BINGOGameMehtaSujana 
{
   public static void main(final String[] args)                                  // main
   {
      
      Scanner input = new Scanner(System.in);
      System.out.println("Welcome to a game of BINGO!");
      System.out.println("Here is your card:\n");
      
         BINGOCardMehtaSujana game = new BINGOCardMehtaSujana();                 //to call BingoCard class.                
         game.BingoCard();
         game.printCard();
      
      while(true)                                                                //to run a loop for menu
      {
         System.out.println("\nWhat would you like to do?");
         System.out.println("\t\t1)Enter a called number.");
         System.out.println("\t\t2)See current card.");
      
         int num = input.nextInt();                                     //input for menu
         
         if (num == 1)
         {
             System.out.print("Enter the called number:");
             int num1 = input.nextInt();                                //input to replace number from card.
             game.replaceNum(num1); 
         } 
         else if (num == 2)
         {
             game.printCard();                                          // print card
         }
         else
         {
            System.out.println("INVALID NUMBER!");
         }
         
         if (game.gameOver())                                        //to stop the loop, once winner is declared. 
         {
            break;
         }
      }
   }
}
      
   