import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PeaSoupandPancakes {

  public static class Restaurant {
    private List<String> menu;
    public String name;
    public Restaurant(List<String> menu, String name) {
      this.menu = menu;
      this.name = name;
    }
    public boolean fit() {
      return (this.menu.contains("pea soup") && this.menu.contains("pancakes")); 
    }
  }
  public static void main(String[] args) {
    List<String> menu;
    Scanner sc = new Scanner(System.in);
    int numRes = sc.nextInt();
    Restaurant[] resArray = new Restaurant[numRes];
    for (int i = 0; i < numRes; i++) {
      int numMen = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      menu = new ArrayList<>(numMen);
      for (int j = 0; j < numMen; j++){
        menu.add(sc.nextLine());
      }
      resArray[i] = new Restaurant(menu, name);
    }
    sc.close();
    System.out.println(resFinder(resArray));
  }

  public static String resFinder(Restaurant[] res) {
    for (Restaurant r : res) {
      if (r.fit()) {
        return r.name;
      }
    }
    return "Anywhere is fine I guess";
  }
}
