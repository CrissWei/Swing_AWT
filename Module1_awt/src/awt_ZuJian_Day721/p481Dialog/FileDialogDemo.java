package awt_ZuJian_Day721.p481Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* ��������:               ��������:
    1��String getDirectory()       ��ȡ���򿪻򱣴��ļ��ľ���·��
    2��String getFile()            ��ȡ���򿪻򱣴��ļ����ļ���
    3��FileDialog(Frame parent,String title, int mode)
  �����ĺ������£�
        ����һ���ļ��Ի���: <br/>
       Frame parent:ָ��������<br/>
       String title:�Ի������<br/>
       int mode:�ļ��Ի�������,���ָ��ΪFileDialog.LOAD ,���ڴ��ļ�,���ָ��ΪFileDialog.SAVE,���ڱ����ļ�

*/
public class FileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
//1.��������FileDialog����
        FileDialog fd1 = new FileDialog(frame,"ѡ��Ҫ�򿪵��ļ�",FileDialog.LOAD);//��LOAD�� �� 0
        FileDialog fd2 = new FileDialog(frame,"ѡ��Ҫ�����·��",FileDialog.SAVE);//����SAVE�� �� 1

//2.����������ť
        /*fd1.add(new Button("���ļ�Open"));
        fd2.add(new Button("�����ļ�Save")); �����������������������Ϊ����Ҫ�ö��������ã�����������*/
        Button b1 = new Button("���ļ�");
        Button b2 = new Button("�����ļ�");

//3.����������ť���õ�������Ϊ:��ȡ�򿪻��߱����·���ļ���
        /*new Button()*/ b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd1.setVisible(true);//���������������
                //��ȡѡ���·�����ļ�
                String directory = fd1.getDirectory();
                String file = fd1.getFile();
                System.out.println("�򿪵��ļ�·��Ϊ��"+directory);
                System.out.println("�򿪵��ļ�����Ϊ��"+file);
            }
        });

        /*new Button()*/b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd2.setVisible(true);//���������������
                //��ȡѡ���·�����ļ�
                String directory = fd2.getDirectory();
                String file = fd2.getFile();
                System.out.println("������ļ�·��Ϊ��"+directory);
                System.out.println("������ļ�����Ϊ��"+file);
            }
        });


//4.��[��ť/�Ի���]��ӵ�Frame��,  �������ǶԻ����ǰ�ť��
      /*  frame.add(fd1,BorderLayout.NORTH);
        frame.add(fd2); ��������ӶԻ���Frame��Ҫ��Ӱ�ť��
*/
        //Button��ӵ�Frame
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        //��Ѵ�С�Ϳɼ�
        frame.pack();
        frame.setVisible(true);
    }
}
