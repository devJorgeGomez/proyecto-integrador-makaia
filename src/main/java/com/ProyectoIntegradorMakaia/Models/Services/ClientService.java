package com.ProyectoIntegradorMakaia.Models.Services;

import com.ProyectoIntegradorMakaia.Entities.Cliente;
import com.ProyectoIntegradorMakaia.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Cliente> getAllClients() {
        return (List<Cliente>) clientRepository.findAll();
    }

    public Cliente getClientById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Cliente createClient(Cliente client) {
        return this.clientRepository.save(client);
    }

    public Cliente updateClient(Long id, Cliente updateClient) {
        Cliente existingClient = clientRepository.findById(id).orElse(null);

        if (existingClient != null) {
            existingClient.setNombre(updateClient.getNombre());
            existingClient.setApellido(updateClient.getApellido());
            existingClient.setFecha_nacimiento(updateClient.getFecha_nacimiento());
            existingClient.setGenero(updateClient.getGenero());
            return clientRepository.save(existingClient);
        }

        return null;
    }

    public void deleteClient(Long id) {
        this.clientRepository.deleteById(id);
    }

}