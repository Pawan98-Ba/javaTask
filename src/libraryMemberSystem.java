class BorrowLimitExceededException extends Exception {
    public BorrowLimitExceededException(String message) {
        super(message);
    }
}

abstract class LibraryMember {
    private String name;
    private int borrowedBooks;

    public LibraryMember(String name) {
        this.name = name;
        this.borrowedBooks = 0;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    protected void borrowOneBook() {
        borrowedBooks++;
    }

    public abstract void borrowBook() throws BorrowLimitExceededException;
}

class Student extends LibraryMember {
    public Student(String name) {
        super(name);
    }
    @Override
    public void borrowBook() throws BorrowLimitExceededException {
        if (getBorrowedBooks() >= 3)
            throw new BorrowLimitExceededException("Student limit exceeded!");
        borrowOneBook();
        System.out.println("Student borrowed book. Total: " + getBorrowedBooks());
    }
}

class Teacher extends LibraryMember {
    public Teacher(String name) {
        super(name);
    }
    @Override
    public void borrowBook() throws BorrowLimitExceededException {
        if (getBorrowedBooks() >= 5)
            throw new BorrowLimitExceededException("Teacher limit exceeded!");
        borrowOneBook();
        System.out.println("Teacher borrowed book. Total: " + getBorrowedBooks());
    }
}

class Guest extends LibraryMember {
    public Guest(String name) {
        super(name);
    }
    @Override
    public void borrowBook() throws BorrowLimitExceededException {
        if (getBorrowedBooks() >= 1)
            throw new BorrowLimitExceededException("Guest limit exceeded!");
        borrowOneBook();
        System.out.println("Guest borrowed book. Total: " + getBorrowedBooks());
    }
}

public class libraryMemberSystem {
    public static void main(String[] args) {
        try {
            LibraryMember s = new Student("Alice");
            LibraryMember t = new Teacher("Bob");
            LibraryMember g = new Guest("John");

            s.borrowBook();
            t.borrowBook();
            g.borrowBook();


        } catch (BorrowLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



