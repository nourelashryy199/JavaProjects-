import java.awt.BorderLayout; // to manage layout of components (North, South, East, West, Center)
import java.awt.Container; // to hold components in the frame
import java.awt.GridLayout; // arranges components in a grid of rows and columns
import java.awt.event.ActionEvent; //represents action events like button clicks
import java.awt.event.ActionListener; //interface to handle action events
import javax.swing.JButton; // to create clickable buttons
import javax.swing.JFrame; // main window frame
import javax.swing.JPanel; // to create a panel to hold components

public class MyFrame extends JFrame implements ActionListener { //main application window

    // a panel to draw polygons
    private MyPanel drawingPanel; // instance variable for the custom drawing panel

    public MyFrame() {  // constructor to set up the frame
	setTitle("Polygon Drawer"); // setting title of the frame
	setSize(400, 400); // setting initial size of the frame
	setLocationRelativeTo(null); // center on screen

	Container contentPane = this.getContentPane(); // get the content pane to add components
	drawingPanel = new MyPanel(); // create an instance of MyPanel for drawing
	contentPane.add(drawingPanel, BorderLayout.CENTER); //add drawing panel to center of content pane

	/* create a column of buttons using GridLayout in an ordinary JPanel
	 * (because it doesn't need extra functionality) on the EAST side of
	 * the content pane.
	 */
	JPanel columnOfButtons = new JPanel(new GridLayout(8,1));
	for (int i = 3; i < 10; i++) { //create buttons for polygons with 3 to 9 sides
	    makeButton(columnOfButtons, String.valueOf(i), this); // add button to panel and set this frame as listener
	}
	makeButton(columnOfButtons, "Exit", this); // add exit button
	contentPane.add(columnOfButtons, BorderLayout.EAST); // add button panel to the east side of content pane
    }

    // add a button to the specified JPanel and make the JPanel listen
    private void makeButton(JPanel p, String name, ActionListener target) { // method to create and add a button
	JButton b = new JButton(name); // create a new button with the specified name
	p.add(b); // add the button to the specified panel
	b.addActionListener(target); // set the specified target as the action listener for the button
    }

    public void actionPerformed(ActionEvent e) { // handle button click events
	String cmd = e.getActionCommand(); // get the command associated with the button click
	if (cmd.equals("Exit")) { // if the exit button was clicked
		System.exit(0); // terminate the application
	} else {
	    int sides = Integer.parseInt(cmd); // parse the number of sides from the button label
	    drawingPanel.setPolygonSides(sides); // set the number of sides in the drawing panel
	}
}

    public static void main(String args[]) {
	JFrame frm = new MyFrame();
	frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frm.setVisible(true);
    }
}
