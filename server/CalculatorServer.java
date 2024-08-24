package server;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
             LocateRegistry.createRegistry(1099);
            // server is running at port 1099
            // adding server object to registry
            
            Calculator calc = new CalculatorImpl(); // server object
            // we have to register the server object to RMI Registry
            // createRegistry() takes int parameter i.e port number
           
            
            Naming.rebind("rmi://localhost/CalculatorServer", calc); 
            System.out.println("Server is running...");
        } catch (MalformedURLException | RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
