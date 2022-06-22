package awt_zz2Game_Day723;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class p506ChessGame {

    JFrame frame = new JFrame("��������Ϸ");

    //����4����Ա����BufferedImage���ֱ��ʾ4��ͼƬ
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage select;

    //����2����Ա�������������̵ĸ�height839&&��width835
    final int TABLE_WIDTH = 835;
    final int TABLE_HEIGHT = 839;

    //���������������¶�������
    final int BOARD_SIZE = 15;

    //����ÿһ������ռ���̵Ĵ�С�ߴ�
    final int RATE = TABLE_WIDTH / BOARD_SIZE;//835/15,���������̴�С���Ĩ�������������

    //������Ա��������¼������X&Y�����ϵ�ƫ����
    final int X_OFFSET = 5;
    final int Y_OFFSET = 9;//����ƫ�������

    //����һ����ά���飬��¼���ӣ��������[i][j]����ֵΪ: 0-û������,1-����,2-����
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    //������Ա��������¼ѡ���ĳ�ʼ���֮꣨����޸ĵģ�����ѡ���������ʵ���Ƕ�ά����board�е�����ֵ
    int select_X = -1;
    int select_Y = -1;

    //----�����ǳ�Ա����������-------------------------------------------
    //----�������Զ����࣬��Ϊ����-------------------------------------------
    public class ChessBoard extends Canvas{
        @Override
        public void paint(Graphics g) { //��ͼ�߼�
            //��������
            g.drawImage(table,0,0,null);

            //����ѡ���
            if (select_X>0&&select_Y>0){
                g.drawImage(select,select_X*RATE+X_OFFSET,select_Y*RATE+Y_OFFSET,null);
            }
            //���ƺڰ�����
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    //���ƺ���
                    if (board[i][j]==2){
                        g.drawImage(black,i*RATE+X_OFFSET,j+RATE+Y_OFFSET,null);
                    }
                    //���ư���
                    if (board[i][j]==1){
                        g.drawImage(white,i*RATE+X_OFFSET,j+RATE+Y_OFFSET,null);
                    }

                }
            }


        }
    }
    //�����Զ���������̶���������������ķ���
    ChessBoard cb= new ChessBoard();//Ϊ�˺������װ���̣���1���������̴�С��2����ӵ�frame�м�CENTER��

    //����������������¼��ǰ�������ɫ
    int board_type = 2;//Ĭ���Ǻ�ɫ��2����black,1��white,0����û�塣��ʱ����Ը���ɫ


    //�����ײ�Ҫ�õ������
    Panel panel = new Panel();
    Button whiteButton = new Button("����");
    Button blackButton = new Button("����");
    Button deleteButton = new Button("ɾ��");




    //-----------------------------------------------
    public void refreshButtonColor (Color white, Color black, Color delete) {
        whiteButton.setBackground (white) ;
        blackButton.setBackground (black) ;
        deleteButton.setBackground (delete);
    }

    //-----------------------------------------------

//----//������3����ť��������ΪListener-----------------------------
    private void init() throws Exception {//������3����ť��������ΪListener����װ��ͼ

        whiteButton.addActionListener(e -> {//��������尴ť��ʱ����Ҫ��ȫ2����
            //�޸ĵ�ǰҪ�µ����ӵı�־Ϊ1 ,��Ϊ����������1����������Ϊ2
            board_type=1;

            //ˢ�°�ť����ɫ����Ϊ3����ť��Ҫˢ�£�����Ϊ�˴����࣬�������װ��һ�����������ü��ɡ�
            refreshButtonColor(Color.GREEN,Color.gray,Color.gray);//�����°��尴ť�����尴ť���̣��������
        });
        blackButton.addActionListener(e -> {//��������尴ť��ʱ����Ҫ��ȫ2����
            //�޸ĵ�ǰҪ�µ����ӵı�־Ϊ1 ,��Ϊ����������1����������Ϊ2
            board_type=2;

            //ˢ�°�ť����ɫ����Ϊ3����ť��Ҫˢ�£�����Ϊ�˴����࣬�������װ��һ�����������ü��ɡ�
            refreshButtonColor(Color.gray,Color.GREEN,Color.gray);//�����º��尴ť�����尴ť���̣��������
        });
        deleteButton.addActionListener(e -> {//��������尴ť��ʱ����Ҫ��ȫ2����
            //�޸ĵ�ǰҪ�µ����ӵı�־Ϊ1 ,��Ϊ����������1����������Ϊ2
            board_type=0;

            //ˢ�°�ť����ɫ����Ϊ3����ť��Ҫˢ�£�����Ϊ�˴����࣬�������װ��һ�����������ü��ɡ�
            refreshButtonColor(Color.gray,Color.gray,Color.GREEN);//������ɾ����ť��ɾ����ť���̣��������
        });
//----3����ť��������Ϊ�� �������----------------------------

        //��װ�ײ���ť��Panel���ٴ�֮ǰ�����õ�������Ϊ��Ҳ�����ȵ�Listener
        panel.add(whiteButton);
        panel.add(blackButton);
        panel.add(deleteButton);

        //���panel��frame���ϲ�
        frame.add(panel,BorderLayout.SOUTH);

//----��װ���̿�ʼ----------------------------
        //�������̵�ͼƬ
        
        table= ImageIO.read(new File("Module1_awt\\image\\chess.jpg"));
        white= ImageIO.read(new File("Module1_awt\\image\\white.jpg"));
        black= ImageIO.read(new File("Module1_awt\\image\\black.jpg"));
        select= ImageIO.read(new File("Module1_awt\\image\\box.jpg"));



        //����������������ƶ�ʱ����Ϊ
        cb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                select_X = (e.getX()-X_OFFSET)/RATE;   //�����֮��ֵ��select_X
                select_Y = (e.getY()-Y_OFFSET)/RATE;   //�����֮��ֵ��select_X

                //�ػ�repaint
                cb.repaint();
            }
        });

        //��������������ϵ�������Ϊ
        cb.addMouseListener(new MouseAdapter() {
            //�����������ø÷���
            @Override
            public void mouseClicked(MouseEvent e) {
                int xPos = (e.getX()-X_OFFSET)/RATE;
                int yPos = (e.getY()-Y_OFFSET)/RATE;

                //�����������������������
                board[xPos][yPos]=board_type;
                //�ػ�
                cb.repaint();
            }

            @Override//������Ƴ�ȥ���������̽����ʱ��ѡ�����ʧ��Ҳ�����ػ���漴��
            public void mouseExited(MouseEvent e) {
                select_X=-1;
                select_Y=-1;
                cb.repaint();
            }
        });

        //��װ���̣���1���������̴�С��2����ӵ�frame�м�CENTER��
        cb.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));//1���������̴�С
        frame.add(cb);//2�������̣�drawArea��������ӵ�frame�м�CENTER
//---��װ�������-----------------------------



        //������Ѵ�С&�ɼ�
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

    public static void main(String[] args) throws Exception {
        new p506ChessGame().init();
    }

}
