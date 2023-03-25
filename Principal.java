import java.io.FileNotFoundException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        int op1=0;
        int op2=0;
        boolean continuar=true;
        Dictionary d= new Dictionary();
        d.crearAsociacion();
        while(continuar){
            op1=0;
            op2=0;
            System.out.println("Bienvenido al diccionario inglés – español - francés");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Ver el diccionario \n2. Traducir el documento \n3. Salir");
            op1=teclado.nextInt();
            teclado.nextLine();
            if(op1==1){
                System.out.println("Eliga el idioma por el que quiere ver ordenado el diccionario");
                System.out.println("1. Inglés \n2. Español \n3. Francés");
                op2=teclado.nextInt();
                teclado.nextLine();
                if(op2==1){
                    d.In_order(1);
                }
                else if(op2==2){
                    d.In_order(2);
                }
                else if(op2==3){
                    d.In_order(3);
                }
                else{
                    System.out.println("Ingrese una opción válida");
                }
            }
            else if(op1==2){
                System.out.println("Eliga el idioma al que quiere traducir el documento");
                System.out.println("1. Inglés \n2. Español \n3. Francés");
                op2=teclado.nextInt();
                teclado.nextLine();
                if(op2==1){
                    System.out.println( d.translate(1));
                }
                else if(op2==2){
                    System.out.println( d.translate(2));
                }
                else if(op2==3){
                    System.out.println( d.translate(3));
                }
                else{
                    System.out.println("Ingrese una opción válida");
                }
            }
            else if(op1==3){
                continuar=false;
            }
            else{
                System.out.println("Ingrese una opción válida");
            }
        }
    }
}
