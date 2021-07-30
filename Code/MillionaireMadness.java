import java.util.PriorityQueue;

public class MillionaireMadness {
  public static class Pair implements Comparable<Pair>{
    int i;
    int j;
    int w;
    public Pair(int i, int j, int w) {
      this.i=i;
      this.j=j;
      this.w = w;
    }

    public int compareTo(Pair p) {
      return this.w-p.w;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int r = io.getInt();
    int c = io.getInt();
    int[][] maze = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        maze[i][j] = io.getInt();
      }
    }
    boolean[][] visited = new boolean[r][c]; //default set to false
    PriorityQueue<Pair> queue = new PriorityQueue<>();
    int ladder = 0;
    queue.offer(new Pair(0,0,0));
    while (!visited[r-1][c-1]) {
      Pair temp = queue.poll();
      int row = temp.i;
      int col = temp.j;
      ladder = temp.w > ladder ? temp.w : ladder;
      int height = maze[row][col];
      visited[row][col] = true;
      int nr1 = row - 1;
      int nr2 = row + 1;
      int nc1 = col + 1;
      int nc2 = col - 1;
      if (nr1 >= 0 && !visited[nr1][col]) {
        queue.offer(new Pair(nr1,col, maze[nr1][col]-height));
      }
      if (nr2 <= r - 1 && !visited[nr2][col]) {
        queue.offer(new Pair(nr2,col,maze[nr2][col]-height));
      }
      if (nc1 <= c - 1 && !visited[row][nc1]) {
        queue.offer(new Pair(row,nc1,maze[row][nc1]-height));
      }
      if (nc2 >= 0 && !visited[row][nc2]) {
        queue.offer(new Pair(row,nc2,maze[row][nc2]-height));
      }
    }
    io.println(ladder);
    io.close();
  }
}
