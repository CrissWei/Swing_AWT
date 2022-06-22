package awt_ZuJian_Day721.p481Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 方法名称:
*        Dialog(Frame owner, String title, boolean modal)
 *
*  方法功能:
        创建一个对话框对象 : <br/>
        owner:当前对话框的父窗口<br/>
        title:当前对话框的标题<br/>
        modal :当前对话框是否是模式对话框, true/false
*/
public class DialoDemo1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(500,500,6000,6000);//设置Frame框的大小和位置
        frame.setBackground(Color.pink);//粉色


//1. 创建两个对话框Dialog对象，一个模式的，  一个非模式的
        //public Dialog(Frame owner, String title, boolean modal)
        Dialog dialogYes = new Dialog(frame,"测试模式对话框Dialog",true);
        Dialog dialogNo = new Dialog(frame,"测试非模式对话框Dialog",false);

//2.通过setBounds方法设置Dialog的位置以及大小
        dialogYes.setBounds(300,300,600,600);
        dialogNo.setBounds(300,300,600,600);

//3.创建两个按钮
        Button Open1 = new Button("打开模式对话框");
        Button Open2 = new Button("打开非模式对话框");

//4.给这两个按钮添加点击后的行为【视界】
        Open1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogYes.setVisible(true);//设置模式对话框可见
            }
        });

        Open2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogNo.setVisible(true);//设置非模式对话框可见
            }
        });


//5.把按钮添加到frame中
        frame.add(Open1,BorderLayout.NORTH);//北部

        frame.add(Open2);//中间


        //设置最近大小和Frame可见
        frame.pack();
        frame.setVisible(true);


    }
}
