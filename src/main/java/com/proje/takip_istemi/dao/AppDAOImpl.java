package com.proje.takip_istemi.dao;

import com.proje.takip_istemi.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AppDAOImpl implements AppDAO {

    EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public  List<Proje> findProjectsByPersonelId(int theId) {

       TypedQuery<Personel> query= entityManager.createQuery(
                     "select p from Personel p "
                                +"JOIN FETCH p.projeler "
                                +"where p.id= :data"
                        ,Personel.class
                );

        query.setParameter("data",theId);
        Personel personel = null;

        try {
            personel = query.getSingleResult();
        } catch (NoResultException ex) {
            return Collections.emptyList();
        }

        List<Proje> projeler = personel.getProjeler();

        return projeler;

    }

    @Override
    public List<Gorev> findGorevlerByPersonelId(int theId) {

        TypedQuery<Personel> query= entityManager.createQuery(
                "select p from Personel p "
                        +"JOIN FETCH p.gorevler "
                        +"where p.id= :data"
                    ,Personel.class
        );

        query.setParameter("data",theId);

        Personel personel=query.getSingleResult();

        return personel.getGorevler();
    }

    @Override
    public List<Personel> findPersonelByYoneticiId(int theId) {

            TypedQuery<Yonetici> query= entityManager.createQuery(
                "select y from Yonetici y "
                        +"JOIN FETCH y.admin "
                        +"JOIN FETCH y.personelList "
                        +"where y.id= :data"
                ,Yonetici.class
        );

        query.setParameter("data",theId);

        Yonetici yonetici=query.getSingleResult();
        return yonetici.getPersonelList();

    }

    @Override
    public List<Gorev> findGorevlerByProjeId(int theId) {

        TypedQuery<Proje> query= entityManager.createQuery(
                "select p from Proje p "
                        +"JOIN FETCH p.gorevler "
                        +"where p.id= :data"
                ,Proje.class
        );

        query.setParameter("data",theId);

        Proje proje =query.getSingleResult();

        List<Gorev> gorevler=proje.getGorevler();

        return gorevler;

    }

    @Override
    @Transactional
    public void updateProje(Proje proje) {
        entityManager.merge(proje);
    }

    @Override
    @Transactional
    public void updateGorev(Gorev gorev) {
        entityManager.merge(gorev);

    }

    @Override
    public List<Yorum> getYorumlarByProjeId(int id) {
        TypedQuery<Proje> query= entityManager.createQuery(
                "select p from Proje p "
                        +"JOIN FETCH p.yorumlar "
                        +"where p.id= :data"
                ,Proje.class
        );

        query.setParameter("data",id);

        Proje proje =query.getSingleResult();

        List<Yorum> gorevler=proje.getYorumlar();

        return gorevler;


    }

    @Override
    @Transactional
    public void updatePersonel(Personel personel) {
        entityManager.merge(personel);
    }

    @Override
    public List<Yonetici> findYoneticilerByAdminId(int id) {
        TypedQuery<Admin> query=entityManager.createQuery(
                "select a from Admin a "
                +"JOIN FETCH a.yonetici "
                +"where a.id= :data", Admin.class
        );
        query.setParameter("data",id);

        Admin admin=null;
        try{
            admin=query.getSingleResult();
        }catch (NoResultException exc){
            return Collections.emptyList();
        }
        List<Yonetici> yoneticiList=admin.getYonetici();
        return yoneticiList;
    }

    @Override
    @Transactional
    public void updateYonetici(Yonetici yonetici) {
        entityManager.merge(yonetici);
    }


}
