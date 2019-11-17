import javax.swing.JPanel;
import java.awt.Graphics;

public class MyPanelBomber extends JPanel {
	private Bomber _bomber;
	
	@Override	
	public void paint(Graphics g) {
		super.paint(g);
		if (_bomber != null)
			_bomber.drawBomber(g, this.getWidth(), this.getHeight());
	}
	
	public MyPanelBomber() {
	}
	
	public void SetBomber(Bomber bomber) {
		_bomber = bomber;
	}
}