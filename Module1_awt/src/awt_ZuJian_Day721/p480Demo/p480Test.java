package awt_ZuJian_Day721.p480Demo;

import javax.swing.*;
import java.awt.*;

/*
* 2.5.1�������
�����:   ����:
* Button      ��ť
* Canvas    ���ڻ�ͼ�Ļ��� ���������⡿
* Checkbox  ��ѡ�����(Ҳ�ɵ�����ѡ�����ʹ��)���ڽ����Checkbox�����ϳ�һ�飬һ��Checkbox�����ֻ��һ������ ��ѡ�У�
* CheckboxGroup ��ȫ����ɵ�ѡ�����
* Choice ����ѡ���
* Frame ���ڣ�  ��GUI������ͨ�����ഴ������
* Label ��ǩ��,���ڷ�����ʾ���ı�
* List  �б�������������Ӷ�����Ŀ
* Panel ���ܵ������ڻ���������,����ŵ�����������
* Scrollbar  ����������������Ҫ�û�����λ��ĳ����Χ��ֵ�� �Ϳ���ʹ�û��������, �����ɫ��������RGB������ֵ���õĻ�������
������һ��������ʱ ,����ָ�����ķ��򡢳�ʼֵ������Ĵ�С�� ��Сֵ�����ֵ��
* ScrollPane  ��ˮƽ����ֱ���������������������Ҫ��
* TextArea   �����ı���
* TextField  �����ı���
*/
public class p480Test {
    Frame frame = new Frame("�����ǲ��Ի������");
    //�ı���5��10��
    TextArea ta = new TextArea(5, 10);
    //����ѡ���򣬲������ɫ
    Choice Colors = new Choice();
    //�ֲ�����д�����������ڷ������������ӷ���
//        choiceColor.add("��");
//        choiceColor.add("��");
//        choiceColor.add("��");
    //�Ա�ѡ
    CheckboxGroup cbg = new CheckboxGroup();//����һ�������
    Checkbox male = new Checkbox("��", cbg, true);//�У���ǰ����cbg,true��Ĭ����ѡ?
    Checkbox female = new Checkbox("Ů", cbg, false);//Ů,Ĭ��ûѡ
    //�Ƿ��ѻ�
    Checkbox isMarried = new Checkbox("�Ƿ��ѻ飿");
    //һ���ı�
    TextField tf = new TextField(50);//50���ı�
    //��ť
    Button sure = new Button("ȷ��");//�����ť��50���ı����Ҳ�
    //�б��list������ɫ��
    List listColor = new List(6, true);//6�У��Ƿ��ѡ:true
//        choiceColor.add("��");
//        choiceColor.add("��");
//        choiceColor.add("��");

    private void method1() {//��дstatic
        //��װ���棬���������嵽�ֲ�ϸ�ڣ��������װ�����ɾֲ�ϸ�ڵ�����ƴ��--------

        //��1����װ�ײ���ʹ��Box����װ�ײ��ĵ����ı�����򵥡���ˮƽ����
        Box hBox = Box.createHorizontalBox();
        hBox.add(tf);//��ӵײ��ı���
        hBox.add(sure);//���ȷ�ϰ�ť
        //��bBox�ŵ�Frame���ϲ�����
        frame.add(hBox, BorderLayout.SOUTH);

        //��2����װѡ�����ݿ򡿣�Ҳ�Ǵ���һ����ˮƽ�����Box
        Box hBox2 = Box.createHorizontalBox();

        //�����ɫ��ѡ�����
        Colors.add("��");
        Colors.add("��");
        Colors.add("��");
        //��ѡ�����ӵ�hBox2, ���Ҫ��hBox2��ӵ�Frame��������
        hBox2.add(Colors);

        //�����Ůѡ���,���Ƿ��ѻ�
        hBox2.add(male);
        hBox2.add(female);
        hBox2.add(isMarried);

        //��3����װѡ����������ı��򡿰������2���ֵ�Choiceѡ�����ݿ���ı�����Area�ڴ�ֱVertical�������������
        Box topLeftBox = Box.createVerticalBox();
        //Box�������������Box
        topLeftBox.add(ta);//����ı���
        topLeftBox.add(hBox2);//�����һ��װ��ѡ�����ݵ�Box
/*
        //���Ҫ��topLeft��ӵ�Frame��������
        //frame.add(toLeft,BorderLayout.CENTER);
        frame.add(topLeft);//Ĭ�Ͼ����м�����CENTER
����ʱ������,��Ϊ���ð��ұ���ӽ���,�Ȱ��ұߵ���ɫ�ı���һ��add��,Ȼ��������һ����ӵ�Frame��CENTER��
*/
        //����װ��������ˮƽBox����װtoLeft���ұߵ��ı���
        Box topBox = Box.createHorizontalBox();//����topBox

        topBox.add(topLeftBox);//���topLeftBox��topBox����

        //�����ɫ
        listColor.add("��ɫ");
        listColor.add("��ɫ");
        listColor.add("��ɫ");
        topBox.add(listColor);//����Ҳ���ɫ�ı���



        //��TopBox��ӵ���Frame�м�����
        frame.add(topBox);//Ĭ�Ͼ����м�����

        //����������Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        new p480Test().method1();//����.�������ƣ����ñ����static����
    }
}