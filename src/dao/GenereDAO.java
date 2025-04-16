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

    //imposto parametri di connessione
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
                generi.add(new Genere( //oggetto film
                    rs.getInt("idGenere"), //richiesta deve matchare vostruttore o variabile in cui la stiamo chiedendo
                    rs.getString("nome"),
                    rs.getString("sottogenere"),
                    rs.getDouble("dewey")
                    ));
}
} 
return generi;
}




}