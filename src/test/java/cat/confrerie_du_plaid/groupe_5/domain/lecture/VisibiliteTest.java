package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VisibiliteTest {
    @Test()
    public void visibilitePublique() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("PUBLIQUE");
        assert visibilite == Visibilite.PUBLIQUE;
    }

    @Test()
    public void visibiliteAmis() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("AMIS");
        assert visibilite == Visibilite.AMIS;
    }

    @Test()
    public void visibilitePersonnelle() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("PERSONNELLE");
        assert visibilite == Visibilite.PERSONNELLE;
    }

    @Test()
    public void visibiliteInvalide() {
        assertThrows(VisibiliteInvalide.class, () -> {
            Visibilite.depuis("INCONNU");
        }, "Visibilite inconnue : INCONNU");
    }
}
