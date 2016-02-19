import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Test
  public void definitionObjectInitializesCorrectly() {
    Definition testDefinition = new Definition("test");
    assertEquals(true, testDefinition instanceof Definition);
  }

  @Test
  public void getDefinitionMethodReturnsCorrectDefinition() {
    Definition testDefinition = new Definition("test");
    assertEquals("test", testDefinition.getDefinition());
  }

  @Test
  public void allMethodReturnsAllInstancesOfDefinition() {
    Definition testOne = new Definition("one");
    Definition testTwo = new Definition("Two");
    assertTrue(Definition.all().contains(testOne));
    assertTrue(Definition.all().contains(testTwo));
  }

  @Test
  public void findMethodReturnsDefinitionWithSameID() {
    Definition testOne = new Definition("one");
    Definition testTwo = new Definition("two");
    assertEquals(Definition.find(testOne.getId()), testOne);
    assertEquals(Definition.find(testTwo.getId()), testTwo);
  }
}
