/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_jdbc_lp;

import DAO.MinibusDAO;
import DataSource.OracleConnexion;
import Metier.Minibus;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sql.DataSource;
/**
 *
 * @author Enzou
 */
public class TP_JDBC_LP {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws SQLException {
         
        DataSource ds = OracleConnexion.getDataSource ();
        Connection connection = ds.getConnection();
        MinibusDAO mDAO = new MinibusDAO(connection);
        boolean a=true;
        int choix;
        Scanner sc;
        int idMinibusChoix;
        int capaciteChoix;
        int updateNB;
        do {
            System.out.println("Menu :\n\t1- Liste des minibus\n\t2- Update la capacite d'un minibus\n\t3- Inserer un minibus\n\t0- Quitter");
            sc=new Scanner(System.in);
            choix=sc.nextInt();
            switch (choix) {
                case 1:
                    
                    ArrayList<Minibus> listOfMinibus = mDAO.findAll();
                    for (Minibus m : listOfMinibus) {
                        System.out.println(m.toString());
                    }
                    
                    break;
                    
                case 2:
                    
                    System.out.println("De quel minibus voulez vous changer la capacite ? (Entrer ID)");
                    sc=new Scanner(System.in);
                    idMinibusChoix=sc.nextInt();
                    
                    
                    System.out.println("Quel sera sa nouvelle capacite ?");
                    sc=new Scanner(System.in);
                    capaciteChoix=sc.nextInt();
                    
                    
                    updateNB = mDAO.update(new Minibus(idMinibusChoix, capaciteChoix));
                    
                    if(updateNB==1) {
                        System.out.println("Success ! Update done");
                    } else {
                        System.out.println("Failed... Update canceled");
                    }
                    
                    break;
                    
                case 3:
                    
                    System.out.println("Entrez l'ID du nouveau minibus : ");
                    sc=new Scanner(System.in);
                    idMinibusChoix=sc.nextInt();
                    
                    
                    System.out.println("Quelle sera sa capacite ?");
                    sc=new Scanner(System.in);
                    capaciteChoix=sc.nextInt();
                    
                    
                    int insertState = mDAO.insert(new Minibus(idMinibusChoix, capaciteChoix));
                    
                    if(insertState==1) {
                        System.out.println("Success ! Insert done");
                    } else {
                        System.out.println("Failed... Insert canceled");
                    }
                    
                    
                    break;
                default:
                    a=false;
                    System.out.println("Merci d'avoir utilisé nos services");
                    break;
            }
        } while(a);
        connection.close();
    }
    
}
