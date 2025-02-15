package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {
	private Store store;
	private JTextField title;
	private JTextField category;
	private JTextField director;
	private JTextField length;
	private JTextField cost;
	private JButton btnSubmit;
	private JButton btnBack;
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(6,6));
		
		cp.add(new JLabel("Enter title"));
		title = new JTextField(20);
		cp.add(title);
		
		cp.add(new JLabel("Enter category"));
		category = new JTextField(20);
		cp.add(category);
		
		cp.add(new JLabel("Enter director"));
		director = new JTextField(20);
		cp.add(director);
		
		cp.add(new JLabel("Enter length"));
		length = new JTextField(20);
		cp.add(length);
		
		cp.add(new JLabel("Enter cost"));
		cost = new JTextField(20);
		cp.add(cost);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(store, null);
				dispose();
				
			}
			
		});
		
		btnSubmit = new JButton("Enter");
		
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {	
					String titleString = title.getText();
					String categoryString = category.getText();
					String directorString = director.getText();
					int lengthInt = Integer.parseInt(length.getText());
					float costFloat = Float.parseFloat(cost.getText());
					DigitalVideoDisc dvd = new DigitalVideoDisc(1,titleString, categoryString, directorString, lengthInt, costFloat);
					store.addMedia(dvd);
					new CartScreen(store, null);
					dispose();
				}catch(IllegalArgumentException ev){
					JFrame frame = new JFrame();
					JDialog dialog = new JDialog(frame, "Play media", true);
			        JPanel mainGui = new JPanel(new BorderLayout());
			        
			        mainGui.setBorder(new EmptyBorder(50, 50, 50, 50));
			        mainGui.add(new JLabel("Cost must be float and type must be integer"));
			        JPanel buttonPanel = new JPanel(new FlowLayout());
			        mainGui.add(buttonPanel, BorderLayout.SOUTH);

			        JButton close = new JButton("Close");
			        close.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							dialog.setVisible(false);
							frame.setVisible(false);
						}
			        	
			        });
			        buttonPanel.add(close);
			        frame.setLocationRelativeTo(null);
			        dialog.setContentPane(mainGui);
			        dialog.pack();
			        dialog.setLocationRelativeTo(frame);
			        dialog.setVisible(true);
				}
			}
			
		});
		cp.add(btnBack);
		cp.add(btnSubmit);

		setTitle("Add DVD");
		setSize(600,240);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}