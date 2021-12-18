package ru.qnocks.hibernateconnectionexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.qnocks.hibernateconnectionexample.domain.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class OwnerDao implements CrudDao<Owner, Long> {

    private final EntityManagerFactory emf;

    @Autowired
    public OwnerDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public void save(Owner entity) {
    }

    @Override
    public void deleteById(Long aLong) {
    }

    @Override
    public void update(Long aLong, Owner entity) {
    }

    @Override
    public Owner findById(Long aLong) {
        return null;
    }

    @Override
    public Iterable<Owner> findAll() {
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        List owners = entityManager.createQuery("SELECT o FROM Owner o").getResultList();
        entityManager.getTransaction().commit();

        return owners;
    }
}
