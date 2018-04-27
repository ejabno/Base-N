package logic;

import java.util.LinkedList;
import java.util.Scanner;

public class Calculator {
    private int maxDigits;
    private int base;

    Calculator(int maxDigits, int base) {
        if (base <= 0) {
            throw new IllegalArgumentException("Can't have a negative base number");
        }
        else if (base > 36) {
            throw new IllegalArgumentException("Given base is too high (max 36)");
        }

        if (maxDigits <= 0) {
            throw new IllegalArgumentException("Can't have zero or less max digits");
        }

        this.maxDigits = maxDigits;
        this.base = base;
    }

    String convert(int number) {
        LinkedList<Integer> digits = new LinkedList<>();
        int quotient = Math.abs(number);
        while (quotient >= base) {
            digits.addFirst(quotient % base);
            quotient /= base;
        }
        digits.addFirst(quotient);

        StringBuilder resultBuilder = new StringBuilder();
        for (Integer n: digits) {
            resultBuilder.append(radixConvert(n));
            if (resultBuilder.length() >= maxDigits) {
                throw new RuntimeException("Not enough digits specified (need " + digits.size() + ")");
            }
        }

        return resultBuilder.toString();
    }

    private char radixConvert(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("This method requires positives only");
        }
        else if (i > 36) {
            throw new IllegalArgumentException("Cannot convert numbers higher than 36");
        }
        else if (i <= 9) {
            return (char)(48+i);
        }
        else {
            return (char)(55+i);
        }
    }

    public int parseStringToInt(String input) {
        int i = 0;
        int pow = input.length() - 1;
        int result = 0;

        while (i < input.length()) {
            int currChar = input.charAt(i);
            if (currChar >= 48 && currChar <= 57) {
                currChar -= 48;
            }
            else if (currChar >= 65 && currChar <= 90) {
                currChar -= 55;
            }
            else if (currChar >= 97 && currChar <= 122) {
                currChar -= 87;
            }
            else {
                throw new IllegalArgumentException("Can't be converted");
            }

            if (currChar >= base) {
                throw new IllegalArgumentException("This character doesn't exist in this base");
            }

            result += currChar * (int)Math.pow(base, pow);
            --pow;
            ++i;
        }
        return result;
    }

}
