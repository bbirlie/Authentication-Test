import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) {

        int inputId = 12345;
        String password = "password";
        boolean verify = false;
        boolean passCheck = false;
        String passVerify;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/capstonebookstore","root","root");
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from employee");

            while (resultSet.next()) {
                if (inputId == resultSet.getInt("employeeId")) {
                    verify = true;
                }
            }
//            if(verify) {
//                passVerify = String.format("select empPassword from employee where employeeId = %s",inputId);
//                ResultSet r2 = statement.executeQuery(passVerify);
//                if(password == r2.getString("empPassword")){
//                    passCheck = true;
//                }
//                System.out.println(passCheck);
//            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }//end main
}//end