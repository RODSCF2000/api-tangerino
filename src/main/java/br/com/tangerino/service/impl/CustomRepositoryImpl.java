package br.com.tangerino.service.impl;

import java.io.Serializable;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.tangerino.repository.CustomRepository;
import jakarta.persistence.EntityManager;

public class CustomRepositoryImpl<T, ID extends Serializable>
extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

    private final EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public CustomRepositoryImpl(@SuppressWarnings("rawtypes") JpaEntityInformation entityInformation, 
                                EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void refresh(T t) {
        entityManager.refresh(t);
    }
}