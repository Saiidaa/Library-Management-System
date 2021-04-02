import ви.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;

    public class DAO {
        public static int save(String nom,String name,String author,String publisher,int quantity){
            int status=0;


            try{
                Connection con= DB.getConnection();
                PreparedStatement ps=con.prepareStatement("insert values into books");
                ps.setString(1,nom);
                ps.setString(2,name);
                ps.setString(3,author);
                ps.setString(4,publisher);
                ps.setInt(5,quantity);
                status=ps.executeUpdate();
                con.close();
            }catch(Exception r){System.out.println(r);}
            return status;
        }
    }


