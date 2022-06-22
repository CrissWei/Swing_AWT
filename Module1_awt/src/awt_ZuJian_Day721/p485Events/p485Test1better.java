package awt_ZuJian_Day721.p485Events;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
案例: 完成下图效果,点击确定按钮,在单行文本域内显示hello world:
***使用步骤:
        1.创建事件源组件对象;
        2.自定义类,实现xxListener接口,重写接口抽象方法;
        3.创建事件监听器对象(自定义类对象)
        4.调用事件源组件对象的addXxxListener方法完成注册监听
*/
public class p485Test1better {
    Frame frame = new Frame("这是事件测试窗口");

    //1.创建事件源组件对象ok 【事件源就是ok按钮】
    TextField tf = new TextField("30行文本内容在这",30);
    Button ok = new Button("确定");


  /* ------------------如果多个事件源都要用到监听器，那么使用外部类，而非匿名内部类
   //2.自定义类【可以是内部类或者外部类】,实现xxListener接口,重写方法;
    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //在MyListener这个类的中添加tf的内容
            tf.setText("Hello World");
        }
    }
------------------*/

    private void method(){
    //在方法内部组装视图
/*------------------------

        //【myListener就是监听器】
        MyListener myListener = new MyListener();
---------------------*/

        //注册监听,  【如果事件监听器只跟一个事件源有关】采用匿名内部类，不去单独创建一个类
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("控制台代码执行。。。");
                //在匿名内部类中添加tf的内容
                tf.setText("Hello World");
            }
        });

        //把tf和ok放到Frame当中
        frame.add(tf);//文本内容放中间，不固定
        frame.add(ok,BorderLayout.SOUTH);//固定按钮


        //设置最佳大小和可见
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new p485Test1better().method();//调用方法
    }

}
