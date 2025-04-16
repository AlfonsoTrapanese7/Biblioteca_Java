import java.sql.Date;
import java.time.LocalDate;

import bean.Libro;
import dao.LibroDAO;

public class LibroTest {
    public static void main(String[] args) {
        LibroDAO mioLibroDAO = new LibroDAO();

        System.out.println("Tabella SELECT * ");
        try
        {
            System.out.println(mioLibroDAO.selectAll());
        }
        catch (Exception e)
        {
            System.out.println("Errore durante la visualizzazione della tabella");
        }

        System.out.println();
        System.out.println("Record con id 11");
        try
        {
            System.out.println(mioLibroDAO.selectLibroById(11));
        }
        catch (Exception e)
        {
            System.out.println("Errore durante la visualizzazione della tabella");
        }

        System.out.println();
        System.out.println("Inserimento libro");
        Libro mioLibro = new Libro(100, "De vulgari eloquentia", 1, 3, Date.valueOf(LocalDate.of(1305, 4, 15)), "9788893663717", "Le lettere", 20.90, 164);
       
        try
        {
            mioLibroDAO.insert(mioLibro); 
            System.out.println("Libro inserito correttamente");    
        }
        catch (Exception e)
        {
            System.out.println("Errore durante l'inserimento");
        }
    }
}