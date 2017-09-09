package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Address;

public interface AddressService {

    Address getById(long id);

    Address save(Address address);

    Address update(long id, Address address);


}
