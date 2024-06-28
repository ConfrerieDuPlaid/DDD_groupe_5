package cat.confrerie_du_plaid.groupe_5.domain.lecture;

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

    public Lecture(DefaultId id, DefaultId livreId, Commentaire commentaire, Evaluation evaluation, Avancement avancement) {
        this.lectureId = id;
        this.livreId = livreId;
        this.now = now();
        this.commentaire = commentaire;
        this.evaluation = evaluation;
        this.avancement = avancement;
    }
}
