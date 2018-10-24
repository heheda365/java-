package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel {
    public static void main(String args[]) {
        draw d = new draw();

    }
}

class draw extends JFrame {
    //�����������Ҫ�Ĺ���
    private JPanel jp1, jp2, jp3;
    //private MyCanvas canvas;
    private Graphics2D g;
//    private Graphics2D g;
    //����ѡ���б�
    private Choice ShapeChoice, SizeChoice, ColorChoice;
    //һЩ�ؼ�������
    private String controlName[] = {"��������:", "���ɻ滭", "ֱ��", "Բ", "����", "���ʴ�С:", "������ɫ:", "��Բ", "Բ�Ǿ���", "Բ����"};
    //�ɹ�ѡ�����ɫ
    private String ColorChoose[] = {"black", "blue", "cyan", "darkGray", "gray", "green", "lightGray",
            "magenta", "orange", "pink", "red", "white", "yellow"};
    private String BrushSize[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "30", "40"};
    private JLabel jb1, jb2, jb3, jb4, jb5;//������ʹ�õ���������ʾ��ǩ
    private JButton ClearButton;//������尴ť
    private JButton FreeDrawButton, DrawLineButton, DrawCircleButton,
            DrawEllipseButton, DrawRectangleButton, DrawRoundRectButton, DrawArcButton, clearButton;//ͼ��ѡ��ť
    Menu file, help;//�˵���
    MenuItem exit, about;//�˵���ѡ��
    //�ӿ�ܻ�ȡ������
    public String DrawWhat = "FreeDraw";//����ͼ������,Ĭ�����ɻ���
    public Color CurrentColor = Color.BLACK;//������ɫ��Ĭ�Ϻ�ɫ
    public int X0, Y0, X1, Y1, X2, Y2;//��������λ�ú��ɿ�����λ��,��굱ǰλ��
    public float brushSize = 1f;//���ʵĴ�С,Ĭ�ϴ�СΪ1f


    private Font f = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 30);//��������1
    private Font f1 = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 20);//��������2
    private Font f2 = new Font("΢���ź�", Font.LAYOUT_NO_LIMIT_CONTEXT, 16);//��������3

    class JDialog1 {
        //��ʼ������ʽ�Ի���
        JDialog jd1 = new JDialog(draw.this, "about", true);

        JDialog1() {
            jd1.setBounds(1100, 600, 400, 300);
            jd1.setVisible(false);
            jd1.setLayout(null);

            //���õ�һ���Ի�������
            JPanel jp1 = new JPanel();
            jp1.setBounds(0, 0, 400, 300);
            jp1.setLayout(null);
            JLabel jl4 = new JLabel("          "
                    + "�ƿ�2�� 2015111926 �Ÿ���");
            jl4.setBounds(0, 0, 400, 150);
            jl4.setFont(f1);
            jp1.add(jl4);
            JButton jb3 = new JButton("ȷ��");
            jb3.setBounds(150, 150, 100, 50);
            jb3.setBackground(Color.LIGHT_GRAY);
            jb3.setFont(f1);
            jb3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    jd1.dispose();
                }
            });
            jd1.add(jp1);
            jd1.add(jb3);
            jd1.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        }
    }

    public draw() {
        super("DrawPanel");
        this.show();
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        //this.setTitle("DrawPanel");//����ı���С�DrawPanel��
        this.setBounds(500, 300, 1200, 600);//���������򴰿ڵ�λ�úʹ�С
        this.setResizable(false);//���򴰿ڲ��ɸı��С
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//����رպ��˳�����
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();//��ʼ����壬���һ��Ų����ؼ�,�����Ż���,jp3�Ż���ͼ��ѡ��ť
        jp1.setBackground(Color.LIGHT_GRAY);//�Ų�����ť����屳��ɫ��Ϊ��ɫ
        jp2.setBackground(Color.white);//���屳��ɫΪ��ɫ
        jp3.setBackground(Color.LIGHT_GRAY);//ͼ��ѡ��������ɫΪ��ɫ
        //canvas = new MyCanvas();//��ʼ�����壬��Ϊ��ͼ������
        //�˵�������
        MenuBar mb = new MenuBar();
        this.setMenuBar(mb);
        file = new Menu("File");
        help = new Menu("Help");
        mb.add(file);
        mb.add(help);
        exit = new MenuItem("Exit");
        about = new MenuItem("about");
        file.add(exit);
        help.add(about);
        file.setFont(f1);
        help.setFont(f1);
        exit.setFont(f1);
        about.setFont(f1);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                //this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//���exit���˳�����
                System.exit(0);
            }

        });
        about.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new JDialog1().jd1.setVisible(true);
            }

        });
        //���ڲ�����������
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        jp1.setBounds(0, 0, 1500, 50);//���������������ڵ����Ϸ�
        jp2.setBounds(100, 50, 1400, 810);//�м��ǻ�ͼ������Ϣ��ʾ�����������ڵ����·�
        jp3.setBounds(0, 50, 100, 800);//ͼ��ѡ�����������
        jp1.setLayout(null);
        jp2.setLayout(null);
        jp3.setLayout(null);
        //��ʼ���ؼ�
        jb1 = new JLabel();
        jb2 = new JLabel();
        jb3 = new JLabel();
        ShapeChoice = new Choice();
        SizeChoice = new Choice();
        ColorChoice = new Choice();
        jb4 = new JLabel("�������ɻ���");
        jb5 = new JLabel("��ǰ���λ��:");
        ClearButton = new JButton("���");
        FreeDrawButton = new JButton("���ɻ���");
        DrawLineButton = new JButton("ֱ��");
        DrawCircleButton = new JButton("Բ");
        DrawEllipseButton = new JButton("��Բ");
        DrawRectangleButton = new JButton("����");
        DrawRoundRectButton = new JButton("Բ�Ǿ���");
        DrawArcButton = new JButton("Բ��");
        clearButton = new JButton("��Ƥ��");
        //���ð�ť�ı���
        ClearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.setBackground(Color.LIGHT_GRAY);
        FreeDrawButton.setBackground(Color.LIGHT_GRAY);
        DrawLineButton.setBackground(Color.LIGHT_GRAY);
        DrawCircleButton.setBackground(Color.LIGHT_GRAY);
        DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
        DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
        DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
        DrawArcButton.setBackground(Color.LIGHT_GRAY);
        //���ÿؼ��ϵ��ı�����
        jb1.setText(controlName[0]);
        jb2.setText(controlName[5]);
        jb3.setText(controlName[6]);
        //���������б������
        /*ShapeChoice.addItem("ʵ��");ShapeChoice.addItem("����");ShapeChoice.addItem("��Ƥ��");*/
        ColorChoice.addItem(ColorChoose[0]);
        ColorChoice.addItem(ColorChoose[1]);
        ColorChoice.addItem(ColorChoose[2]);
        ColorChoice.addItem(ColorChoose[3]);
        ColorChoice.addItem(ColorChoose[4]);
        ColorChoice.addItem(ColorChoose[5]);
        ColorChoice.addItem(ColorChoose[6]);
        ColorChoice.addItem(ColorChoose[7]);
        ColorChoice.addItem(ColorChoose[8]);
        ColorChoice.addItem(ColorChoose[9]);
        ColorChoice.addItem(ColorChoose[10]);
        ColorChoice.addItem(ColorChoose[11]);
        ColorChoice.addItem(ColorChoose[12]);
        SizeChoice.addItem(BrushSize[0]);
        SizeChoice.addItem(BrushSize[1]);
        SizeChoice.addItem(BrushSize[2]);
        SizeChoice.addItem(BrushSize[3]);
        SizeChoice.addItem(BrushSize[4]);
        SizeChoice.addItem(BrushSize[5]);
        SizeChoice.addItem(BrushSize[6]);
        SizeChoice.addItem(BrushSize[7]);
        SizeChoice.addItem(BrushSize[8]);
        SizeChoice.addItem(BrushSize[9]);
        SizeChoice.addItem(BrushSize[10]);
        SizeChoice.addItem(BrushSize[11]);
        SizeChoice.addItem(BrushSize[12]);
        SizeChoice.addItem(BrushSize[13]);
        //���ÿؼ�����
        jb1.setFont(f);
        ShapeChoice.setFont(f);
        jb2.setFont(f);
        jb3.setFont(f);
        SizeChoice.setFont(f);
        ColorChoice.setFont(f);
        jb4.setFont(f1);
        jb5.setFont(f1);
        ClearButton.setFont(f);
        clearButton.setFont(f1);

        FreeDrawButton.setFont(f2);
        DrawLineButton.setFont(f1);
        DrawCircleButton.setFont(f1);
        DrawEllipseButton.setFont(f1);
        DrawRectangleButton.setFont(f1);
        DrawRoundRectButton.setFont(f2);
        DrawArcButton.setFont(f1);
        //���ÿؼ�λ��
        /*jb1.setBounds(20, 0, 320, 50);ShapeChoice.setBounds(350, 0, 200, 50);*/
        jb2.setBounds(20, 0, 140, 50);
        SizeChoice.setBounds(170, 0, 80, 50);
        jb3.setBounds(270, 0, 140, 50);
        ColorChoice.setBounds(420, 0, 150, 50);
        jb4.setBounds(20, 750, 680, 50);
        jb5.setBounds(720, 750, 680, 50);
        ClearButton.setBounds(590, 0, 100, 50);


        //ͼ��ѡ��ťλ��
        FreeDrawButton.setBounds(0, 50, 100, 50);
        DrawLineButton.setBounds(0, 100, 100, 50);
        DrawCircleButton.setBounds(0, 150, 100, 50);
        DrawEllipseButton.setBounds(0, 200, 100, 50);
        DrawRectangleButton.setBounds(0, 250, 100, 50);
        DrawRoundRectButton.setBounds(0, 300, 100, 50);
        DrawArcButton.setBounds(0, 350, 100, 50);
        clearButton.setBounds(0, 400, 100, 50);
        //��ӿؼ�
        /*jp1.add(jb1);jp1.add(ShapeChoice);*/
        jp1.add(jb2);
        jp1.add(jb3);
        jp1.add(SizeChoice);
        jp1.add(jb3);
        jp1.add(ColorChoice);
        jp2.add(jb4);
        jp2.add(jb5);
        jp1.add(ClearButton);
        jp3.add(FreeDrawButton);
        jp3.add(DrawCircleButton);
        jp3.add(DrawEllipseButton);
        jp3.add(DrawRectangleButton);
        jp3.add(DrawRoundRectButton);
        jp3.add(DrawArcButton);
        jp3.add(DrawLineButton);
        jp3.add(clearButton);
        //ͼ��ѡ��ťע�������
        FreeDrawButton.addActionListener(new ActionListener() {//���ɻ���

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "FreeDraw";
                jb4.setText("�������ɻ���");
                FreeDrawButton.setBackground(Color.WHITE);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawLineButton.addActionListener(new ActionListener() {//ֱ��

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawLine";
                jb4.setText("���ڻ�ֱ��");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.white);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawCircleButton.addActionListener(new ActionListener() {//Բ

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawCircle";
                jb4.setText("���ڻ�Բ");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.WHITE);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawRectangleButton.addActionListener(new ActionListener() {//����

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawRectangle";
                jb4.setText("���ڻ�����");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.WHITE);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawRoundRectButton.addActionListener(new ActionListener() {//Բ�Ǿ���

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawRoundRect";
                jb4.setText("���ڻ�Բ�Ǿ���");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.WHITE);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawEllipseButton.addActionListener(new ActionListener() {//��Բ

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawEllipse";
                jb4.setText("���ڻ���Բ");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.WHITE);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        DrawArcButton.addActionListener(new ActionListener() {//Բ��

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "DrawArc";
                jb4.setText("���ڻ�Բ��");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.WHITE);
                clearButton.setBackground(Color.LIGHT_GRAY);
            }

        });
        clearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                DrawWhat = "Clear";
                jb4.setText("����ʹ����Ƥ��");
                FreeDrawButton.setBackground(Color.LIGHT_GRAY);//����һ����ť֮�������ť����ɫ����Ϊ��ɫ��������ť����ɫ�ָ�Ϊ����ɫ
                DrawLineButton.setBackground(Color.LIGHT_GRAY);
                DrawCircleButton.setBackground(Color.LIGHT_GRAY);
                DrawRectangleButton.setBackground(Color.LIGHT_GRAY);
                DrawRoundRectButton.setBackground(Color.LIGHT_GRAY);
                DrawEllipseButton.setBackground(Color.LIGHT_GRAY);
                DrawArcButton.setBackground(Color.LIGHT_GRAY);
                clearButton.setBackground(Color.white);
            }

        });

        SizeChoice.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent arg0) {
                // TODO Auto-generated method stub
                if (SizeChoice.getSelectedIndex() == 0) brushSize = 1f;
                else if (SizeChoice.getSelectedIndex() == 1) brushSize = 2f;
                else if (SizeChoice.getSelectedIndex() == 2) brushSize = 3f;
                else if (SizeChoice.getSelectedIndex() == 3) brushSize = 4f;
                else if (SizeChoice.getSelectedIndex() == 4) brushSize = 5f;
                else if (SizeChoice.getSelectedIndex() == 5) brushSize = 6f;
                else if (SizeChoice.getSelectedIndex() == 6) brushSize = 7f;
                else if (SizeChoice.getSelectedIndex() == 7) brushSize = 8f;
                else if (SizeChoice.getSelectedIndex() == 8) brushSize = 9f;
                else if (SizeChoice.getSelectedIndex() == 9) brushSize = 10f;
                else if (SizeChoice.getSelectedIndex() == 10) brushSize = 15f;
                else if (SizeChoice.getSelectedIndex() == 11) brushSize = 20f;
                else if (SizeChoice.getSelectedIndex() == 12) brushSize = 30f;
                else if (SizeChoice.getSelectedIndex() == 13) brushSize = 40f;

            }

        });

			/*//����ѡ��ע������������õ�ǰ���Ƶ�ͼ��
			ShapeChoice.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					if(ShapeChoice.getSelectedIndex() == 0) {
						dash = new BasicStroke(brushSize);
					}
					else if(ShapeChoice.getSelectedIndex() == 1) {
						dash = new BasicStroke(brushSize, BasicStroke.CAP_BUTT,
				                BasicStroke.JOIN_ROUND,brushSize, new float[] { 15, 10, },
				                0f);
					}
					else if(ShapeChoice.getSelectedIndex() == 2) {
						CurrentColor = Color.WHITE;
					}


				}

			});*/
        //������ɫѡ��ע������������õ�ǰ������ɫ
        ColorChoice.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                // TODO Auto-generated method stub
                if (ColorChoice.getSelectedIndex() == 0) CurrentColor = Color.black;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 1) CurrentColor = Color.blue;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 2) CurrentColor = Color.cyan;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 3) CurrentColor = Color.darkGray;//���ɫ
                else if (ColorChoice.getSelectedIndex() == 4) CurrentColor = Color.gray;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 5) CurrentColor = Color.green;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 6) CurrentColor = Color.lightGray;//ǳ��ɫ
                else if (ColorChoice.getSelectedIndex() == 7) CurrentColor = Color.magenta;//����ɫ
                else if (ColorChoice.getSelectedIndex() == 8) CurrentColor = Color.orange;//�ۻ�ɫ
                else if (ColorChoice.getSelectedIndex() == 9) CurrentColor = Color.pink;//�ۺ�ɫ
                else if (ColorChoice.getSelectedIndex() == 10) CurrentColor = Color.red;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 11) CurrentColor = Color.white;//��ɫ
                else if (ColorChoice.getSelectedIndex() == 12) CurrentColor = Color.yellow;//��ɫ
                System.out.println(CurrentColor.toString());

            }

        });

        ClearButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 1500, 770);
            }


        });
        //����һ���滭��
        g = (Graphics2D) this.getGraphics();
        g.setClip(110, 120, 1500, 750);
			/*//g.clipRect(0,100,1500,850);//���ò��˻��屳��ɫ
			g.setColor(Color.WHITE);
			g.fillRect(0,0,1500,750);*/
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            public void mousePressed(MouseEvent e) {//��갴��ȥ��ʱ���ȡ��ʼ���������
                X0 = e.getX();
                Y0 = e.getY();
            }

            public void mouseReleased(MouseEvent e) {//�ɿ���ʱ���ȡ�������꣬������������Ĺ�ϵ���Ʋ�ͬ��ͼ��
                X1 = e.getX();
                Y1 = e.getY();
                g.setStroke(new BasicStroke(brushSize));
                g.setColor(CurrentColor);

                if (DrawWhat == "DrawLine") {//��ֱ��
                    g.drawLine(X0, Y0, X1, Y1);
                } else if (DrawWhat == "DrawCircle") {//��Բ
                    g.drawOval(X0, Y0, X1 - X0, X1 - X0);
                } else if (DrawWhat == "DrawRectangle") {//������
                    g.drawRect(X0, Y0, X1 - X0, Y1 - Y0);
                } else if (DrawWhat == "DrawEllipse") {//����Բ
                    g.drawOval(X0, Y0, X1 - X0, Y1 - Y0);
                } else if (DrawWhat == "DrawRoundRect") {//��Բ�Ǿ���
                    g.drawRoundRect(X0, Y0, X1 - X0, Y1 - Y0, 40, 25);
                } else if (DrawWhat == "DrawArc") {//��Բ����
                    g.drawArc(X0, Y0, X1 - X0, Y1 - Y0, 0, 180);
                }
            }

        });
        addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {//����϶���ʱ��һֱ�ڻ�ȡ��������
                // TODO Auto-generated method stub
                X1 = e.getX();
                Y1 = e.getY();
                jb5.setText("��ǰ���λ��:" + X1 + " " + Y1);//������϶���������ʾλ��
                g.setStroke(new BasicStroke(brushSize));
                g.setColor(CurrentColor);
                if (DrawWhat == "FreeDraw") {//һֱ���Ƶ�ǰ�㣬�����������ϵ�����ͻ�������
                    g.setColor(CurrentColor);
                    g.drawLine(X0, Y0, X1, Y1);
                    X0 = e.getX();
                    Y0 = e.getY();
                } else if (DrawWhat == "Clear") {//������ʵ�����ɻ��Ʋ���
                    g.setColor(Color.white);
                    g.drawLine(X0, Y0, X1, Y1);
                    X0 = e.getX();
                    Y0 = e.getY();
                }
                /*
                 * ��������ͼ��һ�߻�һ����ʾ�ģ���������������ԭ����ͼ�����Ѿ����˵�ͼ�β���
                 */
					else if(DrawWhat == "DrawRectangle") {//������
						g.drawRect(X0, Y0, X1-X0, Y1-Y0);
						g.setColor(Color.white);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						g.drawRect(X0, Y0, X1-X0, Y1-Y0);
					}
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                X2 = e.getX();
                Y2 = e.getY();
                jb5.setText("��ǰ���λ��:" + X2 + " " + Y2);//������ƶ���������ʾλ��
            }

        });
    }
}
//