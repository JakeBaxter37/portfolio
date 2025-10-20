/**
 * a class to represent a player
 */

public class Player 
{
	   /* ### FIELD(S) ### */
	    /**
	     * The name of the player
	     * the points of the player
	     */
	    private String name;
	    private int points;


		/**
		 * Default constructor
	     * Creates an instance of player with null string for the name
	     * and with their points set to 0
	     */
	    public Player() 
	    {
	    	name = "";
	    	points = 0;
	    }

	    /**
	     * Creates an instance of player with a specified name and points.
	     * 
	     * @param nam the name of player, point the points of the player
	     * 
	     */
	    public Player(String nam, int point) 
	    {
	    	name = nam;
	    	points = point;
	    }

	    /**
	     * Retrieves the name of the player 
	     * 
	     * @return the name of the player 
	     */
	    public String getName() 
	    {
	        return name;
	    }

	    /**
	     * Sets the name of the player 
	     * 
	     * @param the name of the player 
	     */
	    public void setName(String nam) 
	    {
	    	name = nam;
	    }
	    /**
	     * Retrieves the amount of points of the player
	     * 
	     * @return points the points of the player
	     */
	    public int getPoints() 
	    {
			return points;
		}
	    /**
	     * Sets the number of points the player has
	     * 
	     * @param point the points of the player
	     */
		public void setPoints(int point) 
		{
			points = point;
		}
		
}
