package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

/*
* Box����,�ṩ��5������ľ�̬������������Щ������:
�������ƣ�                                       �������ܣ�
    static Component createHorizontalGlue()              ����һ��ˮƽGlue (��ͬʱ�����͸߼��)
    static Component createVerticalGlue()                ����һ����ֱGlue (��ͬʱ�����͸߼��)
    static Component createHorizontalStrut(int width)    ����һ��ָ�����(��ȹ̶���,ֻ�ɴ�ֱ��)��ˮƽStrut
    static Component createVerticalStrut(int height)     ����һ��ָ���߶�(�߶ȹ̶���,ֻ����ˮƽ��)�Ĵ�ֱStrut

ƽ����������ļ��)
*/
public class p479Box_Gap {
    public static void main(String[] args) {
        Frame frame = new Frame();
//1.����ˮƽ���е�Box����hBox
        Box hBox = Box.createHorizontalBox();

//2.��hBox��������Ӱ�ť,����Ҫ�ڶ����ť֮����ӷָ�
        hBox.add(new Button("ˮƽ��ť1"));
/*        Component hGlue = Box.createHorizontalGlue();
        hBox.add(hGlue);  �����Ǻ϶�Ϊһ*/
        hBox.add(Box.createHorizontalGlue());//�ڰ�ť1��2֮�䣬��Ӽ��������ͬʱ���쳤��

        hBox.add(new Button("ˮƽ��ť2"));
        hBox.add(Box.createHorizontalStrut(30));//�̶�ˮƽ���Ŀ��Ϊ30

        hBox.add(new Button("ˮƽ��ť3"));

//3.������ֱ���е�Box����vBox
        Box vBox = Box.createVerticalBox();
//4.��vBox��������Ӱ�ť,����Ҫ�ڶ����ť֮����ӷָ�
        vBox.add(new Button("��ֱ��ť1"));
        vBox.add(Box.createHorizontalGlue());//����ˮƽ�ʹ�ֱ
        vBox.add(Box.createVerticalStrut(30));//�Լ����һ���̶��߶�

        vBox.add(new Button("��ֱ��ť2"));
        vBox.add(Box.createHorizontalStrut(30));//�̶��߶�Ϊ30

        vBox.add(new Button("��ֱ��ť3"));

//5.��box������ӵ�frame��
        frame.add(vBox);//Ĭ���м�����
        frame.add(hBox,BorderLayout.NORTH);//��������

        //���������С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);


    }
}
