
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//LECTOR DE ENTRADA



        System.out.println("Toppings Disponibles:");
        CLSPizza.mostrarToppings(CLSPizza.inicializarToppingsDisponibles());


        CLSPizza pizza = CLSPizza.crearPizza(reader,CLSPizza.inicializarToppingsDisponibles());

        System.out.println(pizza.calculateTotalPrice());

        CLSPizza.prepararPizza();

        System.out.print("Por favor ingresa el valor de su billete: ");
        double valor = CLSPizza.obtenerEnteroInput(reader);

        System.out.println("Tu cambio es: " + (valor - pizza.calculateTotalPrice()));
    }
}

