/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author instalador
 */
public class Prueba {

    public static void escribirFile(File fiche)   {
        // Creamos un fichero para escribir en él
        FileWriter fw=null; //True hace que se sobreescriba el fichero y mantenga el contenido anterior.
        try {
            fw = new FileWriter(fiche, true);
            fw.write("holaaaa" + "\n");
            System.out.println("Datos guardados correctamente 1.");
            System.out.println("-----------------------------");
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void escribirPrinter(File ficha) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(ficha);
            for (int i = 0; i < 10; i++) {
                pw.println("Guardando: " + i);
            }
            System.out.println("Datos guardados correctamente 2.");
            System.out.println("-----------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != ficha) {
                pw.close();
            }
        }
    }

    public static void escribirBuffer(File fich)  {
        BufferedWriter salida =null;
        try {
            salida = new BufferedWriter(new FileWriter(fich, true));
            salida.write("Si señor!!" + "\n");
            System.out.println("Datos guardados correctamente 3.");
            System.out.println("-----------------------------");
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            if (null != fich) {
                try {
                    salida.close();
                } catch (IOException ex) {
                    Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
//Lee caracter por caracter. No es muy eficiente
    public static void leerFile()  { 
        
        String texto = "";
        int c;
        FileReader leer1 = null;
        try {
            leer1 = new FileReader("C:\\Users\\Instalador\\Desktop\\LeerFile.txt");
            c = leer1.read();
           while (c != -1) {
                texto = texto + (char) c;   
                c = leer1.read();
            }  
        System.out.println("Leyendo..." + "\n");
        }catch (FileNotFoundException ex) { 
            System.out.println("Salta la excepcion");
             ex.printStackTrace(); 
            }   catch (IOException e) {
            e.getStackTrace();
        }  
         finally {
            try {
                leer1.close();
            } catch (IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(texto);
        }

    }
//Lee frases enteras. Es mas eficiente.
    public static void leerFichero(String direccion)  {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(direccion);
            br = new BufferedReader(fr);
            String linea;
            System.out.println("Leyendo fichero enviado:"+ "\n");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null || br !=null) {
                try {
                    fr.close();
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
public static void borrar(File fichero){
    fichero.delete();
  
    System.out.println("Fichero borrado");    
            
    
}
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        
            File fichero = new File("C:\\Users\\Instalador\\Desktop", "Escritura.txt");
            File ficha = new File("C:\\Users\\Instalador\\Desktop", "Escritura2.txt");
            File fichu = new File("C:\\Users\\Instalador\\Desktop", "Escritura3.txt");

            fichero.createNewFile();
            ficha.createNewFile();

            escribirFile(fichero);
            escribirPrinter(ficha);
            escribirBuffer(fichu);
            
            leerFile();
            System.out.println("------------------------");
            leerFichero("C:\\Users\\Instalador\\Desktop\\LeerFile.txt");
            borrar(fichero);
    }
}
