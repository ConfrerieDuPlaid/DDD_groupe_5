package cat.confrerie_du_plaid.groupe_5.domain;

import org.junit.jupiter.api.Test;

public class IdDefautTest {
    @Test()
    public void idGenereParDefaut() {
        IdDefaut idDefaut = IdDefaut.generate();
        assert idDefaut.valeur() != null;
    }

    @Test()
    public void idGenereDepuis() {
        IdDefaut idDefaut = IdDefaut.depuis("test");
        assert idDefaut.valeur().equals("test");
    }

    @Test()
    public void idDefautEgal() {
        IdDefaut idDefaut1 = IdDefaut.depuis("test");
        IdDefaut idDefaut2 = IdDefaut.depuis("test");
        assert idDefaut1.equals(idDefaut2);
    }

    @Test()
    public void idDefautNonEgal() {
        IdDefaut idDefaut1 = IdDefaut.depuis("test");
        IdDefaut idDefaut2 = IdDefaut.depuis("test2");
        assert !idDefaut1.equals(idDefaut2);
    }

    @Test()
    public void idDefautEnString () {
        IdDefaut idDefaut = IdDefaut.depuis("test");
        assert idDefaut.toString().equals("{ valeur='test'}");
    }
}
