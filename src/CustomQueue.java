public class CustomQueue {
    private Knoten first;
    private Knoten last;

    public CustomQueue() {
        first = last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(Object item) {
        if(item != null) {
            if(isEmpty()) {
                first = new Knoten(item, null);
                last = first;
            } else {
                last.setNext(new Knoten(item, null));
                last = last.getNext();
            }
        }
    }

    public void dequeue() {
        if(!isEmpty()) {
            first = first.getNext();
        }
    }

    public Object front() {
        if(!isEmpty()) {
            return first.getItem();
        } else {
            return null;
        }
    }
}
