package banner;

import java.util.Random;

import javax.swing.*; 


/* Klassen skapar ett controller2-objekt med inmatade värden som körs i ett frame-objekt
 * @author Andreas Jönsson den 13/1-2019  
 * 
 **/
public class Controller2 
{
	//skapar alla objekt i klassen
	private Test2UI ui;
	private Array7x7 middleGrid;
	private Array7 leftColumn;
	private Array7 rightColumn;
	
	Random rng = new Random();
	
	 /**
	    * Konstruerar och initialiserar ett controller2-objekt.
	    * controller = new Controller2()
	    */
	public Controller2()
	{
		middleGrid= new Array7x7();	
		rightColumn = new Array7();	
		leftColumn = new Array7();	
	
		
		//ger slumpartade värden till alla värden
		for(int i = 0; i < 7; i++)	
		{		
			rightColumn.setElement(i, rng.nextInt(8));		
			leftColumn.setElement(i, rng.nextInt(8));
				
			for(int j = 0; j < 0; j++)		
			{			
				middleGrid.setElement(i, j, rng.nextInt(8));		
			}
		}	
	
		//inititerar Test2UI-objektet
		ui = new Test2UI(this.leftColumn, this.rightColumn, this.middleGrid, this);
	}	
	
	 /**
	    * Konstruerar och initialiserar ett controller2-objekt med angivna värden.
	    * controller = new Controller2()
	    * @param mLeftColumn vänster kolumn
	    * @param mRightColumn höger kolumn
	    * @param mmArray mittenfäältet
	    */
	public Controller2(Array7 mLeftColumn, Array7 mRightColumn, Array7x7 mArray)
	{
		middleGrid= mArray;
	rightColumn = mRightColumn;
	leftColumn = mLeftColumn;
	
	//inititerar Test2UI-objektet
	ui = new Test2UI(this.leftColumn, this.rightColumn, this.middleGrid, this);
	}		

	
	

	//get-metoder för controller2-klassen
	
	
	/**
	    * Retunerar mittenfältet
	    *  som en array7x7.
	    * @return array7x7 mittenfältet
	    */
	public Array7x7 getArray()
	{
		return this.middleGrid;
	}
	
	
	/**
	    * Retunerar den högra kolumnen som en array7.
	    * @return array7 höger kolumn
	    */
	public Array7 getLeftColumn()
	{
		return this.leftColumn;
	}
	
	
	/**
	    * Retunerar den vänstra kolumnen som en array7.
	    * @return array7 vänster kolumn
	    */
	public Array7 getRightColumn()
	{
		return this.rightColumn;
	}
	
	
	/**
	    * Retunerar Test2UI som controller2 använder.
	    * @return Test2UI userInterface för controller2 objektet
	    */
	public Test2UI getUI()
	{
		return this.ui;
	}
	
	
	
	
	/**
	    * Uppdaterar alla elementen i test2ui-objektet i controller2-klassen
	    */
	public void update()
	{
		for(int i = 0; i < 7; i++)
		{
			this.ui.getLeftTfColumn()[i].setText(Integer.toString(this.ui.getLeftColumn().getElement(i)));			
			this.ui.getRightTfColumn()[i].setText(Integer.toString(this.ui.getRightColumn().getElement(i)));

			for(int j = 0; j <7; j++)
			{

				this.ui.getMiddleLblColumn()[i][j].setText(Integer.toString(this.ui.getMiddleColumn().getElement(i, j)));
			}
		}
	}
	
	
	
	
	/**
	    * Flyttar alla element till vänster i mittenfältet
	    */
	public void moveLeft()
	{
		this.ui.setLeftColumn(this.ui.getMiddleColumn().shiftLeft(this.ui.getRightColumn()));
	}
	
	
	
	
	/**
	    * Flyttar alla element till höger i mittenfältet
	    */
	public void moveRight()
	{
		this.ui.setRightColumn(this.ui.getMiddleColumn().shiftRight(this.ui.getLeftColumn()));;
	}
}



