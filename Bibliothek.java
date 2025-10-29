import java.util.*;
import java.util.function.BiConsumer;

public class Bibliothek {

    Map<String, Set<String>> bibliothek = new HashMap<>();

    public void addBook(String titel, String autor) {
        Set<String> bucher = bibliothek.get(titel);
        if (bucher == null) {
            bucher = new HashSet<>();
            bibliothek.put(titel, bucher);
        }
        if (!bucher.contains(autor)) {
            bucher.add(autor);
        }
    }

    public boolean removeBook(String titel, String author) {
        Set<String> authors = bibliothek.get(titel);
        if (authors == null) {
            System.out.println("Leer . Fehler!");
            return false;
        }
        boolean losch = authors.remove(author);
        if (losch) {
            System.out.println("INFO ;" + author + "als Autor für" + titel + "entfernt.");
            if (authors.isEmpty()) {
                bibliothek.remove(titel);
                System.out.println("Da keine Autoren mehr vorhanden, wurde der Titel `" + titel + "komplett entfernt");
            }
            return true;
        } else {
            System.out.println("Fehler" + author + "war nicht als Autor für " + titel + "eingetragen");
            return false;
        }
    }

    public List<String> allAutorList() {
        System.out.println("####Alle Autoren in der Bibliothek####");
        Set<String> allAutorset = new HashSet<>();
        for (Set<String> a : bibliothek.values()) {
            allAutorset.addAll(a);
        }

        return new ArrayList<>(allAutorset);
    }

    public void listBookAutor(String autor) {
        System.out.println("---\nBucher von" + autor + "------");
        List<String> findBook = new ArrayList<>();
        for (Map.Entry<String, Set<String>> eintrag : bibliothek.entrySet()) {

            String titel = eintrag.getKey();
            Set<String> autorens = eintrag.getValue();

            if (autorens.contains(autor)) {
                findBook.add(titel);
            }
        }
        if (findBook.isEmpty()) {
            System.out.println("Keine Bucher von diesem Autor gefunden");
        } else {
            for (String s : findBook) {
                System.out.println("-" + s);
            }
        }
    }

    public void searchAutorTitel ( String titel ) {
        System.out.println("\n---Suche Autoren für" + titel+ "---");
        Set<String> autoren = bibliothek.get(titel);
        if (autoren != null && !autoren.isEmpty()) {
            for (String s : autoren) {
                System.out.println("----" + s);
            }
        } else {
            System.out.println("Dieser Titel wurde nicht in der Bibliothek gefunden.");
        }
    }
    public void listAll () {
        System.out.println("\n---Alle Titel in der Bibliothek");
        for (Map.Entry<String,Set<String>> a : bibliothek.entrySet()) {
            String titels = a.getKey();
            Set<String> authors = a.getValue();
            System.out.printf("'%s' von %s\n", authors,titels);
        }
        //bibliothek.foreach((titel,autoren) -> { soutf("'%s' von %s\n" , titel,autoren);});
    }

    public static void main(String[] args) {
        Bibliothek bib = new Bibliothek();
        bib.addBook("Die Verwandlung", "Franz Kafka");
        bib.addBook("Faust" , "Johann Wolfgang von Goethe");
        bib.addBook("Analyse" , "Sigmund Freud");
        bib.addBook("Analyse" , "Carl Jung");

        bib.listAll();

        List<String> alleAutoren = bib.allAutorList();
        System.out.println("Gefundene Autoren ; " + alleAutoren);

        bib.listBookAutor("Franz Kafka");

        bib.searchAutorTitel("Analyse");

        System.out.println("\n--- Entfernen eines Autors ---");
        bib.removeBook("Analyse" , "Carl Jung") ;
        bib.searchAutorTitel("Analyse");

        System.out.println("\n--- Buch Komplett Entfernen ---");
        bib.removeBook("Faust" , "Johann Wolfgang von Goethe");
        bib.searchAutorTitel("Faust");

    }


}
