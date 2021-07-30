import java.util.PriorityQueue;

public class Zipf {
  public static int N;

  public static class Song implements Comparable<Song>{
    String name;
    long q;
    int i;
    public Song(long f, String n, int i) {
      name = n;
      q = f * i;
      this.i = i;
    }
    public int compareTo(Song s) {
      if (q == s.q) {
        return i - s.i;
      } else if (q < s.q) {
        return 1;
      }
      return -1;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int N = io.getInt();
    int number = io.getInt();
    PriorityQueue<Song> q = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      q.add(new Song(io.getLong(),io.getWord(), i+1));
    }
    for (int i = 0; i < number; i++) {
      io.println(q.poll().name);
    }
    io.close();
  }
}
