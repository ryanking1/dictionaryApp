import java.util.ArrayList;

public class PingPong {
  public static void main(String[] args) {}

    public ArrayList isPingPong(Integer number) {
      ArrayList<Object> numberArray = new ArrayList<Object>();
      for (Integer i = 1; i <= number; i++) {
        if (i % 3 == 0) {
          numberArray.add("ping");
        } else if (i % 5 == 0) {
          numberArray.add("pong");
        } else {
          numberArray.add(i);
        }
      }
    return numberArray;
  }
}
  //     if ( number % 15 == 0) {
  //       return "pingpong";
  //     } else if ( number % 3 == 0 ) {
  //       return "ping";
  //     } else if ( number % 5 == 0 ){
  //       return "pong";
  //     }
  //     return "test";
  // }
