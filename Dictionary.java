import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Dictionary {
    // Crear los árboles binarios de búsqueda
    BinaryTree<Association<String, String>> englishTree = new BinaryTree<>();
    BinaryTree<Association<String, String>> spanishTree = new BinaryTree<>();
    BinaryTree<Association<String, String>> frenchTree = new BinaryTree<>();

    
    public void crearAsociacion() throws FileNotFoundException{
        // Cargar las asociaciones del archivo de diccionario
        Scanner scanner = new Scanner(new File("diccionario.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length != 3) {
                // omitir líneas con formato incorrecto
                continue;
            }
            String englishWord = parts[0].toLowerCase().trim();
            String spanishWord = parts[1].toLowerCase().trim();
            String frenchWord = parts[2].toLowerCase().trim();

            // Crear las asociaciones
            Association<String, String> englishAssoc = new Association<>(englishWord, spanishWord, frenchWord);
            Association<String, String> spanishAssoc = new Association<>(spanishWord, englishWord, frenchWord);
            Association<String, String> frenchAssoc = new Association<>(frenchWord, englishWord, spanishWord);

            // Insertar las asociaciones en los árboles binarios de búsqueda
            englishTree.insert(englishAssoc);
            spanishTree.insert(spanishAssoc);
            frenchTree.insert(frenchAssoc);
        }
        scanner.close();

    }

    public void In_order(int idioma){
        switch(idioma){
            case 1:
                englishTree.printInOrder();
                break;
            case 2:
                spanishTree.printInOrder();
                break;
            case 3:
                frenchTree.printInOrder();
                break;

        }

    }

    public String translate(int idioma) throws FileNotFoundException{
        String resultado = "";
        boolean English = false;
        boolean Spanish = false;
        boolean French =false;
        Scanner sentence = new Scanner(new File("texto.txt"));
        while(sentence.hasNextLine()){
            String sentence1 = sentence.nextLine();
            if (sentence1.endsWith(".")) {
                sentence1 = sentence1.substring(0, sentence1.length() - 1);
            }
            String[] words = sentence1.split(" ");
            for(int i=0;i<words.length;i++){
                if(englishTree.contains(words[i].toLowerCase())){
                    English = true;
                }
                else if(spanishTree.contains(words[i].toLowerCase())){
                    Spanish = true;
                }
                else if(frenchTree.contains(words[i].toLowerCase())){
                    French = true;
                }
            }
            switch(idioma){
                case 1://traducir a ingles
                    if(Spanish){//la oración está en español
                        for(int i=0;i<words.length-1;i++){
                            if(spanishTree.contains(words[i])){
                                words[i]=spanishTree.getValue(words[i]).getValue1();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(spanishTree.contains(words[words.length-1])){
                            words[words.length-1]=spanishTree.getValue(words[words.length-1]).getValue1();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    else if(French){//La oración estaba en frances
                        for(int i=0;i<words.length-1;i++){
                            if(frenchTree.contains(words[i])){
                                words[i]=frenchTree.getValue(words[i]).getValue1();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(frenchTree.contains(words[words.length-1])){
                            words[words.length-1]=frenchTree.getValue(words[words.length-1]).getValue1();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    break;
                case 2: //traducir a español
                    if(English){//la oracion estaba en ingles
                        for(int i=0;i<words.length-1;i++){
                            if(englishTree.contains(words[i])){
                                words[i]=englishTree.getValue(words[i]).getValue1();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(englishTree.contains(words[words.length-1])){
                            words[words.length-1]=englishTree.getValue(words[words.length-1]).getValue1();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    else if(French){//la oracion estaba en frances
                        for(int i=0;i<words.length-1;i++){
                            if(frenchTree.contains(words[i])){
                                words[i]=frenchTree.getValue(words[i]).getValue2();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(frenchTree.contains(words[words.length-1])){
                            words[words.length-1]=frenchTree.getValue(words[words.length-1]).getValue2();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    break;
                case 3: //traducir a frances
                    if(Spanish){
                        for(int i=0;i<words.length-1;i++){
                            if(spanishTree.contains(words[i])){
                                words[i]=spanishTree.getValue(words[i]).getValue2();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(spanishTree.contains(words[words.length-1])){
                            words[words.length-1]=spanishTree.getValue(words[words.length-1]).getValue2();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    else if(English){
                        for(int i=0;i<words.length-1;i++){
                            if(englishTree.contains(words[i])){
                                words[i]=englishTree.getValue(words[i]).getValue2();
                                resultado+=words[i]+" ";
                            }
                            else{
                                resultado+="*"+words[i]+"* ";
                            }
                        }
                        if(englishTree.contains(words[words.length-1])){
                            words[words.length-1]=englishTree.getValue(words[words.length-1]).getValue2();
                            resultado+=words[words.length-1]+".";
                        }
                        else{
                            resultado+="*"+words[words.length-1]+"*.";
                        }
                    }
                    break;
            }

        }
        
            
        return resultado;
    }
    
}
