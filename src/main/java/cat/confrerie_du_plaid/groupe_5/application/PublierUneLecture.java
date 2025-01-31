package cat.confrerie_du_plaid.groupe_5.application;

import cat.confrerie_du_plaid.groupe_5.application.annotations.UseCase;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lecture;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lectures;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Visibilite;
import cat.confrerie_du_plaid.groupe_5.domain.livre.Livres;
import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.*;
import cat.confrerie_du_plaid.groupe_5.infrastructure.shared.PublierUneLectureCommand;

@UseCase
public class PublierUneLecture {
    private final Livres livres;
    private final Lectures lectures;

    public PublierUneLecture(Livres livres, Lectures lectures) {
        this.livres = livres;
        this.lectures = lectures;
    }

    public Lecture publierUneLecture(PublierUneLectureCommand command)
            throws LivreNonTrouve, CommentaireInvalide, PagesTotalesInvalide, EvaluationInvalide, PagesLuesInvalide, VisibiliteInvalide, LectureInvalide {
        var livre = livres
                .recupererUnLivreParSonId(command.livreId)
                .orElseThrow(() -> new LivreNonTrouve("Livre n'existe pas"));

        final var lecture = Lecture.nouvelleLecturePourLeLivre(livre.id());
        lecture.commenter(command.commentaire);
        lecture.evaluer(command.evaluation);
        lecture.definirAvancement(command.pagesLues, command.pagesTotales);
        lecture.definirVisibilite(Visibilite.depuis(command.visibilite));

        lectures.enregistrer(lecture);
        return lecture;
    }

}
