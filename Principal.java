/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;

/**
 *
 * @author Rafathan
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     int opcion = 3;
        Scanner reader = new Scanner(System.in);
        boolean error;
        Libro l = new Libro();

        while (opcion != 0) {

            System.out.print("\nMENU\n0-Salir\n1-Nuevo libro.\n2-Ver libro almacenado.\n");
            do {
                try {
                    System.out.print("Seleccion: ");
                    opcion = Integer.parseInt(reader.next());
                    error = false;
                } catch (NumberFormatException a) {
                    System.out.println("Opcion incorrecta.");
                    error = true;
                }
                if ((opcion < 0) || (opcion > 2)) {
                    System.out.println("Opcion incorrecta.");
                    error = true;
                }
            } while (error);
            
            if (opcion == 1) {
                reader.nextLine();
                System.out.print("Titulo del libro: ");
                l.cambia_titulo(reader.nextLine());
                
                System.out.print("Autor del libro: ");
                l.cambia_autor(reader.nextLine());

                do {
                    try {
                        System.out.print("ISBN del libro: ");
                        l.cambia_isbn(reader.nextLine());
                        error = false;
                    } catch (IllegalArgumentException a) {
                        System.out.println("Codigo ISBN no valido.");
                        error = true;
                    }
                } while (error);
            }

            if (opcion == 2) {
                System.out.print("\n\nTitulo: " + l.consulta_titulo() + "\nAutor: " + l.consulta_autor() + "\nCodigo ISBN: " + l.consulta_isbn() + "\n\n");
            }
        }
    }

}

