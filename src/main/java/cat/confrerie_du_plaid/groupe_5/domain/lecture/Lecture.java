package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.IdDefaut;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.CommentaireInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.EvaluationInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.PagesLuesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.PagesTotalesInvalide;
import cat.confrerie_du_plaid.groupe_5.domain.annotations.AgregateRoot;
import cat.confrerie_du_plaid.groupe_5.domain.annotations.Entity;
import cat.confrerie_du_plaid.groupe_5.domain.livre.LivreId;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.LocalDate.now;

@AgregateRoot
@Entity
public class Lecture {
    private final IdDefaut lectureId;
    private LivreId livreId;
    private LocalDate now;

    private Commentaire commentaire = new Commentaire.SansCommentaire();
    private Evaluation evaluation = new Evaluation.SansEvaluation();
    private Avancement avancement = new Avancement.SansAvancement();
    private Visibilite visibilite = Visibilite.AMIS;

    public Lecture(IdDefaut id, LivreId livreId, LocalDate dateDeLecture) {
        this.lectureId = id;
        this.livreId = livreId;
        this.now = dateDeLecture;
    }

    public static Lecture nouvelleLecturePourLeLivre(LivreId id) {
        return new Lecture(IdDefaut.generate(), id, now());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lecture lecture)) return false;
        return Objects.equals(lectureId, lecture.lectureId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lectureId);
    }
}
