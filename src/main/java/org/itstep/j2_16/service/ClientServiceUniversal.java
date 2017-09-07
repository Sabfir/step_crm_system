package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.ClientDao;
import org.itstep.j2_16.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static java.lang.String.format;

@Service
public class ClientServiceUniversal implements ClientService {
    private ClientDao clientDao;

    @Autowired
    public ClientServiceUniversal(ClientDao clientDao){
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    public Client getById(long id) {
        return clientDao.getById(id);
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public Client update(long id, Client client) {
        Client foundClient = getById(id);
        if (foundClient == null) {
            throw new RuntimeException(format("Client by %s not found", id));
        }

        client.setId(id);
        clientDao.update(client);

        return client;
    }

}
