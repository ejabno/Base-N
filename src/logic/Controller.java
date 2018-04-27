package logic;

import gui.MainPanel;

import javax.swing.*;
import java.util.LinkedList;

public class Controller implements InfoProvider {
    private Calculator[] baseNCalculators;
    private String[] allCalculations;

    static final int BINARY = 0;
    static final int OCTAL = 1;
    static final int DECIMAL = 2;
    static final int HEX = 3;
    static final int BASE36 = 4;

    private LinkedList<Observer> observers;

    private JFrame appFrame;

    public Controller(int maxDigits) {
        baseNCalculators = new Calculator[5];
        baseNCalculators[0] = new Calculator(maxDigits, 2); //Binary
        baseNCalculators[1] = new Calculator(maxDigits, 8); //Octal
        baseNCalculators[2] = new Calculator(maxDigits, 10); //Decimal
        baseNCalculators[3] = new Calculator(maxDigits, 16); //Hex
        baseNCalculators[4] = new Calculator(maxDigits, 36); //Base 36

        allCalculations = new String[5];
        observers = new LinkedList<>();

        appFrame = new JFrame("Base-N Calculator");
        appFrame.setSize(400,400);
        appFrame.setLocationRelativeTo(null);
        appFrame.setResizable(false);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.add(new MainPanel(this));
    }

    public void start() {
        appFrame.setVisible(true);
    }

    public void generateResult(String input, int base) {
        int decimalResult = 0;
        try {
            switch (base) {
                case 2:
                    decimalResult = baseNCalculators[BINARY].parseStringToInt(input);
                    break;
                case 8:
                    decimalResult = baseNCalculators[OCTAL].parseStringToInt(input);
                    break;
                case 10:
                    decimalResult = baseNCalculators[DECIMAL].parseStringToInt(input);
                    break;
                case 16:
                    decimalResult = baseNCalculators[HEX].parseStringToInt(input);
                    break;
                case 36:
                    decimalResult = baseNCalculators[BASE36].parseStringToInt(input);
                    break;
            }
        }
        catch (Exception e) {
            throw new RuntimeException("Unable to convert");
        }

        for (int i = 0; i < 5; ++i) {
            allCalculations[i] = baseNCalculators[i].convert(decimalResult);
        }

        updateObservers();
    }

    public String[] getAllCalculations() {
        return allCalculations;
    }

    public void addObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    private void updateObservers() {
        for (Observer o: observers) {
            o.update();
        }
    }
}
