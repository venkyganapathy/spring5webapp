package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    private void initData(){

        Publisher harper = new Publisher("Harper Collins",
                "171 Laughing Waters","12th Main");
        publisherRepository.save(harper);

        Author harari = new Author("Yuval Novah","Harari");
        Book sapiens = new Book("Sapiens","12924");
        harari.getBooks().add(sapiens);
        sapiens.getAuthors().add(harari);
        sapiens.setPublisher(harper);

        authorRepository.save(harari);
        bookRepository.save(sapiens);



        Publisher milwaukee = new Publisher("Milwaukee Publishers",
                "25 Laughing Waters","10th Main");
        publisherRepository.save(milwaukee);

        Author duhigg = new Author("Charles","Duhigg");
        Book habit = new Book("Habit","12885");
        duhigg.getBooks().add(habit);
        habit.getAuthors().add(duhigg);
        habit.setPublisher(milwaukee);

        authorRepository.save(duhigg);
        bookRepository.save(habit);

    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
