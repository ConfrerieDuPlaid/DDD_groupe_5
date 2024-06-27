package cat.confrerie_du_plaid.groupe_5.application.livre;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PublierUneLectureTest {

    @org.junit.jupiter.api.Test
    void publierUneLectureAvecUnCommentaireEtUneNote() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, "commentaire", 5.0));
    }

    @org.junit.jupiter.api.Test
    void publierUneLectureAvecUnCommentaireMaisPasDeNote() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, "commentaire", 5.0));
    }

    @org.junit.jupiter.api.Test
    void publierUneLectureSansCommentaireMaisAvecUneNote() {
        PublierUneLecture publierUneLecture = new PublierUneLecture();
        assertNotNull(publierUneLecture.publier("1", null, "commentaire", 5.0));
    }
}