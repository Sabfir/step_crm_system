package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.entity.Address;

public interface AddressService {

    List<Address> getAll();

    Address getById(long id);

    Address save(Address address);

    Address update(long id, Address address);


}
