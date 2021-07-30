public class Teque {

  public static class QueueArrModified {
    public int[] arr;
    public int front, back;
    public int capacity;
    public int count;
  
    public QueueArrModified(int i) {
      arr = new int[i]; // create array of integers
      front = 0; // the queue is empty
      back = 0;
      capacity = i; 
    }
  
    public int peek(int a) {
      return arr[(a + front) % capacity];
    }
  
    public int pollfront() {
      int item = arr[front];
      front = (front + 1) % capacity;
      count--;
      return item;
    }
  
    public int pollback() {
      int item = arr[(capacity + back - 1) % capacity];
      back = (capacity + back - 1) % capacity;
      count--;
      return item;
    }
  
    public void offerback(int item) {
      arr[back] = item;
      back = (back + 1) % capacity;
      count++;
    }
  
    public void offerfront(int item) {
      arr[(front + capacity - 1) % capacity] = item;
      front = (front + capacity - 1) % capacity;
      count++;
    }
  }
  
  public static void main(String[] args) {
    Kattio io = new Kattio(System.in, System.out);
    int n = io.getInt();
    QueueArrModified front = new QueueArrModified((n + 1) / 2);
    QueueArrModified back = new QueueArrModified((n + 1) / 2);
    String command;
    int c;
    for (int i = 0; i < n; i++) {
      command = io.getWord();
      c = io.getInt();
      switch(command) {
        case "push_back":
        if (back.count >= front.count) {
          back.offerback(c);
          front.offerback(back.pollfront());
        } else {
          back.offerback(c);
        }
          break;
        case "push_front":
          if (front.count > back.count) {
            front.offerfront(c);
            back.offerfront(front.pollback());
          } else {
            front.offerfront(c);
          }
          break;
        case "push_middle":
          if (front.count == back.count) {
            front.offerback(c);
          } else {
            back.offerfront(c);
          }
          break;
        case "get":
          if (c < front.count) {
            io.println(front.peek(c));
          } else {
            io.println(back.peek(c - front.count));
          }
          break;
      }
    }
    io.close();
  }
}
