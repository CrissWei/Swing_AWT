package awt_zz1Game_Day722.p500Image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/*
* �����������һЩ�򵥵ļ���ͼ��, �����ͼ��Ч����Ȼ�Ƚϵ�����AWT Ҳ����������ϻ���λͼ��
Graphics�ṩ��drawImage image)�������ڻ���λͼ,�÷�����Ҫһ��Image����һ����λͼ ,ͨ��
�÷÷��Ϳ��Ի��Ƴ�ָ����λͼ��

* λͼʹ�ò���:
    1.����Image���������BufferedImage(int width,int height,int ImageType)������ʱ��Ҫָ��λͼ�Ŀ�߼�����
        ����;��ʱ�൱�����ڴ���������һ��ͼƬ;
    2.����BufferedImage�����getGraphics(������ȡ����,��ʱ�Ϳ������ڴ��е�����ͼƬ�ϻ�ͼ��,��ͼ�ķ���
        ��֮ǰѧϰ��һģһ��;
    3.�������paint�������ṩ��Graphics�����drawImage(����, --���Ե��ڴ��е�ͼƬBufferedImage�� �Ƶ�
        �ض�������ϡ�
*/
public class p501Demo1 {

    private Frame frame = new Frame("���ֻ����");

    //���廭ͼ���Ŀ�&��
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //����һ���Ҽ��˵����������û��ʵ���ɫ
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("��ɫ");
    private MenuItem greenItem = new MenuItem("��ɫ");
    private MenuItem blueItem = new MenuItem(" ��ɫ");

    //����һ����������¼��ǰ���ʵ���ɫ,Ĭ����ɫΪBlack
    private Color currentColor = Color.BLACK;



    //1.����Image���������BufferedImage(int width,int height,int ImageType)
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);//ͼƬ����ΪRGB

    // 2.����BufferedImage�����getGraphics
    Graphics g = image.getGraphics();


    //�������ⶨ��2��������������¼����϶������У���һ���϶����������
    private int preX = -1;//Ĭ��Ϊ-1����ô��˼���ǵ�һ������û����һ�����
    private int preY = -1;


    //�Զ����ഴ��һ�黭����extends Canvas,��дpaint����--------------------------
    public class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //�������paint�������ṩ��Graphics�����drawImage
            /*  boolean b =*/
            g.drawImage(image, 0, 0, null);
        }

    }
    //�����Զ�����Ķ�����������������ķ���
    myCanvas drawArea = new myCanvas();
//----�Զ���������-------------------------------------------------------

    private void methodInit() {//�����ڲ�����װ��ͼ(��С��˿������װ)&&�߼�����

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                //�ж� ��ɫ��� switch case break;
                switch (ac) {
                    case "��ɫ":
                        currentColor = Color.RED;
                        break;
                    case "��ɫ":
                        currentColor = Color.GREEN;
                        break;
                    case "��ɫ":
                        currentColor = Color.blue;
                        break;
                }
            }
        };

        //�û����������ú�֮��ע��������������������Ϊ�����ֱ�add������Ӧ���¼�Դ
        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        blueItem.addActionListener(listener);

        //�㶨�����Events֮�󣬡���ʼ��װ�����ȴӼ򵥵�PopupMenu,����Ҽ���ʾ�˵��������ڴ���װ֮ǰҪ���õ�Event Listener��
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        //Ȼ���colorMenu��ӵ�drawArea����
        drawArea.add(colorMenu);


//--����Ҽ��˵�����װ--------------------------------------------------
        //���������ø�drawAreaע��MouseEvents & Listener : ����Ҽ���ʾ�˵���
        drawArea.addMouseListener(new MouseAdapter() {
           @Override
            //Released��ʾ�ͷ���꣬��˼�ǵ���겻�ٵ��������̧���ƶ���ʱ����ø÷���
            public void mouseReleased(MouseEvent e) {
                boolean pt = e.isPopupTrigger();//�Ƿ������

                if (pt) { //�˵�����e.getX(),e.getY()�Ǹ�������Ҽ������꣬��ʾshow����˵���
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }

                //����겻�ٵ�������ǵ�̧���ƶ���ʱ�����õ�1��������꣬
                preX = -1;
                preY = -1;
            }
        });
//--����Ҽ��˵�����װ--------------------------------------------------


        //����λͼ�ı���Ϊ��ɫ
        g.setColor(Color.white);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);//�������ɫ����������

        //���������ƶ�����������������Ļ��� [���ڻ���������������ƶ�]
        /*drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
*//*
                if (preX > 0 && preY > 0) {//�������϶����˲�ȥ������
                    //�����ʵ���ɫ
                    g.setColor(currentColor);
                    //��������һ������Ҫ2���㣬Ҳ����2�����꣬�ֱ���������������յ�����
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //���ǵ�һ�����ʱ������preX��preY��ֵ
                preX = e.getX();
                preY = e.getY();

                //�ػ������ˢ��flush
                drawArea.repaint();*//*
            }
        });*/

        //���������ƶ�����������������Ļ��� [���ڻ���������������ƶ�]

        drawArea.addMouseListener(new MouseAdapter() {//TMD��Ȼû��new MouseMotionAdapter
            @Override
            public void mouseDragged(MouseEvent e) {

                if (preX > 0 && preY > 0) {//�������϶����˲�ȥ������
                    //�����ʵ���ɫ
                    g.setColor(currentColor);
                    //��������һ������Ҫ2���㣬Ҳ����2�����꣬�ֱ���������������յ�����
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //���ǵ�һ�����ʱ������preX��preY��ֵ
                preX = e.getX();
                preY = e.getY();

                //�ػ������ˢ��flush
                drawArea.repaint();
            }
        });

        //������úû���drawArea�Ĵ�С��Ȼ��ѻ�����װһ�µ�Frame����ʾ
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
        frame.add(drawArea);


        //����Frame��Ѵ�С&�ɼ�
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new p501Demo1().methodInit();
    }

}
