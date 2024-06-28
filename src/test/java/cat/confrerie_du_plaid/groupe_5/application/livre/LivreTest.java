package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.domain.livre.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.livre.LivreId;
import org.junit.jupiter.api.Test;

public class LivreTest {
    @Test()
    public void livreEgal() {
        Livre livre1 = new Livre(LivreId.depuis("test"));
        Livre livre2 = new Livre(LivreId.depuis("test"));
        assert livre1.equals(livre2);
    }

    @Test()
    public void livreNonEgal() {
        Livre livre1 = new Livre(LivreId.depuis("test"));
        Livre livre2 = new Livre(LivreId.depuis("test2"));
        assert !livre1.equals(livre2);
    }
}
