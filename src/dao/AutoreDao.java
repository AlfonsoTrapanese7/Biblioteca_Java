package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import bean.Autore;

public class AutoreDao {
        //imposto i parametri di connessione
    private final String url = "jdbc:mysql://localhost:3306/cinema"; // Sostituisci con l'URL del tuo database
    private final String user = "root"; // Sostituisci con il tuo username
    private final String password = ""; // Sostituisci con la tua password

    public List<Autore> selectAll() throws SQLException {
        List<Autore> autori = new ArrayList<>();
        String sql = "SELECT * FROM film";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                autori.add(new Autore(
                        rs.getInt("id_autore"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("paese_nascita"),
                        rs.getDate("data_nascita"),
                        rs.getDate("anno_decesso")
                ));
            }
        }

        return autori;
    }


    public Autore selectAutoreById(int id) throws SQLException {
        String sql = "SELECT * FROM autore WHERE id_autore = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id); 

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Autore(
                        rs.getInt("id_autore"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("paese_nascita"),
                        rs.getDate("data_nascita"),
                        rs.getDate("anno_decesso")
                    );
                }
            }
        }

        return null; 
    }

    public void delete(int id) throws SQLException {

        String sql = "DELETE FROM autore WHERE id_auore = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    public void update(Autore autore) throws SQLException {
        String sql = "UPDATE film SET titolo=?,genere=?,casa_produttrice=?,regia=?,voto=?,lingua=?,attori_principali=?,paese_di_produzione=? WHERE id_film=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            stmt.setString(1, autore.getNome());
            stmt.setString(2, autore.getCognome());
            stmt.setString(3, autore.getPaeseNascita());
            stmt.setDate(4, (java.sql.Date) autore.getDataNascita());
            stmt.setDate(5, (java.sql.Date) autore.getAnnoDecesso());

            stmt.executeUpdate();
        }
    }
}
