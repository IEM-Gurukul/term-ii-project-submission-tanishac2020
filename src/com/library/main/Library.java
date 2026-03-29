package com.library.main;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    // ADD BOOK
    public void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    // UPDATE BOOK
    public void updateBook(int id, String title, String author) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(title);
                b.setAuthor(author);
                System.out.println("Book updated!");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // DELETE BOOK
    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
        System.out.println("Book deleted!");
    }

    // SEARCH
    public void searchByTitle(String key) {
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(key.toLowerCase()))
                b.display();
        }
    }

    public void searchByAuthor(String key) {
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(key.toLowerCase()))
                b.display();
        }
    }

    public void searchById(int id) {
        for (Book b : books) {
            if (b.getId() == id)
                b.display();
        }
    }

    // DISPLAY
    public void showAvailableBooks() {
        for (Book b : books)
            if (!b.isIssued()) b.display();
    }

    public void showAllBooks() {
        for (Book b : books) b.display();
    }

    // ISSUE / RETURN
    public void issueBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && !b.isIssued()) {
                b.issueBook();
                System.out.println("Issued!");
                return;
            }
        }
        System.out.println("Not available!");
    }

    public void returnBook(int id) {
        for (Book b : books) {
            if (b.getId() == id && b.isIssued()) {
                b.returnBook();
                System.out.println("Returned!");
                return;
            }
        }
        System.out.println("Invalid!");
    }

    // MEMBERS
    public void addMember(Member m) {
        members.add(m);
        System.out.println("Member added!");
    }

    public void showMembers() {
        for (Member m : members) m.display();
    }

    // STATS
    public void showStats() {
        int issued = 0;
        for (Book b : books)
            if (b.isIssued()) issued++;

        System.out.println("Total Books: " + books.size());
        System.out.println("Issued Books: " + issued);
        System.out.println("Available Books: " + (books.size() - issued));
        System.out.println("Total Members: " + members.size());
    }
}