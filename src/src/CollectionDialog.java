import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CollectionDialog extends JDialog {
	private MyPanelWarPlane panelWarPlane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CollectionDialog dialog = new CollectionDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CollectionDialog() {
		setBounds(100, 100, 450, 322);
		getContentPane().setLayout(null);
		panelWarPlane = new MyPanelWarPlane();
		panelWarPlane.setBounds(21, 41, 150, 110);
		getContentPane().add(panelWarPlane);
		JLabel labelWarPlane = new JLabel(
				"\u0412\u043E\u0435\u043D\u043D\u044B\u0439 \u0441\u0430\u043C\u043E\u043B\u0435\u0442");
		labelWarPlane.setHorizontalAlignment(SwingConstants.CENTER);
		labelWarPlane.setBounds(21, 23, 150, 14);
		getContentPane().add(labelWarPlane);
	}

	public void ShowCollection(ArrayList<ITransport> memoryArrayList) {
		String[] arrayWarPlane = new String[memoryArrayList.size()];
		for (int i = 0; i < arrayWarPlane.length; i++)
			arrayWarPlane[i] = "Индекс " + i;
		JList JListWarPlane = new JList(arrayWarPlane);
		JListWarPlane.setBounds(181, 11, 105, 143);
		JListWarPlane.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				panelWarPlane.SetWarPlane(memoryArrayList.get(JListWarPlane.getSelectedIndex()));
				panelWarPlane.repaint();
			}
		});
		JListWarPlane.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListWarPlane.setSelectedIndex(0);
		getContentPane().add(JListWarPlane);
	}
}