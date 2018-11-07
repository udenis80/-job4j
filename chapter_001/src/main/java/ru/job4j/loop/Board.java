package ru.job4j.loop;

/**
 * Построить шахматную доску в псевдографике.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @return summ
 */

public class Board {
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int sum = i + j;// Выше в задании мы определили закономерность, когда нужно проставлять X
                if (sum % 2 == 0) {   // условие проверки, что писать пробел или X
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}



