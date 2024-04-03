public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        List list = new List();

        list.append(new Buch("Herr der Ringe", "J.R.R. Tolkien", 13.99, 1));
        list.append(new Buch("Harry Potter und der Stein der Weisen", "J.K. Rowling", 12.99, 2));

        list.append(new Buch("1984", "George Orwell", 9.99, 4));
        list.append(new Buch("To Kill a Mockingbird", "Harper Lee", 8.99, 5));
        list.append(new Buch("Der Große Gatsby", "F. Scott Fitzgerald", 11.99, 6));
        list.append(new Buch("Harry Potter und die Kammer des Schreckens", "J.K. Rowling", 12.99, 7));
        list.append(new Buch("Der Fänger im Roggen", "J.D. Salinger", 9.49, 8));
        list.append(new Buch("Stolz und Vorurteil", "Jane Austen", 7.99, 9));
        list.append(new Buch("Harry Potter und der Gefangene von Askaban", "J.K. Rowling", 13.49, 10));
        list.append(new Buch("Der Alchimist", "Paulo Coelho", 10.49, 11));
        list.append(new Buch("Der kleine Prinz", "Antoine de Saint-Exupéry", 6.99, 12));
        list.append(new Buch("Der Herr der Fliegen", "William Golding", 8.49, 13));
        list.append(new Buch("Alice im Wunderland", "Lewis Carroll", 7.99, 14));
        list.append(new Buch("Der Report der Magd", "Margaret Atwood", 11.99, 15));
        list.append(new Buch("Brave New World", "Aldous Huxley", 9.99, 16));
        list.append(new Buch("Moby-Dick", "Herman Melville", 12.99, 17));
        list.append(new Buch("Die Odyssee", "Homer", 11.49, 18));
        list.append(new Buch("Frankenstein", "Mary Shelley", 8.99, 19));
        list.append(new Buch("Jane Eyre", "Charlotte Brontë", 10.99, 20));
        list.append(new Buch("Wuthering Heights", "Emily Brontë", 9.99, 21));
        list.append(new Buch("Die Abenteuer des Huckleberry Finn", "Mark Twain", 7.49, 22));
        list.append(new Buch("Die Bibel", "Verschiedene Autoren", 14.99, 23));
        list.append(new Buch("Krieg und Frieden", "Leo Tolstoi", 15.99, 24));
        list.append(new Buch("Anna Karenina", "Leo Tolstoi", 13.99, 25));

        list.print();

        list.insertSorted(new Buch("Der Hobbit", "J.R.R. Tolkien", 10.99, 3));

        list.print();
    }
}