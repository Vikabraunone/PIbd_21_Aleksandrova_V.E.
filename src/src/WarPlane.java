import java.awt.Color;
import java.awt.Graphics;

public class WarPlane extends AirTransport {
	protected final int warPlaneWidth = 100;
	protected final int warPlaneHeight = 80;

    public WarPlane(String info)
    {
        String[] strs = info.split(";");
        if (strs.length == 3)
        {
        	SetMaxSpeed(Integer.parseInt(strs[0]));
    		SetWeight(Float.parseFloat(strs[1]));
    		SetMainColor(new Color(Integer.parseInt(strs[2])));
        }
    }
	
	public WarPlane(int maxSpeed, float weight, Color mainColor) {
		SetMaxSpeed(maxSpeed);
		SetWeight(weight);
		SetMainColor(mainColor);
	}

	@Override
	public void DrawWarPlane(Graphics g) {
		// двигатели
		g.setColor(Color.black);
		g.drawOval(_startPosX + 60, _startPosY + 10, 10, 10);
		g.drawOval(_startPosX + 60, _startPosY + 50, 10, 10);
		g.drawRect(_startPosX + 54, _startPosY + 9, 12, 12);
		g.drawRect(_startPosX + 54, _startPosY + 49, 12, 12);
		g.setColor(GetMainColor());
		g.fillOval(_startPosX + 60, _startPosY + 10, 10, 10);
		g.fillOval(_startPosX + 60, _startPosY + 50, 10, 10);
		g.fillRect(_startPosX + 55, _startPosY + 10, 10, 12);
		g.fillRect(_startPosX + 55, _startPosY + 50, 10, 12);
		g.setColor(Color.black);
		g.drawLine(_startPosX + 70, _startPosY + 10, _startPosX + 70, _startPosY + 20);
		g.drawLine(_startPosX + 70, _startPosY + 50, _startPosX + 70, _startPosY + 60);
		// корпус
		g.setColor(GetMainColor());
		g.fillRect(_startPosX + 20, _startPosY + 30, 70, 10);
		g.fillRect(_startPosX + 20, _startPosY + 30, 70, 10);
		g.setColor(Color.black);
		g.drawRect(_startPosX + 20, _startPosY + 30, 70, 10);
		// крылья
		g.setColor(GetMainColor());
		g.fillRect(_startPosX + 40, _startPosY, 20, 70);
		g.setColor(Color.BLACK);
		g.drawRect(_startPosX + 40, _startPosY, 20, 30);
		g.drawRect(_startPosX + 40, _startPosY + 40, 20, 30);
		// хвост
		g.setColor(GetMainColor());
		g.fillRect(_startPosX + 80, _startPosY + 10, 10, 50);
		g.setColor(Color.BLACK);
		g.drawRect(_startPosX + 80, _startPosY + 10, 10, 20);
		g.drawRect(_startPosX + 80, _startPosY + 40, 10, 20);
	}

	@Override
	public void MoveTransport(Direction direction) {
		float step = GetMaxSpeed() * 100 / GetWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - warPlaneWidth) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - warPlaneHeight) {
				_startPosY += step;
			}
			break;
		}
	}
	
	@Override
    public String toString() {
        return GetMaxSpeed() + ";" + GetWeight() + ";" + GetMainColor().getRGB();
    }
}