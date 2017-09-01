package org.itstep.j2_16.dao;

import java.util.List;
import org.itstep.j2_16.entity.Address;

public interface AddressDao {

    List<Address> getAll();

    Address save(Address address);
}
