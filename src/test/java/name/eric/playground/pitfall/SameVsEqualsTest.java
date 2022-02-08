package name.eric.playground.pitfall;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.Point;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;

/**
 * This should illustrate the difference between {@link ArgumentMatchers}.same(..) and {@link ArgumentMatchers}.eq(..).
 *
 * <ul>
 * <li>
 *  same(..): compares just the reference of objects
 * </li>
 * <li>
 *  eq(..): compares the values
 * </li>
 * </ul>
 *
 * <h3>Conclusion</h3>
 * It could be the same object but not equal, if the values are changed during processing!
 */
@ExtendWith(MockitoExtension.class)
public class SameVsEqualsTest {

  @Mock
  private Consumer<Point> mock;
  @InjectMocks
  private SameVsEquals underTest;

  @Test
  public void testEqual() {
    Point a = new Point(20, 40);

    underTest.doSomething(a);

    verify(mock).accept(same(a));
    verify(mock).accept(eq(a)); // values are changed on the object
    verify(mock).accept(eq(new Point(20, 100)));
  }
}
