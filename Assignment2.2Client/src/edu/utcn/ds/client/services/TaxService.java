package edu.utcn.ds.client.services;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

import edu.utcn.ds.common.entities.Car;
import edu.utcn.ds.common.interfaces.ICarTaxCalculator;

@SuppressWarnings("deprecation")
public class TaxService {

	public TaxService() {
		
	}
	
	public double computeCarTax(int engineSize) {
		double tax = 0.0;
		try {
			System.setProperty("java.security.policy","file:./security.policy");
			System.setSecurityManager(new RMISecurityManager());
			
			ICarTaxCalculator calculator = (ICarTaxCalculator)Naming.lookup("rmi://localhost/CarTaxCalculator");
			
			Car c = new Car(0, engineSize, 0.0);
			tax = calculator.computeTax(c);
		} catch (RemoteException | NotBoundException | MalformedURLException e) {
			e.printStackTrace();
		}
		return tax;
	}
	
	public double computeCarSellingPrice(int year, double price) {
		double selling_price = 0.0;
		try {
			System.setProperty("java.security.policy","file:./security.policy");
			System.setSecurityManager(new RMISecurityManager());
			
			ICarTaxCalculator calculator = (ICarTaxCalculator)Naming.lookup("rmi://localhost/CarTaxCalculator");
			
			Car c = new Car(year, 0, price);
			selling_price = calculator.computeSellingPrice(c);
		} catch (RemoteException | NotBoundException | MalformedURLException e) {
			e.printStackTrace();
		}
		return selling_price;
	}
}
