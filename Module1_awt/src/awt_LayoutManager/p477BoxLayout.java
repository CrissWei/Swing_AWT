package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

public class p477BoxLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("����BoxLayout");

        //1������BoxLayout����
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        //2����BoxLayout��������ΪFrame
        frame.setLayout(boxLayout);

        //3����Ӱ�ť��Frame
        frame.add(new Button("��ť1"));
        frame.add(new Button("��ť2"));



        frame.pack();
        frame.setVisible(true);
    }
}
