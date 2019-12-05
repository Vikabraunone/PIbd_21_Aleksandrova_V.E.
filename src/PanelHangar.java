import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelHangar extends JPanel {
	public Hangar hangar;
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		hangar.Draw(g);
	}
}
