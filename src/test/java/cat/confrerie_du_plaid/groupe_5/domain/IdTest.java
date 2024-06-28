package cat.confrerie_du_plaid.groupe_5.domain;

import org.junit.jupiter.api.Test;

public class IdTest {
    @Test()
    public void idGenereParDefaut() {
        Id id = Id.generate();
        assert id.valeur() != null;
    }

    @Test()
    public void idGenereDepuis() {
        Id id = Id.depuis("test");
        assert id.valeur().equals("test");
    }

    @Test()
    public void idDefautEgal() {
        Id id1 = Id.depuis("test");
        Id id2 = Id.depuis("test");
        assert id1.equals(id2);
    }

    @Test()
    public void idDefautNonEgal() {
        Id id1 = Id.depuis("test");
        Id id2 = Id.depuis("test2");
        assert !id1.equals(id2);
    }

    @Test()
    public void idDefautEnString () {
        Id id = Id.depuis("test");
        assert id.toString().equals("{valeur='test'}");
    }
}
