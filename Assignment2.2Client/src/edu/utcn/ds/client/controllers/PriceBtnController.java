package edu.utcn.ds.client.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.utcn.ds.client.services.TaxService;
import edu.utcn.ds.client.views.TaxCalculatorView;

public class PriceBtnController implements ActionListener {

	private TaxCalculatorView view;
	private TaxService taxService;
	
	public PriceBtnController(TaxCalculatorView view) {
		this.view = view;
		taxService = new TaxService();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (view.getFabricationYear().equals("")) {
			JOptionPane.showMessageDialog(view.getFrame(), "If you want to calculate the selling price, the fabrication year cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			if (view.getPurchasingPrice().equals("")) {
				JOptionPane.showMessageDialog(view.getFrame(), "If you want to calculate the selling price, the purchasing price cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				int year = Integer.parseInt(view.getFabricationYear());
				double price = Double.parseDouble(view.getPurchasingPrice());
				try {
					double tax = taxService.computeCarSellingPrice(year, price);
					view.printResult("Selling Price: " + String.valueOf(tax));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(view.getFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
