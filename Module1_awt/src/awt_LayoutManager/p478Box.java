package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

/*
* ��java.swing����,�ṩ��-���µ�����Box ,��������Ĭ�ϲ��ֹ���������BoxLayout,����������,ʹ��Box
����ȥ���ɶ��GUI���,Ȼ���ٰ�Box������Ϊһ�����,��ӵ�������������,�Ӷ��γ����崰�ڲ��֡�

��������:                             ��������:
    static Box createHorizontalBox()        ����һ��ˮƽ���������Box������
    static Box createVerticalBox()          ����һ����ֱ��������� Box������
*/
public class p478Box {
    public static void main(String[] args) {
        Frame frame = new Frame("���ǲ���Box����");

//1.����һ��ˮƽ���������Box����
        Box hBox = Box.createHorizontalBox();
//2.����ǰ���������������ť
        hBox.add(new Button("ˮƽ��ť1"));
        hBox.add(new Button("ˮƽ��ť2"));

//3.����һ����ֱ���������Box����
        Box vBox = Box.createVerticalBox();

//4.����ǰ���������������ť
        vBox.add(new Button("��ֱ��ť1"));
        vBox.add(new Button("��ֱ��ť2"));

//5.������Box������ӵ�Frame��չʾ
        frame.add(hBox,BorderLayout.NORTH);//����
        frame.add(vBox);//Ĭ�Ͼ����м䲿��


        frame.pack();
        frame.setVisible(true);

    }
}
