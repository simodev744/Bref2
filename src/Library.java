import java.util.ArrayList;


public class Library {
    private ArrayList<Book> books;


    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }


    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("Aucun livre dans la bibliothèque.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }


    public void searchBook(String searchTerm) {
        boolean found = false;
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getIsbn().contains(searchTerm)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun livre trouvé.");
        }
    }


    public void deleteBook(String isbn) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            System.out.println("Le livre a été supprimé.");
        } else {
            System.out.println("Livre non trouvé.");
        }
    }


    public void modifyBook(String isbn, String newTitle, String newAuthor) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(newTitle);
                book.setAuthor(newAuthor);
                System.out.println("Le livre a été modifié.");
                return;
            }
        }
        System.out.println("Livre non trouvé.");
    }


    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println("Le livre a été emprunté.");
                } else {
                    System.out.println("Le livre est déjà emprunté.");
                }
                return;
            }
        }
        System.out.println("Livre non trouvé.");
    }


    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println("Le livre a été retourné.");
                } else {
                    System.out.println("Le livre n'a pas été emprunté.");
                }
                return;
            }
        }
        System.out.println("Livre non trouvé.");
    }


    public void showBookStatus() {
        System.out.println("Livres disponibles:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book);
            }
        }
        System.out.println("\nLivres empruntés:");
        for (Book book : books) {
            if (!book.isAvailable()) {
                System.out.println(book);
            }
        }
    }
}
