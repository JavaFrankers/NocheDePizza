package org.javafrankers.dao;

import org.javafrankers.model.Client;

import java.util.List;

public interface ClientDao {
    void discharge(Client client);
    List<Client> listClients(String cliente_id);
    Client modifyClient(Client client);
    void deleteClient(Client client);
}
