package awt_LayoutManager;

import java.awt.*;

public class p472BorderLayout {
    public static void main(String[] args) {
       methodBorderLayout();
    }
    private static void methodBorderLayout() {
/*
* 1.当向使用BorderLayout布局管理器的容器中添加组件时, 需要指定要添加到哪个区域中,
        如果没有指定添加到哪个区域中,则默认添加到中间区域中;
  2.如果向同一个区域中添加多个组件时，后放入的组件会覆盖先放入的组件;
*/
        Frame frame = new Frame("这个是边界布局BorderLayout");
//1.给frame设置BorderLayout布局管理器
        frame.setLayout(new BorderLayout(20,20));

//2.往frame的指定区域添加组件
        frame.add(new Button("北侧按钮"),BorderLayout.NORTH);
        frame.add(new Button("南侧按钮"),BorderLayout.SOUTH);
        //如果不往某个区域中放入组件,那么该区域不会空白出来,而是会被其他区域占用
//        frame.add(new Button("西侧按钮"),BorderLayout.WEST);//如果注释调，区域就会被占了，不会空白
//        frame.add(new Button("东侧按钮"),BorderLayout.EAST);
       /* frame.add(new Button("中间按钮"),BorderLayout.CENTER);

        //如果再次添加组件到某个区域，那么会覆盖之前的组件内容,不指定区域默认就是添加到CENTER中间区域
        frame.add(new TextField("这是一个文本，默认添加到Center并且覆盖之前的中间按钮组件"));
*/
        //如果不想被覆盖，那么添加到Panel组件，再把Panel组件添加到Frame框架就行【类似添加到集合，然后return集合】
//        frame.add( new Panel().add(new Button("中间按钮")));
//        frame.add( new Panel().add(new TextField("和中间按钮共存的文本内容")));//还是覆盖了前面的内容，没共存的效果

        //创建Panel组件对象，并添加内容在Panel里面
        Panel panel = new Panel();
        panel.add(new Button("中间按钮"));
        panel.add(new TextField("和中间按钮共存的文本内容"));
        //把Panel组件添加到Frame中
        frame.add(panel);

        //设置最近大小
        frame.pack();
        frame.setVisible(true);

    }
}
