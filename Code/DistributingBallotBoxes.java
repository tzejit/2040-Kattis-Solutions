import java.util.PriorityQueue;

class DistributingBallotBoxes {

  public static class City implements Comparable<City>{
    public int box = 1;
    public double people;

    public City(int b, double c) {
      people = c*(b-1)/b;
      box = b;
    }

    public City(double p) {
      people = p;
    }

    public int compareTo(City c) {
      return this.people > c.people ? -1 : 1;
    }

    public int intpeople() {
      return (int)(people*box + box -1)/box; 
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    while (n != -1) {
      int num = io.getInt();
      PriorityQueue<City> q = new PriorityQueue<>(n);
      for (int i = 0; i < n; i++) {
        q.add(new City(io.getDouble()));
      }
      int i = num - n;
      while (i > 0) {
        City temp = q.poll();
        City nc = new City(temp.box+1,temp.people);
        i--;
        q.add(nc);
      }
      io.println(q.poll().intpeople());
      n = io.getInt();
    }
    io.getInt();
    io.close();
  }
}