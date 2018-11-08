package edu.utcn.ds.server.start;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

import edu.utcn.ds.implementations.CarTaxCalculator;

@SuppressWarnings("deprecation")
public class ServerStart {

	public ServerStart() {
		
	}
	
	public void startServer() {
		try {
			System.setProperty("java.security.policy","file:./security.policy");
			System.setSecurityManager(new RMISecurityManager());
			
			LocateRegistry.createRegistry(1099);
			
			CarTaxCalculator carTaxCalculator = new CarTaxCalculator();
			
			Naming.rebind("rmi://localhost/CarTaxCalculator", carTaxCalculator);
			
			System.out.println("Server successfully started!");
		} catch (Exception e) {
			System.out.println("Server initialization failed!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerStart server = new ServerStart();
		server.startServer();
	}
}
