import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacioninterfaz extends UnicastRemoteObject implements interfaz {
    public implementacioninterfaz() throws RemoteException {
        super();
    }

    @Override
    public String mensaje() throws RemoteException {
        return "Hola desde el servidor";
    }

    @Override
    public double suma(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double resta(double a, double b) throws RemoteException {
        return a - b;
    }

    @Override
    public double multiplicacion(double a, double b) throws RemoteException {
        return a * b;
    }

    @Override
    public double division(double a, double b) throws RemoteException {
        if (b != 0) {
            return a / b;
        } else {
            throw new RemoteException("No se puede dividir por cero");
        }
    }
}
