import java.util.ArrayList;

class JoinStrings {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    if (n == 1) {
      io.println(io.getWord());
      io.close();
      return;
    }
    String[] strings = new String[n];
    ArrayList<TailedLinkedList> order = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      strings[i] = io.getWord();
      TailedLinkedList temp = new TailedLinkedList();
      temp.addFront(i);
      order.add(temp);
    }
    for (int i = 0; i < n - 2; i++) {
      TailedLinkedList a = order.get(io.getInt() - 1);
      TailedLinkedList b = order.get(io.getInt() - 1);
      a.getTail().setNext(b.getHead());
      a.tail = b.tail;
    }
    TailedLinkedList a = order.get(io.getInt() - 1);
    TailedLinkedList b = order.get(io.getInt() - 1);
    a.getTail().setNext(b.getHead());
    a.tail = b.tail;
    for (ListNode cur = a.head; cur != null; cur = cur.getNext()) {
      io.print(strings[cur.item]);
    }
    io.println();
    io.close();
  }
}