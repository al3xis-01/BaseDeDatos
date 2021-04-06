package sql;
// 7472006014 - belen
/*
Conexion básica de mysql con java usando la libreria mysql-connector-java-8.0.23.jar



 */

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String user;
    private String pass;
    private String db_name;
    private String host_name;
    private String port;
    private String url;
    private String driver;
    private Connection connection;

    public Conexion() {
        //first constructor all automatic
        this.user = "alexis";
        this.pass = "ciber.2021";
        this.db_name = "ciber";
        this.host_name = "localhost";
        this.port = "3306";
        this.driver = "com.mysql.cj.jdbc.Driver";
        this.connection = null;
        url = "jdbc:mysql://"+host_name+":"+port+"/"+db_name;

        registrarDriver(driver);

    }

    public Conexion(String user, String pass, String db_name, String host_name, String port, String driver) {
        // second constructor in case changed user,pass,db_name, etc
        this.user = user;
        this.pass = pass;
        this.db_name = db_name;
        this.host_name = host_name;
        this.port = port;
        this.driver = driver;
        this.connection = null;


        url = "jdbc:mysql://"+host_name+":"+port+"/"+db_name;

        registrarDriver(driver);

    }

    private void registrarDriver(String driver) {
        try{
            Class.forName(driver);
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Error: "+e,
                    "ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection conectar(){
        try {
            connection = DriverManager.getConnection(url,user,pass);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+e,"ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }





    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getDb_name() {
        return db_name;
    }

    public String getHost_name() {
        return host_name;
    }

    public String getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public Connection getConnection() {
        if(connection == null) conectar();
        return connection;
    }
}
