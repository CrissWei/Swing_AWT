package awt_LayoutManager;

import java.awt.*;

/*
* public GridLayout (int rows,int cols,int hgap,int ygap)
参数是：采用指定的行数、列数，以及指定的横向间距、纵向间距将容器分割成多个网格。

* 案例:
    使用Frame+Panel ,配合FlowLayout和GridLayout完成-个计算器效果。
*/
public class p474GridLayout {
    public static void main(String[] args) {

        method();
    }
    private static void method(){
        //开头固定写法
        Frame frame = new Frame("计算器");
//1.创建一个PaneI对象，里面存放一个TextFiled组件
        Panel panel1 = new Panel();
        panel1.add(new TextField(30));//最多容纳30个文本
        //panel1.add(new TextField("计算器"));
//--------------------------------------

//2.把当前这个Pane1添加到frame的北边区域
        frame.add(panel1,BorderLayout.NORTH);

//3.创建一个Pane1对象， 并且设置它的布局管理器为GridLayout
        Panel panel2 = new Panel();
        //Panel由默认的Flowlayout 修改为GridLayout布局，参数分别是（3行，5列，4水平间距，4垂直间距）
        panel2.setLayout(new GridLayout(3,5,4,4));

//4.往Panel中添加内容
        for (int i = 0; i < 10; i++) {
            panel2.add(new Button(String.valueOf(i)));//将int转为String
            //panel2.add(new Button(i+""));//加一个空的"" ，也可变为字符串
        }
        //添加+-*/.
        panel2.add(new Button("+"));
        panel2.add(new Button("-"));
        panel2.add(new Button("*"));
        panel2.add(new Button("/"));
        panel2.add(new Button("."));

//5.把当前Pane1添加到frame中
        frame.add(panel2);

        //设置最佳大小和可见
        frame.pack();
        frame.setVisible(true);
    }
}
