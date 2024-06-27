package cat.confrerie_du_plaid.groupe_5.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentaireTest {
    @Test()
    public void commentaireVide() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Commentaire commentaire = Commentaire.ecrireCommentaire("");
        });
    }

    @Test()
    public void commentaireNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Commentaire commentaire = Commentaire.ecrireCommentaire(null);
        });
    }

    @Test()
    public void commentaireTropCourt() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Commentaire commentaire = Commentaire.ecrireCommentaire("C'est trop court ici");
        });
    }

    @Test
    public void commentaireValide () {
        String contenu = "Ce commentaire a cinq mots";
        Commentaire commentaire = Commentaire.ecrireCommentaire(c addontenu);
        Assertions.assertEquals(contenu, commentaire.getContenu());
    }
}
