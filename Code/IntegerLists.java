import java.util.LinkedList;

public class IntegerLists {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    for (int i = 0; i < n ; i++) {
      boolean error = false;
      char[] c = io.getWord().toCharArray();
      int num = io.getInt();
      String input = io.getWord();
      String[] parsed = input.substring(1, input.length()-1).split(",");
      LinkedList<Integer> list = new LinkedList<>();
      for (int j = 0; j < num ; j++) {
        list.add(Integer.valueOf(parsed[j]));
      }
      boolean reversed = false;
      for (char command : c) {
        if (command == 'R') {
          if (reversed) {
            reversed = false;
          } else {
            reversed = true;
          }
        } else {
          if (list.isEmpty()) {
            io.println("error");
            error = true;
            break;
          } else if (reversed) {
            list.removeLast();
          } else {
            list.removeFirst();
          }
        }
      }
      if (!error) {
        io.print('[');
        while (!list.isEmpty()) {
          if (reversed) {
            io.print(list.removeLast());
          } else {
            io.print(list.removeFirst());
          }
          if (!list.isEmpty()) {
            io.print(',');
          }
        }
        io.println(']');
      }
    }
    io.close();
  }
}
