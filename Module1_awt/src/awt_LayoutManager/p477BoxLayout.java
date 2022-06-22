package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

public class p477BoxLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("测试BoxLayout");

        //1、创建BoxLayout对象
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        //2、把BoxLayout对象设置为Frame
        frame.setLayout(boxLayout);

        //3、添加按钮到Frame
        frame.add(new Button("按钮1"));
        frame.add(new Button("按钮2"));



        frame.pack();
        frame.setVisible(true);
    }
}
