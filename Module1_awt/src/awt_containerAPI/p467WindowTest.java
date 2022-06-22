package awt_containerAPI;

import java.awt.*;

/**/
public class p467WindowTest {
    public static void main(String[] args) {
//1. 创建一个窗口对象
        Frame frame = new Frame("这里是窗口的名称");

//2.指定窗口的位置，大小,颜色
        frame.setBackground(Color.pink);//颜色
        frame.setLocation(100,100);//位置
        frame.setSize(512,800);//长宽

//3.设置窗口对象可见
        frame.setVisible(true);



    }
}
