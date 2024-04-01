public class Knoten {
    private Object item;
    private Knoten next;

    public Knoten(Object item, Knoten next) {
        this.item = item;
        this.next = next;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Knoten getNext() {
        return next;
    }

    public void setNext(Knoten next) {
        this.next = next;
    }
}
