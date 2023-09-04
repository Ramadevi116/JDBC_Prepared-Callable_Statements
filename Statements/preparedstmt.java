import java.sql.*;
import java.io.*;
class preparedstmt
{
    public static void main(String[] args){
        String Driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/bankbalance";
        String userid="root";
        String psw="sql834";
	try{
        InputStreamReader i=new InputStreamReader(System.in);
        BufferedReader b=new BufferedReader(i);
	System.out.println("Enter username : ");
        String username=b.readLine();
	System.out.println("Enter password : ");
        String password=b.readLine();
        
        Class.forName(Driver);
        Connection con=DriverManager.getConnection(url,userid,psw);
        String qry="select balance from balance where userid=? and password=?";
        PreparedStatement stmt=con.prepareStatement(qry);
        stmt.setString(1,username);
        stmt.setString(2,password);
        ResultSet res=stmt.executeQuery();
        if(res.next()){
            System.out.println(res.getDouble(1));
        }else{
            System.out.println("Invalid details");
        }
        con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}