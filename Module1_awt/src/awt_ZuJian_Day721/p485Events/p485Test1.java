package awt_ZuJian_Day721.p485Events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
����: �����ͼЧ��,���ȷ����ť,�ڵ����ı�������ʾhello world:
***ʹ�ò���:
        1.�����¼�Դ�������;
        2.�Զ�����,ʵ��xxListener�ӿ�,��д�ӿڳ��󷽷�;
        3.�����¼�����������(�Զ��������)
        4.�����¼�Դ��������addXxxListener�������ע�����
*/
public class p485Test1 {
    Frame frame = new Frame("�����¼����Դ���");

    //1.�����¼�Դ�������ok ���¼�Դ����ok��ť��
    TextField tf = new TextField("30���ı���������",30);
    Button ok = new Button("ȷ��");


    //2.�Զ����ࡾ�������ڲ�������ⲿ�ࡿ,ʵ��xxListener�ӿ�,��д����;
    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //��MyListener�����������tf������
            tf.setText("Hello World");
        }
    }


    private void method(){
    //�ڷ����ڲ���װ��ͼ

        //��myListener���Ǽ�������
        MyListener myListener = new MyListener();

        //ע�����
        ok.addActionListener(myListener);//�Ѽ�������Ϊ���������¼�Դok����

        //��tf��ok�ŵ�Frame����
        frame.add(tf);
        frame.add(ok,BorderLayout.SOUTH);

        //������Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new p485Test1().method();//���÷���
    }

}
