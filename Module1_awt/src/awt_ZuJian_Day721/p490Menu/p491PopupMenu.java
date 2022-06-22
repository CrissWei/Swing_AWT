package awt_ZuJian_Day721.p490Menu;

import java.awt.*;
import java.awt.event.*;

/*
* ʵ��˼·:
    1.����PopupMenu�˵����;
    2.�������MenuItem�˵���,����ӵ�PopupMenu��;
    3.��PopupMenu��ӵ�Ŀ�������;
    4.Ϊ��Ҫ�һ�����PopupMenu�˵��������ע���������¼������������û��ͷ��Ҽ�ʱ, �����˵���
*/
public class p491PopupMenu {
    Frame frame = new Frame("����PopupMenu");

    //�����ı���
    TextArea ta = new TextArea("��������", 30, 40);
    //����Panel����
    Panel panel = new Panel();

    //�����Ҽ��˵�PopupMenu
    PopupMenu popupMenu = new PopupMenu();
    //popupMenu.add(new MenuItem("ע��"));//�������治���Բ�����������
    MenuItem comment = new MenuItem("ע��");
    MenuItem cancelComment = new MenuItem("ȡ��ע��");
    MenuItem copy = new MenuItem("����");
    MenuItem save = new MenuItem("����");

    //------------------------------  //method�����ڲ���װ��ͼ,��С������װ
    private void method(){
        //�����ڲ���д��EventListener�¼�������������Ч��
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                ta.append("�������"+ac+"\n");//�����������ӵ�TextArea��������
            }
        };

        //ע���¼�Դ,��EventListener��ΪParam������ӵ�����
        comment.addActionListener(listener);
        cancelComment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);


        //��װMenuItem��PopupMenu����
        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(save);

        //������Щ��װ�õĲ˵�popupMenu����װ��ӵ�Panel������
        panel.add(popupMenu);

        //����Panel��С������2ѡ1
        //panel.setBounds(100,100,50,80);//X,Y���룬����
        panel.setPreferredSize(new Dimension(50,80));//����

        //��Panelע�����Mouse�¼��������¼�����EventsListener�������û�User���[�ͷ�Released]����Ҽ���������ʾ�˵�
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //���÷������ж�����������Ҽ��ͷ�
                boolean flag = e.isPopupTrigger();
                //�����true�������Ҽ�Released,����false
                if (flag){//���flag��true���Ҽ���������ʾPopupMenu��
                    //����show������ʾpopupMenu�˵�,�����ֱ���panel������X��Y����
                    popupMenu.show(panel,e.getX(),e.getY());//X,Y���������������λ��show����

                }

            }
        });

        //��󣬰��ı���TextArea��Panel��װ��Frame���м���
       frame.add(ta);
       frame.add(panel,BorderLayout.SOUTH);

       //------------------------------
        //����WindowListener�������û����x�رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ֹͣ��ǰ����,�˳�JAVA�����
                System.exit(0);
            }
        });
       //------------------------------

        //����frame��Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new p491PopupMenu().method();

    }
}
