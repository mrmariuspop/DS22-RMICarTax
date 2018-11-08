package edu.utcn.ds.client.views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import edu.utcn.ds.client.controllers.PriceBtnController;
import edu.utcn.ds.client.controllers.TaxBtnController;

public class TaxCalculatorView {

	private JFrame frmCarTaxCalculator;
	private JTextField yearTextField;
	private JTextField engineSizeTextField;
	private JTextField priceTextField;
	private JLabel lblResult;

	public TaxCalculatorView() {
		initialize();
	}

	private void initialize() {
		frmCarTaxCalculator = new JFrame();
		frmCarTaxCalculator.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmCarTaxCalculator.setTitle("Car Tax Calculator");
		frmCarTaxCalculator.setBounds(100, 100, 450, 320);
		frmCarTaxCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCarTaxCalculator.getContentPane().setLayout(null);
		
		JLabel lblCompleteTheFollowing = new JLabel("Complete the following fields and choose the desired operation.");
		lblCompleteTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompleteTheFollowing.setFont(new Font("Traditional Arabic", Font.BOLD, 12));
		lblCompleteTheFollowing.setBounds(10, 11, 414, 34);
		frmCarTaxCalculator.getContentPane().add(lblCompleteTheFollowing);
		
		JLabel lblCarFabricationYear = new JLabel("Car Fabrication Year");
		lblCarFabricationYear.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCarFabricationYear.setBounds(10, 56, 200, 34);
		frmCarTaxCalculator.getContentPane().add(lblCarFabricationYear);
		
		yearTextField = new JTextField();
		yearTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		yearTextField.setBounds(220, 56, 200, 34);
		frmCarTaxCalculator.getContentPane().add(yearTextField);
		yearTextField.setColumns(10);
		
		JLabel lblCarEngineSize = new JLabel("Car Engine Size");
		lblCarEngineSize.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCarEngineSize.setBounds(10, 101, 200, 34);
		frmCarTaxCalculator.getContentPane().add(lblCarEngineSize);
		
		engineSizeTextField = new JTextField();
		engineSizeTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		engineSizeTextField.setBounds(220, 101, 200, 34);
		frmCarTaxCalculator.getContentPane().add(engineSizeTextField);
		engineSizeTextField.setColumns(10);
		
		JLabel lblCarPurchasingPrice = new JLabel("Car Purchasing Price");
		lblCarPurchasingPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCarPurchasingPrice.setBounds(10, 146, 200, 34);
		frmCarTaxCalculator.getContentPane().add(lblCarPurchasingPrice);
		
		priceTextField = new JTextField();
		priceTextField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		priceTextField.setBounds(220, 146, 200, 34);
		frmCarTaxCalculator.getContentPane().add(priceTextField);
		priceTextField.setColumns(10);
		
		JButton taxBtn = new JButton("Compute Tax");
		taxBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		taxBtn.setBounds(10, 186, 200, 34);
		taxBtn.addActionListener(new TaxBtnController(this));
		frmCarTaxCalculator.getContentPane().add(taxBtn);
		
		JButton priceBtn = new JButton("Compute Selling Price");
		priceBtn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		priceBtn.setBounds(220, 186, 200, 34);
		priceBtn.addActionListener(new PriceBtnController(this));
		frmCarTaxCalculator.getContentPane().add(priceBtn);
		
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblResult.setBounds(10, 231, 414, 34);
		frmCarTaxCalculator.getContentPane().add(lblResult);
	}
	
	public JFrame getFrame() {
		return frmCarTaxCalculator;
	}
	
	public String getFabricationYear() {
		return yearTextField.getText();
	}
	
	public String getEngineSize() {
		return engineSizeTextField.getText();
	}
	
	public String getPurchasingPrice() {
		return priceTextField.getText();
	}
	
	public void printResult(String result) {
		lblResult.setText(result);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxCalculatorView window = new TaxCalculatorView();
					window.frmCarTaxCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
