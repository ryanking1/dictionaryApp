import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clear", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word.all().clear();
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/wordform", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/wordform.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/definitionForm", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/definitionForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/word", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String word = request.queryParams("word");
      Word newWord = new Word(word);
      model.put("words", Word.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      model.put("word", word);
      model.put("template", "templates/word-definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/:id/definitionForm", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));
      ArrayList<Definition> definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/definitionForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/definition", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      ArrayList<Definition> definitions = word.getDefinitions();

      if (definitions == null) {
        definitions = new ArrayList<Definition>();
        request.session().attribute("definitions", definitions);
      }

      String definition = request.queryParams("definition");

      Definition newDefinition = new Definition(definition);

      definitions.add(newDefinition);
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word-definition.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
