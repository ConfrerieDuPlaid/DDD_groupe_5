package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.application.annotations.UseCase;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.*;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.*;
import cat.confrerie_du_plaid.groupe_5.domain.livre.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.Livres;
import cat.confrerie_du_plaid.groupe_5.domain.DefaultId;
import cat.confrerie_du_plaid.groupe_5.infrastructure.shared.PublierUneLectureCommand;

import java.util.Optional;

@UseCase
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
                DefaultId.generate(),
                DefaultId.from(command.livreId),
                Commentaire.ecrireCommentaire(command.commentaire),
                Evaluation.ajouterUneNote(command.evaluation),
                Avancement.sauvegarder(command.pagesLues, command.pagesTotales)
        );

        lectures.enregistrer(lecture);
        return lecture;
    }

}
