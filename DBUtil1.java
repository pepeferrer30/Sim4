/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacro.pkg4;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Joan_2k2
 */
public class DBUtil1 {

    private Connection conn;
     
    public String nombreUsuario = "";
    public String password = "";
    public String puerto = "";
    public String host = "";
    public String error="";
    public String bdd="";
    private static DBUtil1 db;

    public Connection getConexion() {

        try {
            String cadenaConexion = "jdbc:mysql://"+DBUtil1.getDBUtil().host+ ":"+DBUtil1.getDBUtil().puerto+"/"+DBUtil1.getDBUtil().bdd;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(cadenaConexion, DBUtil1.getDBUtil().nombreUsuario,DBUtil1.getDBUtil().password);
            return this.conn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void cerrarConexion() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public synchronized static DBUtil1 getDBUtil(){
        if(db==null){
            db=new DBUtil1();
        }
        return db;
    }

}