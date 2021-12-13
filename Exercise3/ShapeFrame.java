// package de.ase.ima;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// import de.ase.ima.shapes.Point;
// import de.ase.ima.shapes.Shape;
import shapes.Point;
import shapes.Shape;

public class ShapeFrame extends JFrame {
	private static final long serialVersionUID = 2356640056135798986L;

	private static final int OFFSET_X = 5;
	private static final int OFFSET_Y = 25;

	private List<Shape> shapes;
	
	private JFrame controlFrame;

	public ShapeFrame() {
		super("Shape frame demo");
		setSize(1000, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		// create control frame
		controlFrame = new JFrame("Control");
		JButton btn = new JButton("Calculate Perimeter");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				String msg = "";
				try {
					if (shapes.size() == 0) {
						msg = "No shapes have been drawn yet";
					}
					
					for (Shape s : shapes) {
						Method m = s.getClass().getMethod("calculatePerimeter");
						double perimeter = (double) m.invoke(s);
						msg += "Perimeter of shape (" + s.getClass() + "): " + String.format("%1$,.2f", perimeter) + "\n";
					}
				} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
					msg = "Method has not been implemented yet";
				}
				JOptionPane.showMessageDialog(controlFrame, msg);
			}
		});
		JPanel cp = new JPanel();
		cp.setBorder(new EmptyBorder(5, 5, 5, 5));
		cp.add(btn, BorderLayout.PAGE_START);
		controlFrame.setSize(400, 85);
		controlFrame.add(cp);
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setLocation(50, 50);
	}

	@Override
	public void setVisible(boolean b) {
		controlFrame.setVisible(b);
		super.setVisible(b);
	}
	
	public void drawShapes(List<Shape> shapes) {
		this.shapes = shapes;
		repaint();
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (shapes != null) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			// check each shape in list
			for (Shape s : shapes) {
				g2.setColor(s.getColor());
				GeneralPath path = generatePath(s);
				if (s.isFilled()) {
					g2.setPaint(s.getColor());
					g2.fill(path);
				}
				g2.draw(path);
			}

		}
	}

	private GeneralPath generatePath(Shape s) {

		// check if at least one line is defined
		if (s.getPoints() == null || s.getPoints().size() < 2) {
			return null;
		}

		// calculate the path
		GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, s.getPoints().size());
		Point p = s.getPoints().get(0);
		path.moveTo(p.getX() + OFFSET_X, p.getY() + OFFSET_Y);
		for (int i = 1; i < s.getPoints().size(); i++) {
			p = s.getPoints().get(i);
			path.lineTo(p.getX() + OFFSET_X, p.getY() + OFFSET_Y);
		}
		path.closePath();
		return path;
	}

}
