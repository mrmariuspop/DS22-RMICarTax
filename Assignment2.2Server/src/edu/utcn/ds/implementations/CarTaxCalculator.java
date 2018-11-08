package edu.utcn.ds.implementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import edu.utcn.ds.common.entities.Car;
import edu.utcn.ds.common.interfaces.ICarTaxCalculator;

public class CarTaxCalculator extends UnicastRemoteObject implements ICarTaxCalculator {

	private static final long serialVersionUID = 1L;

	public CarTaxCalculator() throws RemoteException {
		
	}
	
	public double computeTax(Car c) throws RemoteException {
		int engineSize = c.getEngineSize();
		double tax = 0;
		double sum = 8.0;
		
		if (engineSize <= 0) {
			throw new IllegalArgumentException("Engine capacity must be positive!");
		}
		
		if(engineSize > 1601) sum = 18.0;
		if(engineSize > 2001) sum = 72.0;
		if(engineSize > 2601) sum = 144.0;
		if(engineSize > 3001) sum = 290.0;
		
		tax = (engineSize / 100) * sum;
		
		return tax;
	}
	
	public double computeSellingPrice(Car c) throws RemoteException {
		int year = c.getYear();
		double purchasing_price = c.getPrice();
		double selling_price = 0.0;
		
		if (year < 1886) {
			throw new IllegalArgumentException("Invalid car year!");
		}
		if (purchasing_price <= 0) {
			throw new IllegalArgumentException("Purchasing price must be positive!");
		}
		
		selling_price = purchasing_price - (purchasing_price / 7.0) * ((double)(2015 - year));
		
		return selling_price;
	}
}
