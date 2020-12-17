package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.embed.swing.JFXPanel;
import p4_group_8_repo.Player;
import p4_group_8_repo.ScoreHandler;

class ScoreHandlerTest {

	private JFXPanel panel=new JFXPanel();
	ScoreHandler sch=new ScoreHandler();
	public Player animal=new Player();

	@Test
	void testGethiscore() {
		sch.readscores();
		int temp=sch.gethiscore();
		assertNotNull(temp);
	}

	@Test
	void testGetPoints() {
		int temp=sch.getPoints();
		assertNotNull(temp);
	}

}
