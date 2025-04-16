import bean.Genere;
import dao.GenereDAO;

public class GenereTest {
    
    public static void main(String[] args) {
       GenereDAO mioGenereDAO = new GenereDAO();
        System.out.println("Tabella SELECT * ");
        try {
            System.out.println(mioGenereDAO.selectAll());
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione della tabella");
        }

        System.out.println("Record con id 1");
        try {
            System.out.println(mioGenereDAO.selectGenereById(1));
        } catch (Exception e) {
            System.out.println("Errore durante la visualizzazione del record con id 1");
        }

        System.out.println("Inserimento genere");
        Genere mioGenere = new Genere(10,"narrativa", "horror",12.12 );
        
        try {
            mioGenereDAO.insert(mioGenere);
            System.out.println("Genere inserito correttamente");
        } catch (Exception e) {
            System.out.println("Errore durante l'inserimento");
        }
          
    }

}
