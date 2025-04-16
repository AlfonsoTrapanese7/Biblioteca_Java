package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Genere;

public class GenereDAO {

    // imposto parametri di connessione
    private final String url = "jdbc:mysql://localhost:3306/cinema"; // Sostituisci con l'URL del tuo database
    private final String user = "root"; // Sostituisci con il tuo username
    private final String password = ""; // Sostituisci con la tua password

    public List<Genere> selectAll() throws SQLException {
        List<Genere> generi = new ArrayList<>();
        String sql = "SELECT * FROM genere"; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement(); 
             ResultSet rs = stmt.executeQuery(sql)) { //tabella modificata con prima riga vuota

            while (rs.next()) { //metodo next fa due azioni; skippa una riga e rilascia quella riga
                generi.add(new Genere( 
                    rs.getInt("idGenere"), 
                    rs.getString("nome"),
                    rs.getString("sottogenere"),
                    rs.getDouble("dewey")
                    ));
}
} 
return generi;
}

public Genere selectGenereById(int id) throws SQLException {
    String sql="SELECT * FROM film WHERE idGenere = ?";

    try (Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement stmt = conn.prepareStatement(sql)) {

    stmt.setInt(1, id);

    try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
            return new Genere(
                rs.getInt("idGenere"), 
                rs.getString("nome"),
                rs.getString("sottogenere"),
                rs.getDouble("dewey")
            );
        }

    }
} return null;
}

public void delete(int id) throws SQLException{
    String sql="DELETE FROM film WHERE idGenere = ?"; 

    try (Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id); 
        stmt.executeUpdate();
}
}

public void update(Genere genere) throws SQLException {
    String sql = "UPDATE film SET idGenere=?,nome=?,sottogenere=?,dewey=?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
    PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1,genere.getIdGenere());
        stmt.setString(2,genere.getNome());
        stmt.setString(3, genere.getSottogenere());
        stmt.setDouble(4, genere.getDewey());

    stmt.executeUpdate();
    }
}

public void update(String nuovoGenere, int id) throws SQLException {
    String sql = "update genere set nome = ? where idGenere = ?";
    try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
        stmt.setString(1, nuovoGenere);
        stmt.setInt(2, id);
            
        stmt.executeUpdate();
}
}

public void insert(Genere genere) throws SQLException {
    String sql = "INSERT INTO genere(idGenere, nome, sottogenere, dewey) VALUES (?,?,?,?)"; 
    try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1,genere.getIdGenere());
            stmt.setString(2,genere.getNome());
            stmt.setString(3, genere.getSottogenere());
            stmt.setDouble(4, genere.getDewey());
            
            stmt.executeUpdate();
}
}
}
