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

public class AutoreDAO {
        //imposto i parametri di connessione
    private final String url = "jdbc:mysql://localhost:3306/Libreria"; // Sostituisci con l'URL del tuo database
    private final String user = "root"; // Sostituisci con il tuo username
    private final String password = ""; // Sostituisci con la tua password

    public List<Autore> selectAll() throws SQLException {
        List<Autore> autori = new ArrayList<>();
        String sql = "SELECT * FROM autore";

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
        String sql = "UPDATE autore SET nome=?,cognome=?,paese_nascita=?,data_nascita=?,anno_decesso=? WHERE id_autore=?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            
            stmt.setString(1, autore.getNome());
            stmt.setString(2, autore.getCognome());
            stmt.setString(3, autore.getPaeseNascita());
            stmt.setDate(4, (java.sql.Date) autore.getDataNascita());
            stmt.setDate(5, (java.sql.Date) autore.getAnnoDecesso());
            stmt.setInt(6, autore.getIdAutore());
            stmt.executeUpdate();
        }
    }

    public void updateNome(String nuovoNome, int id) throws SQLException {
        String sql = "update autore set nome = ? where id_autore = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuovoNome);
            stmt.setInt(2, id);

            stmt.executeUpdate(); 
        }
    }

    public void updateCognome(String nuovoCognome, int id) throws SQLException {
        String sql = "update autore set cognome = ? where id_autore = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nuovoCognome);
            stmt.setInt(2, id);

            stmt.executeUpdate();
        }
    }

    public void insert(Autore autore) throws SQLException {
        String sql = "INSERT INTO autore(nome,cognome,paese_nascita,data_nascita,anno_decesso) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, autore.getNome());
            stmt.setString(2, autore.getCognome());
            stmt.setString(3, autore.getPaeseNascita());
            stmt.setDate(4, (java.sql.Date) autore.getDataNascita());
            stmt.setDate(5, (java.sql.Date) autore.getAnnoDecesso());
            stmt.setInt(6, autore.getIdAutore());

            stmt.executeUpdate();
        }
    }
}
