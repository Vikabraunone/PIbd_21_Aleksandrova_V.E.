import java.awt.EventQueue;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.*;
import javax.swing.*;

public class WarPlaneConfigApplication {
	public JFrame frame;
	private static MyPanelWarPlane panelWarPlane;
	private static ITransport warPlane;
	private JPanel panelGroupConfig;
	private JPanel panelGroupMain;
	private JPanel panelGroupColor;
	private JPanel panelGroupCountBombs;
	private JLabel labelConfigWarPlane;
	private JLabel labelColor;
	private JLabel labelTypeBombs;
	private static JList jListMainColor;
	private static JList jListDopColor;
	private static JList jListWarPlane;
	private static JList jListBomberConfig;
	private static JList jListWarPlaneConfig;
	private static JList jListBlack;
	private static JList jListWhite;
	private static JList jListGreen;
	private static JList jListRed;
	private static JList jListBlue;
	private static JList jListYellow;
	private static JList jListLightGray;
	private static JList jListOrange;
	private static JList jListCircleBombs;
	private static JList jListSquareBombs;
	private static JList jListRectangleBombs;
	private static JList jListBombs;
	private JList jListLevels;
	private PanelHangar panelHangar;
	private MultiLevelHangar hangar;

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

		jListWarPlaneConfig = new JList(new String[] { "Военный самолёт" });
		jListWarPlaneConfig.setBackground(SystemColor.menu);
		jListWarPlaneConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListWarPlaneConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListWarPlaneConfig.setBounds(10, 35, 120, 20);
		jListWarPlaneConfig.setDragEnabled(true);
		panelGroupConfig.add(jListWarPlaneConfig);

		jListBomberConfig = new JList(new String[] { "Бомбардировщик" });
		jListBomberConfig.setBackground(SystemColor.menu);
		jListBomberConfig.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListBomberConfig.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListBomberConfig.setBounds(10, 70, 120, 20);
		jListBomberConfig.setDragEnabled(true);
		panelGroupConfig.add(jListBomberConfig);

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

		jListWarPlane = new JList();
		jListWarPlane.setBounds(10, 11, 112, 78);
		jListWarPlane.setOpaque(false);
		jListWarPlane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListWarPlane.setTransferHandler(new ListHandlerWarPlane());
		panelWarPlane.add(jListWarPlane);

		jListMainColor = new JList(new String[] { "Основной цвет" });
		jListMainColor.setBackground(SystemColor.menu);
		jListMainColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListMainColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListMainColor.setBounds(20, 122, 97, 20);
		jListMainColor.setTransferHandler(new ListHandlerMainColor());
		panelGroupMain.add(jListMainColor);

		jListDopColor = new JList(new String[] { "Доп. цвет" });
		jListDopColor.setBackground(SystemColor.menu);
		jListDopColor.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListDopColor.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jListDopColor.setBounds(20, 153, 97, 20);
		jListDopColor.setTransferHandler(new ListHandlerDopColor());
		panelGroupMain.add(jListDopColor);

		jListBombs = new JList(new String[] { "Бомбы" });
		jListBombs.setBackground(SystemColor.menu);
		jListBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListBombs.setBounds(20, 184, 97, 20);
		jListBombs.setTransferHandler(new ListHandlerTypeBombs());
		panelGroupMain.add(jListBombs);

		panelGroupColor = new JPanel();
		panelGroupColor.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelGroupColor.setBounds(369, 11, 97, 223);
		frame.getContentPane().add(panelGroupColor);
		panelGroupColor.setLayout(null);

		labelColor = new JLabel("\u0426\u0432\u0435\u0442\u0430:");
		labelColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelColor.setBounds(10, 11, 46, 14);
		panelGroupColor.add(labelColor);

		jListBlack = new JList(new String[] { "Black" });
		jListBlack.setForeground(Color.BLACK);
		jListBlack.setBackground(Color.BLACK);
		jListBlack.setBounds(10, 45, 30, 30);
		jListBlack.setDragEnabled(true);
		panelGroupColor.add(jListBlack);

		jListWhite = new JList(new String[] { "White" });
		jListWhite.setBorder(new LineBorder(Color.DARK_GRAY));
		jListWhite.setForeground(Color.WHITE);
		jListWhite.setBackground(Color.WHITE);
		jListWhite.setBounds(50, 45, 30, 30);
		jListWhite.setDragEnabled(true);
		panelGroupColor.add(jListWhite);

		jListGreen = new JList(new String[] { "Green" });
		jListGreen.setBorder(new LineBorder(Color.GREEN));
		jListGreen.setForeground(Color.GREEN);
		jListGreen.setBackground(Color.GREEN);
		jListGreen.setBounds(10, 86, 30, 30);
		jListGreen.setDragEnabled(true);
		panelGroupColor.add(jListGreen);

		jListRed = new JList(new String[] { "Red" });
		jListRed.setBorder(new LineBorder(Color.DARK_GRAY));
		jListRed.setForeground(Color.RED);
		jListRed.setBackground(Color.RED);
		jListRed.setBounds(50, 86, 30, 30);
		jListRed.setDragEnabled(true);
		panelGroupColor.add(jListRed);

		jListBlue = new JList(new String[] { "Blue" });
		jListBlue.setBorder(new LineBorder(Color.DARK_GRAY));
		jListBlue.setBackground(Color.BLUE);
		jListBlue.setForeground(Color.BLUE);
		jListBlue.setBounds(10, 127, 30, 30);
		jListBlue.setDragEnabled(true);
		panelGroupColor.add(jListBlue);

		jListYellow = new JList(new String[] { "Yellow" });
		jListYellow.setBorder(new LineBorder(Color.DARK_GRAY));
		jListYellow.setBackground(Color.YELLOW);
		jListYellow.setForeground(Color.YELLOW);
		jListYellow.setBounds(50, 127, 30, 30);
		jListYellow.setDragEnabled(true);
		panelGroupColor.add(jListYellow);

		jListLightGray = new JList(new String[] { "Gray" });
		jListLightGray.setBorder(new LineBorder(Color.DARK_GRAY));
		jListLightGray.setBackground(Color.LIGHT_GRAY);
		jListLightGray.setForeground(Color.LIGHT_GRAY);
		jListLightGray.setBounds(10, 168, 30, 30);
		jListLightGray.setDragEnabled(true);
		panelGroupColor.add(jListLightGray);

		jListOrange = new JList(new String[] { "Orange" });
		jListOrange.setBorder(new LineBorder(Color.DARK_GRAY));
		jListOrange.setBackground(Color.ORANGE);
		jListOrange.setForeground(Color.ORANGE);
		jListOrange.setBounds(50, 169, 30, 30);
		jListOrange.setDragEnabled(true);
		panelGroupColor.add(jListOrange);

		panelGroupCountBombs = new JPanel();
		panelGroupCountBombs.setBorder(new LineBorder(new Color(192, 192, 192)));
		panelGroupCountBombs.setBounds(476, 11, 132, 223);
		frame.getContentPane().add(panelGroupCountBombs);
		panelGroupCountBombs.setLayout(null);

		labelTypeBombs = new JLabel("\u0422\u0438\u043F \u0431\u043E\u043C\u0431:");
		labelTypeBombs.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTypeBombs.setBounds(10, 11, 84, 16);
		panelGroupCountBombs.add(labelTypeBombs);

		jListCircleBombs = new JList(new String[] { "Круглые" });
		jListCircleBombs.setBackground(SystemColor.menu);
		jListCircleBombs.setBounds(10, 38, 112, 20);
		jListCircleBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListCircleBombs.setDragEnabled(true);
		panelGroupCountBombs.add(jListCircleBombs);

		jListSquareBombs = new JList(new String[] { "Квадратные" });
		jListSquareBombs.setBackground(SystemColor.menu);
		jListSquareBombs.setBounds(10, 64, 112, 20);
		jListSquareBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListSquareBombs.setDragEnabled(true);
		panelGroupCountBombs.add(jListSquareBombs);

		jListRectangleBombs = new JList(new String[] { "Прямоугольные" });
		jListRectangleBombs.setBackground(SystemColor.menu);
		jListRectangleBombs.setBounds(10, 88, 112, 20);
		jListRectangleBombs.setBorder(new LineBorder(new Color(0, 0, 0)));
		jListRectangleBombs.setDragEnabled(true);
		panelGroupCountBombs.add(jListRectangleBombs);

		JButton buttonAdd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (warPlane != null) {
						hangar.GetHangar(jListLevels.getSelectedIndex()).operatorAdd(warPlane);
						panelWarPlane.SetWarPlane(warPlane);
						panelHangar.repaint();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "На этом уровне нет свободных мест");
				} finally {
					frame.dispose();
				};
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
		jListMainColor.clearSelection();
		jListDopColor.clearSelection();
		jListWarPlane.clearSelection();
		jListBomberConfig.clearSelection();
		jListWarPlaneConfig.clearSelection();
		jListBlack.clearSelection();
		jListWhite.clearSelection();
		jListGreen.clearSelection();
		jListRed.clearSelection();
		jListBlue.clearSelection();
		jListYellow.clearSelection();
		jListLightGray.clearSelection();
		jListOrange.clearSelection();
		jListCircleBombs.clearSelection();
		jListSquareBombs.clearSelection();
		jListRectangleBombs.clearSelection();
		jListBombs.clearSelection();
	}

	public static MyPanelWarPlane GetPanelWarPlane() {
		// обновить данные
		panelWarPlane.SetWarPlane(warPlane);
		return panelWarPlane;
	}

	public static ITransport GetWarPlane() {
		return warPlane;
	}

	public static void SetWarPlane(ITransport transport) {
		warPlane = transport;
	}

	public static IBombs GetBombs() {
		return ((Bomber) warPlane).GetBombs();
	}

	public static void SetBombs(IBombs bombs) {
		((Bomber) warPlane).SetBombs(bombs);
	}

	public static Color GetMainColor() {
		return ((WarPlane) warPlane).GetMainColor();
	}

	public static void SetMainColor(Color color) {
		((WarPlane) warPlane).SetMainColor(color);
	}

	public static Color GetDopColor() {
		return ((Bomber) warPlane).GetDopColor();
	}

	public static void SetDopColor(Color color) {
		((Bomber) warPlane).SetDopColor(color);
	}
}
