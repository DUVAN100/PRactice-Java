package controllers;

import dao.VeterinarianDao;
import Models.Veterinarian;
import java.util.List;

/**
 * VeterinarianController class manages the business logic 
 * for veterinarian operations.
 * 
 * @author @ Duvan Yesid Vivaas Bermudez 1002280067
 */
public class VeterinarianController {
    private final VeterinarianDao veterinarianDao;

    public VeterinarianController(VeterinarianDao veterinarianDao) {
        this.veterinarianDao = veterinarianDao;
    }
    
    public void addVeterinarian(String name, String specialty, String email, String phone) {
        Veterinarian veterinarian = new Veterinarian(name, specialty, email, phone);
        veterinarianDao.addVeterinarian(veterinarian);
    }

    public Veterinarian getVeterinarianById(int id) {
        return veterinarianDao.getVeterinarianById(id);
    }

    public List<Veterinarian> getAllVeterinarians() {
        return veterinarianDao.getAllVeterinarians();
    }

    public void updateVeterinarian(int id, String name, String specialty, String email, String phone) {
        Veterinarian veterinarian = new Veterinarian(id, name, specialty, email, phone);
        veterinarianDao.updateVeterinarian(veterinarian);
    }

    public void deleteVeterinarian(int id) {
        veterinarianDao.deleteVeterinarian(id);
    }
}
