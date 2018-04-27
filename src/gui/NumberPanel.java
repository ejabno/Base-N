package gui;

import logic.InfoProvider;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class NumberPanel extends BaseGUI {
    private int base;

    private JTextField panelTextField;

    NumberPanel(InfoProvider i, int base, String label) {
        super(i);
        this.base = base;

        setLayout(new FlowLayout());
        JLabel panelLabel = new JLabel(label);
        panelLabel.setPreferredSize(new Dimension(100, 50));
        add(panelLabel);
        panelTextField = new JTextField("", 20);
        add(panelTextField);
        panelTextField.addActionListener(actionEvent -> {
            try {
                infoProvider.generateResult(actionEvent.getActionCommand(), base);
            }
            catch (Exception e) {
                panelTextField.setText("Please enter a valid number");
            }
        });
    }

    public void update() {
        String[] results = infoProvider.getAllCalculations();
        switch(base) {
            case 2:
                panelTextField.setText(results[0]);
                break;
            case 8:
                panelTextField.setText(results[1]);
                break;
            case 10:
                panelTextField.setText(results[2]);
                break;
            case 16:
                panelTextField.setText(results[3]);
                break;
            case 36:
                panelTextField.setText(results[4]);
                break;
        }
    }
}
