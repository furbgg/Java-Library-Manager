> **Note: Language Context**
>
> Please note that this project was written in **German** as part of my `Ausbildung` (German vocational training). Therefore, all variable names, comments, and console outputs (`System.out.println`) within the source code are in German.

---

# Java Library Manager (Console App)

## About This Project

This is a console-based application that simulates a simple library catalog. It's a classic `Ausbildung` project designed to practice **advanced `Map` collections**.

The core of this project is the use of `Map<String, Set<String>>` to correctly handle a "many-to-many" relationship: a single book (`String`) can have multiple authors (`Set<String>`).

## Key Features

* **`addBook(titel, autor)`**: Adds a book and its author. If the book title already exists, it simply adds the new author to the existing `Set`.
* **`removeBook(titel, author)`**: Removes a single author from a book. If that was the *last* author, it correctly removes the entire book (title) from the library.
* **`allAutorList()`**: Gathers all unique authors from the entire library into a single `List` for review.
* **`listBookAutor(autor)`**: Searches the entire library and finds all books associated with a specific author.
* **`searchAutorTitel(titel)`**: A simple lookup to find all authors for a specific book title.
* **`listAll()`**: Prints the entire library catalog.
