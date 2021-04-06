package sql;

import javax.swing.*;
import java.sql.*;

public class Comando {
    private Connection con;
    private boolean status_connection;

    public Comando() {
        init();

    }

    private void init() {
        con = new Conexion().conectar();
        if(con == null) status_connection = false;
        else status_connection = true;
    }

    public ResultSet obtener(String table_name,String where){
        String consult = "SELECT * FROM " + table_name + where;;
        return obtener(consult);

    }

    public ResultSet obtener(String consult){
        if(status_connection){ // status_connection == true if conn is connected

            try {
                PreparedStatement preparedStatement = con.prepareStatement(consult);
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error : " + e,"Error",JOptionPane.ERROR_MESSAGE);
                status_connection = false;
            }
        }
        init();
        return null;
    }

    public boolean insert(String consult){
        return enterCommand(consult);
    }

    private boolean enterCommand(String consult) {
        if(status_connection){
            try {
                PreparedStatement preparedStatement = con.prepareStatement(consult);
                int value_off_execute = preparedStatement.executeUpdate(); // return x > 0, if row's is affected

                if(value_off_execute > 0){
                    return true;
                }

                return false; // PARA CAMBIAR EL NUMERO DE ROWS AFFECTADAS, CAMBIAR CODIGO DE INTERFAZ Y ADEMAS RETORNAR value_off_Execute COMO el valor
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(null,"Error: "+throwables,"ERROR",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        init();
        return false;
    }

    public boolean delete(String consult){
        return enterCommand(consult);
    }



}
