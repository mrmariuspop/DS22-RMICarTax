package edu.utcn.ds.client.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import edu.utcn.ds.client.services.TaxService;
import edu.utcn.ds.client.views.TaxCalculatorView;

public class TaxBtnController implements ActionListener {

	private TaxCalculatorView view;
	private TaxService taxService;
	
	public TaxBtnController(TaxCalculatorView view) {
		this.view = view;
		taxService = new TaxService();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (view.getEngineSize().equals("")) {
			JOptionPane.showMessageDialog(view.getFrame(), "If you want to calculate the tax, the engine size cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			int engineSize = Integer.parseInt(view.getEngineSize());
			try {
				double tax = taxService.computeCarTax(engineSize);
				view.printResult("Tax: " + String.valueOf(tax));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(view.getFrame(), e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
