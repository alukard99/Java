import java.io.File;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Alukard
 */
public class MiOS {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if("copiar".equals(args[0])){
            copiar(args[1],args[2]);
        }
        if("ver".equals(args[0])){
            
        }
    }
    public static void copiar(String rutaF1,String rutaF2) throws FileNotFoundException, IOException{
        File rutaL = new File(rutaF1);
        File rutaE = new File(rutaF2);
        if(rutaL.exists()){
            if(rutaE.exists()){
                System.out.println("Sobreescribir? s/N");
                Scanner entrada = new Scanner(System.in);
                String sob;
                do{
                    sob = entrada.nextLine();
                }
                while(!"y".equals(sob) && !"n".equals(sob));
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
}
