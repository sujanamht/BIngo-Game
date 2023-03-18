
import java.util.Scanner;
public class BINGOCardMehtaSujana
{
      int[][] card = new int[5][5];                                                 // 5x5 bingo card
           
      public void BingoCard()
      {
         for (int row = 0; row < 5; row++)
         {
            for (int col = 0; col < 5; col++) 
            {
               int num;
               do 
               {
                  num = (int) (Math.random() * 15) + 1 + (col * 15);                   // generate a number between 1 and 15, 16 and 30, 31 and 45, 46 and 60, or 61 and 75
               }
               while (isDuplicate(num, card, row, col));
                     card[row][col] = num;
            }
         }
         card[2][2] = 0;                                                              // the center is "free"
   
      }
   
      public void printCard()                                                         // Print the BINGO card
      {                                     
         System.out.println( "| "+"B "+ " | "+ "I " + "  | "+"N "+ "  | "+"G "+ "  | "+"O " + "  | ");
         
         for (int row = 0; row < 5; row++) 
         {
            for (int col = 0; col < 5; col++) 
            {
               if (col == 0) 
               {
                  System.out.printf( "| "+"%-3d"+ "| ", card[row][col]);
               }
               else 
               {
                  System.out.printf("%-4d"+ "| ", card[row][col]);
               }
            }
               System.out.println();
         }
      }
   
      private static boolean isDuplicate(int num, int[][] card, int row, int col)                   // to check dublicate number 
      {
         for (int i = 0; i < row; i++) 
         {
            if (card[i][col] == num) 
            {
               return true;
            }
         }
         for (int j = 0; j < col; j++) 
         {
            if (card[row][j] == num) 
            {
               return true;
            }
         }
         return false;
      }
   
      public void replaceNum(int num1)
      {
         boolean found = false; 
         for (int i = 0; i < 5; i++) 
         {
            for (int j = 0; j < 5; j++)
            {
               if (card[i][j] == num1) 
               {
                  card[i][j] = 0;
                  found = true;                                // mark as found if num1 is found in the card
               }
            }
         }
         gameOver();
            
            if (gameOver() == true)
            {
               System.out.println("\nLooks like we've got a winner! BINGO!!!");
               printCard();
            }
            else if (!found) 
            {
               System.out.println("Invalid Number!");
            }
            else 
            {
               System.out.println(" No winner yet!");
            }
      }
      
      private boolean checkCols()                                                   // to check called number in columns. 
      {
         for (int i = 0; i < 5; i++) 
         {
            if (card[0][i] + card[1][i] + card[2][i] + card[3][i] + card[4][i] == 0)
            {
               return true;
            }
         }
            return false;
      }
   
      private boolean checkRows()                                                   // to check called number in rows. 
      {
         for (int i = 0; i < 5; i++) 
         {
            if (card[i][0] + card[i][1] + card[i][2] + card[i][3] + card[i][4] == 0) 
            {
               return true;
            }
         }
            return false;
      }
   
      private boolean checkDiag()                                                    // to check called number diagonally. 
      {
         if  (card[0][0] + card[1][1] + card[2][2] + card[3][3] + card[4][4] == 0 || card[0][4] + card[1][3] + card[2][2] + card[3][1] + card[4][0] == 0) 
         {
            return true;
         }
         else
         {
            return false;
         }
      }
   
      public boolean gameOver()                                                    // to return true if any rows or columns or diagonal is complete. 
      {
         return (checkCols() || checkRows() || checkDiag());
      }

}




