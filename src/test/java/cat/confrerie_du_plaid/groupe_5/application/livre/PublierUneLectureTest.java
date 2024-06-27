package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.CommentaireInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.LivreNonTrouve;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;


class PublierUneLectureTest {

    private final static String livreIdConnu = "1";
    private final static String commentaireValide = "Un commentaire de plus de cinq mots.";

    private static class MockLivres implements Livres {
        @Override
        public Optional<Livre> recupererUnLivreParSonId(String livreId) {
            if(livreId.equals(PublierUneLectureTest.livreIdConnu))
                return Optional.of(new Livre());
            else
                return Optional.empty();
        }
    }

    private static class MockPublications implements Publications {
        @Override
        public void enregistrer(Publication publication) {

        }
    }


    public static PublierUneLecture publierUneLecture = new PublierUneLecture(new MockLivres(), new MockPublications());

    @Test()
    void publierUneLectureAvecUnCommentaireEtUneNote() throws Exception {
        publierUneLecture.publier(livreIdConnu, commentaireValide, 4.5, 100, 200);
    }

    @Test()
    void publierUneLectureAvecUnCommentaireMaisPasDevaluation() throws Exception{
        publierUneLecture.publier(livreIdConnu, commentaireValide, null, 100, 200);
    }

    @Test()
    void publierUneLectureSansCommentaireMaisAvecUneNote() throws Exception {
        publierUneLecture.publier(livreIdConnu, null, 4.5, 100, 200);
    }

    @Test()
    void unLivreNestPasTrouvé() {
        assertThrows(LivreNonTrouve.class, () -> {
            publierUneLecture.publier("2", commentaireValide, 4.5, 100, 200);
        });
    }

    @Test()
    public void commentaireVide() {
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            publierUneLecture.publier(livreIdConnu, "", 4.5, 100, 200);
        }, "Le contenu du commentaire ne peut pas être vide");
    }

    @Test()
    public void commentaireTropCourt() {
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            publierUneLecture.publier(livreIdConnu, "commentaire trop court", 4.5, 100, 200);
        }, "Le contenu du commentaire doit contenir au moins 5 mots");
    }

    @Test()
    public void avancementPagesLuesNull() throws Exception {
        publierUneLecture.publier(livreIdConnu, commentaireValide, 4.5, null, 200);
    }


}