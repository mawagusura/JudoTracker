package judotrackerpro;

import java.util.ArrayList;

public class Categories {
    public static ArrayList<Categorie> categories;

    public static ArrayList<Categorie> getCategoriesBySexe(Sexe sexe) {
        ArrayList<Categorie> result = new ArrayList<Categorie>();
        for (Categorie cat:categories) {
            if (cat.getSexe() == sexe) {
                result.add(cat);
            }
        }
        return result;
    }

}
