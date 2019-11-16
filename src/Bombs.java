import java.awt.Color;
import java.awt.Graphics;

public class Bombs {
	  public CountBomb Count;

      public Bombs(CountBomb count)
      {
          Count = count;
      }

      public void DrawBomber(Graphics g, int _startPosX, int _startPosY)
      {
    	  int count;
    	  if (Count == CountBomb.Six)
    		  count = 6;
    	  else if (Count == CountBomb.Seven)
    		  count = 7;
    	  else if (Count == CountBomb.Eight)
    		  count = 8;
    	  else if (Count == CountBomb.Nine)
    		  count = 9;
    	  else
    		  count = 10;
          int i=0;
          while (i < count && i < 3)
          {
        	  g.setColor(Color.gray);
              g.fillOval(_startPosX + 10, _startPosY + i * 10, 10, 10);
              g.setColor(Color.black);
              g.drawOval(_startPosX + 10, _startPosY + i * 10, 10, 10);
              i++;
          }

          while (i < count && i < 6)
          {
        	  g.setColor(Color.gray);
              g.fillOval(_startPosX + 10, _startPosY + i * 10 + 10, 10, 10);
              g.setColor(Color.black);
              g.drawOval(_startPosX + 10, _startPosY + i * 10 + 10, 10, 10);
              i++;
          }

          int j = 0;
          while (i < count && i < 9)
          {
        	  g.setColor(Color.gray);
              g.fillOval(_startPosX + 20, _startPosY + j , 10, 10);
              g.setColor(Color.black);
              g.drawOval(_startPosX + 20, _startPosY + j , 10, 10);
              i++;
              j += 10;
          }

          while (i < count)
          {
        	  g.setColor(Color.gray);
              g.fillOval(_startPosX + 20, _startPosY + 40, 10, 10);
              g.setColor(Color.black);
              g.drawOval(_startPosX + 20, _startPosY  + 40, 10, 10);
              i++;
          }
      }
}
