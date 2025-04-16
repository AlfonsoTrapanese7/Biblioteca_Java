package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import bean.Prestito;


public class PrestitoDAO {
    private final String url = "jdbc:mysql://localhost:3306/Libreria"; // Sostituisci con l'URL del tuo database
    private final String user = "root"; // Sostituisci con il tuo username
    private final String password = ""; // Sostituisci con la tua password

    public List<Prestito> selectAll() throws SQLException {
        List<Prestito> prestiti = new ArrayList<>();
        String sql = "SELECT * FROM prestito";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    
                    prestiti.add(new Prestito(rs.getInt("id_prestito"), 
                                            rs.getInt("fk_id_libro"),
                                            rs.getDate("data_prestito") , 
                                            rs.getDate("data_restituzione"), 
                                            rs.getString("stato"), 
                                            rs.getDouble("penale"), 
                                            rs.getInt("estensione"), 
                                            rs.getString("note")));
                    
                }
            }
        return prestiti;
    }

    public Prestito selectPrestitoById(int id) throws SQLException {
        
        String sql = "SELECT * FROM prestito WHERE id_prestito = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id); 

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Prestito(
                        rs.getInt("id_prestito"), 
                        rs.getInt("fk_id_libro"),
                        rs.getDate("data_prestito") , 
                        rs.getDate("data_restituzione"), 
                        rs.getString("stato"), 
                        rs.getDouble("penale"), 
                        rs.getInt("estensione"), 
                        rs.getString("note")
                    );
                }
            }
        }    
        return null;
    }

    public void delete(int id) throws SQLException {
        //il punto interrogativo sta a significare che il valore di id_prestito cambia in base a cio' che passo nel metodo
        String sql = "DELETE FROM prestito WHERE id_prestito = ?"; 
    
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            //sto dicendo che il valore del primo punto interrogativo va sostituito con id dell'input del metodo
            stmt.setInt(1, id); 
            stmt.executeUpdate(); //si chiama excecuteUpdate e non executeDelete perchè per il database la cancellazione, l'inserimento e l'aggiornamento sono operazioni di update
        } 
    }

    public void update(Prestito prestito) throws SQLException {
        String sql = "UPDATE prestito SET fk_id_libro=?,data_prestito=?,data_restituzione=?,stato=?,penale=?,estensione=?,note=? WHERE id_prenotazione=?"; 
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            //sto dicendo che il valore del primo punto interrogativo va sostituito con id dell'input del metodo
            stmt.setInt(1, prestito.getFkIdLibro());
            stmt.setDate(2, prestito.getDataPrestito());
            stmt.setDate(3, prestito.getDataRestituzione());
            stmt.setString(4, prestito.getStato());
            stmt.setDouble(5, prestito.getPenale());
            stmt.setInt(6, prestito.getEstensione());
            stmt.setString(7, prestito.getNote());
            stmt.setInt(8, prestito.getIdPrestito());
            stmt.executeUpdate(); //si chiama excecuteUpdate e non executeDelete perchè per il database la cancellazione, l'inserimento e l'aggiornamento sono operazioni di update
        } 
    }

    public void update(String nuoveNote, int id) throws SQLException {
        String sql = "update prestito set note = ? where id_prenotazione = ?"; 
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            //sto dicendo che il valore del primo punto interrogativo va sostituito con id dell'input del metodo
            stmt.setString(1, nuoveNote);
            stmt.setInt(2, id);
            //update film set note = nuoveNote where id_prestito = id

            stmt.executeUpdate(); //si chiama excecuteUpdate e non executeDelete perchè per il database la cancellazione, l'inserimento e l'aggiornamento sono operazioni di update
        } 
    }

    public void insert(Prestito prestito) throws SQLException {
        String sql = "INSERT INTO prestito(fk_id_libro, data_prestito, data_restituzione, stato, penale, estensione, note) VALUES (?,?,?,?,?,?,?)"; 
        try (Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(sql)) {
    
            stmt.setInt(1, prestito.getFkIdLibro());
            stmt.setDate(2, prestito.getDataPrestito());
            stmt.setDate(3, prestito.getDataRestituzione());
            stmt.setString(4, prestito.getStato());
            stmt.setDouble(5, prestito.getPenale());
            stmt.setInt(6, prestito.getEstensione());
            stmt.setString(7, prestito.getNote());

            stmt.executeUpdate();
        } 
    }
}
