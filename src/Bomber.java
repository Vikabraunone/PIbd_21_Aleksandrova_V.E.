import java.awt.Color;
import java.awt.Graphics;

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
    private boolean _isEngine;
    private boolean _emblem;
    Bombs bomb;
    
    public void MaxSpeed (int maxSpeed) {
    	_maxSpeed = maxSpeed;
    }
    
    public int MaxSpeed() {
    	return _maxSpeed;
    }
    
    public void Weight (float weight) {
    	_weight = weight;
    }
    
    public float Weight() {
    	return _weight;
    }
    
    public void MainColor (Color mainColor) {
    	_mainColor = mainColor;
    }
    
    public Color MainColor() {
    	return _mainColor;
    }
    
    public void DopColor (Color dopColor) {
    	_dopColor = dopColor;
    }
    
    public Color DopColor() {
    	return _dopColor;
    }
    
    public void Spire (boolean spire) {
    	_isSpire = spire;
    }
    
    public boolean Spire() {
    	return _isSpire;
    }
    
    public void Bombs (boolean bombs) {
    	_isEngine = bombs;
    }
    
    public boolean Bombs() {
    	return _isEngine;
    }
    
    public void Emblem (boolean emblem) {
    	_emblem = emblem;
    }
    
    public boolean Emblem() {
    	return _emblem;
    }
 
    public Bomber(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean spire, boolean bombs, boolean emblem, CountBomb count)
    {
        _maxSpeed = maxSpeed;
        _weight = weight;
        _mainColor = mainColor;
        _dopColor = dopColor;
        _isSpire = spire;
        _isEngine = bombs;
        _emblem = emblem;
        bomb = new Bombs(count);
    }

    public void SetPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public void MoveTransport(Direction direction)
    {
        float step = _maxSpeed * 100 / _weight;
        switch (direction)
        {
            // вправо
            case Right:
                if (_startPosX + step < _pictureWidth - bomberWidth)
                {
                    _startPosX += step;
                }
                break;
            //влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            //вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;
            //вниз
            case Down:
                if (_startPosY + step < _pictureHeight - bomberHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    
    public void drawBomber(Graphics g, int width, int height) {
        if (_isSpire)
        {
            g.setColor(_dopColor);
            g.fillOval(_startPosX, _startPosY + 33, 50, 4);
            g.setColor(Color.BLACK);
            g.fillOval(_startPosX, _startPosY + 33, 50, 4);
        }
        if (_isEngine)
        {
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
        }
        g.setColor(_mainColor);
        g.fillOval(_startPosX + 20, _startPosY + 30, 70, 10);
        g.fillRect(_startPosX + 20, _startPosY + 30, 70, 10);
        g.setColor(Color.BLACK);
        g.drawRect(_startPosX + 20, _startPosY + 30, 70, 10);
        //крылья
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
        if (_emblem)
        {
        	g.setColor(Color.RED);
            g.fillOval( _startPosX + 45, _startPosY + 50, 10, 10);
            g.setColor(Color.BLACK);
            g.drawOval(_startPosX + 45, _startPosY + 50, 10, 10);
        }
        bomb.DrawBomber(g,_startPosX, _startPosY);
    }
}
