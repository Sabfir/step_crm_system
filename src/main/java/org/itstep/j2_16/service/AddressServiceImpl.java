package org.itstep.j2_16.service;


import org.itstep.j2_16.dao.AddressDao;
import org.itstep.j2_16.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;

    @Autowired
    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public Address getById(long id) {
        return addressDao.getById(id);
    }

    @Override
    public Address save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address update(long id, Address address) {
        Address foundAddress = getById(id);
        if (foundAddress == null) {
            throw new RuntimeException(format("Address by %s not found", id));
        }

        address.setId(id);
        addressDao.update(address);

        return address;
    }

    public static boolean ifNotNull(String s) {
    Address address = new Address();
    address.setCountry(s);
    if (address.getCountry().equals("")){
        return false;
    }
    return true;
    }
}
