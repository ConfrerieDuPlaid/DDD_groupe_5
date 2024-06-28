package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.livre.LivreId;
import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LectureTest {
    @Test()
    public void nouvelleLecturePourLeLivre() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        assert lecture.getLivreId().equals(livreId);
        assert lecture.getDateDeLecture().equals(LocalDate.now());
    }

    @Test()
    public void nouvelleLectureAvecLivreNull () {
        assertThrows(LectureInvalide.class, () -> {
            Lecture.nouvelleLecturePourLeLivre(null);
        }, "L'id du livre doit être renseigné");
    }

    @Test()
    public void nouvelleLectureAvecCommentaire() throws LectureInvalide, CommentaireInvalide {
        Commentaire commentaire = Commentaire.ecrire("Ce commentaire a cinq mots");
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        lecture.commenter(commentaire.getContenu());
        assert lecture.getCommentaire().equals(commentaire);
    }

    @Test()
    public void nouvelleLectureAvecEvaluation() throws LectureInvalide, EvaluationInvalide {
        Evaluation evaluation = Evaluation.ajouterUneNote(3.5);
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        lecture.evaluer(evaluation.getNote());
        assert lecture.getEvaluation().equals(evaluation);
    }

    @Test()
    public void nouvelleLectureSansCommentaire() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        assert lecture.getCommentaire().equals(new Commentaire.SansCommentaire());
    }

    @Test()
    public void nouvelleLectureSansEvaluation() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        assert lecture.getEvaluation().equals(new Evaluation.SansEvaluation());
    }

    @Test()
    public void nouvelleLectureSansAvancement() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        assert lecture.getAvancement().equals(new Avancement.SansAvancement());
    }

    @Test()
    public void nouvelleLectureAvecAvancement() throws LectureInvalide, PagesLuesInvalide, PagesTotalesInvalide {
        Avancement avancement = Avancement.sauvegarder(10, 100);
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        lecture.definirAvancement(avancement.getPagesLues(), avancement.getPagesTotales());
        assert lecture.getAvancement().equals(avancement);
    }

    @Test()
    public void nouvelleLectureAvecVisibiliteParDefaut() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
    }

    @Test()
    public void nouvelleLectureAvecVisibilite() throws LectureInvalide, VisibiliteInvalide {
        Visibilite visibilite = Visibilite.depuis("AMIS");
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        lecture.definirVisibilite(visibilite);
        assert lecture.getVisibilite().equals(visibilite);
    }

    @Test()
    public void lectureNonEgale() throws LectureInvalide {
        LivreId livreId = LivreId.depuis("test");
        Lecture lecture = Lecture.nouvelleLecturePourLeLivre(livreId);
        LivreId livreId2 = LivreId.depuis("test2");
        Lecture lecture2 = Lecture.nouvelleLecturePourLeLivre(livreId2);
        assert !lecture.equals(lecture2);
    }
}
