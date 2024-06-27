package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.*;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.*;
import cat.confrerie_du_plaid.groupe_5.domain.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.Livres;

import java.util.Optional;

import static java.time.LocalDate.now;

public class PublierUneLecture {
    private final Livres livres;
    private final Lectures lectures;

    public PublierUneLecture(Livres livres, Lectures lectures) {
        this.livres = livres;
        this.lectures = lectures;
    }

    public Lecture publierUneLecture(PublierUneLectureCommand command)
            throws LivreNonTrouve, CommentaireInvalide, PagesTotalesInvalide, EvaluationInvalide, PagesLuesInvalide {
        Optional<Livre> livre = livres.recupererUnLivreParSonId(command.livreId);
        if(livre.isEmpty()) {
            throw new LivreNonTrouve("Livre n'existe pas");
        }

        var lecture = new Lecture(
                command.livreId,
                Commentaire.ecrireCommentaire(command.commentaire),
                Evaluation.ajouterUneNote(command.evaluation),
                Avancement.sauvegarder(command.pagesLues, command.pagesTotales)
        );

        lectures.enregistrer(lecture);
        return lecture;
    }

}
