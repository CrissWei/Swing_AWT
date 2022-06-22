package awt_LayoutManager;

import javax.swing.*;
import java.awt.*;

/*
* Box类中,提供了5个方便的静态方法来生成这些间隔组件:
方法名称：                                       方法功能：
    static Component createHorizontalGlue()              创建一条水平Glue (可同时拉伸宽和高间距)
    static Component createVerticalGlue()                创建一条垂直Glue (可同时拉伸宽和高间距)
    static Component createHorizontalStrut(int width)    创建一条指定宽度(宽度固定了,只可垂直拉)的水平Strut
    static Component createVerticalStrut(int height)     创建一条指定高度(高度固定了,只可拉水平宽)的垂直Strut

平方向上拉伸的间距)
*/
public class p479Box_Gap {
    public static void main(String[] args) {
        Frame frame = new Frame();
//1.创建水平排列的Box容器hBox
        Box hBox = Box.createHorizontalBox();

//2.往hBox容器中添加按钮,还需要在多个按钮之间添加分割
        hBox.add(new Button("水平按钮1"));
/*        Component hGlue = Box.createHorizontalGlue();
        hBox.add(hGlue);  下面是合二为一*/
        hBox.add(Box.createHorizontalGlue());//在按钮1和2之间，添加间隔，可以同时拉伸长宽

        hBox.add(new Button("水平按钮2"));
        hBox.add(Box.createHorizontalStrut(30));//固定水平间距的宽度为30

        hBox.add(new Button("水平按钮3"));

//3.创建垂直排列的Box容器vBox
        Box vBox = Box.createVerticalBox();
//4.往vBox容器中添加按钮,还需要在多个按钮之间添加分割
        vBox.add(new Button("垂直按钮1"));
        vBox.add(Box.createHorizontalGlue());//可拉水平和垂直
        vBox.add(Box.createVerticalStrut(30));//自己添加一个固定高度

        vBox.add(new Button("垂直按钮2"));
        vBox.add(Box.createHorizontalStrut(30));//固定高度为30

        vBox.add(new Button("垂直按钮3"));

//5.把box容器添加到frame中
        frame.add(vBox);//默认中间区域
        frame.add(hBox,BorderLayout.NORTH);//北边区域

        //设置最近大小和可见
        frame.pack();
        frame.setVisible(true);


    }
}
