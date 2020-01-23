import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HangarApplication {
	private JFrame frameHangar;
	private PanelHangar panelHangar;
	private JTextField textFieldPlace;
	private MyPanelWarPlane panelTakeWarPlane;
	private JList<String> JListLevels;
	public Color mainColor;
	public Color dopColor;
	private ArrayList<ITransport> memoryArrayList = new ArrayList<ITransport>();
	private MultiLevelHangar hangar;
	private ITransport warPlane;
	private final int countLevel = 5;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameHangar = new JFrame();
		frameHangar.setTitle("\u0410\u043D\u0433\u0430\u0440");
		frameHangar.setBounds(100, 100, 1100, 550);
		frameHangar.getContentPane().setLayout(null);
		panelHangar = new PanelHangar();
		panelHangar.setBounds(10, 11, 850, 470);
		hangar = new MultiLevelHangar(countLevel, panelHangar.getWidth(), panelHangar.getHeight());
		panelHangar.SetHangar(hangar.GetHangar(0));
		frameHangar.getContentPane().add(panelHangar);
		JLabel labelPlace = new JLabel("\u041C\u0435\u0441\u0442\u043E:");
		labelPlace.setBounds(912, 199, 59, 23);
		frameHangar.getContentPane().add(labelPlace);
		labelPlace.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPlace.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelShoose = new JLabel("\u0412\u044B\u0431\u0440\u0430\u0442\u044C");
		labelShoose.setBounds(930, 170, 81, 30);
		frameHangar.getContentPane().add(labelShoose);
		labelShoose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldPlace = new JTextField();
		textFieldPlace.setBounds(974, 200, 37, 20);
		frameHangar.getContentPane().add(textFieldPlace);
		textFieldPlace.setColumns(10);
		String[] masLevels = new String[countLevel];
		for (int i = 0; i < countLevel; i++)
			masLevels[i] = "Уровень " + (i + 1);
		JListLevels = new JList(masLevels);
		JListLevels.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				panelHangar.SetHangar(hangar.GetHangar(JListLevels.getSelectedIndex()));
				panelHangar.repaint();
			}
		});
		JListLevels.setBounds(865, 11, 200, 96);
		JListLevels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListLevels.setSelectedIndex(0);
		frameHangar.getContentPane().add(JListLevels);
		JButton buttonSetWarPlane = new JButton();
		buttonSetWarPlane
				.setText("\u041F\u043E\u0441\u0430\u0434\u0438\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonSetWarPlane.setLayout(new BorderLayout());
		buttonSetWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WarPlaneConfigApplication configFrame = new WarPlaneConfigApplication();
				configFrame.frame.setVisible(true);
				configFrame.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				configFrame.initializeConfig(panelHangar, hangar, JListLevels);
			}
		});
		buttonSetWarPlane.setBounds(865, 111, 200, 30);
		frameHangar.getContentPane().add(buttonSetWarPlane);
		JButton buttonTurnBomber = new JButton();
		buttonTurnBomber
				.setText("\u0423\u043B\u0443\u0447\u0448\u0438\u0442\u044C \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		buttonTurnBomber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					dopColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
					hangar.GetHangar(JListLevels.getSelectedIndex())
							.SetColorChangeWarPlane(Integer.parseInt(textFieldPlace.getText()), dopColor);
					hangar.GetHangar(JListLevels.getSelectedIndex())
							.operatorMul(Integer.parseInt(textFieldPlace.getText()));
					panelHangar.repaint();
				}
			}
		});
		buttonTurnBomber.setBounds(865, 226, 200, 30);
		frameHangar.getContentPane().add(buttonTurnBomber);
		JButton buttonTurnWarPlane = new JButton();
		buttonTurnWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					hangar.GetHangar(JListLevels.getSelectedIndex())
							.operatorDiv(Integer.parseInt(textFieldPlace.getText()));
					panelHangar.repaint();
				}
			}
		});
		buttonTurnWarPlane.setText(
				"\u0423\u043F\u0440\u043E\u0441\u0442\u0438\u0442\u044C \u0431\u043E\u043C\u0431\u0430\u0440\u0434\u0438\u0440\u043E\u0432\u0449\u0438\u043A");
		buttonTurnWarPlane.setBounds(865, 254, 200, 30);
		frameHangar.getContentPane().add(buttonTurnWarPlane);
		JPanel panelGroup = new JPanel();
		panelGroup.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panelGroup.setBounds(865, 285, 200, 155);
		panelGroup.setLayout(null);
		JButton buttonGetWarPlane = new JButton("\u0417\u0430\u0431\u0440\u0430\u0442\u044C");
		buttonGetWarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textFieldPlace.getText().equals("")) {
					try {
						warPlane = hangar.GetHangar(JListLevels.getSelectedIndex())
								.operatorSub(Integer.parseInt(textFieldPlace.getText()));
						if (warPlane != null) {
							warPlane.SetPosition(10, 10, panelTakeWarPlane.getWidth(), panelTakeWarPlane.getHeight());
							memoryArrayList.add(warPlane);
						}
						panelTakeWarPlane.SetWarPlane(warPlane);
						panelTakeWarPlane.repaint();
						panelHangar.repaint();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Не найден самолет на месте " + Integer.parseInt(textFieldPlace.getText()));
					}
				}
			}
		});
		buttonGetWarPlane.setBounds(55, 11, 91, 23);
		panelGroup.add(buttonGetWarPlane);
		panelTakeWarPlane = new MyPanelWarPlane();
		panelTakeWarPlane.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTakeWarPlane.setBounds(42, 45, 120, 100);
		panelGroup.add(panelTakeWarPlane);
		frameHangar.getContentPane().add(panelGroup);
		JButton buttonShowCollection = new JButton("\u041A\u043E\u043B\u043B\u0435\u043A\u0446\u0438\u044F");
		buttonShowCollection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CollectionDialog collectionWarPlane = new CollectionDialog();
				collectionWarPlane.ShowCollection(memoryArrayList);
				collectionWarPlane.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				collectionWarPlane.setVisible(true);
			}
		});
		buttonShowCollection.setBounds(912, 440, 112, 23);
		frameHangar.getContentPane().add(buttonShowCollection);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 100, 40);
		JMenu fileMenu = new JMenu("Файл");
		menuBar.add(fileMenu);
		JMenuItem loadMenu = new JMenuItem("Загрузить игру");
		fileMenu.add(loadMenu);
		JMenuItem saveMenu = new JMenuItem("Сохранить игру");
		fileMenu.add(saveMenu);
		JMenuItem loadLevelMenu = new JMenuItem("Загрузить уровень");
		fileMenu.add(loadLevelMenu);
		JMenuItem saveLevelMenu = new JMenuItem("Сохранить уровень");
		fileMenu.add(saveLevelMenu);
		frameHangar.setJMenuBar(menuBar);
		loadMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");
				if (ret == JFileChooser.APPROVE_OPTION)
					try {
						hangar.LoadData(fileopen.getSelectedFile());
						JOptionPane.showMessageDialog(null, "Загрузили игру");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Не загрузили игру");
					}
				panelHangar.SetHangar(hangar.GetHangar(JListLevels.getSelectedIndex()));
				panelHangar.repaint();
			}
		});
		saveMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Сохранить файл");
				if (ret == JFileChooser.APPROVE_OPTION)
					try {
						File file = fileopen.getSelectedFile();
						file = new File(file.toString() + ".txt");
						hangar.SaveFile(file);
						JOptionPane.showMessageDialog(null, "Сохранение прошло успешно");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Не сохранилось");
					}
			}
		});
		loadLevelMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Открыть файл");
				if (ret == JFileChooser.APPROVE_OPTION)
					try {
						hangar.LoadLevelData(fileopen.getSelectedFile());
						JOptionPane.showMessageDialog(null, "Загрузили уровень " + (hangar.GetLevel() + 1));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Не загрузили уровень");
					}
				panelHangar.SetHangar(hangar.GetHangar(JListLevels.getSelectedIndex()));
				panelHangar.repaint();
			}
		});
		saveLevelMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileopen = new JFileChooser();
				int ret = fileopen.showDialog(null, "Сохранить файл");
				if (ret == JFileChooser.APPROVE_OPTION) {
					File file = fileopen.getSelectedFile();
					file = new File(file.toString() + ".txt");
					try {
						hangar.SaveLevelFile(file, JListLevels.getSelectedIndex() + 1);
						JOptionPane.showMessageDialog(null,
								"Сохранение уровня " + (JListLevels.getSelectedIndex() + 1) + " прошло успешно");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
						JOptionPane.showMessageDialog(null,
								"Не удалось сохранить уровень " + JListLevels.getSelectedIndex());
					}
					panelHangar.SetHangar(hangar.GetHangar(JListLevels.getSelectedIndex()));
					panelHangar.repaint();
				}
			}
		});
	}
}