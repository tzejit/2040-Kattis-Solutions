import java.util.Arrays;
import java.util.Stack;

public class Amazing {

  public static String[] c = new String[] {"left", "right", "up", "down"};
  public static String[] copp = new String[] {"right", "left", "down", "up"};
  public static int[] diropp = new int[] {1, 0, 3, 2};
  public static int[][] vmod = new int[][] {{0,-1} ,{0,1} ,{1,0} ,{-1,0}};
  public static boolean[][] visited = new boolean[400][400];
  public static int row = 200;
  public static int col = 200;
  public static class Tile {
    boolean [] dir = new boolean[4]; //l r u d visited
    public boolean dead() {
      return dir[0] && dir[1] && dir[2] && dir[3];
    }
  }
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    Stack<Integer> command = new Stack<>();
    Stack<Tile> tile = new Stack<>();
    Tile t = new Tile();
    tile.push(t);
    visited[row][col] = true;
    while (!tile.empty()) {
      Tile temp = tile.peek();
      if (!temp.dead()) {
        int i = 0;
        for (i = 0; i < 4; i++) {
          if (!temp.dir[i]) {
            if (visited[row+vmod[i][0]][col+vmod[i][1]]) {
              temp.dir[i] = true;
            } else {
              temp.dir[i] = true;
              break;
            }
          }
        }
        if (i == 4) {
          tile.pop();
          if (command.empty()) {
            break;
          } else {
            int cmd = command.pop();
            io.println(c[cmd]);
            io.flush();
            io.getWord();
            row += vmod[cmd][0];
            col += vmod[cmd][1];
            //io.print(row + " " + col);
            continue;
          }
        }
          io.println(c[i]);
          //io.println(Arrays.toString(temp.dir));
          io.flush();
          String n = io.getWord();
          if (n.equals("wall")) {
            continue;
          } else if (n.equals("ok")) {
            row += vmod[i][0];
            col += vmod[i][1];
            //io.print(row + " " + col);
            visited[row][col] = true;
            command.push(diropp[i]);
            Tile nt = new Tile();
            nt.dir[diropp[i]] = true;
            tile.push(nt);
          } else {
            return;
          }
      } else {
        tile.pop();
        if (command.empty()) {
          break;
        } else {
          int cmd = command.pop();
          io.println(c[cmd]);
          io.flush();
          io.getWord();
          row += vmod[cmd][0];
          col += vmod[cmd][1];
          //io.print(row + " " + col);
        }
      }
    }
    io.println("no way out");
    io.flush();
    io.getWord();
  }
}
