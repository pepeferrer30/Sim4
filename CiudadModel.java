/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simulacro.pkg4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class CiudadModel extends DBUtil1{
    
     public ArrayList<Ciudad> MostrarTodo(String consulta) {
        ArrayList<Ciudad> alma = new ArrayList();

        try {
            PreparedStatement smt = this.getConexion().prepareStatement(consulta);//la consulta es select * from libro
            ResultSet rs = smt.executeQuery();

            while (rs.next()) {
                int id =Integer.parseInt(rs.getString("ID")) ;
                String name = rs.getString("Name");
                String countrycode = rs.getString("CountryCode");
                String district = rs.getString("District");
                int population =Integer.parseInt( rs.getString("Population"));
                
                Ciudad c = new Ciudad(id, name, countrycode, district, population);
                alma.add(c);

            }

        }  catch (SQLException e) {
            DBUtil1.getDBUtil().error=e.toString();
        }

        return alma;
    }
     public void ejecutar(String consulta) throws SQLException {

        try {
            PreparedStatement smt = this.getConexion().prepareStatement(consulta);
            smt.executeUpdate();
        } catch (SQLException e) {
            DBUtil1.getDBUtil().error=e.toString();
        }

    }
    
}
