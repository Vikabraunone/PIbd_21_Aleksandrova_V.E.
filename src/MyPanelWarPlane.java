import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanelWarPlane extends JPanel {
	public static WarPlane warPlane = null;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (warPlane != null)
			warPlane.DrawWarPlane(g);
	}
}