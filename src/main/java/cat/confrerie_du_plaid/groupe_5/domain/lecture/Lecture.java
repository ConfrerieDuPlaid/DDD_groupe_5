package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.CommentaireInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.EvaluationInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.PagesTotalesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.DefaultId;
import cat.confrerie_du_plaid.groupe_5.domain.annotations.Entity;

import java.time.LocalDate;

import static java.time.LocalDate.now;

@Entity
public class Lecture {
    private final DefaultId lectureId;
    private DefaultId livreId;
    private LocalDate now;

    private Commentaire commentaire;
    private Evaluation evaluation;
    private Avancement avancement;
    private Visibilite visibilite;

    public Lecture(DefaultId id, DefaultId livreId) {
        this.lectureId = id;
        this.livreId = livreId;
        this.now = now();
        this.visibilite = Visibilite.AMIS;
    }

    public void commenter(String commentaire) throws CommentaireInvalide {
        this.commentaire = Commentaire.ecrire(commentaire);
    }

    public void evaluer(Double evaluation) throws EvaluationInvalide {
        this.evaluation = Evaluation.ajouterUneNote(evaluation);
    }

    public void definirAvancement(Integer pagesLues, Integer pagesTotales) throws PagesLuesInvalide, PagesTotalesInvalide {
        this.avancement = Avancement.sauvegarder(pagesLues, pagesTotales);
    }

    public void definirVisibilite(Visibilite visibilite) {
        this.visibilite = visibilite;
    }
}
