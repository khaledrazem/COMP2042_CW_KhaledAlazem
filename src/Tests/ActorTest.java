package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import obstacles.*;
import p4_group_8_repo.ViewManager;
import p4_group_8_repo.Player;

class ActorTest {

	private JFXPanel panel=new JFXPanel();
	void setUp() {
		
	}
	@Test
	void testMove() {
		Player animal=new Player();
		double tempx=animal.getX();
		double tempy=animal.getY();
		
		animal.move(100,100);
		
		assertEquals(animal.getX(),tempx+100);
		assertEquals(animal.getY(),tempy+100);
	}

	@Test
	void testGetType() {
		Turtle turtle=new Turtle(30);
		String type=turtle.getType();
		assertEquals("Turtle30.0",type);
		
		Log log=new Log("file:src/Images/log3.png",30);
		type=log.getType();
		assertEquals("Log30.0",type);
		
		WetTurtle wturtle=new WetTurtle(30);
		type=wturtle.getType();
		assertEquals("Turtle30.0",type);
		
	}

}
