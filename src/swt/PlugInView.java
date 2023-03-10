package swt;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlugInView extends JFrame{
    private JPanel panelPlugins;
    private JTextField parameterA;
    private JTextField parameterB;

    private JLabel parameterALable;
    private JLabel parameterBLable;
    private JButton computeButton;
    private JTable pluginTable;

    private JFrame frame;

    public PlugInView(List<IPlugin> plugins) {

        frame = new JFrame("PlugIn Based Calculator");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,500));
        //frame.setResizable(false);

        //add panel
        frame.add(panelPlugins);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //add(new JScrollPane(pluginTable));

        createTable(plugins, 0, 0);

        computeButton.addActionListener(e->{

            int a = Integer.parseInt(parameterA.getText());
            int b = Integer.parseInt(parameterB.getText());

            // Compute
            createTable(plugins, a, b);

            clearTextFields();

        });
    }

    private void clearTextFields() {
        parameterA.setText("");
        parameterB.setText("");
    }

    private void createTable(List<IPlugin> customPlugIns, int a, int b) {

        pluginTable.setModel(new PlugInTable(customPlugIns, a, b));

    }

}
