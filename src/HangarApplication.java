import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.border.LineBorder;

public class HangarApplication {
	private JFrame frameHangar;
	private JTextField textFieldPlace;
	private PanelHangar panelHangar;
	private JPanel panelTakeWarPlane;
	public static Color mainColor;
	public static Color dopColor;
	Random rnd = new Random();
	Hangar<ITransport, IBombs> hangar;
	ITransport warPlane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangarApplication window = new HangarApplication();
					window.frameHangar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HangarApplication() {
		initialize();
		hangar = new Hangar<ITransport, IBombs>(20, panelHangar.getWidth(), panelHangar.getHeight());
		panelHangar.hangar = hangar;
		JLabel labelPlace = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		labelPlace.setBounds(906, 67, 59, 23);
		frameHangar.getContentPane().add(labelPlace);
		labelPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPlace.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelShoose = new JLabel("\u0412\u044B\u0431\u0440\u0430\u0442\u044C");
		labelShoose.setBounds(924, 42, 81, 14);
		frameHangar.getContentPane().add(labelShoose);
		labelShoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPlace = new JTextField();
		textFieldPlace.setBounds(968, 68, 37, 20);
		frameHangar.getContentPane().add(textFieldPlace);
		textFieldPlace.setColumns(10);
		panelHangar.repaint();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHangar = new JFrame();
		frameHangar.setTitle("\u0410\u043D\u0433\u0430\u0440");
		frameHangar.setBounds(100, 100, 1091, 530);
		frameHangar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameHangar.getContentPane().setLayout(null);

		JButton buttonSetWarPlane = new JButton();
		buttonSetWarPlane
				.setText("\u041F\u043E\u0441\u0430\u0434\u0438\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonSetWarPlane.setLayout(new BorderLayout());
		buttonSetWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
				warPlane = new WarPlane(100, 1000, mainColor);
				warPlane.SetPosition(0, 0, panelTakeWarPlane.getWidth(), panelTakeWarPlane.getHeight());
				hangar.operatorAdd(warPlane);
				panelHangar.repaint();
			}
		});
		buttonSetWarPlane.setBounds(865, 113, 200, 30);
		frameHangar.getContentPane().add(buttonSetWarPlane);
		JButton buttonSetBomber = new JButton();
		buttonSetBomber.setText(
				"\u041F\u043E\u0441\u0430\u0434\u0438\u0442\u044C \u0431\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A");
		buttonSetBomber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
				dopColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
				int posX = rnd.nextInt(90) + 10;
				int posY = rnd.nextInt(90) + 10;
				int typeBombs = rnd.nextInt(3);
				IBombs bombs;
				if (typeBombs == 0)
					bombs = new CircleBombs();
				else if (typeBombs == 1)
					bombs = new SquareBombs();
				else
					bombs = new RectangleBombs();
				bombs.SetPosition(posX, posY);
				warPlane = new Bomber(rnd.nextInt(200) + 100, rnd.nextInt(200) + 100, mainColor, dopColor, true, true,
						true, bombs);
				warPlane.SetPosition(0, 0, panelTakeWarPlane.getWidth(), panelTakeWarPlane.getHeight());
				hangar.operatorAdd(warPlane);
				panelHangar.repaint();
			}
		});
		buttonSetBomber.setBounds(865, 154, 200, 30);
		frameHangar.getContentPane().add(buttonSetBomber);
		JButton buttonTurnBomber = new JButton();
		buttonTurnBomber
				.setText("\u0423\u043B\u0443\u0447\u0448\u0438\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonTurnBomber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					dopColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
					hangar.SetColorChangeWarPlane(Integer.parseInt(textFieldPlace.getText()), dopColor);
					hangar.operatorMul(Integer.parseInt(textFieldPlace.getText()));
					panelHangar.repaint();
				}
			}
		});
		buttonTurnBomber.setBounds(865, 195, 200, 30);
		frameHangar.getContentPane().add(buttonTurnBomber);
		JButton buttonTurnWarPlane = new JButton();
		buttonTurnWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					hangar.operatorDiv(Integer.parseInt(textFieldPlace.getText()));
					panelHangar.repaint();
				}
			}
		});
		buttonTurnWarPlane.setText(
				"\u0423\u043F\u0440\u043E\u0441\u0442\u0438\u0442\u044C \u0431\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A");
		buttonTurnWarPlane.setBounds(865, 236, 200, 30);
		frameHangar.getContentPane().add(buttonTurnWarPlane);
		JPanel panelGroup = new JPanel();
		panelGroup.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelGroup.setBounds(896, 304, 158, 161);
		frameHangar.getContentPane().add(panelGroup);
		panelGroup.setLayout(null);
		JButton buttonGetWarPlane = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonGetWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					warPlane = hangar.operatorSub(Integer.parseInt(textFieldPlace.getText()));
					if (warPlane != null)
						warPlane.SetPosition(10, 10, panelTakeWarPlane.getWidth(), panelTakeWarPlane.getHeight());
					MyPanelWarPlane.warPlane = (WarPlane) warPlane;
					panelTakeWarPlane.repaint();
					panelHangar.repaint();
				}
			}
		});
		buttonGetWarPlane.setBounds(32, 11, 91, 23);
		panelGroup.add(buttonGetWarPlane);
		panelTakeWarPlane = new MyPanelWarPlane();
		panelTakeWarPlane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTakeWarPlane.setBounds(20, 50, 120, 100);
		panelGroup.add(panelTakeWarPlane);
		panelHangar = new PanelHangar();
		panelHangar.setBounds(10, 11, 850, 470);
		frameHangar.getContentPane().add(panelHangar);
	}
}
