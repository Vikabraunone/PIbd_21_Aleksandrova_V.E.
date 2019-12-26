import java.awt.EventQueue;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;
import javax.swing.*;

public class WarPlaneConfigApplication {
	JFrame frame;
	private JPanel panelGroupConfig;
	public static MyPanelWarPlane panelWarPlane;
	private JPanel panelGroupMain;
	private JPanel panelGroupColor;
	private JPanel panelGroupCountBombs;
	private JLabel labelConfigWarPlane;
	private JLabel labelColor;
	private JLabel labelTypeBombs;
	private static JList JListMainColor;
	private static JList JListDopColor;
	private static JList JListWarPlane;
	private static JList JListBomberConfig;
	private static JList JListWarPlaneConfig;
	private static JList JListBlack;
	private static JList JListWhite;
	private static JList JListGreen;
	private static JList JListRed;
	private static JList JListBlue;
	private static JList JListYellow;
	private static JList JListLightGray;
	private static JList JListOrange;
	private static JList JListCircleBombs;
	private static JList JListSquareBombs;
	private static JList JListRectangleBombs;
	private static JList JListBombs;
	public static ITransport warPlane;
	public static IBombs bombs = new CircleBombs();
	public static Color MainColor = Color.WHITE;
	public static Color DopColor = Color.BLACK;
	private PanelHangar panelHangar;
	private MultiLevelHangar hangar;
	private JList jListLevels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WarPlaneConfigApplication window = new WarPlaneConfigApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WarPlaneConfigApplication() {
		initialize();
	}

	public void initializeConfig(PanelHangar panelHangar, MultiLevelHangar hangar, JList jListLevels) {
		this.panelHangar = panelHangar;
		this.hangar = hangar;
		this.jListLevels = jListLevels;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle(
				"\u0412\u044B\u0431\u043E\u0440 \u0432\u043E\u0435\u043D\u043D\u043E\u0433\u043E \u0441\u0430\u043C\u043E\u043B\u0435\u0442\u0430");
		frame.setBounds(100, 100, 659, 284);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panelGroupConfig = new JPanel();
		panelGroupConfig.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panelGroupConfig.setBounds(10, 11, 170, 105);
		panelGroupConfig.setLayout(null);
		frame.getContentPane().add(panelGroupConfig);

		labelConfigWarPlane = new JLabel("\u041A\u043E\u043D\u0444\u0438\u0433\u0443\u0440\u0430\u0446\u0438\u044F");
		labelConfigWarPlane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelConfigWarPlane.setBounds(10, 11, 117, 14);
		panelGroupConfig.add(labelConfigWarPlane);

		JListWarPlaneConfig = new JList(new String[] { "Военный самолёт" });
		JListWarPlaneConfig.setBackground(SystemColor.menu);
		JListWarPlaneConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListWarPlaneConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListWarPlaneConfig.setBounds(10, 35, 120, 20);
		JListWarPlaneConfig.setDragEnabled(true);
		panelGroupConfig.add(JListWarPlaneConfig);

		JListBomberConfig = new JList(new String[] { "Бомбардировщик" });
		JListBomberConfig.setBackground(SystemColor.menu);
		JListBomberConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListBomberConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListBomberConfig.setBounds(10, 70, 120, 20);
		JListBomberConfig.setDragEnabled(true);
		panelGroupConfig.add(JListBomberConfig);

		panelGroupMain = new JPanel();
		panelGroupMain.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panelGroupMain.setBounds(207, 11, 152, 223);
		panelGroupMain.setLayout(null);
		frame.getContentPane().add(panelGroupMain);

		panelWarPlane = new MyPanelWarPlane();
		panelWarPlane.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panelWarPlane.setBounds(10, 11, 132, 100);
		panelWarPlane.setLayout(null);
		panelGroupMain.add(panelWarPlane);

		JListWarPlane = new JList();
		JListWarPlane.setBounds(10, 11, 112, 78);
		JListWarPlane.setOpaque(false);
		JListWarPlane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListWarPlane.setTransferHandler(new ListHandlerWarPlane(panelWarPlane));
		panelWarPlane.add(JListWarPlane);

		JListMainColor = new JList(new String[] { "Основной цвет" });
		JListMainColor.setBackground(SystemColor.menu);
		JListMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListMainColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListMainColor.setBounds(20, 122, 97, 20);
		JListMainColor.setTransferHandler(new ListHandlerMainColor(panelWarPlane));
		panelGroupMain.add(JListMainColor);

		JListDopColor = new JList(new String[] { "Доп. цвет" });
		JListDopColor.setBackground(SystemColor.menu);
		JListDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListDopColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListDopColor.setBounds(20, 153, 97, 20);
		JListDopColor.setTransferHandler(new ListHandlerDopColor(panelWarPlane));
		panelGroupMain.add(JListDopColor);

		JListBombs = new JList(new String[] { "Бомбы" });
		JListBombs.setBackground(SystemColor.menu);
		JListBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListBombs.setBounds(20, 184, 97, 20);
		JListBombs.setTransferHandler(new ListHandlerTypeBombs(panelWarPlane));
		panelGroupMain.add(JListBombs);

		panelGroupColor = new JPanel();
		panelGroupColor.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelGroupColor.setBounds(369, 11, 97, 223);
		frame.getContentPane().add(panelGroupColor);
		panelGroupColor.setLayout(null);

		labelColor = new JLabel("\u0426\u0432\u0435\u0442\u0430:");
		labelColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelColor.setBounds(10, 11, 46, 14);
		panelGroupColor.add(labelColor);

		JListBlack = new JList(new String[] { "Black" });
		JListBlack.setForeground(Color.BLACK);
		JListBlack.setBackground(Color.BLACK);
		JListBlack.setBounds(10, 45, 30, 30);
		JListBlack.setDragEnabled(true);
		panelGroupColor.add(JListBlack);

		JListWhite = new JList(new String[] { "White" });
		JListWhite.setBorder(new LineBorder(Color.DARK_GRAY));
		JListWhite.setForeground(Color.WHITE);
		JListWhite.setBackground(Color.WHITE);
		JListWhite.setBounds(50, 45, 30, 30);
		JListWhite.setDragEnabled(true);
		panelGroupColor.add(JListWhite);

		JListGreen = new JList(new String[] { "Green" });
		JListGreen.setBorder(new LineBorder(Color.GREEN));
		JListGreen.setForeground(Color.GREEN);
		JListGreen.setBackground(Color.GREEN);
		JListGreen.setBounds(10, 86, 30, 30);
		JListGreen.setDragEnabled(true);
		panelGroupColor.add(JListGreen);

		JListRed = new JList(new String[] { "Red" });
		JListRed.setBorder(new LineBorder(Color.DARK_GRAY));
		JListRed.setForeground(Color.RED);
		JListRed.setBackground(Color.RED);
		JListRed.setBounds(50, 86, 30, 30);
		JListRed.setDragEnabled(true);
		panelGroupColor.add(JListRed);

		JListBlue = new JList(new String[] { "Blue" });
		JListBlue.setBorder(new LineBorder(Color.DARK_GRAY));
		JListBlue.setBackground(Color.BLUE);
		JListBlue.setForeground(Color.BLUE);
		JListBlue.setBounds(10, 127, 30, 30);
		JListBlue.setDragEnabled(true);
		panelGroupColor.add(JListBlue);

		JListYellow = new JList(new String[] { "Yellow" });
		JListYellow.setBorder(new LineBorder(Color.DARK_GRAY));
		JListYellow.setBackground(Color.YELLOW);
		JListYellow.setForeground(Color.YELLOW);
		JListYellow.setBounds(50, 127, 30, 30);
		JListYellow.setDragEnabled(true);
		panelGroupColor.add(JListYellow);

		JListLightGray = new JList(new String[] { "Gray" });
		JListLightGray.setBorder(new LineBorder(Color.DARK_GRAY));
		JListLightGray.setBackground(Color.LIGHT_GRAY);
		JListLightGray.setForeground(Color.LIGHT_GRAY);
		JListLightGray.setBounds(10, 168, 30, 30);
		JListLightGray.setDragEnabled(true);
		panelGroupColor.add(JListLightGray);

		JListOrange = new JList(new String[] { "Orange" });
		JListOrange.setBorder(new LineBorder(Color.DARK_GRAY));
		JListOrange.setBackground(Color.ORANGE);
		JListOrange.setForeground(Color.ORANGE);
		JListOrange.setBounds(50, 169, 30, 30);
		JListOrange.setDragEnabled(true);
		panelGroupColor.add(JListOrange);

		panelGroupCountBombs = new JPanel();
		panelGroupCountBombs.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelGroupCountBombs.setBounds(476, 11, 132, 223);
		frame.getContentPane().add(panelGroupCountBombs);
		panelGroupCountBombs.setLayout(null);

		labelTypeBombs = new JLabel("\u0422\u0438\u043F \u0431\u043E\u043C\u0431:");
		labelTypeBombs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTypeBombs.setBounds(10, 11, 84, 16);
		panelGroupCountBombs.add(labelTypeBombs);

		JListCircleBombs = new JList(new String[] { "Круглые" });
		JListCircleBombs.setBackground(SystemColor.menu);
		JListCircleBombs.setBounds(10, 38, 112, 20);
		JListCircleBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListCircleBombs.setDragEnabled(true);
		panelGroupCountBombs.add(JListCircleBombs);

		JListSquareBombs = new JList(new String[] { "Квадратные" });
		JListSquareBombs.setBackground(SystemColor.menu);
		JListSquareBombs.setBounds(10, 64, 112, 20);
		JListSquareBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListSquareBombs.setDragEnabled(true);
		panelGroupCountBombs.add(JListSquareBombs);

		JListRectangleBombs = new JList(new String[] { "Прямоугольные" });
		JListRectangleBombs.setBackground(SystemColor.menu);
		JListRectangleBombs.setBounds(10, 88, 112, 20);
		JListRectangleBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		JListRectangleBombs.setDragEnabled(true);
		panelGroupCountBombs.add(JListRectangleBombs);

		JButton buttonAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (warPlane != null) {
					hangar.GetHangar(jListLevels.getSelectedIndex()).operatorAdd(warPlane);
					MyPanelWarPlane.warPlane = (WarPlane) warPlane;
					panelHangar.repaint();
				}
				frame.dispose();
			}
		});
		buttonAdd.setBounds(10, 127, 104, 23);
		frame.getContentPane().add(buttonAdd);

		JButton buttonCancel = new JButton("\u041E\u0442\u043C\u0435\u043D\u0430");
		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		buttonCancel.setBounds(76, 160, 104, 23);
		frame.getContentPane().add(buttonCancel);
	}

	public static void ClearIndexJLists() {
		JListMainColor.clearSelection();
		JListDopColor.clearSelection();
		JListWarPlane.clearSelection();
		JListBomberConfig.clearSelection();
		JListWarPlaneConfig.clearSelection();
		JListBlack.clearSelection();
		JListWhite.clearSelection();
		JListGreen.clearSelection();
		JListRed.clearSelection();
		JListBlue.clearSelection();
		JListYellow.clearSelection();
		JListLightGray.clearSelection();
		JListOrange.clearSelection();
		JListCircleBombs.clearSelection();
		JListSquareBombs.clearSelection();
		JListRectangleBombs.clearSelection();
		JListBombs.clearSelection();
	}
}
