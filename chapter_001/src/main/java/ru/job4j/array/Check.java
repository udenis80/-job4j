package ru.job4j.array;
/**
 * Package for Check task.
 *
 * @author Denis Ukhanov (udenis80@mail.ru)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    public boolean mono(boolean[] data) {
        boolean result = false;
      for (int i = 0; i < data.length; i++) {
          if (data[i] == data[i + 1]) {
              result = true;
          } else {
              result = false;
          }
          break;
      }
        return result;
    }
}
