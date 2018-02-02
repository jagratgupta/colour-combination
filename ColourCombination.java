import java.awt.*;
import java.awt.event.*;

 class WindowCloser extends WindowAdapter
{
	public void windowClosing(WindowEvent e)
	{
		Window w = e.getWindow();
		w.setVisible(false);
		w.dispose();
		System.exit(1);
	}
}
class ColourCombination implements AdjustmentListener
{
	Frame f;
	Panel p1,p2,p3;
	Scrollbar sb1,sb2,sb3;
	TextField t1,t2,t3;
	int red,green,blue;
	Color c ;
	
	
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		  red=sb1.getValue();
			t1.setText(red+"");
		
		  green=sb2.getValue();
			t2.setText(green+"");
		
		  blue=sb3.getValue();
			t3.setText(blue+"");
	
		c = new Color(red,green,blue);
	
		/*p3 = new Panel();
		p3.setBackground(c);
		
		f.add(p3,"Center");
		*/
		f.setBackground(c);
		f.setVisible(true);
		
				
		
	}
	
	
	public ColourCombination()
	{
			f = new Frame();
			f.setTitle("frame");
			f.setSize(200,300);
		
		BorderLayout bl = new BorderLayout();
		
		f.setLayout(bl);
		
		Color c1=new Color(200,32,36);
		Panel p1 = new Panel(new GridLayout(0,3));
		p1.setBackground(c1);
		
		

		
		 sb1 = new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		sb1.setBackground(Color.red);
		sb1.addAdjustmentListener(this);
		p1.add(sb1);
		
		 sb2 = new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		sb2.setBackground(Color.green);	

		sb2.addAdjustmentListener(this);		
		p1.add(sb2);
		
		 sb3 = new Scrollbar(Scrollbar.VERTICAL,0,5,0,260);
		sb3.setBackground(Color.blue);
		sb3.addAdjustmentListener(this);
		p1.add(sb3);
		
		f.add(p1,"East");		
		
		Panel p2 = new Panel();
		p1.setBackground(Color.orange);
		
		Label l1 = new Label("Red");
		p2.add(l1);
		
		t1 = new TextField(50);
		p2.add(t1);
		
		Label l2 = new Label("Green");
		p2.add(l2);
		
		t2 = new TextField(50);
		p2.add(t2);
		
		Label l3 = new Label("Blue");
		p2.add(l3);
		
		t3 = new TextField(50);
		p2.add(t3);
		
		f.add(p2,"South");

		WindowCloser wc = new WindowCloser();
		f.addWindowListener(wc);
		f.setVisible(true);
	}
	
	public static void main (String args[])
	{
		ColourCombination cc = new ColourCombination();
		
	}
	

}