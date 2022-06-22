package awt_LayoutManager;

import java.awt.*;

public class p472BorderLayout {
    public static void main(String[] args) {
       methodBorderLayout();
    }
    private static void methodBorderLayout() {
/*
* 1.����ʹ��BorderLayout���ֹ�������������������ʱ, ��Ҫָ��Ҫ��ӵ��ĸ�������,
        ���û��ָ����ӵ��ĸ�������,��Ĭ����ӵ��м�������;
  2.�����ͬһ����������Ӷ�����ʱ������������Ḳ���ȷ�������;
*/
        Frame frame = new Frame("����Ǳ߽粼��BorderLayout");
//1.��frame����BorderLayout���ֹ�����
        frame.setLayout(new BorderLayout(20,20));

//2.��frame��ָ������������
        frame.add(new Button("���ఴť"),BorderLayout.NORTH);
        frame.add(new Button("�ϲఴť"),BorderLayout.SOUTH);
        //�������ĳ�������з������,��ô�����򲻻�հ׳���,���ǻᱻ��������ռ��
//        frame.add(new Button("���ఴť"),BorderLayout.WEST);//���ע�͵�������ͻᱻռ�ˣ�����հ�
//        frame.add(new Button("���ఴť"),BorderLayout.EAST);
       /* frame.add(new Button("�м䰴ť"),BorderLayout.CENTER);

        //����ٴ���������ĳ��������ô�Ḳ��֮ǰ���������,��ָ������Ĭ�Ͼ�����ӵ�CENTER�м�����
        frame.add(new TextField("����һ���ı���Ĭ����ӵ�Center���Ҹ���֮ǰ���м䰴ť���"));
*/
        //������뱻���ǣ���ô��ӵ�Panel������ٰ�Panel�����ӵ�Frame��ܾ��С�������ӵ����ϣ�Ȼ��return���ϡ�
//        frame.add( new Panel().add(new Button("�м䰴ť")));
//        frame.add( new Panel().add(new TextField("���м䰴ť������ı�����")));//���Ǹ�����ǰ������ݣ�û�����Ч��

        //����Panel������󣬲����������Panel����
        Panel panel = new Panel();
        panel.add(new Button("�м䰴ť"));
        panel.add(new TextField("���м䰴ť������ı�����"));
        //��Panel�����ӵ�Frame��
        frame.add(panel);

        //���������С
        frame.pack();
        frame.setVisible(true);

    }
}
