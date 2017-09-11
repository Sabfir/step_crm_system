package org.itstep.j2_16.dao;

import java.util.List;
import org.itstep.j2_16.entity.Address;

public interface AddressDao {

    Address getById(long id);

    Address save(Address address);

    void update(Address address);
}
