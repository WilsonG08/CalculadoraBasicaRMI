import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.RemoteException;


public class cliente {
    public static void main(String[] args) {
        try {
            // Obtener el registro RMI del servidor
            Registry registro = LocateRegistry.getRegistry("localhost", 1234);

            // Obtener la instancia de la interfaz remota desde el registro
            interfaz objetoRemoto = (interfaz) registro.lookup("ClienteRemoto");

            // Mostrar menú al usuario
            Scanner scanner = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("Seleccione una operación:");
                System.out.println("1. Suma");
                System.out.println("2. Resta");
                System.out.println("3. Multiplicación");
                System.out.println("4. División");
                System.out.println("0. Salir");

                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= 4) {
                    System.out.print("Ingrese el primer número: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Ingrese el segundo número: ");
                    double num2 = scanner.nextDouble();

                    switch (opcion) {
                        case 1:
                            System.out.println("Resultado: " + objetoRemoto.suma(num1, num2));
                            break;
                        case 2:
                            System.out.println("Resultado: " + objetoRemoto.resta(num1, num2));
                            break;
                        case 3:
                            System.out.println("Resultado: " + objetoRemoto.multiplicacion(num1, num2));
                            break;
                        case 4:
                            try {
                                System.out.println("Resultado: " + objetoRemoto.division(num1, num2));
                            } catch (RemoteException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                }
            } while (opcion != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
