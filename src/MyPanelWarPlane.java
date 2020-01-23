import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanelWarPlane extends JPanel {
	private ITransport warPlane = null;
  
	public void SetWarPlane(ITransport warPlane) {
		this.warPlane = warPlane;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (warPlane != null)
			warPlane.DrawWarPlane(g);
	}
}