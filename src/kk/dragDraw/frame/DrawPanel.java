package kk.dragDraw.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawPanel extends JPanel {

    private int x0;
    private int y0;
    private String type;

    private Graphics2D graphics2D;
    public DrawPanel(){
        super();

        this.type = "freeDraw";
//        this.setBackground(Color.white);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                x0 = e.getX();
                y0 = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                graphics2D = (Graphics2D) getGraphics();
                if(type == "drawRect"){
                    graphics2D.drawRect(x0, y0, e.getX() - x0, e.getY() - y0);
                } else if(type == "drawCircle"){
                    graphics2D.drawOval(x0, y0, e.getX() - x0, e.getY() - y0);
                } else if(type == "drawLine"){
                    graphics2D.drawLine(x0, y0, e.getX(), e.getY());
                }

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if(type == "freeDraw") {
                    int x = e.getX();
                    int y = e.getY();
                    graphics2D = (Graphics2D) getGraphics();
                    graphics2D.drawLine(x0, y0, x, y);
                    x0 = x;
                    y0 = y;
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                graphics2D = (Graphics2D) getGraphics();
//                graphics2D.drawLine(x0, y0, e.getX(), e.getY());
            }
        });
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void clean(){
        graphics2D = (Graphics2D) this.getGraphics();
        Color tc = graphics2D.getColor();
        graphics2D.setColor(this.getBackground());
        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
        graphics2D.setColor(tc);
    }

    @Override
    public void paint(Graphics g) {
        g = this.graphics2D;
    }
}
