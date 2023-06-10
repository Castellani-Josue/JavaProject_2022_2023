package Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesPerso
{
   public static void PropertiesTest()
   {
       try {

           Properties prop = new Properties();
           prop.load(new FileInputStream("Image.properties"));
           prop.list(System.out);
       }
       catch(FileNotFoundException e)
       {
           System.out.println("Erreur ! Fichier non trouve...");
       }
       catch(IOException e)
       {
           System.out.println("Erreur IO !");
       }
   }
}
