package org.itstep.j2_16.service;

import java.util.List;
import org.itstep.j2_16.dao.AddressDao;
import org.itstep.j2_16.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceUniversal implements AddressService {
    private AddressDao addressDao;

    @Autowired
    public AddressServiceUniversal(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> getAll() { return addressDao.getAll();
    }

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }
}
