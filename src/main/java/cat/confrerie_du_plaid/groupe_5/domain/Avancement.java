package cat.confrerie_du_plaid.groupe_5.domain;

public class Avancement {
    private Integer page;
    private Integer chapitre;

    private Avancement(Integer page, Integer chapitre) {
        this.page = page;
        this.chapitre = chapitre;
    }

    public static Avancement sauvegarder(Integer page, Integer chapitre) {
        if (page == null && chapitre == null) {
            throw new IllegalArgumentException("La page ou le chapitre doivent être renseignés");
        }
        if (page < 0 ){
            throw new IllegalArgumentException("La page doit être positive");
        }
        if (chapitre < 0) {
            throw new IllegalArgumentException("Le chapitre doit être positif");
        }
        return new Avancement(page, chapitre);
    }
}
