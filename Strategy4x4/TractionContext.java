package Strategy4x4;

// Contexto da estratégia de traçao (Cérebro que decide qual estratégia escolher)
public class TractionContext {
    private TractionMode tractionMode;

    public void setTractionMode(TractionMode tractionMode) {
        this.tractionMode = tractionMode;
    }

    public void drive() {
        if (tractionMode != null) {
            tractionMode.drive();
        } else {
            System.out.println("Nenhum modo de tração selecionado..️");
        }
    }
}