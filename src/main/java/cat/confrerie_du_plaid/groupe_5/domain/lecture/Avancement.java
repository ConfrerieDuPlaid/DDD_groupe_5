package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.PagesTotalesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.ValueObject;

import java.util.Objects;

@ValueObject
public class Avancement {
    private final Integer pagesLues;
    private final Integer pagesTotales;

    public static class SansAvancement extends Avancement {
        public SansAvancement() {
            super(0, 0);
        }
    }

    protected Avancement(Integer page, Integer pagesTotales) {
        this.pagesLues = page;
        this.pagesTotales = pagesTotales;
    }

    public static Avancement sauvegarder(Integer pagesLues, Integer pagesTotales) throws PagesLuesInvalide, PagesTotalesInvalide {
        if(pagesLues == null && pagesTotales == null) {
            return new SansAvancement();
        }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avancement that)) return false;
        return Objects.equals(getPagesLues(), that.getPagesLues()) && Objects.equals(getPagesTotales(), that.getPagesTotales());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPagesLues(), getPagesTotales());
    }
}
