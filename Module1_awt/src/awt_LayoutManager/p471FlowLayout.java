package awt_LayoutManager;

import java.awt.*;

/*
* 接口 : LayoutManager
    GridLayout  网格布局
    FLowLayout  流式布局

* 接口:LayoutManager2
    CardLayout      卡片布局
    GridBagLayout   网格包布局
    BorderLayout    边界布局
*/
public class p471FlowLayout {
    public static void main(String[] args) {


        //methodFlowLayout();//流动布局1
        //methodBorderLayout();//边框布局2
    }
    //public BorderLayout(int hgap,int vgap):使用指定的水平间距、 垂直间距创建BorderLayout布局管理器。


    private static void methodFlowLayout(){
        //设置窗口
        Frame frame = new Frame("这是测试窗口Layout名称");

//1. 通过setLayout方法设置容器的布局管理器 。   //参数意思是：(从左边开始流动，水平间距20像素，垂直间距20像素)
//      frame.setLayout(new FlowLayout(FlowLayout.LEFT,20,20));//左对齐
//      frame.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));//居中对齐
        frame.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));//右对齐

//2.添加多个按钮到frame中
        for (int i =1; i <= 100; i++) {
            frame.add(new Button("恩牛"+i));
        }

//3.设置最佳大小, frame.pack方法
        frame.pack();

        //显示可见
        frame.setVisible(true);
    }
}
