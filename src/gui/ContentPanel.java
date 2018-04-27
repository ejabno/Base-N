package gui;

import logic.InfoProvider;

import javax.swing.*;
import java.awt.*;

public class ContentPanel extends BaseGUI {
    ContentPanel(InfoProvider i) {
        super(i);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        NumberPanel binaryPanel = new NumberPanel(i, 2, "Binary:");
        add(binaryPanel);
        NumberPanel octalPanel = new NumberPanel(i, 8, "Octal:");
        add(octalPanel);
        NumberPanel decimalPanel = new NumberPanel(i, 10, "Decimal:");
        add(decimalPanel);
        NumberPanel hexPanel = new NumberPanel(i, 16, "Hex:");
        add(hexPanel);
        NumberPanel base36Panel = new NumberPanel(i, 36, "Base 36:");
        add(base36Panel);
    }

    public void update(){}
}
