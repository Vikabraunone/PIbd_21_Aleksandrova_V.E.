import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class MyPanelBomber extends JPanel {
	Random rnd = new Random();
	static Direction direction = null;
	public static Bombs bombs;
	public static WarPlane warPlane = null;
	public static CountBomb countBombs = null;
	public static Color colorBombs = null;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (warPlane != null)
			warPlane.DrawWarPlane(g);
		if (bombs != null)
			bombs.DrawBombs(g, countBombs, colorBombs);
	}

	public MyPanelBomber() {
		bombs = null;
	}
}