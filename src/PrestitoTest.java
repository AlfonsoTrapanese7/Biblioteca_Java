import java.sql.Date;
import java.time.LocalDate;

import bean.Prestito;
import dao.PrestitoDAO;

public class PrestitoTest {
    
    public static void main(String[] args) {
        PrestitoDAO mioPrestitoDAO = new PrestitoDAO();
        System.out.println("Tabella SELECT * ");
        try {
            System.out.println(mioPrestitoDAO.selectAll());
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione della tabella");
        }
        System.out.println("Record con id 1");
        try {
            System.out.println(mioPrestitoDAO.selectPrestitoById(1));
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione del record con id 1");
        }
        System.out.println("Inserimento Prestito ");
        Prestito mioPrestito = new Prestito(300, 20, Date.valueOf(LocalDate.of(2025, 11, 10)), Date.valueOf(LocalDate.of(2025, 11, 25)), "restituito", 10, 1, "La pagina 40 è stata danneggiata");
        System.out.println("Prestito inserito correttamente");
        try {
            mioPrestitoDAO.insert(mioPrestito);
        } catch (Exception e) {
            System.out.println("Errore durante l'inserimento");
        }
         
    }
    
}
