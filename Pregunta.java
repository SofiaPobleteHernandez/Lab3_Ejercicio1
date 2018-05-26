public class Pregunta {
    private String question;
    private int score;

    public Pregunta(String question, int score){
        this.question=question;
        this.score=score;
    }

    public String getQuestion(){
        return this.question;
    }

    public int getScore(){
        return this.score;
    }

    public String setQuestion(String question){
        this.question=question;
        return this.question;
    }

    public int setScore(int Score){
        this.score=score;
        return this.score;
    }
}
