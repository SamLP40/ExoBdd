/**
 * Programme de configuration qui lit le fichier config.properties permettant la connexion à MariaDB.
 * @author Le-porcherS 3-3-2023
 */
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class CreateConfigFile {

	  public static void main(String args[]) throws IOException {
	      Properties prop = readPropertiesFile("lib/config.properties");
	      System.out.println("username: "+ prop.getProperty("db.login")); // récup du login dans config
	      System.out.println("password: "+ prop.getProperty("db.password")); // recup du mdp dans config

	      try {
	    
	    	  BufferedWriter file = new BufferedWriter(new FileWriter("config.properties"));
	    	  file.newLine();
	    	  file.write("username:"+ prop.getProperty("db.login"));
	    	  file.write("password: "+prop.getProperty("db.password"));
	    	  
	    	  file.close();
	      } catch (Exception e) {
	    	  
	    	  e.printStackTrace();
	      }
	     
	   }
	   public static Properties readPropertiesFile(String fileName) throws IOException {
	      FileInputStream fis = null;
	      Properties prop = null;
	      try {
	         fis = new FileInputStream(fileName);
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }

	      return prop;
	   }
}
