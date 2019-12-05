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
	private Bomber bomber;
	JPanel panelBomber;

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
		Random rnd = new Random();
		frameBomber = new JFrame();
		frameBomber.setTitle("\u0411\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A");
		frameBomber.setBounds(100, 100, 918, 545);
		frameBomber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBomber.getContentPane().setLayout(null);
		panelBomber = new MyPanelBomber();
		panelBomber.setBounds(0, 0, 900, 500);
		frameBomber.getContentPane().add(panelBomber);
		panelBomber.setLayout(null);
		JButton buttonCreate = new JButton("\u0421\u043E\u0437\u0434\u0430\u0442\u044C");
		buttonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bomber = new Bomber(100 + rnd.nextInt(200), 100 + rnd.nextInt(200), new Color(0, 128, 0), Color.BLACK,
						true, true, true);
				bomber.SetPosition(rnd.nextInt(300), rnd.nextInt(300), panelBomber.getWidth(), panelBomber.getHeight());
				((MyPanelBomber) panelBomber).SetBomber(bomber);
				panelBomber.repaint();
			}
		});
		buttonCreate.setForeground(Color.BLACK);
		buttonCreate.setBounds(29, 39, 89, 23);
		panelBomber.add(buttonCreate);
		ImageIcon iconUp = new ImageIcon("btnUp.jpg");
		Image img = iconUp.getImage();
		Image newimg = img.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
		iconUp = new ImageIcon(newimg);
		JButton buttonUp = new JButton(iconUp);
		buttonUp.setBounds(770, 370, 30, 30);
		panelBomber.add(buttonUp);
		buttonUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bomber.MoveTransport(Direction.Up);
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
				bomber.MoveTransport(Direction.Down);
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
				bomber.MoveTransport(Direction.Left);
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
				bomber.MoveTransport(Direction.Right);
				panelBomber.repaint();
			}
		});
	}
}
