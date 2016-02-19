import org.fluentlenium.adapter.FluentTest;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.*;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Word List");
  }

  @Test
  public void checkWordIsAddedCorrectly() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("cat");
    submit(".btn", withText("Add Word"));
    assertThat(pageSource()).contains("cat");
  }

  @Test
  public void checkMultipleWordsAreAddedCorrectly() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("cat");
    submit(".btn", withText("Add Word"));
    assertThat(pageSource()).contains("cat");
    click("a", withText("Add a New Word"));
    fill("#word").with("dog");
    submit(".btn", withText("Add Word"));
    assertThat(pageSource()).contains("cat", "dog");
  }

  @Test
  public void checkWordContainsDefinition() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#word").with("testcat");
    submit(".btn", withText("Add Word"));
    click("a", withText("testcat"));
    click("a", withText("Add a new definition"));
    fill("#definition").with("fluffy ball of hatred");
    submit(".btn", withText("Add Definition"));
    assertThat(pageSource()).contains("fluffy ball of hatred");
  }
}
