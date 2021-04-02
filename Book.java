import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "book")

public class Book {

    @Id
    Integer id;

    @Column(name = "name")
    private String name;

    public Book() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne(optional = false, mappedBy="book")
    public Author author;
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "book")
    private Set<Author> users;

    public Set<Author> getUsers() {
        return users;
    }
    public void setUsers(Set<Author> users) {
        this.users = users;
    }


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
    private Set<Author> users;

    public Set<Author> getUsers() {
        return users;
    }

    public void setUsers(Set<Author> users) {
        this.users = users;
    }


}

