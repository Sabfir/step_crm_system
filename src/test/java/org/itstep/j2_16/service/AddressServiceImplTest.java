package org.itstep.j2_16.service;

import org.itstep.j2_16.dao.AddressDao;
import org.itstep.j2_16.service.AddressServiceImpl;
import org.itstep.j2_16.entity.Address;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AddressServiceImplTest {
    AddressDao addressDaoMock = Mockito.mock(AddressDao.class);
    private AddressService addressService =new AddressServiceImpl(addressDaoMock);

    @Test
    public void ifNotNull(){
        //given
        Address address = new Address();
        String s = "";

        //when
        address.setCountry(s);

        //then
        System.out.println(AddressServiceImpl.ifNotNull(s));
    }

}