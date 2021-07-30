import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class DataStruc {
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    while(io.hasMoreTokens()){
      int n = io.getInt();
      PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
      Stack<Integer> stack = new Stack<>();
      LinkedList<Integer> q = new LinkedList<>();
      boolean prqu = true;
      boolean st = true;
      boolean qu = true;
      for(int i = 0; i < n; i++) {
        int c = io.getInt();
        int x = io.getInt();
        if (c == 1) {
          if (prqu)
            pq.add(x);
          if (st)
            stack.push(x);
          if (qu)
            q.offer(x);
        } else {
          if (prqu)
            if (!pq.isEmpty())
              prqu = (x == pq.poll());
            else
              prqu = false;
          if (st)
            if (!stack.isEmpty())
              st = (x == stack.pop());
            else
              st = false;
          if (qu)
            if (!q.isEmpty())
              qu = (x == q.poll());
            else
              qu = false;
        }
      }
      if (!qu && !st && !prqu) {
        io.println("impossible");
      } else if (qu && !st && !prqu) {
        io.println("queue");
      } else if (!qu && st && !prqu) {
        io.println("stack");
      } else if (!qu && !st && prqu) {
        io.println("priority queue");
      } else {
        io.println("not sure");
      }
    }
    io.close();
  }
}
