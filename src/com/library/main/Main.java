package com.library.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1 Add Book");
            System.out.println("2 Update Book");
            System.out.println("3 Delete Book");
            System.out.println("4 Search by Title");
            System.out.println("5 Search by Author");
            System.out.println("6 Search by ID");
            System.out.println("7 Available Books");
            System.out.println("8 All Books");
            System.out.println("9 Issue Book");
            System.out.println("10 Return Book");
            System.out.println("11 Add Member");
            System.out.println("12 All Members");
            System.out.println("13 Statistics");
            System.out.println("0 Exit");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String t = sc.nextLine();
                    System.out.print("Author: ");
                    String a = sc.nextLine();
                    lib.addBook(new Book(id, t, a));
                    break;

                case 2:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Title: ");
                    t = sc.nextLine();
                    System.out.print("New Author: ");
                    a = sc.nextLine();
                    lib.updateBook(id, t, a);
                    break;

                case 3:
                    System.out.print("ID: ");
                    lib.deleteBook(sc.nextInt());
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Keyword: ");
                    lib.searchByTitle(sc.nextLine());
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Author: ");
                    lib.searchByAuthor(sc.nextLine());
                    break;

                case 6:
                    System.out.print("ID: ");
                    lib.searchById(sc.nextInt());
                    break;

                case 7:
                    lib.showAvailableBooks();
                    break;

                case 8:
                    lib.showAllBooks();
                    break;

                case 9:
                    System.out.print("ID: ");
                    lib.issueBook(sc.nextInt());
                    break;

                case 10:
                    System.out.print("ID: ");
                    lib.returnBook(sc.nextInt());
                    break;

                case 11:
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    lib.addMember(new Member(mid, sc.nextLine()));
                    break;

                case 12:
                    lib.showMembers();
                    break;

                case 13:
                    lib.showStats();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid!");
            }
        }
    }
}