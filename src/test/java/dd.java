import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.Scanner; 
public class dd { 
   public static void main(String[] args) throws IOException { 
      try { 
         File csv = new File("자바-L22.txt"); 
         Scanner key = new Scanner(csv); 
        
         while (key.hasNextLine()) { 
        	key.useDelimiter("[,]"); 
            System.out.printf("%s \t", key.next()); 
            System.out.println(); 
         } 
         key.close(); 
         } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } 
   } 
} 