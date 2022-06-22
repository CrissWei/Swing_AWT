package awt_ZuJian_Day721.p492Paint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
  ��AWT��,�����ṩ��ͼ���ܵ���Graphics����
    * �����⡿����ôComponent�����Graphics�������ʲô��ϵ,������Component��������ͼ����?
    * ���𰸡�����Component����,�ṩ����������������������ͼ�εĻ�����ˢ��:

     ��ͼ3��������
        Paint(Graphics g):������������;��ϵͳ�Զ���
        update(Graphics g):�ڲ�����paint����,ˢ��������;��ϵͳ�Զ���
        repaint():����update����,ˢ��������; ���ֶ���
        ------------------------
�����л�ͼҲһ��,Ҳ��Ҫ����,����,���ϵȵȡ�
AWT���ṩ��Canvas��䵱����,�ṩ��Graphics�����䵱���ʣ�
 ͨ������Graphics�����setColor(�������Ը�����������ɫ)

��ͼ�Ĳ���:
    1.�Զ�����,�̳�Canvas��,��дpaint(Graphics g)������ɻ�ͼ;
    2.��paint�����ڲ�,������ʼ��ͼ֮ǰ����Graphics�����setColor)��setFont()�ȷ������û��ʵ���ɫ�����������;
    3.����Graphics���ʵ�drawXxx(������ʼ��ͼ��


-----------��ͼ���巽��------------------------
��������:               ��������:

//��ͼ
setColor(Color C)       ������ɫ
setFont(Font font)      ��������
drawLine()              ����ֱ��
drawRect()              ���ƾ���
drawRoundRect()         ����Բ�Ǿ���
drawOval()              ������Բ��
drawPolygon()           ���ƶ����
drawArc()               ����Բ��
drawPolyline()          ��������

//���
fillRect()              ����������
fillRoundRect()         ���Բ�Ǿ�������
fillOval()              �����Բ����
fllPolygon()            �����������
fllArc()                ���Բ����Ӧ����������
drawImage()             ����λͼ

*/
public class p492Graphics {
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";
    private Frame frame = new Frame("�����ǲ��Ի�ͼ����");

    //������ť
    Button buttonRect = new Button("���ƾ���");
    Button buttonOval = new Button("������Բ");
    //�����ı���
    TextArea ta = new TextArea("�����ı���",5,10);

//---------------------------
    //����һ������,��¼��ǰҪ����rect or oval
    private String shape ="";//���ַ���

    // 1.�Զ�����,�̳�Canvas��,��дpaint(Graphics g)������ɻ�ͼ;��׼������������
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //�����жϣ����Ʋ�ͬͼ��
            if (shape.equals(RECT_SHAPE)){
                //���ƾ���
                g.setColor(Color.PINK);//��ɫ
                g.drawRect(100,100,150,150);//���ε�����ʹ�С
            }else if (shape.equals(OVAL_SHAPE)) {
                //������Բ
                g.setColor(Color.RED);//��ɫ
                g.drawOval(100, 100, 150, 150);//��Բ������ʹ�С
            }
        }
    }
    //�����Զ���Ļ��������������÷���
    MyCanvas drawArea = new MyCanvas();
//-------------------

    public void init(){//����װ��ͼ����С����

        //���¼��������ȼ�����ť,�õ����ť���з�Ӧ
        buttonRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��һ�£��޸Ŀ��ַ�����ǵ�ֵ
                shape= RECT_SHAPE;//��ֵ
                //Ȼ��ͼ�������repaint�������ػ�
                drawArea.repaint();
            }
        });

        //������Բ��ť
        buttonOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape= OVAL_SHAPE;//��ֵ
                drawArea.repaint();//�ػ�
            }
        });
        //��װ�� ��2����ť��װ��Panel��Ȼ���Panel�ŵ�Frame�ϲ�
        Panel panel = new Panel();
        panel.add(buttonOval);
        panel.add(buttonRect);

        frame.add(panel, BorderLayout.SOUTH);//��һ��Ϊֹ���Ѿ��ѵײ���װ���ˣ�����������Frame�м�


        //���û���DrawArea��С,������СҪ��ͼ�δ�//���������С�����꣬��Ȼ����drawArea���򣬿�����,
        drawArea.setPreferredSize(new Dimension(500,500));
        //Ȼ���drawArea�ŵ�Frame�м�
        frame.add(drawArea);
        frame.add(ta,BorderLayout.NORTH);//�ı�����ڱ���


        //��С&�ɼ�
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new p492Graphics().init();
    }
}
