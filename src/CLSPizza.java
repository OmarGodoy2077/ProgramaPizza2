import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CLSPizza {
    private String name;
    private double basePrice = 60.00;
    private List<Topping> toppings = new ArrayList<>();

    public CLSPizza(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    static List<Topping> inicializarToppingsDisponibles() {
        List<Topping> toppings = new ArrayList<>();

        toppings.add(new Topping("Pepperoni", 10.0));
        toppings.add(new Topping("Piña", 5.0));
        toppings.add(new Topping("Queso Extra", 11.0));
        toppings.add(new Topping("Salsa Extra", 8.0));
        toppings.add(new Topping("Borde de Queso", 15.0));

        return toppings;
    }

    static void mostrarToppings(List<Topping> toppings) {
        for (int i = 0; i < toppings.size(); i++) {
            System.out.println((i + 1) + ". " + toppings.get(i).getName() + " (Q" + toppings.get(i).getPrice() + ")");
        }
    }

    static int obtenerEnteroInput(BufferedReader reader) throws IOException {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingresa un número válido.");
            }
        }
    }

    static CLSPizza crearPizza(BufferedReader reader, List<Topping> toppingsDisponibles) throws IOException {
        CLSPizza pizza = new CLSPizza("Pizza base", 60.0);
        int eleccionTopping;
        do {
            System.out.print("Ingresa el número del topping que deseas agregar (0 para finalizar): ");
            eleccionTopping = obtenerEnteroInput(reader);
            if (eleccionTopping > 0 && eleccionTopping <= toppingsDisponibles.size()) {
                pizza.addTopping(toppingsDisponibles.get(eleccionTopping - 1));
            } else if (eleccionTopping != 0) {
                System.out.println("Opción de topping inválida.");
            }
        } while (eleccionTopping != 0);
        return pizza;
    }

    static void prepararPizza() {
        System.out.println("Preparando tu pizza...");
        for (int i = 10; i > 0; i--) {
            System.out.println("Tiempo restante: " + i + " segundos");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = basePrice;
        for (Topping topping : toppings) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    public String getName() {
        return name;
    }


}


