package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

/*
* 在java.swing包中,提供了-个新的容器Box ,该容器的默认布局管理器就是BoxLayout,大多数情况下,使用Box
容器去容纳多个GUI组件,然后再把Box容器作为一个组件,添加到其他的容器中,从而形成整体窗口布局。

方法名称:                             方法功能:
    static Box createHorizontalBox()        创建一个水平排列组件的Box容器。
    static Box createVerticalBox()          创建一个垂直排列组件的 Box容器。
*/
public class p478Box {
    public static void main(String[] args) {
        Frame frame = new Frame("这是测试Box窗口");

//1.创建一个水平排列组件的Box容器
        Box hBox = Box.createHorizontalBox();
//2.往当前容器中添加两个按钮
        hBox.add(new Button("水平按钮1"));
        hBox.add(new Button("水平按钮2"));

//3.创建一个垂直排列组件的Box容器
        Box vBox = Box.createVerticalBox();

//4.往当前容器中添加两个按钮
        vBox.add(new Button("垂直按钮1"));
        vBox.add(new Button("垂直按钮2"));

//5.把两个Box容器添加到Frame中展示
        frame.add(hBox,BorderLayout.NORTH);//北部
        frame.add(vBox);//默认就是中间部分


        frame.pack();
        frame.setVisible(true);

    }
}
