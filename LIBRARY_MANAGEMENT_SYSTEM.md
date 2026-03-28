# Library Management System - Java Project

## Project Overview

This is a complete **Object-Oriented Programming (OOP)** based **Library Management System** implemented in Java. The system provides a menu-driven console application for managing books, members, and library operations.

## Features

### Book Management
- ✓ Add new books with auto-generated IDs
- ✓ Update book details (title and author)
- ✓ Delete books (only if not issued to members)
- ✓ Search books by:
  - Title (keyword search)
  - Author (keyword search)
  - ID (exact match)
- ✓ Display all books with availability status
- ✓ Display only available books

### Member Management
- ✓ Add new members with auto-generated IDs
- ✓ View all registered members
- ✓ Track issued books per member
- ✓ Maintain member records

### Issue & Return Operations
- ✓ Issue books to members (with availability checks)
- ✓ Return books from members
- ✓ Prevent issues to unavailable books
- ✓ Prevent returns from wrong members

### Library Statistics
- ✓ Display total books in library
- ✓ Display available vs issued books count
- ✓ Display total registered members

## OOP Concepts Applied

### 1. **Encapsulation**
- Private fields with public getters/setters
- Data hiding and controlled access
- Example: Book and Member classes

### 2. **Abstraction**
- LibraryManager service class abstracts complex operations
- Users interact via simple menu-driven interface
- Internal implementation details are hidden

### 3. **Inheritance & Polymorphism**
- Exception handling with custom error messages
- Polymorphic behavior through method overloading and @Override methods
- toString() method overriding for display

### 4. **Single Responsibility Principle**
- Book: Manages book data
- Member: Manages member data
- LibraryManager: Handles all library operations
- Main: Provides user interface

## Project Structure

```
src/
├── com/
│   └── library/
│       ├── model/
│       │   ├── Book.java          (Book data model with encapsulation)
│       │   └── Member.java        (Member data model with encapsulation)
│       ├── service/
│       │   └── LibraryManager.java (Business logic and operations)
│       └── main/
│           └── Main.java          (Entry point with menu interface)
README.md (This file)
```

## Class Descriptions

### 1. Book.java (`com.library.model`)
Represents a book entity with the following attributes:
- `id`: Unique identifier (auto-generated)
- `title`: Title of the book
- `author`: Author of the book
- `available`: Boolean flag for availability status
- `memberId`: ID of the member who has issued the book (0 if not issued)

**Methods:**
- Constructors and getters/setters
- `toString()`: Returns string representation

### 2. Member.java (`com.library.model`)
Represents a library member with the following attributes:
- `memberId`: Unique identifier (auto-generated)
- `name`: Name of the member
- `issuedBookIds`: List of book IDs issued to this member

**Methods:**
- Constructors and getters/setters
- `addIssuedBook()`: Add a book to member's issued list
- `removeIssuedBook()`: Remove a book from member's issued list
- `hasBook()`: Check if member has a specific book
- `getIssuedBooksCount()`: Get count of issued books
- `toString()`: Returns string representation

### 3. LibraryManager.java (`com.library.service`)
Core service class that handles all library operations:

**Book Operations:**
- `addBook(title, author)`: Add new book to library
- `updateBook(id, title, author)`: Update book details
- `deleteBook(id)`: Remove book from library
- `searchByTitle(keyword)`: Search books by title
- `searchByAuthor(keyword)`: Search books by author
- `findBookById(id)`: Find specific book by ID
- `getAvailableBooks()`: Get list of available books
- `getAllBooks()`: Get all books in library

**Member Operations:**
- `addMember(name)`: Add new member
- `findMemberById(id)`: Find specific member
- `getAllMembers()`: Get all members
- `displayAllMembers()`: Display formatted member list

**Issue/Return Operations:**
- `issueBook(bookId, memberId)`: Issue book to member with validation
- `returnBook(bookId, memberId)`: Return book from member with validation

**Utility Methods:**
- `displayAvailableBooks()`: Display available books in formatted table
- `getTotalBooks()`: Get book count
- `getTotalAvailableBooks()`: Get available books count
- `getTotalMembers()`: Get member count

### 4. Main.java (`com.library.main`)
Entry point of the application with menu-driven interface:

**Features:**
- Menu display and user input handling
- Calls appropriate LibraryManager methods based on user choice
- Exception handling and error messages
- Sample data initialization on startup
- Formatted display of books and members

## Compilation Instructions

### Using Command Prompt (Windows)

1. **Navigate to the project directory:**
   ```
   cd c:\Users\tanis\java\term-ii-project-submission-tanishac2020
   ```

2. **Compile all Java files:**
   ```
   javac -d bin src/com/library/model/*.java src/com/library/service/*.java src/com/library/main/*.java
   ```

   OR compile from src directory:
   ```
   cd src
   javac -d ..\bin com/library/model/*.java com/library/service/*.java com/library/main/*.java
   ```

3. **Verify compilation:**
   The `bin` directory should now contain `.class` files in the package structure:
   ```
   bin/
   └── com/
       └── library/
           ├── model/
           │   ├── Book.class
           │   └── Member.class
           ├── service/
           │   └── LibraryManager.class
           └── main/
               └── Main.class
   ```

## Execution Instructions

### Run the Application

1. **Navigate to project root directory:**
   ```
   cd c:\Users\tanis\java\term-ii-project-submission-tanishac2020
   ```

2. **Run the Main class:**
   ```
   java -cp bin com.library.main.Main
   ```

## Sample Usage / Menu Interaction

```
╔═══════════════════════════════════════════╗
║    WELCOME TO LIBRARY MANAGEMENT SYSTEM   ║
╚═══════════════════════════════════════════╝

✓ Sample data loaded successfully!
  - 5 books added
  - 3 members added

===== LIBRARY MANAGEMENT SYSTEM =====
1.  Add Book
2.  Update Book
3.  Delete Book
4.  Search Book by Title
5.  Search Book by Author
6.  Search Book by ID
7.  Display Available Books
8.  Display All Books
9.  Issue Book to Member
10. Return Book from Member
11. Add Member
12. Display All Members
13. Display Statistics
0.  Exit
=====================================
Enter your choice: 7

=== Available Books ===
ID    Title                          Author
------------------------------------------------------------
1     Java Programming              Herbert Schildt
2     Effective Java                Joshua Bloch
3     Clean Code                    Robert C. Martin
4     Design Patterns               Gang of Four
5     The Pragmatic Programmer      Andrew Hunt

Enter your choice: 9
Enter book ID to issue: 1
Enter member ID: 1

✓ Book 'Java Programming' has been successfully issued to John Doe

Enter your choice: 8

=== All Books in Library ===
ID    Title                          Author                    Status
------------------------------------------------------------------------
1     Java Programming              Herbert Schildt           Issued (M1)
2     Effective Java                Joshua Bloch              Available
3     Clean Code                    Robert C. Martin          Available
4     Design Patterns               Gang of Four              Available
5     The Pragmatic Programmer      Andrew Hunt               Available

Enter your choice: 12

=== Library Members ===
ID    Name                           Issued Books
-------------------------------------------------------
1     John Doe                       1
2     Jane Smith                     0
3     Alice Johnson                  0

Enter your choice: 13

=== Library Statistics ===
Total Books: 5
Available Books: 4
Issued Books: 1
Total Members: 3

Enter your choice: 0

╔═══════════════════════════════════════════╗
║  Thank you for using Library Management   ║
║              System. Goodbye!              ║
╚═══════════════════════════════════════════╝
```

## Exception Handling

The system handles various error conditions gracefully:

### Book Operations
- Empty title or author validation
- Book not found errors
- Cannot delete issued books
- Invalid book IDs

### Member Operations
- Empty member name validation
- Member not found errors
- Invalid member IDs

### Issue/Return Operations
- Book not available exceptions
- Book issued to different member exceptions
- Member not found exceptions
- Book not issued exceptions

### Input Validation
- Invalid menu choices
- Non-numeric inputs for IDs
- Handled with user-friendly error messages

## Key Implementation Details

1. **Dynamic ID Generation:**
   - Auto-incrementing IDs for books and members
   - nextBookId and nextMemberId counters

2. **List Management:**
   - ArrayList<Book> for flexible book storage
   - ArrayList<Member> for flexible member storage
   - List tracking of issued books per member

3. **Search Operations:**
   - Case-insensitive keyword searches
   - Efficient linear search for small datasets
   - Partial matching support for title and author

4. **Data Persistence:**
   - In-memory storage during session
   - Sample data initialization on startup
   - Data lost on application exit (no file persistence)

5. **User Interface:**
   - Formatted console output with tables
   - Clear error messages and success confirmations
   - Input validation with retry loops

## Limitations & Future Enhancements

### Current Limitations
- In-memory storage only (no database)
- No data persistence to files
- No user authentication
- Single-threaded application
- No concurrent member access

### Possible Future Enhancements
- File-based persistence (serialization)
- Database integration (SQL)
- User authentication and roles
- Multi-threaded operation
- Web-based GUI
- Overdue book tracking
- Fine calculation for late returns
- Book availability reservation
- Email notifications

## Code Quality Features

✓ **Comments:** Comprehensive comments explaining all methods and classes
✓ **Naming Conventions:** Clear, self-descriptive variable and method names
✓ **Encapsulation:** Private fields with public getters/setters
✓ **Error Handling:** Try-catch blocks and exception messages
✓ **Modularity:** Separation of concerns across packages
✓ **DRY Principle:** No code duplication

## Testing Recommendations

1. Test all CRUD operations for books
2. Test all CRUD operations for members
3. Test book issue with:
   - Available books
   - Unavailable books
   - Non-existent books
   - Non-existent members
4. Test book return with various scenarios
5. Test search operations with valid and invalid data
6. Test menu with invalid inputs
7. Test with edge cases (empty library, single book, etc.)

## Author Notes

This project demonstrates proper OOP principles and is suitable for:
- Learning Object-Oriented Programming concepts
- Understanding package structure and organization
- Learning exception handling in Java
- Console-based application development
- Working with ArrayList and collections
- Menu-driven program design

---

## Quick Reference

| Operation | Command |
|-----------|---------|
| Compile | `javac -d bin src/com/library/model/*.java src/com/library/service/*.java src/com/library/main/*.java` |
| Run | `java -cp bin com.library.main.Main` |
| Add Book | Menu option 1 |
| Issue Book | Menu option 9 |
| Return Book | Menu option 10 |
| View Available | Menu option 7 |
| Search Books | Menu options 4, 5, or 6 |

---

**Date Created:** March 2026
**Java Version:** Java 8 or higher
**Status:** Complete and Ready for Use
