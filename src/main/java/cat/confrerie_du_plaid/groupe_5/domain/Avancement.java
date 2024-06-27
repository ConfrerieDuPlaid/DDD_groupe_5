package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesTotalesInvalide;

public class Avancement {
    private Integer pagesLues;
    private Integer pagesTotales;

    private Avancement(Integer page, Integer pagesTotales) {
        this.pagesLues = page;
        this.pagesTotales = pagesTotales;
    }

    public static Avancement sauvegarder(Integer pagesLues, Integer pagesTotales) throws PagesLuesInvalide, PagesTotalesInvalide {
        if (pagesLues == null) {
            throw new PagesLuesInvalide("La page courante doit être renseignée");
        }
        if (pagesLues < 0 ){
            throw new PagesLuesInvalide("La page doit être positive");
        }
        if (pagesTotales != null) {
            if (pagesTotales < 0) {
                throw new PagesTotalesInvalide("Le nombre de pages totales doit être positif");
            }
            if (pagesTotales < pagesLues) {
                throw new PagesTotalesInvalide("Le nombre de pages totales doit être supérieur ou égal à la page courante");
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

    public Double pourcentageDeLecture() {
        if (pagesTotales == null) {
            return null;
        }
        return (double) pagesLues / pagesTotales * 100;
    }
}
