package awt_containerAPI;
//��������
import java.awt.*;

public class p469ScrollPane {
    public static void main(String[] args) {

methodScrollPane();//���÷���
    }
    private static void methodScrollPane(){
        Frame frame = new Frame("�����Ǵ�������");
//1. ����-��ScrollPane����
        //ScrollPane sp = new ScrollPane();//�������ݱȽ��٣���װ���£�����û�г��ֹ�����ScrollPane
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);//always�й�����

//2.��ScrollPane���������
        sp.add(new TextField("�����ı���"));
        sp.add(new Button("���ǲ��Լ�ť"));

//3.��ScrollPane��ӵ�Frame��
        frame.add(sp);

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
