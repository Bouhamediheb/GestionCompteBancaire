package tn.iit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.iit.beans.Client;
import tn.iit.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    public Client saveOrUpdate(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(Long id) {  // Change Integer to Long
        clientRepository.deleteById(id);
    }

    public List<Client> searchByName(String name) {
        return clientRepository.findByNomContainingIgnoreCase(name);
    }
}
