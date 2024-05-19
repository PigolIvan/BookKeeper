import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class BookMethods {
    static ArrayList<Book> books = new ArrayList<>();
    static Book anotherBook = new Book("ІншаНазва", "ІншийАвтор", 2023);
    //^^^  Зараннє створенна "книга" для перевірки DuplicateYearException
    public static void addBook(String title, String author, int year) throws DuplicateBookException, InvalidYearException {
        Book book = new Book(title, author, year);
        if (year <= 0 | year > 2024) {
            throw new InvalidYearException("Не корректний рік");
        } else if (books.contains(book)) {
            throw new DuplicateBookException("Ця книга вже є.");
        } else {
            System.out.println("Книга успішно додана!");
            books.add(book);
        }
    }
    public static void removeBook(String title, String author) throws BookNotFoundException {
        //Ми ще не вчили ітератор(як мінімум я не міг бути на лекціях якщо і проходили), але для такої задачі він більше підходить.
        Iterator<Book> bookIterator = books.iterator();
        while(bookIterator.hasNext()) {
            Book nextBook = bookIterator.next();
            if (nextBook.getTitle().equals(title) & nextBook.getAuthor().equals(author)){
                System.out.println("Книга успішно видалена.");
                bookIterator.remove();
            } else if(bookIterator.equals(books)) {
                throw new BookNotFoundException("Книгу невдалося видалити.");
            }
        }
    }
    public static void findBookByAuthor(String author){
        ArrayList<Book> booksToShow = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksToShow.add(book);
            }
        }
        for(int i = 0; i<booksToShow.size(); i++){
            Book bookToShow = booksToShow.get(i);
            System.out.println("Знайдена книжка: " + bookToShow.getTitle() + ' ' + bookToShow.getAuthor() + ' '
                    + bookToShow.getYear());
        }
    }
    public static void findBookByYear(int year){
        ArrayList<Book> booksToShow = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                booksToShow.add(book);
            } else {
                booksToShow.removeAll(booksToShow);
            }
        }
        for(int i = 0; i<booksToShow.size(); i++){
            Book bookToShow = booksToShow.get(i);
            System.out.println("Знайдена книжка: " + bookToShow.getTitle() + ' ' + bookToShow.getAuthor() + ' '
                    + bookToShow.getYear());
        }
    }
    public static void main(String[] args)
            throws DuplicateBookException, InvalidYearException, BookNotFoundException {
        books.add(anotherBook);
        //addBook("Назва", "Автор", 0); // перевірка InvalidYearException, краще мати закоментованим, як і винятки нище
        //addBook("ІншаНазва", "ІншийАвтор", 2023); //перевірка DuplicateBookException
        addBook("НазваЯкаНеСхожаНаІнші", "Бублик",  1977);
        addBook("ПаралельнаНазва", "ПаралельнийАвтор", 2023);
        addBook("ЗанадтоКрутаНазва", "ЗанадтоКрутийЯ", 2023);
        removeBook("НазваЯкаНеСхожаНаІнші", "Бублик");
        findBookByYear(1977);//Перевіряєм чи існує ще книга яку видалили + чи видасть нам це порожній список.
        removeBook("НеіснуючаНазва", "НеіснуючийАвтор"); //Перевірка BookNotFoundException
        findBookByAuthor("Паралельний автор");
        findBookByYear(2023);
    }
}
