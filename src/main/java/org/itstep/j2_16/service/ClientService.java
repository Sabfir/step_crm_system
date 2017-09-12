package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Client;

import java.util.List;


public interface ClientService {

    List<Client> getAll();

    Client getById(long id);

    Client save(Client client);

    Client update(long id, Client client);
}
