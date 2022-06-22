package awt_LayoutManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 2.4.5 CardLayout
CardLayout���ֹ�������ʱ����ǿռ�����������������,�������������������������һ����Ƭ(ÿ����Ƭ
ʵ����һ�����) , ÿ��ֻ����������Ǹ�Component�ɹۡ��ͺ���һ���˿���,���ǵ���һ��,ÿ��ֻ
���������һ���˿��Ʋſɼ�.

��������:                             ��������:
    CardLayout()                            ����Ĭ�ϵ�CardLayout���ֹ�������
    CardLayout(int hgap,int Vgap)           ͨ��ָ����Ƭ���������ұ߽�ļ��C hgap)�����±߽�CVgap)�ļ��������CardLayout���ֹ�����.
    first(Container target)                 ��ʾtarget�����еĵ�һ�ſ�Ƭ.
    last(Container talrget)                 ��ʾtarget�����е����һ�ſ�Ƭ
    previous(Container target)              ��ʾtarget�����е�ǰһ-�� ��Ƭ.
    next(Container target)                  ��ʾtarget�����еĺ�һ�ſ�Ƭ.
    show(Container taget,String name)       ��ʾtarget������ָ�����ֵĿ�Ƭ.
*/
public class p476CardLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("���ǲ���CardLayout");

//1.����-��Panel, �����洢���ſ�Ƭ
        Panel p1 = new Panel();
//2.����CardLayout���󣬲��ҰѸö������ø�֮ǰ����������
        CardLayout card = new CardLayout();
        p1.setLayout(card);//��p1���ó�ΪCardLayout����

//3.��pane1�д洢������
        //
        String[] names = {"��1��", "��2��", "��3��", "��4��", "��5��"};


        for (int i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i]));
        }
//4.��p1�ŵ�frame���м�����
        frame.add(p1);

//----------------------------------------
//5.��������-��panel p2, �����洢�����ť���
        Panel p2 = new Panel();

//6.����5����ť���
        Button b1 = new Button("��һ��");
        Button b2 = new Button("��һ��");
        Button b3 = new Button("��һ��");
        Button b4 = new Button("���һ��");
        Button b5 = new Button("������");


//7.����һ���¼���������������ť�ĵ������
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                switch (ac){
                    case "��һ��":
                        //cardLayout.previous(p1)û���㰴ť
                        break;
                    case "��һ��":
                        break;
                    case "��һ��":
                        break;
                    case "���һ��":
                        break;
                    case "������":
                        break;

                }
            }
        };

//8.�ѵ�ǰ���ʱ��������Ͷ����ť�󶨵�һ��

        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
//9.�Ѱ�ť��ӵ�����p2��
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

//10.��p2�ŵ�frame���ϱ�����
        frame.add(p2,BorderLayout.SOUTH);


        //���������С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);
    }
}
