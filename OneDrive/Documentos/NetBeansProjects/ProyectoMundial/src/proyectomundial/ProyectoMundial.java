/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectomundial;

import conexion.CreateConnection;

/**
 *
 * @author melga
 */
public class ProyectoMundial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         CreateConnection cn = new CreateConnection();
        cn.getConnection();
    }
    
    
}
