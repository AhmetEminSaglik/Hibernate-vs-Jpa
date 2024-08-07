package org.aes.compare.orm.business.concrete.jpa;

import jakarta.persistence.TypedQuery;
import org.aes.compare.orm.business.abstracts.AddressService;
import org.aes.compare.orm.business.concrete.comparator.AddressComparator;
import org.aes.compare.orm.business.concrete.jpa.abstracts.JpaImplementation;
import org.aes.compare.orm.model.Address;

import java.util.List;

public class AddressServiceImplJPA extends JpaImplementation<Address> implements AddressService {
    private final AddressComparator comparator = new AddressComparator();

    @Override
    public void save(Address address) {
        initializeTransaction();
        entityManager.persist(address);
        commit();
    }

    @Override
    public Address findById(int id) {
        initializeTransaction();
        Address address = entityManager.find(Address.class, id);
        commit();
        return address;
    }

    @Override
    public List<Address> findAll() {
        initializeTransaction();
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a ", Address.class);
        List<Address> addresses = query.getResultList();
        commit();
        addresses.sort(comparator);
        return addresses;
    }

    @Override
    public List<Address> findAllSavedAndNotMatchedAnyStudentAddress() {
        initializeTransaction();
        TypedQuery<Address> query = entityManager.createQuery("SELECT a FROM Address a " +
                "LEFT JOIN a.student s WHERE s.id IS NULL", Address.class);
        List<Address> addresses = query.getResultList();
        commit();
        addresses.sort(comparator);
        return addresses;
    }

    @Override
    public void update(Address address) {
        initializeTransaction();
        entityManager.merge(address);
        commit();

    }

    @Override
    public void deleteById(int id) {
        initializeTransaction();
        Address address = entityManager.find(Address.class, id);
        entityManager.remove(address);
        commit();
    }

    @Override
    public void resetTable() {
        initializeTransaction();

        entityManager.createNativeQuery("DELETE FROM Address")
                .executeUpdate();
        commit();

        initializeTransaction();

        entityManager.createNativeQuery("ALTER TABLE address AUTO_INCREMENT = 1")
                .executeUpdate();
        commit();
    }

}
