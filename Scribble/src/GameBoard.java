import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  a class to represent a scrabble game board
 */

public class GameBoard {

    /* ### FIELD(S) ### */
	/** A 2D array of objects to store the amount spent on different items for each month. 
	 * instances of the player class for both players 
	 */
	public char[][] Board = new char[15][15];
	public Player P1 = new Player();
	public Player P2 = new Player();
	
    /* ### CONSTRUCTORS ### */
    /**
     * Default constructor. Initialize field to default values.
     */
	public GameBoard()
	{
		int row, col;
		for (row=0; row<Board.length; row++)
		{
			for (col=0; col<Board[row].length; col++)
			{
				Board[row][col] = ' ';
			}
		}
	}
	/**
	 * Displays the game Board and everything on it
	 */
	public void Display()
	{
		int row, col;
		System.out.println("   1  2  3  4  5  6  7  8  9  10 11 12 13 14 15");
			for (row=0; row<Board.length; row++)
			{
				if (row < 9) 
				{
					System.out.print(row+1 + "  ");
				}
				else 
				{
					System.out.print(row+1 + " ");
				}
			for (col=0; col<Board[row].length; col++)
				{
					System.out.print("[" + Board[row][col] + "]");
				}
				System.out.println("");
			}
	}
	/**
	 * asks what direction you would like to place your first word and what it is 
	 * then places it in the center of the board and checks its within the boundaries 
	 * of the board then calculates the points of the word
	 * 
	 * @return the points of the word placed
	 */
	public int firstWord() 
	{
    	HashMap<Character, Integer> letterPoints = new HashMap<Character, Integer>();
    	
    	letterPoints.put('A', 1);
    	letterPoints.put('B', 3); 
    	letterPoints.put('C', 3);
    	letterPoints.put('D', 2);
    	letterPoints.put('E', 1);
    	letterPoints.put('F', 4); 
    	letterPoints.put('G', 2);
    	letterPoints.put('H', 4); 
    	letterPoints.put('I', 1); 
    	letterPoints.put('J', 8); 
    	letterPoints.put('K', 5); 
    	letterPoints.put('L', 1);
    	letterPoints.put('M', 3);
    	letterPoints.put('N', 1);
    	letterPoints.put('O', 1);
    	letterPoints.put('P', 3);
    	letterPoints.put('Q', 10);
    	letterPoints.put('R', 1); 
    	letterPoints.put('S', 1); 
    	letterPoints.put('T', 1); 
    	letterPoints.put('U', 1); 
    	letterPoints.put('V', 4); 
    	letterPoints.put('W', 4); 
    	letterPoints.put('X', 8); 
    	letterPoints.put('Y', 4); 
    	letterPoints.put('Z', 10);
	Scanner s = new Scanner(System.in);
	int startRow,startCol,wPoints=0;
	String dir;
	char[] words = null;
	
	startCol = 7;	
	startRow = 7;
	
	System.out.print("Would you like to go down or right (D/R):" );
	dir = s.nextLine();
	dir = dir.toUpperCase();
	
	if (dir.equals("D"))
	{

		do
		{
			System.out.print("Input the word you would like to add:");
			String word = s.nextLine();		
			word = word.toUpperCase();
			words = word.toCharArray();
	
			if ((startRow - words.length / 2) < 0 || (startRow + words.length / 2) > 15) 
				{
				System.out.println("The word is too big for the board");
				} 
			else 
			{
					break; 
			}
		} while (true);
	}
	
	if (dir.equals("R"))
	{

		do
		{
			System.out.print("Input the word you would like to add:");
			String word = s.nextLine();		
			word = word.toUpperCase();
			words = word.toCharArray();
			
			if ((startCol - words.length / 2) < 0 || (startCol + words.length / 2) > 15) 
			{
				System.out.println("The word is too big for the board");
			} 
			else 
			{
				break; 
			}
		} while (true);
	}
	
	for (char letter : words) 
	{ 
		wPoints += letterPoints.getOrDefault(letter, 0); 
	}
	
	
	
	if (dir.equals("D"))
		{
		startCol -= words.length/2 ;
			for (int i = 0; i < words.length; i++) 
			{
				Board[startCol + i][startRow] = words[i];
			}
		}
	else if (dir.equals("R"))
		{
		startRow -= words.length/2 ;
		for (int i = 0; i < words.length; i++) 
			{
				Board[startCol][startRow + i] = words[i];
			}
		}
	Display();
	return wPoints;
	}
	
	/**
	 * asks the row, column and direction you would like to place your word and what the word is 
	 * then places it in the center of the board and checks its within the boundaries 
	 * of the board and if it intersects with a pre-exsisting letter then calculates the points of the word
	 * 
	 * @return the points of the word placed
	 */
	
	public int addWord()
	{
    	HashMap<Character, Integer> letterPoints = new HashMap<Character, Integer>();
    	
    	letterPoints.put('A', 1);
    	letterPoints.put('B', 3); 
    	letterPoints.put('C', 3);
    	letterPoints.put('D', 2);
    	letterPoints.put('E', 1);
    	letterPoints.put('F', 4); 
    	letterPoints.put('G', 2);
    	letterPoints.put('H', 4); 
    	letterPoints.put('I', 1); 
    	letterPoints.put('J', 8); 
    	letterPoints.put('K', 5); 
    	letterPoints.put('L', 1);
    	letterPoints.put('M', 3);
    	letterPoints.put('N', 1);
    	letterPoints.put('O', 1);
    	letterPoints.put('P', 3);
    	letterPoints.put('Q', 10);
    	letterPoints.put('R', 1); 
    	letterPoints.put('S', 1); 
    	letterPoints.put('T', 1); 
    	letterPoints.put('U', 1); 
    	letterPoints.put('V', 4); 
    	letterPoints.put('W', 4); 
    	letterPoints.put('X', 8); 
    	letterPoints.put('Y', 4); 
    	letterPoints.put('Z', 10);
    	
		Scanner s = new Scanner(System.in);
		int startRow,startCol,wPoints=0, posD = 0;
		String dir;
		char[] words = null;
		char intersectD = ' ';
		
		System.out.print("Would you like to go down or right (D/R):" );
		dir = s.nextLine();
		dir = dir.toUpperCase();
		
		System.out.println("Where would you like to start your word.");
		System.out.print("Row:");
		startCol = s.nextInt();
		startCol--;		
		System.out.print("Column:");
		startRow = s.nextInt();
		startRow--;
		
		s.nextLine();
		
		if (dir.equals("D"))
		{
			do
			{
				System.out.print("Input the word you would like to add:");
				String word = s.nextLine();		
				word = word.toUpperCase();
				words = word.toCharArray();
		
				if ((startRow - words.length / 2) < 0 || (startRow + words.length / 2) > 15) 
					{
					System.out.println("The word is too big for the board");
					} 
				else 
				{
					break; 
				}
			} while (true);
			
						
			for (int i=0; i<words.length; i++)
			{
				if (Board[startCol+i][startRow] != (' '))
				{
					intersectD = Board[startCol+i][startRow];
					posD = startCol+i;
				}
			}
			
			
			if (intersectD != ' ')
			{
				boolean validI = false;
				
				
				while (!validI)
				{
					System.out.print("Input the word you would like to add:");
					String word = s.nextLine();		
					word = word.toUpperCase();
					char[] newWords = word.toCharArray();
					
					if (posD - startCol >= newWords.length || intersectD != newWords[posD - startCol]) 
					{
						System.out.println("The word is doesnt intersect with a pre-exsiting word"); 
						validI = false;
					}
					else
					{
						validI = true;
						for (int i = 0; i < newWords.length; i++) {
			                if (Board[startCol + i][startRow] != ' ' &&
			                    Board[startCol + i][startRow] != newWords[i]) {
			                    System.out.println("The word conflicts with existing letters");
			                    validI = false;
			                    break;
			                }
			            }

			            if (validI) {
			                words = newWords; 
			            }
					}
					
				}
				
			}
			
		}
		
		if (dir.equals("R"))
		{

			do
			{
				System.out.print("Input the word you would like to add:");
				String word = s.nextLine();		
				word = word.toUpperCase();
				words = word.toCharArray();
				
				if ((startCol - words.length / 2) < 0 || (startCol + words.length / 2) > 15) 
				{
					System.out.println("The word is too big for the board");
				} 
				else 
				{
					break; 
				}
			} while (true);
			
			for (int i=0; i<words.length; i++)
			{
				if (Board[startCol][startRow+i] != (' '))
				{
					intersectD = Board[startCol][startRow+i];
					posD = startRow+i;
				}
			}
			
		if (intersectD != ' ')
		{
			boolean validI = false;
			
			while (!validI)
			{
				System.out.print("Input the word you would like to add:");
				String word = s.nextLine();		
				word = word.toUpperCase();
				char[] newWords = word.toCharArray();
				
				if (posD - startRow >= newWords.length || intersectD != newWords[posD - startRow]) 
				{
					System.out.println("The word is doesnt intersect with a pre-exsiting word"); 
					validI = false;
				}
				else
				{
					validI = true;
					for (int i = 0; i < newWords.length; i++) {
		                if (Board[startCol][startRow+i] != ' ' &&
		                    Board[startCol][startRow+i] != newWords[i]) {
		                    System.out.println("The word conflicts with existing letters");
		                    validI = false;
		                    break;
		                }
		            }

		            if (validI) {
		                words = newWords;
		            }
				}
				
			}
		}
		}
		

		
		for (char letter : words) 
		{ 
			wPoints += letterPoints.getOrDefault(letter, 0); 
		}
		
		if (dir.equals("D"))
			{
				for (int i = 0; i < words.length; i++) 
				{
					Board[startCol + i][startRow] = words[i];
				}
			}
		else if (dir.equals("R"))
			{
			for (int i = 0; i < words.length; i++) 
				{
					Board[startCol][startRow + i] = words[i];
				}
			}
		Display();
		return wPoints;
	}

	
	/**
	 * creates a new game and asks for both the players names and then calls the firstWord method and player 
	 * 1 adds the first word then they take turns adding a word and after they have both added a word then 
	 * they are asked if they would like to continue playing the game if they do the cycle repeats and if not
	 * they are then asked if they would like to save their progress in the game and if they do the saveGame
	 * method is called. additionally the each players points are displayed after each turn and the game
	 * ends when either player reaches 200 points then said player wins the game.
	 */
	public void newGame() 
	{
		Scanner s = new Scanner(System.in);
		String cont="Y", save;
		System.out.println("Player 1 name:");
		P1.setName(s.nextLine());	
		System.out.println("Player 2 name:");
		P2.setName(s.nextLine());
		System.out.println(P1.getName() +"'s turn");
		P1.setPoints(firstWord());
		System.out.println(P2.getName() +"'s turn");
		P2.setPoints(addWord());
		System.out.println( P1.getName() + "'s Points: " + P1.getPoints());
		System.out.println( P2.getName() + "'s Points: " + P2.getPoints());

		do 
		{ 
			System.out.print("Do you want to continue the game (Y/N): ");
			cont = s.nextLine().toUpperCase();
			System.out.println(""); 
			if (cont.equals("Y"))
			{ 
				System.out.println(P1.getName() + "'s turn");
				P1.setPoints(addWord() + P1.getPoints());
				System.out.println(P2.getName() + "'s turn"); 
				P2.setPoints(addWord() + P2.getPoints()); 
				System.out.println("Player 1 points: " + P1.getPoints()); 
				System.out.println("Player 2 points: " + P2.getPoints()); 
			}
			if (P1.getPoints() > 200)
			{
				System.out.println(P1.getName() + " wins");
				break;
			}
			else if (P2.getPoints() > 200)
			{
				System.out.println(P2.getName() + " wins");
				break;
			}
			
			
			if (cont.equals("N")) 
			{ 
				System.out.print("Would you like to save Current games Progress (Y/N): ");
				save = s.nextLine().toUpperCase();
				System.out.println(""); 
				if ((save.equals("N")))
				{
					break;
				}
				else if (save.equals("Y"))
				{
					saveGame();
					break;
				}
				else
				{ 
					System.out.println("Would you kindly input either Y or N");
					continue;
				}
			}	
			else 
			{
				System.out.println("Would you kindly input either Y or N");
				continue;
			}
			
			} 
		while (!cont.equals("N")); 
		}
	/**
	 * plays a game that has been previously played and saved using the SaveGame method and loaded 
	 * using the LoadGame method players take turns adding a word and after they have both added a word then 
	 * they are asked if they would like to continue playing the game if they do the cycle repeats and if not
	 * they are then asked if they would like to save their progress in the game and if they do the saveGame
	 * method is called. additionally the each players points are displayed after each turn and the game
	 * ends when either player reaches 200 points then said player wins the game.
	 */
	public void LoadedGame() 
	{
		Scanner s = new Scanner(System.in);
		String cont="Y", save;

		Display();
		
		System.out.println(P1.getName() +"'s turn");
		P1.setPoints(addWord());
		System.out.println(P2.getName() +"'s turn");
		P2.setPoints(addWord());
		System.out.println( P1.getName() + "'s Points: " + P1.getPoints());
		System.out.println( P2.getName() + "'s Points: " + P2.getPoints());

		do 
		{ 
			System.out.print("Do you want to continue the game (Y/N): ");
			cont = s.nextLine().toUpperCase();
			System.out.println(""); 
			if (cont.equals("Y"))
			{ 
				System.out.println(P1.getName() + "'s turn");
				P1.setPoints(addWord() + P1.getPoints());
				System.out.println(P2.getName() + "'s turn"); 
				P2.setPoints(addWord() + P2.getPoints()); 
				System.out.println("Player 1 points: " + P1.getPoints()); 
				System.out.println("Player 2 points: " + P2.getPoints()); 
			}
			if (cont.equals("N")) 
			{ 
				System.out.print("Would you like to save Current games Progress (Y/N): ");
				save = s.nextLine().toUpperCase();
				System.out.println(""); 
				if ((save.equals("N")))
				{
					break;
				}
				else if (save.equals("Y"))
				{
					saveGame();
					break;
				}
				else
				{ 
					System.out.println("Would you kindly input either Y or N");
					continue;
				}
			}	
			else 
			{
				System.out.println("Would you kindly input either Y or N");
				continue;
			}
			} 
		while (!cont.equals("N")); 
		}
	
	/**
	 * Gives a description of how the game is played
	 */
	
	public void help()
	{
		System.out.println("How to play:");
		System.out.println("The 2 players will enter their names and ");
		System.out.println("then player one will have their first turn and will");
		System.out.println("choose a word to input in the middle of the board");
		System.out.println("then player two will have their first turn and will");
		System.out.println("choose a word to input and which the row and ");
		System.out.println("coloumn they would like to input the word ");
		System.out.println("every word after the first word also has to intersect with a ");
		System.out.println("pre-exsiting word both players will then be asked if they ");
		System.out.println("would like to contine playing then the next cycle will repeat");
		System.out.println("if the players dont want to continue they can save the");
		System.out.println("current games progress or they can choose to delete it");
		System.out.println("The game can also end if one player reaches 200 points");
		
	}
	
	/**
	 * Writes the Game board to a file called savedBoard.txt and 
	 * Writes the players names to a file called savedName.txt and 
	 * Writes the players Points to a file called savedPoits.txt  
	 */
	public void saveGame()
	{
		FileOutputStream outputStream = null;
        PrintWriter printWriter = null;
        int row,col;

        try
        {
            outputStream = new FileOutputStream("savedBoard.txt");
        
            printWriter = new PrintWriter(outputStream); 

			for (row=0; row<Board.length; row++)
			{
			for (col=0; col<Board[row].length; col++)
				{
				printWriter.print(Board[row][col]+ ", ");
				}
			printWriter.println("");
			}
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
            if (printWriter != null)
                printWriter.close();
        }
	
	  try
      {
          outputStream = new FileOutputStream("savedName.txt");
      
          printWriter = new PrintWriter(outputStream); 
          
          printWriter.println(P1.getName() + " " + P2.getName());
				
      }
      catch (IOException e)
      {
          System.out.println("Sorry, there has been a problem opening or writing to the file");
          System.out.println("/t" + e);
      }
      finally
      {
          if (printWriter != null)
              printWriter.close();
      }
	  
	  try
      {
          outputStream = new FileOutputStream("savedPoints.txt");
      
          printWriter = new PrintWriter(outputStream); 
          
          printWriter.println(P1.getPoints()+ " " +P2.getPoints());
				
      }
      catch (IOException e)
      {
          System.out.println("Sorry, there has been a problem opening or writing to the file");
          System.out.println("/t" + e);
      }
      finally
      {
          if (printWriter != null)
              printWriter.close();
      }
  }
	
	/**
	 * Reads the Game board from a file called savedBoard.txt into the Field Board 
	 * Reads the players names from a file called savedName.txt their names to both of the players
	 * Reads the players Points from a file called savedPoits.txt into the Points of both of the players
	 */
	public void loadGame()
	{
	    FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        String nextLine;
        

        try
        {
            fileReader = new FileReader("savedBoard.txt");
            
            bufferedReader = new BufferedReader(fileReader); 
            
            nextLine = bufferedReader.readLine();
            
            int row = 0;
            
            while (nextLine != null && row < 15) 
            { 
            	String[] values = nextLine.split(", "); 
            	for (int col = 0; col < values.length && col < Board[row].length; col++) 
            	{ 
            		Board[row][col] = values[col].charAt(0); 
            	}
            nextLine = bufferedReader.readLine();
            row++; 
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Sorry, your file was not found.");
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or reading from the file");
        }
        finally
        {
            if (bufferedReader != null)
            {
                try 
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    System.out.println("Sorry, there has been a problem closing the file");
                }
            }
        }
        
        
        try
        {
            fileReader = new FileReader("savedName.txt");
            
            bufferedReader = new BufferedReader(fileReader); 
            
            nextLine = bufferedReader.readLine();
                        
            while (nextLine != null) 
            { 
            	String[] values = nextLine.split(" "); 
            	
            	P1.setName(values[0]);
            	P2.setName(values[1]);
            	
            nextLine = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Sorry, your file was not found.");
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or reading from the file");
        }
        finally
        {
            if (bufferedReader != null)
            {
                try 
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    System.out.println("Sorry, there has been a problem closing the file");
                }
            }
        }
        try
        {
            fileReader = new FileReader("savedPoints.txt");
            
            bufferedReader = new BufferedReader(fileReader); 
            
            nextLine = bufferedReader.readLine();
                        
            while (nextLine != null) 
            { 
            	String[] values = nextLine.split(" "); 
            	
            	P1.setPoints(Integer.parseInt(values[0]));
            	P2.setPoints(Integer.parseInt(values[1]));
            	
            nextLine = bufferedReader.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Sorry, your file was not found.");
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or reading from the file");
        }
        finally
        {
            if (bufferedReader != null)
            {
                try 
                {
                    bufferedReader.close();
                }
                catch (IOException e)
                {
                    System.out.println("Sorry, there has been a problem closing the file");
                }
            }
        }
       LoadedGame();
	}
}