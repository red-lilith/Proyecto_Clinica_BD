package Acceso_Datos;

import java.sql.*;

public class Acceso_BD {
    String url, usuario, password;
    Connection conexion =null;
    Statement instruccion;
    ResultSet tabla;
    public Acceso_BD() {
        url = "jdbc:postgresql://localhost:5432/clinica";
        usuario = "diana";
        password = "mefistofeles";
        conectar();
    }

    public Connection conectar(){
        try {
            // Se carga el driver
            Class.forName("org.postgresql.Driver");
        } catch( Exception e ) {
            System.out.println( "No se pudo cargar el Driver" );
        }

        try{
            //Crear el objeto de conexion a la base de datos
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println( "Conexión Exitosa" );
            return conexion;
            //Crear objeto Statement para realizar queries a la base de datos
        } catch( Exception e ) {
            System.out.println( "Error de Conexión" );
            return null;
        }

    }//end connect

    public Connection getConnetion(){
        if (conexion == null) {
            return this.conectar();
        }
        else{
            return conexion;
        }

    }

    public void closeConnection(Connection c){
        try{
            if (conexion != null){
                c.close();
            }

        } catch( Exception e ) {
            System.out.println( "Error al cerrar la conexión" );
        }
    }

}