package org.example;

public class NumberToBeginning {
    public String toBeginner(String string) {

        String input = string;
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                output.append(c);
            } else if (!Character.isDigit(c)) {
                temp.append(c);
            }
        }
        output.append("");
        String string1 = String.valueOf(output.append(temp));

        return string1;
    }
}
