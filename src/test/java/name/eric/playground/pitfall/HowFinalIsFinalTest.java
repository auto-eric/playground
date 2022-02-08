package name.eric.playground.pitfall;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HowFinalIsFinalTest {

  @Test
  public void howFinalIsFinal() {
    final Point x = new Point(1, 2);
    x.setLocation(3, 2);

//    x = new Point(3, 2); // this is not allowed by compiler

    assertEquals(new Point(3, 2), x);
  }

  @ParameterizedTest
  @MethodSource("data")
  public void howFinalIsFinal(final Point p) {
//    p = new Point(2, 3); forbidden by compiler
    p.setLocation(2, 3);

    assertEquals(2, p.getX());
    assertEquals(3, p.getY());
  }

  public static Object[][] data() {
    return new Object[][] {
        {new Point(1, 1)}
    };
  }
}
