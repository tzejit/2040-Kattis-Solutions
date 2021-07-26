import java.util.ArrayList;

public class A2048 {

  public static void transpose(ArrayList<ArrayList<Integer>> board) {
    ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(4);
    for (int j = 0; j < 4; j++) { // col
      ArrayList<Integer> row = new ArrayList<>(4);
      for (int i = 0; i < 4; i++) { // row
        row.add(board.get(i).get(j));
      }
      temp.add(row);
    }
    board.clear();
    board.addAll(temp);   
  }

  public static void flip(ArrayList<ArrayList<Integer>> board) {
    for (int i = 0; i < 4; i++) { // row
      board.get(i).add(board.get(i).get(2));
      board.get(i).add(board.get(i).get(1));
      board.get(i).add(board.get(i).get(0));
      board.get(i).remove(0);
      board.get(i).remove(0);
      board.get(i).remove(0);
    }
  }

  public static void magic(ArrayList<ArrayList<Integer>> board) {
    for (int i = 0; i < 4; i++) { // row
      int count = 0;
      boolean merged = false;
      while(board.get(i).contains(0)) {
        board.get(i).remove(board.get(i).indexOf(0));
        count++;
      }
      for (int j = 1; j < board.get(i).size(); j += 2) { //columm
        if (board.get(i).get(j).equals(board.get(i).get(j-1))) {
          merged = true;
          board.get(i).set(j-1, board.get(i).get(j) * 2);
          board.get(i).set(j, 0);
        }
      }
      if (!merged && board.get(i).size() >=3 && board.get(i).get(2).equals(board.get(i).get(1))) {
        board.get(i).set(1, board.get(i).get(1) * 2);
        board.get(i).set(2, 0);
      }
      while(board.get(i).contains(0)) {
        board.get(i).remove(board.get(i).indexOf(0));
        count++;
      }
      for (int k = 0; k < count; k++) {
        board.get(i).add(0);
      }
    }
  }

  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    ArrayList<ArrayList<Integer>> board = new ArrayList<ArrayList<Integer>>(4);
    for (int i = 0; i < 4; i++) { // row
      ArrayList<Integer> row = new ArrayList<>(4);
      for (int j = 0; j < 4; j++) { //column
        row.add(io.getInt());
      }
      board.add(row);
    }
    String n = io.getWord();
    switch(n) {
      case "0": 
        magic(board);
        break;
      case "1":
        transpose(board);
        magic(board);
        transpose(board);
        break;
      case "2":
        flip(board);
        magic(board);
        flip(board);
        break;
      case "3":
        transpose(board);
        flip(board);
        magic(board);
        flip(board);
        transpose(board);
        break;
    } 
    for (int i = 0; i < 4; i++) { 
      for (int j = 0; j < 4; j++) {
        io.print(board.get(i).get(j));
        if (j != 3) {
          io.print(" ");
        }
      }
      io.println();
    }
    io.close();
  }
}
