package gui;

import logic.InfoProvider;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends BaseGUI {

    public MainPanel(InfoProvider i) {
        super(i);
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        add(titlePanel, BorderLayout.PAGE_START);
        JLabel titleHeader = new JLabel("Base-N Calculator");
        titleHeader.setFont(new Font(titleHeader.getFont().getFontName(), Font.PLAIN, 35));
        titlePanel.add(titleHeader);

        ContentPanel contentPanel = new ContentPanel(i);
        add(contentPanel, BorderLayout.CENTER);
    }

    public void update() {

    }
}
