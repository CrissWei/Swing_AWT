package awt_LayoutManager;

import java.awt.*;

/*
* �ӿ� : LayoutManager
    GridLayout  ���񲼾�
    FLowLayout  ��ʽ����

* �ӿ�:LayoutManager2
    CardLayout      ��Ƭ����
    GridBagLayout   ���������
    BorderLayout    �߽粼��
*/
public class p471FlowLayout {
    public static void main(String[] args) {


        //methodFlowLayout();//��������1
        //methodBorderLayout();//�߿򲼾�2
    }
    //public BorderLayout(int hgap,int vgap):ʹ��ָ����ˮƽ��ࡢ ��ֱ��ഴ��BorderLayout���ֹ�������


    private static void methodFlowLayout(){
        //���ô���
        Frame frame = new Frame("���ǲ��Դ���Layout����");

//1. ͨ��setLayout�������������Ĳ��ֹ����� ��   //������˼�ǣ�(����߿�ʼ������ˮƽ���20���أ���ֱ���20����)
//      frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));//�����
//      frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));//���ж���
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));//�Ҷ���

//2.��Ӷ����ť��frame��
        for (int i =1; i <= 100; i++) {
            frame.add(new Button("��ţ"+i));
        }

//3.������Ѵ�С, frame.pack����
        frame.pack();

        //��ʾ�ɼ�
        frame.setVisible(true);
    }
}
