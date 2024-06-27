package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.CommentaireInvalide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentaireTest {
    @Test()
    public void commentaireVide() {
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            Commentaire.ecrireCommentaire("");
        }, "Le contenu du commentaire ne peut pas être vide");
    }

    @Test()
    public void commentaireNull() {
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            Commentaire.ecrireCommentaire(null);
        }, "Le contenu du commentaire ne peut pas être vide");
    }

    @Test()
    public void commentaireTropCourt() {
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            Commentaire.ecrireCommentaire("C'est trop court ici");
        }, "Le contenu du commentaire doit contenir au moins 5 mots");
    }

    @Test
    public void commentaireValide() throws CommentaireInvalide {
        String contenu = "Ce commentaire a cinq mots";
        Commentaire commentaire = Commentaire.ecrireCommentaire(contenu);
        Assertions.assertEquals(contenu, commentaire.getContenu());
    }
}
