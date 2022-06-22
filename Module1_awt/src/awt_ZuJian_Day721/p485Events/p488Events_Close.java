package awt_ZuJian_Day721.p485Events;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class p488Events_Close {
    public static void main(String[] args) {
        Frame frame = new Frame("测试关闭窗口");
        frame.setBounds(200,200,500,500);

        //设置WindowListener，监听用户点击x关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序,退出JAVA虚拟机
                System.exit(0);
            }
        });


        frame.pack();
        frame.setVisible(true);

    }
}
