import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static final String DB_URL = "jdbc:postgresql://localhost/test";
    public static final String Db_user = "postgres";
    public static final String Db_password = "1234";

    public static void main(String[] args) {

        Connection connect = null;
        String sql = "SELECT * FROM employee";

        try{
            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(DB_URL,Db_user,Db_password);
            Statement st = connect.createStatement();
            ResultSet data = st.executeQuery(sql);

            while(data.next()){
                System.out.println(" id : " + data.getInt("id"));
                System.out.println(" name : " + data.getString("name"));
                // bu şekilde diğer değerler de alınabilir.
            }

        } catch (Exception e){
            System.out.println("connection failed");
        }

    }
}