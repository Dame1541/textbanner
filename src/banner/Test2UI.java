package banner;


import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



/* Klassen skapar ett controller2-objekt med inmatade värden som körs i ett frame-objekt
 * @author Andreas Jönsson den 13/1-2019  
 * 
 **/
public class Test2UI extends JPanel
{

	
	//skapar alla objekt i klassen
	private Controller2 controller;
	
	private JButton btnLeft, btnRight;
	
	private JTextField[] tfLeftColumn;
	private JTextField[] tfRightColumn;
	private JLabel[][] lblMiddleGrid;
	
	private Array7 leftColumn;
	private Array7 rightColumn;
	private Array7x7 middleGrid;
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	
	
	
	/**
	    * Konstruerar och initialiserar ett test2ui-objekt med angivna värden.
	    * controller = new Controller2()
	    * @param mLeftColumn vänster kolumn
	    * @param mRightColumn höger kolumn
	    * @param mMiddleGrid mittenfältet
	    * @param mController controller2
	    */
	public Test2UI(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mMiddleGrid, Controller2 mController)
	{
		
		this.controller = mController;
		
		//Panelen
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 200));
		
		//Arrayer
		this.leftColumn = mLeftColumn;
		this.rightColumn = mRightColumn;
		this.middleGrid = mMiddleGrid;
		
		//Paneler
		this.leftPanel = new JPanel();
		this.leftPanel.setLayout(new GridLayout(7, 1));
		
		this.rightPanel = new JPanel();
		this.rightPanel.setLayout(new GridLayout(7, 1));
		
		this.middlePanel = new JPanel();
		this.middlePanel.setLayout(new GridLayout(7, 7));
		
		this.lowerPanel = new JPanel(new GridLayout(1, 2));
		
		//Rader och kolumer
		this.tfLeftColumn = new JTextField[7];
		this.tfRightColumn = new JTextField[7];
		this.lblMiddleGrid = new JLabel[7][7];
		
		MoveListener moveListener = new MoveListener();
		ChangeListener changeListener = new ChangeListener();

		this.btnLeft = new JButton("<- Move Left <-");
		this.btnLeft.addActionListener(moveListener);
		
	    this.btnRight = new JButton("-> Move Right ->");
	    this.btnRight.addActionListener(moveListener);
	    

	    this.lowerPanel.add(this.btnLeft);
	    this.lowerPanel.add(this.btnRight);
	    
	    
		//Inititerar och ger variabler
		for(int i = 0; i < 7; i++)
		{
			this.tfLeftColumn[i] = new JTextField();			
			this.tfLeftColumn[i].setText(Integer.toString(this.leftColumn.getElement(i)));			
			this.tfLeftColumn[i].setPreferredSize(new Dimension(30, 30));	
			this.tfLeftColumn[i].getDocument().addDocumentListener(changeListener);
			this.leftPanel.add(this.tfLeftColumn[i]);
			
			this.tfRightColumn[i] = new JTextField();
			this.tfRightColumn[i].setText(Integer.toString(this.rightColumn.getElement(i)));
			this.tfRightColumn[i].setPreferredSize(new Dimension(30, 30));
			this.tfRightColumn[i].getDocument().addDocumentListener(changeListener);
			this.rightPanel.add(this.tfRightColumn[i]);

			for(int j = 0; j <7; j++)
			{
				this.lblMiddleGrid[i][j] = new JLabel("");
				this.lblMiddleGrid[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				this.lblMiddleGrid[i][j].setText(Integer.toString(this.middleGrid.getElement(i, j)));
				this.lblMiddleGrid[i][j].setPreferredSize(new Dimension(30, 30));
				this.middlePanel.add(this.lblMiddleGrid[i][j]);
			}
		}
		
		
		//lägger till alla paneler i test2ui
	    this.add(this.middlePanel, BorderLayout.CENTER);
	    this.add(this.leftPanel, BorderLayout.WEST);
	    this.add(this.rightPanel, BorderLayout.EAST);
	    this.add(this.lowerPanel, BorderLayout.SOUTH);   
	}
	
	
	
	
	//get-metoder för klassen
	
	
	/**
	    * Retunerar vänster kolumn som en en array av JTextField.
	    * @return JTextField av vänster kolumn
	    */
	public JTextField[] getLeftTfColumn() 
	{
		return this.tfLeftColumn;
	}
	
	
	/**
	    * Retunerar höger kolumn som en en array av JTextField.
	    * @return JTextField av höger kolumn
	    */
	public JTextField[] getRightTfColumn() 
	{
		return this.tfRightColumn;
	}
	
	
	/**
	    * Retunerar mittenfältet som en en tvådimensionell array av JLabel.
	    * @return JLabel av mittenfältet
	    */
	public JLabel[][] getMiddleLblColumn()
	{
	
		return this.lblMiddleGrid;
	}
	
	
	/**
	    * Retunerar den vänstra kolumnen som en array7.
	    * @return array7 vänster kolumn
	    */
	public Array7 getLeftColumn()
	{
		return this.leftColumn;
	}
	
	/**
	    * Retunerar den högra kolumnen som en array7.
	    * @return array7 höger kolumn
	    */
	public Array7 getRightColumn()
	{
		return this.rightColumn;
	}
	
	/**
	    * Retunerar mittenfältet som en array7x7.
	    * @return array7x7 mittenfältet
	    */
	public Array7x7 getMiddleColumn()
	{
		return this.middleGrid;
	}
	
	
	
	
	//set-metoder för test2ui-klassen
	
	
	/**
	    * Sätter den vänstra kolumen till den angivna array7 som skickas in i metoden.
	    * @param mLeftColumn array7
	    */
	public void setLeftColumn(Array7 mLeftColumn)
	{
		this.leftColumn = mLeftColumn;
	}
	
	
	/**
	    * Sätter den högra kolumen till den angivna array7 som skickas in i metoden.
	    * @param mRightColumn array7
	    */
	public void setRightColumn(Array7 mRightColumn)
	{
		this.rightColumn = mRightColumn;
	}
	
	
	/**
	    * Sätter fältet i mitten till den angivna array7x7 som skickas in i metoden.
	    * @param mMiddleColumn array7x7
	    */
	public void setMiddleColumn(Array7x7 mMiddleColumn)
	{
		this.middleGrid = mMiddleColumn;
	}
	
	

	
	//lyssnare för knapptryck
	private class MoveListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource().equals(btnLeft))
			{
				controller.moveLeft();	
			}
			
			else if(e.getSource().equals(btnRight))
			{
				controller.moveRight();
			}
						
			controller.update();
		}		
	}	
	
	
	//lyssnare för ändringar i JTextField
	private class ChangeListener implements DocumentListener
	{
		@Override
		public void insertUpdate(DocumentEvent e) {
			for(int i = 0; i < 7; i++)
			{			
				rightColumn.setElement(i, Integer.parseInt(tfRightColumn[i].getText()));
			}
				
			for(int i = 0; i < 7; i++)
			{		
				leftColumn.setElement(i, Integer.parseInt(tfLeftColumn[i].getText()));
			}

		}

		@Override
		public void removeUpdate(DocumentEvent e) 
		{
			// TODO Auto-generated method stub			
		}

		@Override
		public void changedUpdate(DocumentEvent e) 
		{
			// TODO Auto-generated method stub

		}		
	}	
}
