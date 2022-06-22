package awt_ZuJian_Day721.p490Menu;

import java.awt.*;
import java.awt.event.*;


/*
* p489API�±��и��������Ĳ˵�������:

�˵�������� :         ���ܣ�
    MenuBar                 �˵������˵���������
    Menu                    �˵�������˵������������Ҳ��MenuItem������ , ���Կ���Ϊ�˵���ʹ��
    MenuItem                �˵��������
    PopupMenu               �����Ĳ˵����(�Ҽ��˵����)
    CheckboxMenuItem        ��ѡ��˵������
    *
 С����:
    1.���Ҫ��ĳ���˵��Ĳ˵���֮����ӷָ���,��ôֻ��Ҫ����Menu��add ( new MenuItem("-"))���ɡ�
    2.���Ҫ��ĳ���˵��������ݼ�����,��ôֻ��Ҫ�ڴ����˵������ʱ���ü���,������˵������
        ctrl+shift+Q��ݼ�rֻ��Ҫ: new MenuItem("�˵�������" ,new MenuShortcut(KeyEvent.VK Q,true);
*/
public class p490API {
    //��������
    private Frame frame = new Frame("���ǲ��Բ˵�����Ĵ���");

    //�����˵���MenuBar,����װ�˵�Menu���е������ǲ˵��ļ��ϡ�
    MenuBar menuBar = new MenuBar();
    //�����˵����Menu����ӵ��˵���MenuBar,����װMenuItem
    Menu menuFile = new Menu("�ļ�");
    Menu menuEdit = new Menu("�༭");
    //�Ӳ˵�����ʽ��
    Menu menuSonFormat = new Menu("��ʽ");

    //�����˵������MenuItem
    MenuItem autoLine = new MenuItem("�Զ�����");
    MenuItem copy = new MenuItem("����");
    MenuItem paste = new MenuItem("ճ��");
    //�Ӳ˵�����ʽ��ҲҪ���MenuItem   ���С�ע�͡���ӿ�ݼ�Ctrl+Shift+Q
    MenuItem comment = new MenuItem("ע��",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancelComment = new MenuItem("ȡ��ע��");

    //�����ı���
    TextArea ta = new TextArea("������5�У�30���ı���",5,30);

//    ------------------------
    //��init��������װ��ͼ,��С������װ��һ��һ����˿��
    public  void init(){
        //ֻ��ʾһ���������ڿ���̨���
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /*  String ac = e.getActionCommand();//������޸��ı�����
                System.out.println("������˲˵��"+ac);*/
                ta.append("������˲˵��"+e.getActionCommand()+"\n");//�����ں�������ı����ݣ����޸�ǰ��
            }
        });

        //����װ�Ӳ˵�����ʽ��,���������ע�͡��͡�ȡ��ע�͡�
        menuSonFormat.add(comment);//��װע��
        menuSonFormat.add(cancelComment);//��װȡ��ע��

        //����������4���˵�����װ��һ��"�༭"�˵�
        menuEdit.add(autoLine);//���"�Զ�����"
        menuEdit.add(copy);//���"����"
        menuEdit.add(paste);//���"ճ��"
        menuEdit.add(menuSonFormat);//���"��ʽ"

        //��"�ļ�"��"�༭"��װ���˵���MenuBar����
        menuBar.add(menuFile);//��װ"�ļ�"���˵���MenuBar
        menuBar.add(menuEdit);//��װ"�༭"���˵���MenuBar

        //��MenuBar���ı���FileArea��װ��Frame������
        frame.setMenuBar(menuBar);//��װ�˵���MenuBar
        frame.add(ta);//��װ�ı���FileArea


        //----------
        //����WindowListener�������û����x�رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ֹͣ��ǰ����,�˳�JAVA�����
                System.exit(0);
            }
        });

        //-------------------------�����ǹ̶�д��
        //���ô���������Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new p490API().init();//�����췽��
//�˵�������ʹ��4������:
//1.׼���˵������,��Щ���������MenuItem�����������
//2.׼���˵����Menu����PopupMenu(�һ������Ӳ˵�) ,�ѵ�һ����׼���õĲ˵��������ӽ��� ;
//3.׼���˵������MenuBar,�ѵڶ�����׼���õĲ˵����Menu��ӽ���;
//4.�ѵ�������׼���õĲ˵��������ӵ����ڶ�������ʾ��



    }
}
