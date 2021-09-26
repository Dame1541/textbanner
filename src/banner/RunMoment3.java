package banner;

import java.util.Random;

import javax.swing.JFrame;


/* Klassen skapar ett controller2-objekt med inmatade värden som körs i ett frame-objekt
 * @author Andreas Jönsson den 13/1-2019  
 * 
 **/
public class RunMoment3 
{

	public static void main(String [] args)
	{
		Random rng = new Random();
		
	    Array7 testArray1 = new Array7();
	    Array7 testArray2 = new Array7();
	    Array7x7 testArray3 = new Array7x7();
	    
	    //ger elementen i testArray1,testArray2 och testArray3 ett slumpat värde
	    for(int i = 0; i < 7; i++)
		{
			testArray1.setElement(i, rng.nextInt(9));
			
		}
	    
	    for(int i = 0; i < 7; i++)
		{
			testArray2.setElement(i, rng.nextInt(9));
			
		}

	    for(int x = 0; x < 7; x++)
		{
	    	for(int y = 0; y < 7; y++)
			{
	    		testArray3.setElement(x, y, rng.nextInt(9));
			}
		}
	    
		//skapar controller2-objektet	    
		Controller2 controller = new Controller2(testArray1, testArray2, testArray3);
		
		//skapar frame-objektet
		JFrame frame1 = new JFrame( "SSPViewer" );
		frame1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame1.add(controller.getUI());
		frame1.pack();
		frame1.setVisible( true );
	}
}
