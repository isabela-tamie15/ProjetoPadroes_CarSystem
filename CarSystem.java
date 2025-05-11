import Builder.Car;
import Facade.CarFacade;
import Strategy4x2.DrivingContext;
import Strategy4x2.EcoMode;
import Strategy4x2.SportMode;
import Strategy4x4.TractionContext;
import Strategy4x4.TractionMode4X2;
import Strategy4x4.TractionMode4X4;

import java.util.Scanner;

// Todos os padrões são chamados aqui para executar o sistema geral do carro
public class CarSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nQual tipo de carro você prefere hoje? Digite (1 ou 2) \n1 - Carro 4x2 \n2 - Carro 4x4");

        // 1. Criando um carro usando Builder
        Car car4x2 = new Car.CarBuilder()
                .setMarca("Ford")
                .setModelo("Ecosport")
                .setAno("2018")
                .setMotor("1.5 Flex")
                .setTracao4x4(false)
                .build();

        Car car4x4 = new Car.CarBuilder()
                .setMarca("Toyota")
                .setModelo("Hilux")
                .setAno("2013")
                .setMotor("3.0 Diesel")
                .setTracao4x4(true)
                .build();

        String optionCar = scanner.nextLine();

        scanner.close();

        // Qual carro do Builder usar? Usuário escolhe 1 ou 2
        if (!optionCar.equals("1") && !optionCar.equals("2")) {
            System.out.println("Opção inválida");
            return;
        } else {
            if (optionCar.equals("1")) {                                       // equals compara Strings, == e != compara tipos primitivos
                System.out.println("Carro perfeito para uma viagem urbana!");  // optionCar.equalsIgnoreCase("sim") ignora maiúsculas e minúsculas
                car4x2.showCar();
            } else if (optionCar.equals("2")) {
                System.out.println("Carro perfeito para uma viagem off-road!");
                car4x4.showCar();
            }
        }

        // 2. Usando Facade para ligar o carro, tanto o 4x2 quanto o 4x4
        System.out.println("Verificando se está tudo pronto para sair...");
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();

        if (optionCar.equals("1")) {
            // 3. Escolhendo um modo de condução usando o Strategy4x2 do 4x2
            DrivingContext driving = new DrivingContext();

            System.out.println("\nDirigindo na cidade, escolho Modo Econômico...");
            driving.setDrivingMode(new EcoMode());
            driving.drive();

            System.out.println("\nEntrando na rodovia, troco por Modo Esportivo...");
            driving.setDrivingMode(new SportMode());
            driving.drive();

            // Finaliza o código do carro 4x2
            System.out.println("\nDirija com responsabilidade. Boa viagem!");
        } else if (optionCar.equals("2")) {
            // 3. Escolhendo um modo de tração usando o Strategy4x2 do 4x4
            TractionContext traction = new TractionContext();

            System.out.println("\nDirigindo no asfalto, escolho Modo 4x2...");
            traction.setTractionMode(new TractionMode4X2());
            traction.drive();

            System.out.println("\nEntrando em uma estrada de terra, troco por Modo 4x4...");
            traction.setTractionMode(new TractionMode4X4());
            traction.drive();

            System.out.println("\nVoltando para o asfalto, volto para Modo 4x2...");
            traction.setTractionMode(new TractionMode4X2());
            traction.drive();

            // Finaliza o código do carro 4x4
            System.out.println("\nCurta sua aventura off-road. Boa viagem!");
        }
    }
}

/*
No metodo main, junta os 3 padrões para simular um carro sendo criado, ligado e conduzido.

Como o sistema do carro funcionará:
1) Builder construirá passo a passo um carro personalizável (4x2 ou 4x4).
2) Facade simplificará a inicialização do carro (motor, luzes, portas),
centralizando a lógica na classe Facade e chamando apenas o metodo na main.
3) Strategy permitirá escolher entre diferentes modos de condução
(econômico/esportivo ou 4x2/4x4), podendo mudar dinâmicamente.
*/


