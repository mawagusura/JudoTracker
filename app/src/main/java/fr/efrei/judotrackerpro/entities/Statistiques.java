package fr.efrei.judotrackerpro.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Statistiques {
    @PrimaryKey
    private int id_stats;

    private int dureeMatch; // En secondes
    private int ipponsUtilisateur, wazaariUtilisateur, yukoUtilisateur, ipponsAdv, wazaartAdv,
            yukoAdv, penalitesUtilisateur, penalitesAdv;

    public Statistiques(int idStats, int dureeMatch, int ipponsUtilisateur, int wazaariUtilisateur,
                        int yukoUtilisateur, int ipponsAdv, int wazaartAdv, int yukoAdv, int penalitesUtilisateur, int penalitesAdv) {
        this.id_stats = idStats;
        this.dureeMatch = dureeMatch;
        this.ipponsUtilisateur = ipponsUtilisateur;
        this.wazaariUtilisateur = wazaariUtilisateur;
        this.yukoUtilisateur = yukoUtilisateur;
        this.ipponsAdv = ipponsAdv;
        this.wazaartAdv = wazaartAdv;
        this.yukoAdv = yukoAdv;
        this.penalitesUtilisateur = penalitesUtilisateur;
        this.penalitesAdv = penalitesAdv;
    }

    public int getIdStats() {
        return id_stats;
    }

    public int getDureeMatch() {
        return dureeMatch;
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

    public int getWazaartAdv() {
        return wazaartAdv;
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
