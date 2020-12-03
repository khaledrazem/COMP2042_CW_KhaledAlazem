package ACT;

public interface Act {


	/**
	 * abstract method for act functionality that represents how each object should act in game time
	 * @param actor the object that needs functionality
	 * @param now game timer
	 */
	
	public void act(Actor actor,long now);
	

	/**
	 * This method restricts the actor from going off screen
	 * @param actor the object that needs restriction
	 */
	public void restrictmovement(Actor actor);
}
