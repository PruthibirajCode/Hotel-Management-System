import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Con {
    Connection co;
    Statement s;
   Con(){
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           co= DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem", "root", "Shiva123@mysql");
           s=co.createStatement();

       }catch (Exception e){
          System.out.print(e);
       }
   }
}
