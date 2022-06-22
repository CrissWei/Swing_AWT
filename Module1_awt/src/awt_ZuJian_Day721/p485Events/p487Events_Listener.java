package awt_ZuJian_Day721.p485Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p487Events_Listener {
    public static void main(String[] args) {
        Frame frame = new Frame("����Events����");

        //����������¼�Դ��
        TextField tf = new TextField("������30���ı�����",30);
        //����ѡ��
        Choice choiceNames = new Choice();
        choiceNames.add("����");
        choiceNames.add("١���");
        choiceNames.add("����");
        choiceNames.add("���");

        //����WindowListener�������û����x�رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ֹͣ��ǰ����,�˳�JAVA�����
                System.exit(0);
            }
        });



//------------------------------
//��1.��Ӽ��������o���ı���tf�����TextListener,�������ݵı仯
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();//���÷���
                System.out.println("��ǰ�ı��������ǣ�"+text);
                /*Object source = e.getSource();
                System.out.println("��ǰ�ı��������ǣ�"+source);*/
            }
        });


//��2.��Ӽ���������������ѡ���choiceNames�����ItemListener,������Ŀѡ��ı仯
       choiceNames.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               Object item = e.getItem();
               System.out.println("��ǰ�ı��������ǣ�"+item);

           }
       });

//��3.��Ӽ���������frameע��ContainerListener��������������������������
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                //���
                Component child = e.getChild();
                System.out.println("frame������ˣ�"+child);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                //�Ƴ�
            }
        });

 //------------------------------

        //���ı���������ӵ�Box��
        Box hBox = Box.createHorizontalBox();
        hBox.add(choiceNames);//�������
        hBox.add(tf);//����ı���

        //��Box��ӵ�frame��
        frame.add(hBox);

        frame.pack();
        frame.setVisible(true);


    }
}
