package africa.semicolon.femiVoteApp.repositories;

import africa.semicolon.femiVoteApp.models.Address;

import java.util.List;

public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save(Address address);
    void deleteById(String id);
}
