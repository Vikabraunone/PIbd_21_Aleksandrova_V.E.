import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelHangar extends JPanel {
	private Hangar<ITransport, IBombs> hangar = null;

	public void SetHangar(Hangar<ITransport, IBombs> hangar) {
		this.hangar = hangar;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		hangar.Draw(g);
	}
}
