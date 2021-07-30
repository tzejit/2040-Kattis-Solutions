import java.util.ArrayList;

public class Cannon {
  public static double [] d;
  public static final double INF = 1000000000;
  public static class Vert {
    double x;
    double y;
    int id;
    boolean c;
    public Vert(double i , double j, int d, boolean c) {
      x = i;
      y = j;
      id = d;
      this.c = c;
    }
  }
  public static class Triple {
    Vert s;
    Vert e;
    double t;
    public Triple(Vert start, Vert next) {
      s = start;
      e = next;
      t = time();
    }
    public double time() {
      double dist = Math.sqrt((s.x-e.x)*(s.x-e.x) + (s.y-e.y)*(s.y-e.y));
      if (!s.c) {
        return dist/5;
      }  else {
        return Math.min(Math.abs(dist-50)/5 + 2, dist/5);
      }
    }
    public String toString() {
      return s.id + " " + e.id + " " + (int)t;
    }
  }

  public static void relax(Triple t) {
    if (d[t.e.id] > d[t.s.id] + t.t) {
      d[t.e.id] = d[t.s.id] + t.t;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    Vert start = new Vert(io.getDouble(), io.getDouble(), 0, false);
    Vert end = new Vert(io.getDouble(), io.getDouble(), 1, false);
    ArrayList<Vert> vlist = new ArrayList<>();
    vlist.add(start);
    vlist.add(end);
    ArrayList<Triple> elist = new ArrayList<>();
    elist.add(new Triple(start, end));
    elist.add(new Triple(end, start));
    int c = io.getInt();
    d = new double[c+2];
    d[0] = 0;
    d[1] = INF;
    for (int i = 0 ; i < c; i++) {
      d[i+2] = INF;
      Vert t = new Vert(io.getDouble(), io.getDouble(), i+2, true);
      for (Vert v : vlist) {
        elist.add(new Triple(v, t));
        elist.add(new Triple(t, v));
      }
      vlist.add(t);
    }
    for (int i = 0 ; i < c + 1; i++) {
      for (Triple e : elist) {
        relax(e);
      }
    }
    io.println(d[1]);
    io.close();
  }
}
