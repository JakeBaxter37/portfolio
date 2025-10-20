import java.util.Scanner;

/**
 * a class to represent a menu
 */

public class Menu {
	   /* ### FIELD(S) ### */
	/**
	 * menu result 
	 */
	private int menuR;
	
	/**
	 * Default constructor 
	 * to initialize the menu result to 0
	 */
	
	public Menu()
	{
		menuR = 0;
	}
	
	/**
	 * prompts the user with a menu and asks them what they would like to do 
	 * depending on what they input 1 to call the help method 2 to call the newGame method and 3 to loadGame method
	 */
	
	public void getMenuResult()
	{
		 Scanner s = new Scanner(System.in);
		  System.out.println("What would you like to do ");
		  System.out.println("1 - Help");
		  System.out.println("2 - Start a new game");
		  System.out.println("3 - Load a previously played game");
		  System.out.println("");
		  menuR = s.nextInt();
		  System.out.println("");
	}
	
	/**
	 * depending on what the user inputed when the getMenuResult method is called do different things 
	 * input 1 to call the help method 2 to call the newGame method and 3 to loadGame method
	 */
			
	public void MenuSystem()
	{
		GameBoard GB1 = new GameBoard();
		  do
		  {
			  getMenuResult();
			  if (menuR == 1)
			  {
				  System.out.println("");
				  GB1.help(); 
				  System.out.println("");
				  
			  }
			  else if (menuR == 2)
			  {
				  System.out.println("");
				  GB1.newGame();
				  System.out.println("");
			  }
			  else if (menuR == 3)
			  {
				  System.out.println("");
				  GB1.loadGame();
				  System.out.println("");
			  }
			  else 
			  {
				  System.out.println("Please input one of the selected options");
				  System.out.println("");
			  }
		  }
		  while (menuR != 2 && menuR != 3);
	}
	
	/**
	 * the Programs main method which calls the MenuSystem method
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Menu M1 = new Menu();
		M1.MenuSystem();
	}

}
