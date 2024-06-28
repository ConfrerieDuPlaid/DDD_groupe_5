package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.Id;
import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.*;
import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.AgregateRoot;
import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.Entity;
import cat.confrerie_du_plaid.groupe_5.domain.livre.LivreId;

import java.time.LocalDate;
import java.util.Objects;

import static java.time.LocalDate.now;

@AgregateRoot
@Entity
public class Lecture {
    private final Id lectureId;
    private LivreId livreId;
    private LocalDate dateDeLecture;

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public Id getLectureId() {
        return lectureId;
    }

    public LivreId getLivreId() {
        return livreId;
    }

    public LocalDate getDateDeLecture() {
        return dateDeLecture;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public Avancement getAvancement() {
        return avancement;
    }

    public Visibilite getVisibilite() {
        return visibilite;
    }

    private Commentaire commentaire = new Commentaire.SansCommentaire();
    private Evaluation evaluation = new Evaluation.SansEvaluation();
    private Avancement avancement = new Avancement.SansAvancement();
    private Visibilite visibilite = Visibilite.AMIS;

    public Lecture(Id id, LivreId livreId, LocalDate dateDeLecture) throws LectureInvalide {
        if (id == null) throw new LectureInvalide("L'id de la lecture doit être renseigné");
        if (livreId == null) throw new LectureInvalide("L'id du livre doit être renseigné");
        if (dateDeLecture == null) throw new LectureInvalide("La date de lecture doit être renseignée");
        this.lectureId = id;
        this.livreId = livreId;
        this.dateDeLecture = dateDeLecture;
    }

    public static Lecture nouvelleLecturePourLeLivre(LivreId livreId) throws LectureInvalide {
        return new Lecture(Id.generate(), livreId, now());
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
