package ACT;

public class ActMoveOnly implements Act {
	
	Actor actor;

	@Override
	public void act(Actor actor,long now) {
		actor.move(actor.speed , 0);
		this.actor=actor;
		restrictmovement();

	}

	@Override
	public void restrictmovement() {
		if (actor.getX()>600 && actor.speed>0)
			actor.setX(-200);
		if (actor.getX()<-100 && actor.speed<0)
			actor.setX(800);
		System.out.println("toot");
	}

}
