package cat.confrerie_du_plaid.groupe_5.application.livre;

public class PublierUneLectureCommand {
        public String livreId;
        public String commentaire;
        public Double evaluation;
        public Integer pagesLues;
        public Integer pagesTotales;

        public PublierUneLectureCommand(String livreId, String commentaire, Double evaluation, Integer pagesLues, Integer pagesTotales) {
            this.livreId = livreId;
            this.commentaire = commentaire;
            this.evaluation = evaluation;
            this.pagesLues = pagesLues;
            this.pagesTotales = pagesTotales;
        }
    }