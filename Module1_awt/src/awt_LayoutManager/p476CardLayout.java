package awt_LayoutManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 2.4.5 CardLayout
CardLayout布局管理器以时间而非空间来管理它里面的组件,它将加入容器的所有组件看成一叠卡片(每个卡片
实就是一个组件) , 每次只有最上面的那个Component可观。就好像一副扑克牌,它们叠在一起,每次只
有最上面的一张扑克牌才可见.

方法名称:                             方法功能:
    CardLayout()                            创建默认的CardLayout布局管理器。
    CardLayout(int hgap,int Vgap)           通过指定卡片与容器左右边界的间距C hgap)、上下边界CVgap)的间距来创建CardLayout布局管理器.
    first(Container target)                 显示target容器中的第一张卡片.
    last(Container talrget)                 显示target容器中的最后一张卡片
    previous(Container target)              显示target容器中的前一-张 卡片.
    next(Container target)                  显示target容器中的后一张卡片.
    show(Container taget,String name)       显示target容器中指定名字的卡片.
*/
public class p476CardLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("这是测试CardLayout");

//1.创建-个Panel, 用来存储多张卡片
        Panel p1 = new Panel();
//2.创建CardLayout对象，并且把该对象设置给之前创建的容器
        CardLayout card = new CardLayout();
        p1.setLayout(card);//把p1设置成为CardLayout布局

//3.往pane1中存储多个组件
        //
        String[] names = {"第1张", "第2张", "第3张", "第4张", "第5张"};


        for (int i = 0; i < names.length; i++) {
            p1.add(names[i], new Button(names[i]));
        }
//4.把p1放到frame的中间区域
        frame.add(p1);

//----------------------------------------
//5.创建另外-个panel p2, 用来存储多个按钮组件
        Panel p2 = new Panel();

//6.创建5个按钮组件
        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");


//7.创建一个事件监听器，监听按钮的点击动作
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                switch (ac){
                    case "上一张":
                        //cardLayout.previous(p1)没法点按钮
                        break;
                    case "下一张":
                        break;
                    case "第一张":
                        break;
                    case "最后一张":
                        break;
                    case "第三张":
                        break;

                }
            }
        };

//8.把当前这个时间监听器和多个按钮绑定到一起

        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);
//9.把按钮添加到容器p2中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

//10.把p2放到frame的南边区域
        frame.add(p2,BorderLayout.SOUTH);


        //设置最近大小和可见
        frame.pack();
        frame.setVisible(true);
    }
}
