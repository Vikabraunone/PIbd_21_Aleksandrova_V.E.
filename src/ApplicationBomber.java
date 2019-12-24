import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationBomber {
	private JFrame frameBomber;
	private JPanel panelBomber;
	private ITransport warPlane;
	private IBombs bombs;
	Random rnd = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationBomber window = new ApplicationBomber();
					window.frameBomber.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationBomber() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameBomber = new JFrame();
		frameBomber.setTitle("\u0411\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A");
		frameBomber.setBounds(100, 100, 900, 500);
		frameBomber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBomber.getContentPane().setLayout(null);
		panelBomber = new MyPanelWarPlane();
		panelBomber.setBounds(0, 0, 858, 450);
		frameBomber.getContentPane().add(panelBomber);
		panelBomber.setLayout(null);
		JButton buttonCreateWarPlane = new JButton(
				"\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0432\u043E\u0435\u043D\u043D\u044B\u0439 \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonCreateWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bombs = null;
				warPlane = new WarPlane(rnd.nextInt(200) + 100, rnd.nextInt(200) + 100, new Color(0, 128, 0));
				warPlane.SetPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10, panelBomber.getWidth(),
						panelBomber.getHeight());
				MyPanelWarPlane.warPlane = (WarPlane) warPlane;
				panelBomber.repaint();
			}
		});
		buttonCreateWarPlane.setForeground(Color.BLACK);
		buttonCreateWarPlane.setBounds(29, 39, 236, 23);
		panelBomber.add(buttonCreateWarPlane);
		JButton buttonCreateBomber = new JButton(
				"\u0421\u043E\u0437\u0434\u0430\u0442\u044C \u0431\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A\u0430");
		buttonCreateBomber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int posX = rnd.nextInt(90) + 10;
				int posY = rnd.nextInt(90) + 10;
				int typeBombs = rnd.nextInt(3);
				if (typeBombs == 0)
					bombs = new CircleBombs();
				else if (typeBombs == 1)
					bombs = new SquareBombs();
				else
					bombs = new RectangleBombs();
				bombs.SetPosition(posX, posY);
				warPlane = new Bomber(rnd.nextInt(200) + 100, rnd.nextInt(200) + 100, new Color(0, 128, 0),
						Color.yellow, true, true, true, bombs);
				warPlane.SetPosition(posX, posY, panelBomber.getWidth(), panelBomber.getHeight());
				MyPanelWarPlane.warPlane = (WarPlane) warPlane;
				panelBomber.repaint();
			}
		});
		buttonCreateBomber.setForeground(Color.BLACK);
		buttonCreateBomber.setBounds(364, 39, 265, 23);
		panelBomber.add(buttonCreateBomber);
		ImageIcon iconUp = new ImageIcon("btnUp.jpg");
		Image img = iconUp.getImage();
		Image newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		iconUp = new ImageIcon(newimg);
		JButton buttonUp = new JButton(iconUp);
		buttonUp.setBounds(770, 370, 30, 30);
		panelBomber.add(buttonUp);
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warPlane.MoveTransport(Direction.Up);
				panelBomber.repaint();
			}
		});
		ImageIcon iconDown = new ImageIcon("btnDown.jpg");
		img = iconDown.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		iconDown = new ImageIcon(newimg);
		JButton buttonDown = new JButton(iconDown);
		buttonDown.setBounds(770, 400, 30, 30);
		panelBomber.add(buttonDown);
		buttonDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warPlane.MoveTransport(Direction.Down);
				panelBomber.repaint();
			}
		});
		ImageIcon iconLeft = new ImageIcon("btnLeft.jpg");
		img = iconLeft.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		iconLeft = new ImageIcon(newimg);
		JButton buttonLeft = new JButton(iconLeft);
		buttonLeft.setBounds(740, 400, 30, 30);
		panelBomber.add(buttonLeft);
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warPlane.MoveTransport(Direction.Left);
				panelBomber.repaint();
			}
		});
		ImageIcon iconRight = new ImageIcon("btnRight.jpg");
		img = iconRight.getImage();
		newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		iconRight = new ImageIcon(newimg);
		JButton buttonRight = new JButton(iconRight);
		buttonRight.setBounds(800, 400, 30, 30);
		panelBomber.add(buttonRight);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				warPlane.MoveTransport(Direction.Right);
				panelBomber.repaint();
			}
		});
	}
}