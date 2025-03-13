package controllers;

import dao.ClientDao;
import Models.Client;
import java.util.List;

/**
 * ClientDao class provides CRUD operations for the Client model.
 * 
 * @author Duvan Yesid Vivaas Bermudez 1002280067
 */

public class ClientController {
    private final ClientDao clientDao;

    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public void addClient(String name, String email, String phone, String address) {
        Client client = new Client(name, email, phone, address);
        clientDao.addClient(client);
    }

    public Client getClientById(int id) {
        return clientDao.getClientById(id);
    }

    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public void updateClient(int id, String name, String email, String phone, String address) {
        Client client = new Client(id, name, email, phone, address);
        clientDao.updateClient(client);
    }

    public void deleteClient(int id) {
        clientDao.deleteClient(id);
    }
}
    