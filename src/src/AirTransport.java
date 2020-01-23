import java.awt.Color;
import java.awt.Graphics;

public abstract class AirTransport implements ITransport {
	protected int _startPosX;
	protected int _startPosY;
	protected int _pictureWidth;
	protected int _pictureHeight;
	private int _maxSpeed;
	private float _weight;
	private Color _mainColor;

	public void SetMaxSpeed(int maxSpeed) {
		_maxSpeed = maxSpeed;
	}

	public int GetMaxSpeed() {
		return _maxSpeed;
	}

	public void SetWeight(float weight) {
		_weight = weight;
	}

	public float GetWeight() {
		return _weight;
	}

	public void SetMainColor(Color mainColor) {
		_mainColor = mainColor;
	}

	public Color GetMainColor() {
		return _mainColor;
	}

	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public abstract void DrawWarPlane(Graphics g);

	public abstract void MoveTransport(Direction direction);
}