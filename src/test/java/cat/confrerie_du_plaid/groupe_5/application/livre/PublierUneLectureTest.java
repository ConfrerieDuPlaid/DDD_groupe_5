package cat.confrerie_du_plaid.groupe_5.application.livre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PublierUneLectureTest {

    @Test()
    void publierUneLectureAvecUnCommentaireEtUneNote() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, "commentaire", 5.0));
    }

    @Test()
    void publierUneLectureAvecUnCommentaireMaisPasDevaluation() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, "commentaire", null));
    }

    @Test()
    void publierUneLectureSansCommentaireMaisAvecUneNote() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, null, 5.0));
    }

    @Test()
    void unLivreNestPasTrouvé() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertThrows(LivreNonTrouve.class, publierUneLecture.publier("id", null, "commentaire", 5.0));
    }
}