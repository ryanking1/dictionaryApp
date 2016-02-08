import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class PingPongTest {

  @Test
  public void isPingPong_array() {
    PingPong testPingPong = new PingPong();
    ArrayList<Object> testArray = new ArrayList<Object>();
    testArray.add(1);
    testArray.add(2);
    assertEquals(testArray, testPingPong.isPingPong(2));
  }

  @Test
  public void isPingPong_arrayPing() {
    PingPong testPingPong = new PingPong();
    ArrayList<Object> testArray = new ArrayList<Object>();
    testArray.add(1);
    testArray.add(2);
    testArray.add("ping");
    assertEquals(testArray, testPingPong.isPingPong(3));
  }

  @Test
  public void isPingPong_arrayPong() {
    PingPong testPingPong = new PingPong();
    ArrayList<Object> testArray = new ArrayList<Object>();
    testArray.add(1);
    testArray.add(2);
    testArray.add("ping");
    testArray.add(4);
    testArray.add("pong");
    assertEquals(testArray, testPingPong.isPingPong(5));
  }
  @Test
  public void isPingPong_arrayPingPong() {
    PingPong testPingPong = new PingPong();
    ArrayList<Object> testArray = new ArrayList<Object>();
    testArray.add(1);
    testArray.add(2);
    testArray.add("ping");
    testArray.add(4);
    testArray.add("pong");
    testArray.add("ping");
    testArray.add(7);
    testArray.add(8);
    testArray.add("ping");
    testArray.add("pong");
    testArray.add(11);
    testArray.add("ping");
    testArray.add(13);
    testArray.add(14);
    testArray.add("pingpong");
    assertEquals(testArray, testPingPong.isPingPong(15));
  }
}
