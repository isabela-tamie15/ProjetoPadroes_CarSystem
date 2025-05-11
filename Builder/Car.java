package Builder;

public class Car {
    //Atributos da classe Principal
    private String marca;
    private String modelo;
    private String ano;
    private String motor;
    private boolean tracao4x4;

    //Construtor da classe Principal
    private Car(CarBuilder builder) {
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.ano = builder.ano;
        this.motor = builder.motor;
        this.tracao4x4 = builder.tracao4x4;
    }

    //Não precisou de gets para acessar atributos porque já vai criar objeto dentro desta classe

    //Não precisou de sets tradicionais, porque já vai usar os sets do Builder

    public void showCar() {
        System.out.println("Carro - Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Motor: " + motor + ", Tração 4x4: " + tracao4x4 + "\n");
    }

    //Classe Builder interna porque é como construir carro dentro da classe Carro
    public static class CarBuilder {
        //Atributos da classe Builder
        private String marca;
        private String modelo;
        private String ano;
        private String motor;
        private boolean tracao4x4;

        //sets do Builder
        public CarBuilder setMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public CarBuilder setModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public CarBuilder setAno(String ano) {
            this.ano = ano;
            return this;
        }

        public CarBuilder setMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public CarBuilder setTracao4x4(boolean tracao4x4) {
            this.tracao4x4 = tracao4x4;
            return this;
        }

        public Car build() {
            return new Car(this); //o objeto é criado aqui pelo Builder
        }
    }
}
