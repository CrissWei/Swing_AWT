package awt_ZuJian_Day721.p485Events;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class p488Events_Close {
    public static void main(String[] args) {
        Frame frame = new Frame("���Թرմ���");
        frame.setBounds(200,200,500,500);

        //����WindowListener�������û����x�رմ���
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //ֹͣ��ǰ����,�˳�JAVA�����
                System.exit(0);
            }
        });


        frame.pack();
        frame.setVisible(true);

    }
}
