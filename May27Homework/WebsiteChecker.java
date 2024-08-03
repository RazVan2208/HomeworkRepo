// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.awt.Desktop; 
import java.io.*; 
import java.net.URI;
import java.net.URISyntaxException; 
public class WebsiteChecker {
  public static void main(String[] args) throws IOException {
    Scanner userInput = new Scanner(System.in);
    System.out.println("User input your website: ");
    String userWebsite = userInput.nextLine();
    Desktop chrome = Desktop.getDesktop();
    
    if(checkValidation(userWebsite)){
      URI link;
    try {
        link = new URI(userWebsite);
        chrome.browse(link);
    } catch (URISyntaxException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     
      
    } else {
        System.out.println("Invalid Web URL, try again");
    }
    
  }

  static boolean checkValidation(String website){
    int validationCounter = 0;
    if(website.endsWith(".com") || website.endsWith(".ca") || website.endsWith(".org") || website.endsWith(".net")){
      validationCounter = 1;
    } else {
        return false;
    }
    if(website.startsWith("https://") || website.startsWith("https:/") || website.startsWith("http://") || website.startsWith("www.") || website.startsWith("")){
      validationCounter = 2;
    } else {
        return false;
    }
    if(validationCounter == 2){
      return true;
    }
    return false;
    
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}