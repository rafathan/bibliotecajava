/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;


/**
 *
 * @author Rafathan
 */
public class Libro {


    private String titulo;
    private String autor;
    private String isbn;

    String consulta_autor() {
        return autor;
    }

    void cambia_autor(String autor) {
        this.autor = autor;
    }

    String consulta_titulo() {
        return titulo;
    }

    void cambia_titulo(String titulo) {
        this.titulo = titulo;
    }

    String consulta_isbn() {
        return isbn;
    }

    void cambia_isbn(String isbn) {
        isbn = quitarGuiones (isbn);
        
        if (isbn.length() == 10) {
            if (compruebaIsbn10(isbn) == false) {
                throw new IllegalArgumentException("ISBN no válido");
            }
        } else if (isbn.length() == 13) {
            if (compruebaIsbn13(isbn) == false) {
                throw new IllegalArgumentException("ISBN no válido");
            }
        } else {
            throw new IllegalArgumentException("ISBN no válido");
        }
        this.isbn = isbn;
    }

    private boolean compruebaIsbn10(String isbn) {

        int total = 0;
        int cifra;

        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                if ( (isbn.charAt(i) == 'X')||(isbn.charAt(i) == 'x') ) {
                    cifra = 10;
                } else {
                    cifra = Integer.parseInt(isbn.substring(i, i + 1));
                }
            } else {
                cifra = Integer.parseInt(isbn.substring(i, i + 1));
            }

            total = total + ((i + 1) * cifra);
        }
        if ((total % 11) == 0) {
            return true;
        } else {
            return false;
        }

    }

    private boolean compruebaIsbn13(String isbn) {

        int total = 0;
        int cifra;

        for (int i = 0; i < 12; i++) {
            if ((i % 2) == 0) {
                cifra = Integer.parseInt(isbn.substring(i, i + 1));
            } else {
                cifra = ((Integer.parseInt(isbn.substring(i, i + 1))) * 3);
            }
            total = total + cifra;
        }
        if ((10 - (total % 10)) == (Integer.parseInt(isbn.substring(12)))) {
            return true;
        } else {
            return false;
        }
    }

    private String quitarGuiones(String isbn) {
        isbn = isbn.replaceAll("-", "");
        return isbn;
    }
}