import java.sql.Date;
import java.time.LocalDate;

import bean.Autore;
import dao.AutoreDAO;

public class AutoreTest {
    public static void main(String[] args) {
        AutoreDAO mioAutoreDAO = new AutoreDAO();
        System.out.println("Tabella SELECT * ");
        try {
            System.out.println(mioAutoreDAO.selectAll());
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione della tabella");
        }
        System.out.println("Record con id 1");
        try {
            System.out.println(mioAutoreDAO.selectAutoreById(1));
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione del record con id 1");
        }
        System.out.println("Inserimento autore");
        Autore mioAutore = new Autore("Giovanni","Boccaccio","Italia", Date.valueOf(LocalDate.of(1313, 06, 16)), Date.valueOf(LocalDate.of(1375, 12, 21)));
        System.out.println("Libro inserito correttamente");
        try {
            mioAutoreDAO.insert(mioAutore);
        } catch (Exception e) {
            System.out.println("Errore durante l'inserimento");
        }
         
    }
}
