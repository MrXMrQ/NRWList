public class List {
    private Knoten first, last, it;

    public List() {
        first = last = it = null;
    }

    /*
     * Die Anfrage liefert den Wert true, wenn die Liste keine Objekte enthält,
     * sonst liefert sie den Wert false.
     */

    public boolean isEmpty() {
        return first == null;
    }

    /*
     * Die Anfrage liefert den Wert true, wenn es ein aktuelles Objekt gibt, sonst
     * liefert sie den Wert false.
     */
    public boolean hasAccess() {
        return it != null;
    }


    /*
     * Falls die Liste nicht leer ist, es ein aktuelles Objekt gibt und dieses nicht
     * das letzte Objekt der Liste ist, wird das dem aktuellen Objekt in der Liste
     * folgende Objekt zum aktuellen Objekt, andernfalls gibt es nach Ausführung
     * des Auftrags kein aktuelles Objekt, d. h., hasAccess() liefert den Wert
     * false.
     */
    public void next() {
        if (hasAccess() && it != last) {
            it = it.getNext();
        }
    }

    /*
     * Falls die Liste nicht leer ist, wird das erste Objekt der Liste aktuelles
     * Objekt. Ist die Liste leer, geschieht nichts.
     */
    public void toFirst() {
        if (!isEmpty()) {
            it = first;
        }
    }

    /*
     * Falls die Liste nicht leer ist, wird das letzte Objekt der Liste aktuelles
     * Objekt. Ist die Liste leer, geschieht nichts.
     */
    public void toLast() {
        if (!isEmpty()) {
            it = last;
        }
    }

    /*
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird das
     * aktuelle Objekt zurückgegeben, andernfalls (hasAccess() == false)
     * gibt die Anfrage den Wert null zurück.
     */
    public Object getContent() {
        if (hasAccess()) {
            return it.getItem();
        } else {
            return null;
        }
    }

    /*
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true) und pObject
     * ungleich null ist, wird das aktuelle Objekt durch pObject ersetzt. Sonst
     * bleibt die Liste unverändert.
     */
    public void setContent(Object item) {
        if (hasAccess() && item != null) {
            it.setItem(item);
        }
    }

    /*
     * Ein neues Objekt pObject wird am Ende der Liste eingefügt. Das aktuelle
     * Objekt bleibt unverändert. Wenn die Liste leer ist, wird das Objekt
     * pObject in die Liste eingefügt und es gibt weiterhin kein aktuelles Objekt
     * (hasAccess() == false). Falls pObject gleich null ist, bleibt die Liste
     * unverändert.
     */
    public void append(Object item) {
        if (item != null) {
            Knoten neu = new Knoten(item, null);

            if (isEmpty()) {
                first = last = neu;
            } else {
                last.setNext(neu);
                last = neu;
            }
        }
    }

    /*
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird ein neues
     * Objekt vor dem aktuellen Objekt in die Liste eingefügt. Das aktuelle Objekt
     * bleibt unverändert. Falls die Liste leer ist und es somit kein aktuelles Objekt
     * gibt (hasAccess() == false), wird pObject in die Liste eingefügt und
     * es gibt weiterhin kein aktuelles Objekt. Falls es kein aktuelles Objekt gibt
     * (hasAccess() == false) und die Liste nicht leer ist oder pObject
     * gleich null ist, bleibt die Liste unverändert.
     */
    public void insert(Object item) {
        if (isEmpty()) {
            first = new Knoten(item, null);
            last = first;
        } else if (hasAccess()) {
            if (it == first) {
                Knoten neu = new Knoten(item, first);
                first = neu;
            } else {
                Knoten help = first;

                while (help.getNext() != it) {
                    help = help.getNext();
                }
                help.setNext(new Knoten(item, it));
            }
        }
    }

    public void insertSorted(Object item) {
        if (isEmpty()) {
            first = new Knoten(item, null);
            last = first;
        } else {
            Knoten help = first;
            Knoten neu = new Knoten(item, null);

            if (((Buch) neu.getItem()).getID() < ((Buch) help.getItem()).getID()) {
                neu.setNext(help);
                first = neu;
                return;
            }

            while (help.getNext() != null) {
                if (((Buch) neu.getItem()).getID() > ((Buch) help.getNext().getItem()).getID()) {
                    help = help.getNext();
                } else {
                    neu.setNext(help.getNext());
                    help.setNext(neu);
                    return;
                }
            }

            last.setNext(neu);
            last = neu;
        }
    }

    /*
     * Die Liste list wird an die Liste angehängt. Anschließend wird list
     * eine leere Liste. Das aktuelle Objekt bleibt unverändert. Falls list null
     * oder eine leere Liste ist, bleibt die Liste unverändert.
     */
    public void concat(List list) {
        if (!list.isEmpty()) {
            last.setNext(list.first);
            last = list.last;
            list.first = null;
            list.last = null;
        }
    }

    /*
     * Falls es ein aktuelles Objekt gibt (hasAccess() == true), wird das aktuelle
     * Objekt gelöscht und das Objekt hinter dem gelöschten Objekt wird zum
     * aktuellen Objekt. Wird das Objekt, das am Ende der Liste steht, gelöscht,
     * gibt es kein aktuelles Objekt mehr (hasAccess() == false). Wenn die Liste
     * leer ist oder es kein aktuelles Objekt gibt (hasAccess() == false),
     * bleibt die Liste unverändert.
     */
    public void remove() {
        // Fall 1: Liste ist leer oder es gibt kein aktuelles Element
        if (hasAccess()) {
            // Fall 2: Liste besteht aus nur einem Element
            if (first == last) {
                first = null;
                last = null;
                it = null;

            } else {
                // Fall 3a: es soll vorne gelöscht werden
                if (first == it) {
                    it = first.getNext();
                    first = it;
                }
                // Fall 4: es soll in der Mitte gelöscht werden
                else {
                    Knoten help = first;
                    while (help.getNext() != it) {
                        help = help.getNext();
                    }
                    help.setNext(it.getNext());
                    it = help.getNext();

                    // Fall 3b: es soll hinten gelöscht werden
                    if (help.getNext() == null) {
                        last = help;
                    }
                }
            }
        }
    }

    public void print() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        Knoten help = first;
        while (help != null) {
            Buch temp = (Buch) help.getItem();
            System.out.print("Buch Nr: " + temp.getID() + " geschrieben von " + temp.getAutor() + " mit dem Titel " + temp.getTitel() + " kostet " + temp.getPreis() + " $!");

            if (help == first) System.out.print("  <=== first");
            if (help == last) System.out.print("  <=== last");
            if (help == it) System.out.print("  <=== act");

            System.out.println();
            help = help.getNext();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    }
}
