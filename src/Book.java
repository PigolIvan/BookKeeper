import java.util.Objects;

public class Book {
    String title;
    String author;
    int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book that = (Book) obj;
        return year == that.year && title.equals(that.title) && author.equals(that.author);
    }
    @Override
    public int hashCode() {
        return Objects.hash(year, title, author);
    }
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public int getYear(){return year;}
}
