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

  @Test
  public void getIdMethodReturnsCorrectId() {
    Word testWord = new Word("test");
    assertTrue(Word.all().size() == testWord.getId());
  }

  @Test
  public void getDefinitionsReturnsArrayList() {
    Word testWord = new Word("test");
    assertTrue(testWord.getDefinitions() instanceof ArrayList);
  }

}
