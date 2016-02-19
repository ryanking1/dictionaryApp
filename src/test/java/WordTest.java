import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  // @Rule
  // public ClearRule clearRule = new ClearRule();

  @Test
  public void getWordReturnsCorrectWord_true() {
    Word testWord = new Word("test");
    assertEquals("test", testWord.getWord());
  }

}
