package cat.confrerie_du_plaid.groupe_5.domain;

public class Avancement {
    private Integer pagesLues;
    private Integer pagesTotales;

    private Avancement(Integer page, Integer pagesTotales) {
        this.pagesLues = page;
        this.pagesTotales = pagesTotales;
    }

    public static Avancement sauvegarder(Integer pagesLues, Integer pagesTotales) {
        if (pagesLues == null) {
            throw new IllegalArgumentException("La page courante doit être renseignée");
        }
        if (pagesLues < 0 ){
            throw new IllegalArgumentException("La page doit être positive");
        }
        if (pagesTotales != null) {
            if (pagesTotales < 0) {
                throw new IllegalArgumentException("Le nombre de pages totales doit être positif");
            }
            if (pagesTotales < pagesLues) {
                throw new IllegalArgumentException("Le nombre de pages totales doit être supérieur ou égal à la page courante");
            }
        }
        return new Avancement(pagesLues, pagesTotales);
    }

    public Integer getPagesLues() {
        return pagesLues;
    }

    public Integer getPagesTotales() {
        return pagesTotales;
    }
}
