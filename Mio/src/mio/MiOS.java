package mio;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Alukard
 */
public class MiOS {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //El primer argumento debe ser copiar o ver. Decide que hará el programa.
        if ("copiar".equals(args[0])) {
            copiar(args[1], args[2]);
        }
        if ("ver".equals(args[0])) {
            ver(args[1]);
        }
    }

    public static void copiar(String rutaF1, String rutaF2) throws FileNotFoundException, IOException {
        File rutaL = new File(rutaF1);
        File rutaE = new File(rutaF2);
        if (rutaL.exists()) {
            if (rutaE.exists()) {
                System.out.println("Sobreescribir? s/N");
                Scanner entrada = new Scanner(System.in);
                String sob;
                do {
                    sob = entrada.nextLine();
                } while (!"y".equals(sob) && !"n".equals(sob));
            }
            FileInputStream leer = new FileInputStream(rutaL);
            FileOutputStream escribir = new FileOutputStream(rutaE);

            byte[] buffer = new byte[1024];
            int lon;
            while ((lon = leer.read(buffer)) > 0) {
                escribir.write(buffer, 0, lon);
            }
            leer.close();
            escribir.close();
        }
    }

    public static void ver(String ruta) throws FileNotFoundException {
        File rutaA = new File(ruta);
        File[] array = rutaA.listFiles();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName());
        }
    }
//    public static void escribir(String rutaF1,String rutaF2) throws FileNotFoundException, IOException{
//        File rutaL = new File(rutaF1);
//        if(rutaL.exists()){
//            FileReader fr = new FileReader(rutaL);
//            BufferReader bf = new BufferReader(fr)
//        }
//    }
}
