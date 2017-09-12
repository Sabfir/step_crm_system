package org.itstep.j2_16.service;

import org.itstep.j2_16.entity.Address;
import org.junit.Test;

public class AddressServiceImplTest {
    private AddressService addressService = new AddressServiceImpl(null);

    @Test
    public void saveBeforeSaving() throws Exception{
        //given
        Address address = new Address();
        address.setCountry("UA");
        address.setCity("Lviv");
        //when
        addressService.save(address);

        //then
        System.out.println(
                address.getId() + " /n"+
        address.getCountry()+ " /n"+
        address.getCity()
        );



    }
}
