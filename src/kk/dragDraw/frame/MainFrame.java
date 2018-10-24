package kk.dragDraw.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener {

	DrawPanel drawPanel;
	JButton jbTextOut;
	JButton jbClean;
	JButton jbDraw;
	JButton jbDrawRect;
	JButton jbDrawLine;
	JButton jbDrawCircle;

	public MainFrame() {
		super("java »­Í¼");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panelUp = new JPanel();
		drawPanel = new DrawPanel();
		JPanel panelD = new JPanel();
		
		jbTextOut = new JButton("ÎÄ±¾Êä³ö");
		jbClean = new JButton("Çå¿Õ");
		panelUp.add(jbTextOut);
		panelUp.add(jbClean);
		
		jbDraw = new JButton("Í½ÊÖ»æ»­");
		jbDrawRect = new JButton("»­¾ØÐÎ");
		jbDrawLine = new JButton("»­Ïß");
		jbDrawCircle = new JButton("»­Ô²");

		jbTextOut.addActionListener(this);
		jbClean.addActionListener(this);
		jbDraw.addActionListener(this);
		jbDrawRect.addActionListener(this);
		jbDrawLine.addActionListener(this);
		jbDrawCircle.addActionListener(this);
		
		panelD.add(jbDraw);
		panelD.add(jbDrawRect);
		panelD.add(jbDrawLine);
		panelD.add(jbDrawCircle);

		
		
		
		panel.add(panelUp, BorderLayout.NORTH);
		panel.add(drawPanel, BorderLayout.CENTER);
		panel.add(panelD, BorderLayout.SOUTH);
		
		this.setContentPane(panel);
//		this.pack();
		this.setVisible(true);
		
	}
	
	public void init() {
		 
	}
	
	public static void main(String[] args) {
//		System.out.println(a == b);
		new MainFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbDraw){
			drawPanel.setType("freeDraw");
		} else if(e.getSource() == jbDrawCircle){
			drawPanel.setType("drawCircle");
		} else if(e.getSource() == jbDrawLine){
			drawPanel.setType("drawLine");
		} else if(e.getSource() == jbDrawRect){
			drawPanel.setType("drawRect");
		} else if(e.getSource() == jbClean){
//			drawPanel.setBackground(Color.white);
			drawPanel.clean();
		} else if(e.getSource() == jbTextOut){

		}
	}
}
