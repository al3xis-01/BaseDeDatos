package sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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




}
