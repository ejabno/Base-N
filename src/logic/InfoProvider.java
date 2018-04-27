package logic;

public interface InfoProvider {
    String[] getAllCalculations();

    void generateResult(String input, int base);

    void addObserver(Observer o);
}
