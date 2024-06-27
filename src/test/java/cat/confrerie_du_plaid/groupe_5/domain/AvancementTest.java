package cat.confrerie_du_plaid.groupe_5.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AvancementTest {
    @Test()
    public void avancementPagesLuesNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Avancement avancement = Avancement.sauvegarder(null, 100);
        });
    }

    @Test()
    public void avancementPagesLuesNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Avancement avancement = Avancement.sauvegarder(-1, 100);
        });
    }

    @Test()
    public void avancementPagesTotalesNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Avancement avancement = Avancement.sauvegarder(1, -100);
        });
    }

    @Test()
    public void avancementPagesTotalesInferieurPagesLues() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Avancement avancement = Avancement.sauvegarder(100, 99);
        });
    }

    @Test()
    public void avancementAvecPagesLuesEtPagesTotales() {
        Avancement avancement = Avancement.sauvegarder(50, 100);
        Assertions.assertEquals(50, avancement.getPagesLues());
        Assertions.assertEquals(100, avancement.getPagesTotales());
    }

    @Test()
    public void avancementAvecPagesLuesSansPagesTotales() {
        Avancement avancement = Avancement.sauvegarder(50, null);
        Assertions.assertEquals(50, avancement.getPagesLues());
        Assertions.assertNull(avancement.getPagesTotales());
    }
}
