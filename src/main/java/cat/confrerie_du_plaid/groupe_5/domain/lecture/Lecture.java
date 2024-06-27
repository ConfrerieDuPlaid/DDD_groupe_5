package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import java.time.LocalDate;

import static java.time.LocalDate.now;

public class Lecture {
    private String livreId;
    private LocalDate now;

    private Commentaire commentaire;
    private Evaluation evaluation;
    private Avancement avancement;

    public Lecture(String livreId, Commentaire commentaire, Evaluation evaluation, Avancement avancement) {
        this.livreId = livreId;
        this.now = now();
        this.commentaire = commentaire;
        this.evaluation = evaluation;
        this.avancement = avancement;
    }
}
