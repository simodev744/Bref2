import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        Book fzd = new Book("sgds","qzf","dzqf23");
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Afficher les livres");
            System.out.println("2. Ajouter un livre");
            System.out.println("3. Rechercher un livre");
            System.out.println("4. Supprimer un livre");
            System.out.println("5. Modifier un livre");
            System.out.println("6. Emprunter un livre");
            System.out.println("7. Retourner un livre");
            System.out.println("8. Afficher les livres disponibles et empruntés");
            System.out.println("9. Quitter");
            System.out.print("Choisissez une option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consommer la nouvelle ligne après le choix

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Entrez le titre du livre: ");
                    String title = scanner.nextLine();
                    System.out.print("Entrez l'auteur du livre: ");
                    String author = scanner.nextLine();
                    System.out.print("Entrez l'ISBN du livre: ");
                    String isbn = scanner.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    System.out.println("Livre ajouté.");
                    break;
                case 3:
                    System.out.print("Entrez le titre, l'auteur ou l'ISBN du livre à rechercher: ");
                    String searchTerm = scanner.nextLine();
                    library.searchBook(searchTerm);
                    break;
                case 4:
                    System.out.print("Entrez l'ISBN du livre à supprimer: ");
                    String isbnToDelete = scanner.nextLine();
                    library.deleteBook(isbnToDelete);
                    break;
                case 5:
                    System.out.print("Entrez l'ISBN du livre à modifier: ");
                    String isbnToModify = scanner.nextLine();
                    System.out.print("Entrez le nouveau titre: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Entrez le nouvel auteur: ");
                    String newAuthor = scanner.nextLine();
                    library.modifyBook(isbnToModify, newTitle, newAuthor);
                    break;
                case 6:
                    System.out.print("Entrez l'ISBN du livre à emprunter: ");
                    String isbnToBorrow = scanner.nextLine();
                    library.borrowBook(isbnToBorrow);
                    break;
                case 7:
                    System.out.print("Entrez l'ISBN du livre à retourner: ");
                    String isbnToReturn = scanner.nextLine();
                    library.returnBook(isbnToReturn);
                    break;
                case 8:
                    library.showBookStatus();
                    break;
                case 9:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide. Essayez à nouveau.");
            }
        }
    }
}
