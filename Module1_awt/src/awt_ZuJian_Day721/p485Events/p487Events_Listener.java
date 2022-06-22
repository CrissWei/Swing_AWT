package awt_ZuJian_Day721.p485Events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class p487Events_Listener {
    public static void main(String[] args) {
        Frame frame = new Frame("测试Events窗口");

        //创建组件（事件源）
        TextField tf = new TextField("这里是30列文本内容",30);
        //创建选择
        Choice choiceNames = new Choice();
        choiceNames.add("柳岩");
        choiceNames.add("佟丽娅");
        choiceNames.add("倪妮");
        choiceNames.add("舒淇");

        //设置WindowListener，监听用户点击x关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序,退出JAVA虚拟机
                System.exit(0);
            }
        });



//------------------------------
//【1.添加监听器】給【文本域tf】添加TextListener,监听内容的变化
        tf.addTextListener(new TextListener() {
            @Override
            public void textValueChanged(TextEvent e) {
                String text = tf.getText();//调用方法
                System.out.println("当前文本框内容是："+text);
                /*Object source = e.getSource();
                System.out.println("当前文本框内容是："+source);*/
            }
        });


//【2.添加监听器】给【下拉选择框choiceNames】添加ItemListener,监听条目选项的变化
       choiceNames.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               Object item = e.getItem();
               System.out.println("当前文本框内容是："+item);

           }
       });

//【3.添加监听器】给frame注册ContainerListener监听器，监听容器中组件的添加
        frame.addContainerListener(new ContainerListener() {
            @Override
            public void componentAdded(ContainerEvent e) {
                //添加
                Component child = e.getChild();
                System.out.println("frame中添加了："+child);
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                //移除
            }
        });

 //------------------------------

        //把文本和名字添加到Box中
        Box hBox = Box.createHorizontalBox();
        hBox.add(choiceNames);//添加名字
        hBox.add(tf);//添加文本框

        //把Box添加到frame中
        frame.add(hBox);

        frame.pack();
        frame.setVisible(true);


    }
}
