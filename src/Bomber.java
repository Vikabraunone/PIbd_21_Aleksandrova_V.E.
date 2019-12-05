import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Bomber {
	private int _startPosX;
	private int _startPosY;
	private int _pictureWidth;
	private int _pictureHeight;
	private final int bomberWidth = 90;
	private final int bomberHeight = 70;
	private int _maxSpeed;
	private float _weight;
	private Color _mainColor;
	private Color _dopColor;
	private boolean _isSpire;
	private boolean _isBombs;
	private boolean _isEmblem;
	Bombs bombs;

	public void MaxSpeed(int maxSpeed) {
		_maxSpeed = maxSpeed;
	}

	public int MaxSpeed() {
		return _maxSpeed;
	}

	public void Weight(float weight) {
		_weight = weight;
	}

	public float Weight() {
		return _weight;
	}

	public void MainColor(Color mainColor) {
		_mainColor = mainColor;
	}

	public Color MainColor() {
		return _mainColor;
	}

	public void DopColor(Color dopColor) {
		_dopColor = dopColor;
	}

	public Color DopColor() {
		return _dopColor;
	}

	public void Spire(boolean spire) {
		_isSpire = spire;
	}

	public boolean Spire() {
		return _isSpire;
	}

	public void Bombs(boolean bombs) {
		_isBombs = bombs;
	}

	public boolean Bombs() {
		return _isBombs;
	}

	public void Emblem(boolean emblem) {
		_isEmblem = emblem;
	}

	public boolean Emblem() {
		return _isEmblem;
	}

	public Bomber(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean isSpire, boolean isBombs,
			boolean isEmblem) {
		_maxSpeed = maxSpeed;
		_weight = weight;
		_mainColor = mainColor;
		_dopColor = dopColor;
		_isSpire = isSpire;
		_isBombs = isBombs;
		_isEmblem = isEmblem;
		Random rnd = new Random();
		int number = 6 + rnd.nextInt(5);
		if (number == 6)
			bombs = new Bombs(CountBomb.Six);
		else if (number == 7)
			bombs = new Bombs(CountBomb.Seven);
		else if (number == 8)
			bombs = new Bombs(CountBomb.Eight);
		else if (number == 9)
			bombs = new Bombs(CountBomb.Nine);
		else
			bombs = new Bombs(CountBomb.Ten);
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void MoveTransport(Direction direction) {
		float step = _maxSpeed * 100 / _weight;
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - bomberWidth)
				_startPosX += step;
			break;
		case Left:
			if (_startPosX - step > 0)
				_startPosX -= step;
			break;
		case Up:
			if (_startPosY - step > 0)
				_startPosY -= step;
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - bomberHeight)
				_startPosY += step;
			break;
		}
	}

	public void drawBomber(Graphics g, int width, int height) {
		if (_isSpire) {
			g.setColor(_dopColor);
			g.fillOval(_startPosX, _startPosY + 33, 50, 4);
			g.setColor(Color.BLACK);
			g.fillOval(_startPosX, _startPosY + 33, 50, 4);
		}
		// двигатели
		g.setColor(Color.BLACK);
		g.drawOval(_startPosX + 60, _startPosY + 10, 10, 10);
		g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
		g.drawRect(_startPosX + 54, _startPosY + 9, 12, 12);
		g.drawRect(_startPosX + 54, _startPosY + 49, 12, 12);
		g.setColor(_dopColor);
		g.fillOval(_startPosX + 60, _startPosY + 10, 10, 10);
		g.fillOval(_startPosX + 60, _startPosY + 50, 10, 10);
		g.fillRect(_startPosX + 55, _startPosY + 10, 10, 12);
		g.fillRect(_startPosX + 55, _startPosY + 50, 10, 12);
		g.setColor(Color.BLACK);
		g.drawLine(_startPosX + 70, _startPosY + 10, _startPosX + 70, _startPosY + 20);
		g.drawLine(_startPosX + 70, _startPosY + 50, _startPosX + 70, _startPosY + 60);
		// корпус
		g.setColor(_mainColor);
		g.fillOval(_startPosX + 20, _startPosY + 30, 70, 10);
		g.fillRect(_startPosX + 20, _startPosY + 30, 70, 10);
		g.setColor(Color.BLACK);
		g.drawRect(_startPosX + 20, _startPosY + 30, 70, 10);
		// крылья
		g.setColor(_mainColor);
		g.fillRect(_startPosX + 40, _startPosY, 20, 70);
		g.setColor(Color.BLACK);
		g.drawRect(_startPosX + 40, _startPosY, 20, 30);
		g.drawRect(_startPosX + 40, _startPosY + 40, 20, 30);
		// хвост
		g.setColor(_mainColor);
		g.fillRect(_startPosX + 80, _startPosY + 10, 10, 50);
		g.setColor(Color.BLACK);
		g.drawRect(_startPosX + 80, _startPosY + 10, 10, 20);
		g.drawRect(_startPosX + 80, _startPosY + 40, 10, 20);
		if (_isEmblem) {
			g.setColor(Color.RED);
			g.fillOval(_startPosX + 45, _startPosY + 50, 10, 10);
			g.setColor(Color.BLACK);
			g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
		}
		if (_isBombs)
			bombs.DrawBomber(g, _startPosX, _startPosY);
	}
}
