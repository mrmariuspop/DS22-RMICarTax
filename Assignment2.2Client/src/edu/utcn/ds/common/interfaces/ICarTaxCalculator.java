package edu.utcn.ds.common.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.utcn.ds.common.entities.Car;

public interface ICarTaxCalculator extends Remote {

	public double computeTax(Car c) throws RemoteException;
	public double computeSellingPrice(Car c) throws RemoteException;
}
