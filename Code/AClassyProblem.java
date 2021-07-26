import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AClassyProblem {

  public static class Person implements Comparable<Person>{
    public String name;
    public String[] cls;
    
    public String[] convert(String[] cls) {
      String[] intArr = new String[10];
      int i;
      for (i = 0; i < 10 - cls.length; i++) {
        intArr[i] = "middle";
      }
      for (int j = i; j < 10; j++) {
        intArr[j] = cls[j - i];
      }
      return intArr;
    }

    public Person(String name, String[] cls) {
      this.name = name;
      this.cls = convert(cls);
    }

    @Override
    public int compareTo(Person p) {
      return this.name.compareTo(p.name);
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    for (int i = 0; i < n; i++) {
      int num = io.getInt();
      List<Person> p = new ArrayList<>();
      for (int j = 0; j < num; j++) {
        String nameraw = io.getWord();
        p.add(new Person(nameraw.substring(0, nameraw.length() - 1), io.getWord().split("-")));
        io.getWord(); //remove class
      }
      Collections.sort(p);
      for (int j = 0; j < 10; j++) {
        List<Person> upper = new ArrayList<>();
        List<Person> lower = new ArrayList<>();
        List<Person> middle = new ArrayList<>();
        for (Person s : p) {
          switch (s.cls[j]) {
            case "upper":
              upper.add(s);
              break;
            case "middle":
              middle.add(s);
              break;
            case "lower":
              lower.add(s);
              break;  
          }
        }
        p.clear();
        p.addAll(upper);
        p.addAll(middle);
        p.addAll(lower);
      }
      for (Person prs : p) {
        io.println(prs.name);
      }
      io.println("==============================");  
    }
    io.close();
  }
}