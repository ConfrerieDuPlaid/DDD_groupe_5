package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.domain.exceptions.CommentaireInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.LivreNonTrouve;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.livre.Livres;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lecture;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lectures;
import cat.confrerie_du_plaid.groupe_5.domain.livre.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.livre.LivreId;
import cat.confrerie_du_plaid.groupe_5.infrastructure.shared.PublierUneLectureCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
                return Optional.of(new Livre(LivreId.depuis(livreId)));
            else
                return Optional.empty();
        }
    }

    private static class MockLectures implements Lectures {
        @Override
        public void enregistrer(Lecture lecture) {

        }
    }


    private final static PublierUneLecture publierUneLecture = new PublierUneLecture(new MockLivres(), new MockLectures());

    private static PublierUneLectureCommand command;

    @BeforeEach
    void setUp() {
        command = new PublierUneLectureCommand(
                livreIdConnu,
                commentaireValide,
                4.5,
                100,
                200,
                "AMIS"
        );
    }

    @Test()
    void publierUneLectureUneLectureAvecUnCommentaireEtUneNote() throws Exception {
       Assertions.assertDoesNotThrow(() -> {
           publierUneLecture.publierUneLecture(command);
       });
    }

    @Test()
    void publierUneLectureUneLectureAvecUnCommentaireMaisPasDevaluation() throws Exception{
        command.evaluation = null;
        Assertions.assertDoesNotThrow(() -> {
            publierUneLecture.publierUneLecture(command);
        });
    }

    @Test()
    void publierUneLectureUneLectureSansCommentaireMaisAvecUneNote() throws Exception {
        command.commentaire = null;
        Assertions.assertDoesNotThrow(() -> {
            publierUneLecture.publierUneLecture(command);
        });
    }

    @Test()
    void unLivreNestPasTrouvé() {
        command.livreId = "2";
        assertThrows(LivreNonTrouve.class, () -> {
            publierUneLecture.publierUneLecture(command);
        });
    }

    @Test()
    public void commentaireVide() {
            command.commentaire = "";
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            publierUneLecture.publierUneLecture(command);
        }, "Le contenu du commentaire ne peut pas être vide");
    }

    @Test()
    public void commentaireTropCourt() {
        command.commentaire = "commentaire trop court";
        Assertions.assertThrows(CommentaireInvalide.class, () -> {
            publierUneLecture.publierUneLecture(command);
        }, "Le contenu du commentaire doit contenir au moins 5 mots");
    }

    @Test()
    public void avancementPagesLuesNull() throws Exception {
        command.pagesLues = null;
        Assertions.assertThrows(PagesLuesInvalide.class, () -> {
            publierUneLecture.publierUneLecture(command);
        });

    }


}