package client;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import server.Calculator;
import java.rmi.Naming;
import java.rmi.NotBoundException;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // creating client i.e stub object to invoke remote method
            Calculator stub = (Calculator) Naming.lookup("rmi://localhost/CalculatorServer") ;
            
            // invoking remote method
            double sum = stub.add(12, 45);
            double difference = stub.subtract(56, 20);
            double product = stub.multiply(12, 6);
            double division = stub.divide(99, 3);
            
            System.out.println("Sum of two number: " + sum);
            System.out.println("Difference of two number: " + difference);
            System.out.println("Product of two number: " + product);
            System.out.println("Division of two number: " + division);
        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
