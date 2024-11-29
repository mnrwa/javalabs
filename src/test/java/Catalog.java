import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.bahanov.pracJava.task5.Catalog;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    private Catalog catalog;

    @BeforeEach
    void setUp() {
        catalog = new Catalog();
    }

    @Test
    void testAddIssue() {
        String bookTitle = "Java from EPAM";
        String readerName = "Баханов Владимир";
        Date issueDate = new Date();
        Date returnDate = new Date();

        catalog.addIssue(bookTitle, readerName, issueDate, returnDate);

        assertEquals(1, catalog.getIssues().size());
        Catalog.Issue issue = catalog.getIssues().get(0);

        assertEquals(bookTitle, issue.getNameBook());
        assertEquals(readerName, issue.getNameReader());
        assertEquals(issueDate, issue.getIssueDate());
        assertEquals(returnDate, issue.getReturnDate());
    }

    @Test
    void testPrintIssue() {
        catalog.addIssue("Effective Java", "Иван Петров", new Date(), new Date());

        catalog.printIssue();
    }
}
