package awt_ZuJian_Day721.p481Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* ��������:
*        Dialog(Frame owner, String title, boolean modal)
 *
*  ��������:
        ����һ���Ի������ : <br/>
        owner:��ǰ�Ի���ĸ�����<br/>
        title:��ǰ�Ի���ı���<br/>
        modal :��ǰ�Ի����Ƿ���ģʽ�Ի���, true/false
*/
public class DialoDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(500,500,6000,6000);//����Frame��Ĵ�С��λ��
        frame.setBackground(Color.pink);//��ɫ


//1. ���������Ի���Dialog����һ��ģʽ�ģ�  һ����ģʽ��
        //public Dialog(Frame owner, String title, boolean modal)
        Dialog dialogYes = new Dialog(frame,"����ģʽ�Ի���Dialog",true);
        Dialog dialogNo = new Dialog(frame,"���Է�ģʽ�Ի���Dialog",false);

//2.ͨ��setBounds��������Dialog��λ���Լ���С
        dialogYes.setBounds(300,300,600,600);
        dialogNo.setBounds(300,300,600,600);

//3.����������ť
        Button Open1 = new Button("��ģʽ�Ի���");
        Button Open2 = new Button("�򿪷�ģʽ�Ի���");

//4.����������ť��ӵ�������Ϊ���ӽ硿
        Open1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogYes.setVisible(true);//����ģʽ�Ի���ɼ�
            }
        });

        Open2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogNo.setVisible(true);//���÷�ģʽ�Ի���ɼ�
            }
        });


//5.�Ѱ�ť��ӵ�frame��
        frame.add(Open1,BorderLayout.NORTH);//����

        frame.add(Open2);//�м�


        //���������С��Frame�ɼ�
        frame.pack();
        frame.setVisible(true);


    }
}
