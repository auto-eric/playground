package name.eric.playground.pitfall;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.awt.Point;
import java.util.function.Consumer;

@Setter
public class SameVsEquals {

  private Consumer<Point> consumer;

  public void doSomething(Point point){
    point.setLocation(20, 100);
    consumer.accept(point);
  }
}
