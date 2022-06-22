package awt_LayoutManager;

import java.awt.*;

/*
* public GridLayout (int rows,int cols,int hgap,int ygap)
�����ǣ�����ָ�����������������Լ�ָ���ĺ����ࡢ�����ཫ�����ָ�ɶ������

* ����:
    ʹ��Frame+Panel ,���FlowLayout��GridLayout���-��������Ч����
*/
public class p474GridLayout {
    public static void main(String[] args) {

        method();
    }
    private static void method(){
        //��ͷ�̶�д��
        Frame frame = new Frame("������");
//1.����һ��PaneI����������һ��TextFiled���
        Panel panel1 = new Panel();
        panel1.add(new TextField(30));//�������30���ı�
        //panel1.add(new TextField("������"));
//--------------------------------------

//2.�ѵ�ǰ���Pane1��ӵ�frame�ı�������
        frame.add(panel1,BorderLayout.NORTH);

//3.����һ��Pane1���� �����������Ĳ��ֹ�����ΪGridLayout
        Panel panel2 = new Panel();
        //Panel��Ĭ�ϵ�Flowlayout �޸�ΪGridLayout���֣������ֱ��ǣ�3�У�5�У�4ˮƽ��࣬4��ֱ��ࣩ
        panel2.setLayout(new GridLayout(3,5,4,4));

//4.��Panel���������
        for (int i = 0; i < 10; i++) {
            panel2.add(new Button(String.valueOf(i)));//��intתΪString
            //panel2.add(new Button(i+""));//��һ���յ�"" ��Ҳ�ɱ�Ϊ�ַ���
        }
        //���+-*/.
        panel2.add(new Button("+"));
        panel2.add(new Button("-"));
        panel2.add(new Button("*"));
        panel2.add(new Button("/"));
        panel2.add(new Button("."));

//5.�ѵ�ǰPane1��ӵ�frame��
        frame.add(panel2);

        //������Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);
    }
}
