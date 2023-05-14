package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Address;
import africa.semicolon.femiVoteApp.utils.AppUtils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryImpl implements AddressRepository{

    private final List<Address> addresses = new ArrayList<>();

    @Override
    public Address findById(String id) {
        for (Address address: addresses) {
            if (address.getId().equals(id)) return address;
        }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addresses;
    }

    @Override
    public Address save(Address address) {
        address.setId(AppUtils.generateId());
        addresses.add(address);
        return address;
    }

    @Override
    public void deleteById(String id) {
        Address address = findById(id);
        if(address != null) addresses.remove(address);
    }
}
