import javax.swing.JPanel;
import java.awt.GridBagLayout;


public class Menu_Screen extends JPanel {

	/**
	 * Create the panel.
	 */
	public Menu_Screen() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {100};
		gridBagLayout.rowHeights = new int[] {100};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);

	}

}
