import java.awt.Color;
import java.awt.Graphics;

public class Bomber extends WarPlane {
	private Color _dopColor;
	private boolean _isSpire;
	private boolean _isBombs;
	private boolean _isEmblem;
	IBombs _bombs;

	public Bomber(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean isSpire, boolean isBombs,
			boolean isEmblem, IBombs bombs) {
		super(maxSpeed, weight, mainColor);
		_dopColor = dopColor;
		_isSpire = isSpire;
		_isBombs = isBombs;
		_isEmblem = isEmblem;
		_bombs = bombs;
	}

	public void SetDopColor(Color dopColor) {
		_dopColor = dopColor;
	}

	public Color GetDopColor() {
		return _dopColor;
	}

	public void SetSpire(boolean spire) {
		_isSpire = spire;
	}

	public boolean GetSpire() {
		return _isSpire;
	}

	public void Bombs(boolean bombs) {
		_isBombs = bombs;
	}

	public boolean Bombs() {
		return _isBombs;
	}

	public void SetEmblem(boolean emblem) {
		_isEmblem = emblem;
	}

	public boolean GetEmblem() {
		return _isEmblem;
	}

	@Override
	public void DrawWarPlane(Graphics g) {
		if (_isSpire) {
			g.setColor(_dopColor);
			g.fillOval(_startPosX, _startPosY + 33, 50, 4);
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX, _startPosY + 33, 50, 4);
		}
		super.DrawWarPlane(g);
		if (_isEmblem) {
			g.setColor(_dopColor);
			g.fillOval(_startPosX + 45, _startPosY + 50, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
		}
		if (_isBombs) {
			_bombs.SetPosition(_startPosX, _startPosY);
			_bombs.DrawBombs(g, ((Bombs)_bombs).GetCount(), GetDopColor());
		}
	}
}