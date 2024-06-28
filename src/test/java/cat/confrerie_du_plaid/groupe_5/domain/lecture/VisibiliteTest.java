package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.VisibiliteInvalide;
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

    @Test()
    public void visibilitePubliqueEnString() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("PUBLIQUE");
        assert visibilite.toString().equals("PUBLIQUE");
    }

    @Test()
    public void visibiliteAmisEnString() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("AMIS");
        assert visibilite.toString().equals("AMIS");
    }

    @Test()
    public void visibilitePersonnelleEnString() throws VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("PERSONNELLE");
        assert visibilite.toString().equals("PERSONNELLE");
    }
}
