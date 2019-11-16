import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MyPanelBomber extends JPanel {
	Random rnd = new Random();
	public static Bombs bombs;
	public static WarPlane warPlane = null;
	static Direction direction = null;
	
	@Override	
	public void paint(Graphics g) {
		super.paint(g);
		if (warPlane != null)
		warPlane.DrawWarPlane(g);
		if (bombs != null){
            Color color = new Color(rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
            bombs.DrawBombs(g, CountBomb.Nine, color);
        }
	}
	
	public MyPanelBomber() {
		bombs = null;
	}
}