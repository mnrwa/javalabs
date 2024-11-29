package ru.bahanov.pracJava.task5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Catalog {

    public class Issue {
        private String nameBook;
        private String nameReader;
        private Date issueDate;
        private Date returnDate;

        public Issue(String nameBook, String nameReader, Date issueDate, Date returnDate) {
            this.nameBook = nameBook;
            this.nameReader = nameReader;
            this.issueDate = issueDate;
            this.returnDate = returnDate;
        }

        public Date getIssueDate() {
            return issueDate;
        }

        public Date getReturnDate() {
            return returnDate;
        }

        public String getNameBook() {
            return nameBook;
        }

        public String getNameReader() {
            return nameReader;
        }

        @Override
        public String toString() {
            return "Книга: " + nameBook + ", Читатель: " + nameReader + ", Дата выдачи: " + issueDate + ", Дата возврата: " + returnDate;
        }
    }

    public List<Issue> getIssues() {
        return issues;
    }

    private List<Issue> issues;

    public Catalog() {
        this.issues = new ArrayList<>();
    }

    public void addIssue(String nameBook, String nameReader, Date issueDate, Date returnDate) {
        Issue addIs = new Issue(nameBook, nameReader, issueDate, returnDate);
        issues.add(addIs);
    }

    public void printIssue() {
        for (Issue issue : issues) {
            System.out.println(issue);
        }
    }

    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        catalog.addIssue("Java from EPAM", "Баханов Владимир", new Date(), new Date());
        catalog.addIssue("Readme", "Дмитрий Иванов", new Date(), new Date());


        catalog.printIssue();
    }
}
