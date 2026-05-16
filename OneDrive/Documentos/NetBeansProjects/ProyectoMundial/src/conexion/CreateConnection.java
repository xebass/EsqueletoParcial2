package conexion;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateConnection {
    static Properties config = new Properties();
    
    String hostname = null;
    String port = null;
    String database = null;
    String username= null;
    String password=null;
    
    public CreateConnection(){
    InputStream in = null;
    String path= "C:\\Users\\melga\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoMundial\\src\\conexion\\db_config.properties";
    
    try {
        in = Files.newInputStream(Paths.get(path)); //leer el contenido en bytes del archivo db_config
        config.load(in); //asigna las llaves y valores del archivo db_config
        in.close(); // cerrar el archivo
    } catch(IOException ex){
        System.out.println(ex.getMessage());
    }
       loadProperties();
    }
    
    public void loadProperties (){
    
     this.hostname = config.getProperty(  "hostname" );
     this.port = config.getProperty("port");
     this.username = config.getProperty("username");
     this.password = config.getProperty("password");
     this.database = config.getProperty("database");
    
    }
    
    public Connection getConnection (){
    Connection conn = null;
    try {
        String jdbcPostgres = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
        conn = DriverManager.getConnection(jdbcPostgres, username, password);
        System.out.println("Conexion establecida");

    } catch (SQLException ex) {
        Logger.getLogger(CreateConnection.class.getName()).log(Level.SEVERE, null, ex);
    }
    return conn;
    }

    public PreparedStatement preparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}