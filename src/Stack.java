class Stack<T> {
    private class Item {
        T value; // Das zu verwaltende Objekt
        Item next; // Referenz auf den nächsten Knoten

        Item(T value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    private Item peek;

    // Prüft, ob der Stapel leer ist
    public boolean empty() {
        return this.peek == null;
    }

    // Speichert ein neues Objekt
    public void push(T value) {
        this.peek = new Item(value, this.peek);
    }

    // Gibt das oberste Objekt wieder und entfernt es aus dem Stapel
    public T pop() {
        T temp = this.peek.value;

        if (!empty())
            this.peek = this.peek.next;

        return temp;
    }

    // Gibt das oberste Objekt wieder
    public T peek() {
        return !empty() ? this.peek.value : null;
    }
}