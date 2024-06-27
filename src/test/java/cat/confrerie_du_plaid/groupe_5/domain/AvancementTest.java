package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesTotalesInvalide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvancementTest {
    @Test()
    public void avancementPagesLuesNull() {
        Assertions.assertThrows(PagesLuesInvalide.class, () -> {
            Avancement avancement = Avancement.sauvegarder(null, 100);
        });
    }

    @Test()
    public void avancementPagesLuesNegative() {
        Assertions.assertThrows(PagesLuesInvalide.class, () -> {
            Avancement avancement = Avancement.sauvegarder(-1, 100);
        });
    }

    @Test()
    public void avancementPagesTotalesNegative() {
        Assertions.assertThrows(PagesTotalesInvalide.class, () -> {
            Avancement.sauvegarder(1, -100);
        });
    }

    @Test()
    public void avancementPagesTotalesInferieurPagesLues() {
        Assertions.assertThrows(PagesTotalesInvalide.class, () -> {
            Avancement.sauvegarder(100, 99);
        });
    }

    @Test()
    public void avancementAvecPagesLuesEtPagesTotales() throws PagesLuesInvalide, PagesTotalesInvalide {
        Avancement avancement = Avancement.sauvegarder(50, 100);
        Assertions.assertEquals(50, avancement.getPagesLues());
        Assertions.assertEquals(100, avancement.getPagesTotales());
    }

    @Test()
    public void avancementAvecPagesLuesSansPagesTotales() throws PagesLuesInvalide, PagesTotalesInvalide {
        Avancement avancement = Avancement.sauvegarder(50, null);
        Assertions.assertEquals(50, avancement.getPagesLues());
        Assertions.assertNull(avancement.getPagesTotales());
    }

    @Test()
    public void pourcentageDeLectureNull() throws PagesLuesInvalide, PagesTotalesInvalide {
        Avancement avancement = Avancement.sauvegarder(50, null);
        Assertions.assertNull(avancement.pourcentageDeLecture());
    }

    @Test()
    public void pourcentageDeLecture() throws PagesLuesInvalide, PagesTotalesInvalide {
        Avancement avancement = Avancement.sauvegarder(50, 100);
        Assertions.assertEquals(50.0, avancement.pourcentageDeLecture());
    }
}
