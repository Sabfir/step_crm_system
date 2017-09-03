package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.entity.Address;

public interface AddressService {

    default List<Address> getAll() {
        return getAll();
    }

    Address save(Address address);
}
