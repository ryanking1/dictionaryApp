import java.util.ArrayList;

public class Word {

  private static ArrayList<Word> instances = new ArrayList<Word>();

  private String mWord;
  private int mId;
  private ArrayList<Definition> mdefinitions;

  public Word(String word) {
    mWord = word;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

}
