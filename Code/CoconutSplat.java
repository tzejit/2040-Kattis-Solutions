import java.util.ArrayList;

class CoconutSplat {
  public static void main(String[] args) {
    ArrayList<Double> hands = new ArrayList<>(); // 1 = coconut, 1.2 = half, 1.4 = spill
    Kattio io = new Kattio(System.in, System.out);
    int s = io.getInt();
    int p = io.getInt();
    int index = 0;
    for (int i = 0; i < p; i++) {
      hands.add((double) i + 1);
    }
    while (hands.size() != 1) {
      index = (index + s - 1) % hands.size();
      double handnum = hands.get(index);
      if (handnum % 1 <= 0.1) {
        hands.set(index, handnum + 0.2);
        hands.add(index + 1, handnum + 0.2);
      } else if (handnum % 1 <= 0.3) {
        hands.set(index, handnum + 0.2);
        index++;
      } else {
        hands.remove(index);
      }
    }
    io.println(hands.get(0).intValue());
    io.close();
  }
}