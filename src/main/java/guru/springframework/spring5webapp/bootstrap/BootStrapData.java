package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthtorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthtorRepository authtorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthtorRepository authtorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authtorRepository = authtorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author uday = new Author("Uday", "Kondla");
        Book bk1 = new Book("A New Life", "11111");
        uday.getBooks().add(bk1);
        bk1.getAuthors().add(uday);

        authtorRepository.save(uday);
        bookRepository.save(bk1);

        System.out.println("Bootstrap started");
        System.out.println("no of books: " + bookRepository.count());
        Author priya = new Author("Priya", "Dharshini");
        Book bk2 = new Book("An Old Life", "22222");
        priya.getBooks().add(bk2);
        bk2.getAuthors().add(priya);

        authtorRepository.save(priya);
        bookRepository.save(bk2);
        System.out.println("2nd time");
        System.out.println("no of books: " + bookRepository.count());

        Publisher p = new Publisher();
        p.setName("Kondla Publishers");
        p.setAddressLine1("1-2-3");
        p.setCity("manthani");
        p.setState("Telangana");
        p.setZip("505184");

        publisherRepository.save(p);
        bk1.setPublisher(p);
        p.getBooks().add(bk1);
        p.getBooks().add(bk2);
        publisherRepository.save(p);
        bookRepository.save(bk1);
        System.out.println("publisher books: " + publisherRepository.count());
        System.out.println(p.getBooks().size());
    }

}
