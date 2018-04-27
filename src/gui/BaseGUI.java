package gui;

import logic.InfoProvider;
import logic.Observer;

import javax.swing.*;

public abstract class BaseGUI extends JPanel implements Observer {

    protected InfoProvider infoProvider;

    BaseGUI(InfoProvider i) {
        infoProvider = i;
        infoProvider.addObserver(this);
    }

    public abstract void update();
}
