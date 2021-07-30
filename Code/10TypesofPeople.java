import java.util.LinkedList;

class TypesofPeople {
  public static class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
      this.i=i;
      this.j=j;
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int r = io.getInt();
    int c = io.getInt();
    char[][] maze = new char[r][c];
    for (int i = 0; i < r; i++) {
      maze[i] = io.getWord().toCharArray();
    }
    int n = io.getInt();
    int[][] visited = new int[r][c]; //default set to 0
    int count = 1;
    for (int i = 0; i < n; i++) {
      int r1 = io.getInt() - 1;
      int c1 = io.getInt() - 1;
      int r2 = io.getInt() - 1;
      int c2 = io.getInt() - 1;
      char id = maze[r1][c1];
      LinkedList<Pair> queue = new LinkedList<>();
      if (id != maze[r2][c2]) {
        io.println("neither");
      } else if ((r1 == r2 && c1 == c2) || (visited[r1][c1] != 0 && visited[r1][c1] == visited[r2][c2])) {
        io.println(id == '0' ? "binary" : "decimal");
      } else {
        visited[r1][c1] = count;
        queue.offer(new Pair(r1,c1));
        while (!queue.isEmpty()) {
          Pair temp = queue.poll();
          int row = temp.i;
          int col = temp.j;
          int nr1 = row - 1;
          int nr2 = row + 1;
          int nc1 = col + 1;
          int nc2 = col - 1;
          if (nr1 >= 0 && maze[nr1][col] == id && visited[nr1][col] == 0) {
            visited[nr1][col] = count;
            queue.offer(new Pair(nr1,col));
          }
          if (nr2 <= r - 1 && maze[nr2][col] == id && visited[nr2][col] == 0) {
            visited[nr2][col] = count;
            queue.offer(new Pair(nr2,col));
          }
          if (nc1 <= c - 1 && maze[row][nc1] == id && visited[row][nc1] == 0) {
            visited[row][nc1] = count;
            queue.offer(new Pair(row,nc1));
          }
          if (nc2 >= 0 && maze[row][nc2] == id && visited[row][nc2] == 0) {
            visited[row][nc2] = count;
            queue.offer(new Pair(row,nc2));
          }
        }
        count++;
        if (visited[r2][c2] == visited[r1][c1]) {
          io.println(id == '0' ? "binary" : "decimal");
        } else {
          io.println("neither");
        }
      }
    }
    io.close();
  }
}