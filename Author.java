import javax.persistence.*;
import java.util.Set;

@Entity

@Table(name = "author")
public class Author {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;

    public Author() {


    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(optional = false)
    @JoinColumn(name="book_id", unique = true,
            nullable = false, updatable = false)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToMany
    @JoinTable(name="author_book",
            joinColumns = @JoinColumn(name="author_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="book_id", referencedColumnName="id")
    )
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }
    public void setBooks(Set<Book> books) {
        this.books = books;
    }





}

