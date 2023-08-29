package com.proje.takip_istemi.dao;

import com.proje.takip_istemi.entity.*;

import java.util.List;

public interface AppDAO {

    List<Proje> findProjectsByPersonelId(int theId);

    List<Gorev> findGorevlerByPersonelId(int theId);

    List<Personel> findPersonelByYoneticiId(int theId);

    List<Gorev> findGorevlerByProjeId(int theId);

    void updateProje(Proje proje);

    void updateGorev(Gorev gorev);

    List<Yorum> getYorumlarByProjeId(int id);

    void updatePersonel(Personel personel);

    List<Yonetici> findYoneticilerByAdminId(int id);

    void updateYonetici(Yonetici yonetici);
}
