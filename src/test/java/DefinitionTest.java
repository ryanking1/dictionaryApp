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
}
