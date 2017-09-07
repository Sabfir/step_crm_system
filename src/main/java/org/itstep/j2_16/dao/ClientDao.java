package org.itstep.j2_16.dao;

import org.itstep.j2_16.entity.Client;

import java.util.List;


public interface ClientDao {

    List<Client> getAll();

    Client getById(long id);

    Client save(Client client);

    void update(Client client);
}
