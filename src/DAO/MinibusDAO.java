/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Metier.Minibus;
import java.util.ArrayList;

/**
 *
 * @author Enzou
 */
public class MinibusDAO {

    private final Connection connexionBD;

    public MinibusDAO(Connection c) {
        this.connexionBD = c;
    }

    public ArrayList<Minibus> findAll() {
        ResultSet rset;
        Statement stmt = null;
        ArrayList<Minibus> listeMinibus = null;
        try {
            stmt = connexionBD.createStatement();
            listeMinibus = new ArrayList();
            rset = stmt.executeQuery("SELECT * from MINIBUS ORDER BY 1");
            while (rset.next()) {
                Minibus m = new Minibus(rset.getInt(1), rset.getInt(2));
                listeMinibus.add(m);
            }
         } catch (SQLException exc) {
             System.out.println(exc);
         } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return listeMinibus;
    }
    
    public int update(Minibus m) throws SQLException {
        
        PreparedStatement pst = null;
        int nbUpdate = 0;
        try {
        String rqt = "UPDATE MINIBUS SET capacite=? WHERE noMinibus=?";
        pst = connexionBD.prepareStatement(rqt);
        pst.setInt(1,m.getCapacite());
        pst.setInt(2,m.getNumB());
        nbUpdate = pst.executeUpdate();
        } catch (SQLException exc) {
            System.out.println(exc);
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return nbUpdate;
    }
    
    public int insert(Minibus m) throws SQLException {
        
        PreparedStatement pst = null;
        int nbInsert = 0;
        
        try {
            
        String rqt = "INSERT INTO MINIBUS VALUES (?, ?)";
        pst = connexionBD.prepareStatement(rqt);
        pst.setInt(1,m.getNumB());
        pst.setInt(2,m.getCapacite());
        nbInsert = pst.executeUpdate();
        } catch (SQLException exc) {
            System.out.println(exc);
        } finally {
            try {
                // la clause finally est toujours executée, quoi qu'il arrive
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        return nbInsert;
    }
    
}
