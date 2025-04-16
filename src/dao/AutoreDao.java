package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
}
