/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package copiarunficherodetextoentornos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Clock;

/**
 *
 * @author usuario
 */
public class CopiarUnFicheroDeTextoEntornos {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        // Copia fichero de texto grande con memoria intermedia
        Clock clock1 = Clock.systemUTC();
        double millis1 = clock1.millis();
        int copy;
        FileInputStream in;
        FileOutputStream out;
        BufferedInputStream varuno = null;
        BufferedOutputStream vardos = null;
        try {
            in = new FileInputStream("Tehilim.txt");
            varuno = new BufferedInputStream(in);
            out = new FileOutputStream("copiaTehilim.txt");
            vardos = new BufferedOutputStream(out);
            while ((copy = varuno.read()) != -1) {
                vardos.write(copy);
                vardos.flush();
            }
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            if(varuno != null)
                varuno.close();
            if(vardos != null)
                vardos.close();
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        Clock clock2 = Clock.systemUTC();
        double millis2 = clock2.millis();
        System.out.println("Milisegundos que tarda: " + (millis2 - millis1));
    }
}