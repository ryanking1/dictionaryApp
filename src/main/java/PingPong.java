import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class PingPong {
  public static void main(String[] args) {
    staticFileLocation("/public");
    get("/", (request, response) -> {
      return new ModelAndView(new HashMap(), "templates/pingpong.vtl");
    }, new VelocityTemplateEngine());

  //   public ArrayList isPingPong(Integer number) {
  //     ArrayList<Object> numberArray = new ArrayList<Object>();
  //     for (Integer i = 1; i <= number; i++) {
  //       if (i % 15 == 0) {
  //         numberArray.add("pingpong");
  //       } else if (i % 3 == 0) {
  //         numberArray.add("ping");
  //       } else if (i % 5 == 0) {
  //         numberArray.add("pong");
  //       } else {
  //         numberArray.add(i);
  //       }
  //     }
  //   return numberArray;
  // }
  }
}
