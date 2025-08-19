package com.kozao.services;

import java.sql.*;

import com.kozao.utils.ClaimConstanteUtil;




public class ConnexionDB {
	
	private static Connection connection;

    public static Connection getConnection() {
    	
        if (connection == null) {
            
        	try {
        		
                Class.forName(ClaimConstanteUtil.DRIVER); 
                connection = DriverManager.getConnection(ClaimConstanteUtil.URL, ClaimConstanteUtil.USER, ClaimConstanteUtil.PASSWORD);
                
                // System.out.println("Connexion réussie à la base de données !!");
                
            } catch (ClassNotFoundException e) {
                System.out.println(ClaimConstanteUtil.JDBC_IS_NULL + e.getMessage());
                
            } catch (SQLException e) {
                System.out.println(ClaimConstanteUtil.CONNEXION_ERROR + e.getMessage());
            }
            
        }   
        
        return connection;
    }

}
