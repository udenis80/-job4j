package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Denis Ukhanov (udenis80@mail.ru)
* @version $Id$
* @since 0.1
*/
public class CalculateTest {
/**
* Test echo.
*/
@Test
public void whenTakeNameThenTreeEchoPlusName() {
    String input = "Denis Ukhanov";
    String expect = "Echo, echo, echo : Denis Ukhanov"; 
    Calculate calc = new Calculate();
    String result = calc.echo(input);
    assertThat(result, is(expect));
}
 
}
 