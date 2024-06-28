package cat.confrerie_du_plaid.groupe_5.domain.livre;

import org.junit.jupiter.api.Test;

public class LivreIdTest {
    @Test()
    public void idGenereDepuis() {
        LivreId livreId = LivreId.depuis("test");
        assert livreId.valeur()  == "test";
    }

    @Test()
    public void idDefautEgal() {
        LivreId livreId1 = LivreId.depuis("test");
        LivreId livreId2 = LivreId.depuis("test");
        assert livreId1.equals(livreId2);
    }

    @Test()
    public void idDefautNonEgal() {
        LivreId livreId1 = LivreId.depuis("test");
        LivreId livreId2 = LivreId.depuis("test2");
        assert !livreId1.equals(livreId2);
    }

    @Test()
    public void idDefautEnString () {
        LivreId livreId = LivreId.depuis("test");
        assert livreId.toString().equals("LivreId{valeur='test'}");
    }
}
