package dao;

/**
 * VeterinarianDao class provides CRUD operations for the Veterinarian model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */
import config.DatabaseConnection;
import Models.Veterinarian;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianDao {
    
    public void addVeterinarian(Veterinarian veterinarian) {
        String sql = "INSERT INTO veterinarios (nombre, especialidad, email, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, veterinarian.getName());
            pstmt.setString(2, veterinarian.getSpecialty());
            pstmt.setString(3, veterinarian.getEmail());
            pstmt.setString(4, veterinarian.getPhone());
            pstmt.executeUpdate();
            System.out.println("Veterinarian added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Veterinarian getVeterinarianById(int id) {
        String sql = "SELECT * FROM veterinarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                return new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("especialidad"),
                    rs.getString("email"),
                    rs.getString("telefono")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Veterinarian> getAllVeterinarians() {
        List<Veterinarian> veterinarians = new ArrayList<>();
        String sql = "SELECT * FROM veterinarios";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veterinarian vet = new Veterinarian(
                    rs.getInt("id"),
                    rs.getString("nombre"),      // Nombre correcto
                    rs.getString("email"),       // Email correcto
                    rs.getString("telefono"),    // Teléfono correcto
                    rs.getString("especialidad") // Especialidad correcta
                );
                veterinarians.add(vet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veterinarians;
    }
    
    public void updateVeterinarian(Veterinarian veterinarian) {
        String sql = "UPDATE veterinarios SET nombre = ?, especialidad = ?, email = ?, telefono = ?, direccion = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, veterinarian.getName());
            pstmt.setString(2, veterinarian.getSpecialty());
            pstmt.setString(3, veterinarian.getEmail());
            pstmt.setString(4, veterinarian.getPhone());
            pstmt.setInt(6, veterinarian.getId());
            
            pstmt.executeUpdate();
            System.out.println("Veterinarian updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteVeterinarian(int id) {
        String sql = "DELETE FROM veterinarios WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Veterinarian deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
