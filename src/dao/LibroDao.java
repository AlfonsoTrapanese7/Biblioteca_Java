package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import bean.Libro;

public class LibroDao {
    private final String url = "jdbc:mysql://localhost:3306/libreria";
    private final String user = "root";
    private final String password = "";

    public List<Libro> selectAll() throws SQLException {
        List<Libro> libri = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next())
                {
                    libri.add(new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("titolo"),
                        rs.getInt("fk_id_autore"),
                        rs.getInt("fk_id_genere"),
                        rs.getDate("anno_uscita"),
                        rs.getString("isbn").charAt(0), //Convertiamo il primo carattere in char
                        rs.getString("casa_editrice"),
                        rs.getDouble("costo_libro"),
                        rs.getInt("numero_pagine")
                    ));
                }
            }
        
            return libri;
    }

    public Libro selectLibroById(int id) throws SQLException {
        String sql = "SELECT * FROM libro WHERE id_libro = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
        
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery())
            {
                if (rs.next())
                {
                    return new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("titolo"),
                        rs.getInt("fk_id_autore"),
                        rs.getInt("fk_id_genere"),
                        rs.getDate("anno_uscita"),
                        rs.getString("isbn").charAt(0),
                        rs.getString("casa_editrice"),
                        rs.getDouble("costo_libro"),
                        rs.getInt("numero_pagine")
                    );
                }
            }
        }

        return null;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM libro WHERE id_libro = ?"; 
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
        
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } 
    }

    public void update(Libro libro) throws SQLException {
        String sql = "UPDATE libro SET titolo=?, fk_id_autore=?, fk_id_genere=?, anno_uscita=?, isbn=?, casa_editrice=?, costo_libro=?, numero_pagine=? WHERE id_libro=?"; 
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
        
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, libro.getTitolo());
                stmt.setInt(2, libro.getFkIdAutore());
                stmt.setInt(3, libro.getFkIdGenere());
                stmt.setDate(4, new Date(libro.getAnnoUscita().getTime())); //Conversione da java.util.Date a java.sql.Date
                stmt.setString(5, String.valueOf(libro.getIsbn())); //Converte da char a String
                stmt.setString(6, libro.getCasaEditrice());
                stmt.setDouble(7, libro.getCostoLibro());
                stmt.setInt(8, libro.getNumeroPagine());
                stmt.setInt(9, libro.getIdLibro());
                
                stmt.executeUpdate();
            }
    }

    public void update(String nuovoTitolo, int id) throws SQLException {
        String sql = "update libro set titolo = ? where id_libro = ?";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
        
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, nuovoTitolo);
                stmt.setInt(2, id);
                
                stmt.executeUpdate();
            }
    }

    public void insert(Libro libro) throws SQLException {
        String sql = "INSERT INTO libro(titolo, fk_id_autore, fk_id_genere, anno_uscita, isbn, casa_editrice, costo_libro, numero_pagine) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = DriverManager.getConnection(url, user, password);
        
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, libro.getTitolo());
                stmt.setInt(2, libro.getFkIdAutore());
                stmt.setInt(3, libro.getFkIdGenere());
                stmt.setDate(4, new Date(libro.getAnnoUscita().getTime())); //Conversione da java.util.Date a java.sql.Date
                stmt.setString(5, String.valueOf(libro.getIsbn())); //Converte da char a String
                stmt.setString(6, libro.getCasaEditrice());
                stmt.setDouble(7, libro.getCostoLibro());
                stmt.setInt(8, libro.getNumeroPagine());
                
                stmt.executeUpdate();
            }
    }
}