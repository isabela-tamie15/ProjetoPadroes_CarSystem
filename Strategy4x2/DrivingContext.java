package Strategy4x2;

// Contexto da estratégia de condução (Cérebro que decide qual estratégia escolher)
public class DrivingContext {
    private DrivingMode drivingMode;

    public void setDrivingMode(DrivingMode drivingMode) {
        this.drivingMode = drivingMode;
    }

    public void drive() {
        if (drivingMode != null) {
            drivingMode.drive();
        } else {
            System.out.println("Nenhum modo de condução selecionado.");
        }
    }
}