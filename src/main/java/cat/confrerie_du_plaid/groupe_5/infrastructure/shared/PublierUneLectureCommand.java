package cat.confrerie_du_plaid.groupe_5.infrastructure.shared;

@DTO
public class PublierUneLectureCommand {
        public String livreId;
        public String commentaire;
        public Double evaluation;
        public Integer pagesLues;
        public Integer pagesTotales;
        public String visibilite;

        public PublierUneLectureCommand(String livreId, String commentaire, Double evaluation, Integer pagesLues, Integer pagesTotales, String visibilite) {
            this.livreId = livreId;
            this.commentaire = commentaire;
            this.evaluation = evaluation;
            this.pagesLues = pagesLues;
            this.pagesTotales = pagesTotales;
            this.visibilite = visibilite;
        }
}