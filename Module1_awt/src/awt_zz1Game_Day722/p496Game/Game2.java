package awt_zz1Game_Day722.p496Game;
//�����޸�С���ʼ�ٶȣ���100����repaintˢ��һ��
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game2 {
    //----------------------------------������һЩ��Ա������---------------------
    //���ڶ���
    private Frame frame = new Frame("����С��Ϸ");

    //�������桾�߶�&��ȡ�
    private final int TABLE_WIDTH = 300; //������
    private final int TABLE_HEIGHT = 400;//����߶�

    //�������ġ��߶�&��ȡ�
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //����С��Ĵ�С
    private int BALL_SIZE = 16;//С���ֱ����16������

    //�����������¼���ĵġ���ʼ���꡿
    private int racket_X = 120; //û��final���Σ�X�����ǿɱ�ģ�����Ҫ�ƶ�
    private final int racket_Y = 340;//��final���Σ����ĵ�Y�᷽������

    //�����������¼С��ġ���ʼ���꡿��//��ע�⡿��ΪС�������䶯�����ܱ�final����
    private int ball_X = 120;
    private int ball_Y = 20;

    //�����������¼С����x��y�����Ϸֱ��ƶ��ġ���ʼ�ٶȡ�
    private int speed_X = 10;//һ���ƶ�10������
    private int speed_Y = 5;//һ���ƶ�5������

    //��Ϊ��Ϸ�п��ܽ�����������Ҫ����һ�������������ж���Ϸ�Ƿ������
    private boolean isOver = false;//Ĭ����falseû�н���,��isOver=true,��ô��Ϸ����

    //����һ������ʱ��Timer������swing���У�,100�����ػ�repaintһ��
    //private Timer timer;����util���µ�Timer����swing���µ�
    //private javax.swing.Timer timer;
    private Timer timer;
//----------------------------------������һЩ��Ա������---------------------

    //��Ҫ������һ�黭���������������� ������������Զ���һ���ࡾ�ڲ��ࡿȥ�̳�extends Canvas����дpaint���������䵱����
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //���������ݡ����ص� ��������2�����֣�1.��Ϸ���� 2.������Ϸ��
//--1.��Ϸ����---------------------------------------
            if (isOver) {//���isOver = true
                //��Ϸ�����Ļ�������
                g.setColor(Color.GREEN);//������ɫ
                g.setFont(new Font("Times", Font.BOLD, 30));//��������
                g.drawString("��Ϸ����!!!", 50, 200);//������4���ֵĳ�������
//--1.��Ϸ����---------------------------------------

//----2.������Ϸ-----------------------------------
            } else {//Ĭ����isOver = false,������Ϸ
                //������Ϸ�Ļ������£���Ҫ����2�����֡�����С�򡿺͡��������ġ�

                //������С��
                g.setColor(Color.RED);//С�����ɫ
                //�������drawOval����һ�����ĵ�С�򣬶���ҪfillOval�����С��ʵ��
                g.fillOval(ball_X, ball_Y, BALL_SIZE, BALL_SIZE);//��Ч��g.fillOval(120,20,16,16);

                //���������ġ�
                g.setColor(Color.PINK);
                //g.fillOval(120,340,300,300);�������Ч
                g.fillRect(racket_X, racket_Y, RACKET_WIDTH, RACKET_HEIGHT);//120,340,300,300
            }
        }
    }
//----2.������Ϸ-----------------------------------


    //�������滭�����򡿸��ݸ��Զ�����������������Ա�����ö�����drawArea�����÷���
    MyCanvas drawArea = new MyCanvas();


    private void init() {//�ڷ����ڡ���װ��ͼ���Լ���Ϸ���߼��Ŀ��ơ�

//---�����û�����----------------------------------------
        //����������������ĵ�����仯repaint
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //��ȡ�û���ǰ���µļ�keyCode
                int keyCode = e.getKeyCode();

                //�ж��û��ǰ�������<- ���ǰ� �ҷ���->����
                if (keyCode == KeyEvent.VK_LEFT) {//�����ǰ����==���<-
                    //<-������������ƶ�����
                    if (racket_X > 0) {//�������߽�//������ĵġ����Ͻ���һ��ġ�X�������0����������
                        racket_X -= 10;//x-=2-->x=x-2;
                    }
                }
                if (keyCode == KeyEvent.VK_RIGHT) {//�����ǰ����==�Ҽ�->
                    //->������������ƶ�����
                    if (racket_X < (TABLE_WIDTH - RACKET_WIDTH)) {//�����Ҳ�߽磬����X����>(������-���Ŀ��)
                        racket_X += 10;//һ���ƶ�10������
                    }
                }
            }
        };
        //����ġ�������Listener��д��󣬲����Զ����У��ú͡��¼�ԴEvent���󶨲���
        //�¼�Դ������Frame��Ҳ������drawArea���ɴ�һ��󶨣���ȥע�������
        frame.addKeyListener(keyListener);
        drawArea.addKeyListener(keyListener);
//---�����û�����----------------------------------------

//--��С������Ŀ��ơ�--------------------------------------------
        ActionListener task = new ActionListener() {
            @Override
            //���ݱ߽緶Χ������X��Y������ٶȣ���Ϊ�����˶����ٶȴ�С���䣬�����෴
            public void actionPerformed(ActionEvent e) {
                //�޸�С�� X �᷽����ٶ�
                if (ball_X <= 0 || ball_X >= (TABLE_WIDTH - BALL_SIZE)) {
                    speed_X = -speed_X;//�ٶȴ�С���䣬�����෴
                }
                //�޸�С�� Y �᷽����ٶȡ���С�����������ϵ�ʱ����޸�С��Y���ٶȡ�
                if (ball_Y <= 0 || ball_Y > racket_Y - BALL_SIZE && ball_X > racket_X && ball_X < racket_X + RACKET_WIDTH) {
                    speed_Y = -speed_Y;
                }
                //��С��û���������ϣ���Ϸ����  //[�о��ǻ���||]
                if (ball_Y > racket_Y-BALL_SIZE && (ball_X < racket_X || ball_X>racket_X+RACKET_WIDTH)) {
                    //ֹͣ��ʱ��
                    timer.stop();
                    //�޸ı��Ϊtrue
                    isOver = true;
                    //�ػ����
                    drawArea.repaint();
                }
                //����С������꣬�ػ�repaint����
                ball_X += speed_X;//+10������
                ball_Y += speed_Y;//+5������

                //ˢ���ػ����repaint
                drawArea.repaint();
            }
        };

//--��С������Ŀ��ơ�---------------------------------------------

        //100�������»���repaintˢ��һ�ν���
        /*timer = new Timer(100,task);
        timer.start();//����ʱ��*/
        timer = new Timer(50,task);
        timer.start();


        //���û����ĳ��Ϳ�
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        //���ѻ�ͼ��������ӵ�frame����ʾ����
        frame.add(drawArea);


        //������ɫ����С���ɼ�
        frame.setBackground(Color.WHITE);
        frame.pack();
        frame.setVisible(true);

        //�رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        new Game2().init();//���ù��췽��init
    }
}
