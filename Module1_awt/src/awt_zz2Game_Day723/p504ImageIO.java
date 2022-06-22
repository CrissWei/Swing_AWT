package awt_zz2Game_Day723;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
* 2.8.4 ImageIO��ʹ��
��ʵ��������,�ܶ������֧�ִ򿪱��ش����Ѿ����ڵ�ͼƬ,Ȼ����б༭,�༭��Ϻ�,�����±��浽���ش�
�̡����ʹ��awtҪ��������Ĺ���,��ô��Ҫʹ�õ�ImageIO�����,���Բ������ش��̵�ͼƬ�ļ���

* ��������:                 ��������:

static BufferedImage read(File input)           ��ȡ���ش���ͼƬ�ļ�
static BufferedImage read(InpUutStream input)   ��ȡ���ش���ͼƬ�ļ�
static boolean write(RenderedImage im, String formatName, File output)  �����ش��������ͼƬ�ļ�
*/
public class p504ImageIO{
    Frame frame = new Frame("ͼƬ�鿴��");

    //�����˵���MenuBar����������Ӳ˵�Menu���
    MenuBar menuBar = new MenuBar();

    Menu menu = new Menu("�ļ�");
    MenuItem open = new MenuItem("��");
    MenuItem save = new MenuItem("���Ϊ");

    //����һ��BufferedImage���󣬼�¼���ش�ȡ���ڴ��е�ͼƬ
    BufferedImage image;

    //�Զ���һ����extends Canvas������ͼ����дpaint����������ͼ
    public class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);//���ù۲���Ϊnull
        }
    }
    MyCanvas drawArea = new MyCanvas();//�����Զ�����࣬������������


//-----������init�����￪ʼ��װ��ͼ----��С������װ--------------
    private void init() throws Exception{

        //�����Ǽ�����open,���滹�м���save----------------------------
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                e.getActionCommand();
                //�������󣬴��ļ��Ի���
                FileDialog fd = new FileDialog(frame,"��ͼƬ",FileDialog.LOAD);//0�ʹ���FileDialog.LOAD
                fd.setVisible(true);//���öԻ���ɼ�

                //ѡ�����֮�󣬽������ǻ�ȡ�û�ѡ���ͼƬ·��path�Լ�����name��Ϊ������Ķ�ȡ
                String dirPath = fd.getDirectory();//�ļ�·��
                String fileName = fd.getFile();//�ļ�����

                //Ȼ��ʹ��ImageIO����ȡ�ļ�
             /*   try {
                    //����������õ���·���������ȥ���������Ϳ��Զ�ȡ�ļ���Ȼ��Ѷ�ȡ�����ݸ�ֵ��image
                    image = ImageIO.read(new File(dirPath, fileName));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
                BufferedImage read = null;
                try {
                    read = ImageIO.read(new File(dirPath, fileName));//��ʽ���ǡ�jpg,JPEG���п��ܱ���
                    //��Ҫ�ػ�repaint
                    drawArea.repaint();//�ػ��˾Ϳ���չʾ��ǰ��ȡ��ͼƬ��
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                image =read;//��ֵ��image


            }
        });
        //------����open���----�����Ǳ���save----------------------
        save.addActionListener(e -> {//�����ڲ��࣬����Ҳ���Բ���Lambda
            //�����ļ��Ի������
            FileDialog fd = new FileDialog(frame,"����ͼƬ",FileDialog.SAVE);
            fd.setVisible(true);//���öԻ���ɼ�

            //��ȡ�û�user�����·��path���ļ�����name
            String dirPath = fd.getDirectory();
            String fileName = fd.getFile();

            try {//ֻ�ܴ�ͼƬ��ʽΪ��JPEG,jpg�������򱨴� *********���Բ��ԣ�������ʽ����PNGҲ�����Դ򿪣����棬�����޸ı����ʽ
                ImageIO.write(image,"PNG",new File(dirPath,fileName));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        //-----����saveҲ������ϣ������Ϊ��ϣ��������Ŀ��Դ򿪺ͱ���ͼƬ------------------------



       //�ȰѴ򿪺��������װ���˵��� //---�����棬-----�ȵ���Event����Listener----
        menu.add(save);
        menu.add(open);
        //�ٰѲ˵���װ���˵�����
        menuBar.add(menu);

        //�ٰ�menuBar��ӵ�frame
//        frame.add(menuBar);���󣬲���ֱ�����
        frame.setMenuBar(menuBar);

        //�ѻ���Ҳ��ӵ�frame
        frame.add(drawArea);


        //-------------------------ǰ�ô���----------------
        frame.setBounds(500,500,750,550);
        frame.setBackground(Color.pink);
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
        new p504ImageIO().init();
    }
}
