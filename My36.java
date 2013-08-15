import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
public class My36
{
	public static void main(String[] args)
	{
	    System.out.println("It is program My36");
	    System.out.println("vaddimart");
		MyFrame frame=new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}
class MyFrame extends JFrame
{
	public MyFrame()
	{
		setTitle("Main frame");
		setSize(500,400);
		MyPanel panel=new MyPanel();
		Container pane=getContentPane();
		pane.add(panel);
	}
}
class MyPanel extends JPanel
{
	public MyPanel()
	{
		Action yellowAction= new MyAction("Yellow", new ImageIcon("yellow-ball.gif"),Color.yellow);
		Action blueAction= new MyAction("Blue", new ImageIcon("blue-ball.gif"),Color.blue);
		Action redAction= new MyAction("Red", new ImageIcon("red-ball.gif"),Color.red);
		Action greenAction= new MyAction("Green", new ImageIcon("green-ball.gif"),Color.green);
		add(new JButton(yellowAction));
		add(new JButton(blueAction));
		add(new JButton(redAction));
		add(new JButton(greenAction));

		InputMap imap=getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"),"panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl B"),"panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"),"panel.red");
		imap.put(KeyStroke.getKeyStroke("ctrl G"),"panel.green");
		ActionMap amap=getActionMap();
		amap.put("panel.yellow",yellowAction);
		amap.put("panel.blue",blueAction);
		amap.put("panel.red",redAction);
		amap.put("panel.green",greenAction);
	}

	public class MyAction extends AbstractAction
	{
		public MyAction(String name,Icon icon,Color c)
		{
			putValue(Action.NAME,name);
			putValue(Action.SMALL_ICON, icon);
			putValue("color",c);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to "+name.toLowerCase());
		}
		public void actionPerformed(ActionEvent event)
		{
			Color c=(Color)getValue("color");
			setBackground (c);
		}
	}
}