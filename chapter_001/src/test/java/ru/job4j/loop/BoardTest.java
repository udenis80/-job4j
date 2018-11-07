package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BoardTest {

@Test
public void when3x3() {
    Board board = new Board();
    String rsl = board.paint(3, 5);
    String ln = System.lineSeparator();
    assertThat(rsl, is(
            String.format("X X%s X %sX X%s X %sX X%s", ln, ln, ln, ln, ln)
            )
    );
}
    @Test
    public void when5x4() {
        Board board1 = new Board();
        String rsl1 = board1.paint(5, 4);
        String ln1 = System.lineSeparator();
        assertThat(rsl1, is(
                String.format("X X X%s X X %sX X X%s X X %s", ln1, ln1, ln1, ln1)
                )
        );
    }
}