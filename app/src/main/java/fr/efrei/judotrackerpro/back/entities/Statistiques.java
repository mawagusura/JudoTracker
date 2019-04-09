package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Statistiques {
    @PrimaryKey(autoGenerate = true)
    private Integer id_stats;

    private int duree_match; // En secondes
    private int ipponsUtilisateur, wazaariUtilisateur, yukoUtilisateur, ipponsAdv, wazaariAdv,
            yukoAdv, penalitesUtilisateur, penalitesAdv;

    public Statistiques(Integer id_stats, int duree_match, int ipponsUtilisateur, int wazaariUtilisateur,
                        int yukoUtilisateur, int ipponsAdv, int wazaariAdv, int yukoAdv, int penalitesUtilisateur, int penalitesAdv) {
        this.id_stats = id_stats;
        this.duree_match = duree_match;
        this.ipponsUtilisateur = ipponsUtilisateur;
        this.wazaariUtilisateur = wazaariUtilisateur;
        this.yukoUtilisateur = yukoUtilisateur;
        this.ipponsAdv = ipponsAdv;
        this.wazaariAdv = wazaariAdv;
        this.yukoAdv = yukoAdv;
        this.penalitesUtilisateur = penalitesUtilisateur;
        this.penalitesAdv = penalitesAdv;
    }

    @Ignore
    public Statistiques(int duree_match, int ipponsUtilisateur, int wazaariUtilisateur,
                        int yukoUtilisateur, int ipponsAdv, int wazaaritAdv, int yukoAdv, int penalitesUtilisateur, int penalitesAdv) {
        this(null, duree_match, ipponsUtilisateur,wazaariUtilisateur, yukoUtilisateur, ipponsAdv, wazaaritAdv, yukoAdv,
                penalitesUtilisateur, penalitesAdv);
    }

    public Integer getId_stats() {
        return id_stats;
    }

    public int getDuree_match() {
        return duree_match;
    }

    public int getIpponsUtilisateur() {
        return ipponsUtilisateur;
    }

    public int getWazaariUtilisateur() {
        return wazaariUtilisateur;
    }

    public int getYukoUtilisateur() {
        return yukoUtilisateur;
    }

    public int getIpponsAdv() {
        return ipponsAdv;
    }

    public int getWazaariAdv() {
        return wazaariAdv;
    }

    public int getYukoAdv() {
        return yukoAdv;
    }

    public int getPenalitesUtilisateur() {
        return penalitesUtilisateur;
    }

    public int getPenalitesAdv() {
        return penalitesAdv;
    }
}
