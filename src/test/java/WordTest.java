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

  @Test
  public void allMethodReturnsAllInstancesOfWord() {
    Word firstWord = new Word("one");
    Word secondWord = new Word("Two");
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void findMethodReturnsWordWithSameId() {
    Word testWord = new Word("test");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void addDefinitionToWordObject() {
    Word testWord = new Word("test");
    Definition testDefinition = new Definition("definition");
    testWord.addDefinition(testDefinition);
    assertTrue(testWord.getDefinitions().contains(testDefinition));
  }

}
