package awt_ZuJian_Day721.p490Menu;

import java.awt.*;
import java.awt.event.*;

/*
* 实现思路:
    1.创建PopupMenu菜单组件;
    2.创建多个MenuItem菜单项,并添加到PopupMenu中;
    3.将PopupMenu添加到目标组件中;
    4.为需要右击出现PopupMenu菜单的组件，注册鼠标监听事件，当监听到用户释放右键时, 弹出菜单。
*/
public class p491PopupMenu {
    Frame frame = new Frame("测试PopupMenu");

    //创建文本域
    TextArea ta = new TextArea("我是神仙", 30, 40);
    //创建Panel容器
    Panel panel = new Panel();

    //创建右键菜单PopupMenu
    PopupMenu popupMenu = new PopupMenu();
    //popupMenu.add(new MenuItem("注释"));//方法外面不可以采用匿名对象
    MenuItem comment = new MenuItem("注释");
    MenuItem cancelComment = new MenuItem("取消注释");
    MenuItem copy = new MenuItem("复制");
    MenuItem save = new MenuItem("保存");

    //------------------------------  //method方法内部组装视图,从小到大组装
    private void method(){
        //匿名内部类写个EventListener事件监听器来看到效果
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                ta.append("您点击了"+ac+"\n");//把输出内容添加到TextArea，并换行
            }
        };

        //注册事件源,把EventListener作为Param参数添加到里面
        comment.addActionListener(listener);
        cancelComment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);


        //组装MenuItem到PopupMenu当中
        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(save);

        //最后把这些组装好的菜单popupMenu再组装添加到Panel容器中
        panel.add(popupMenu);

        //设置Panel大小。方法2选1
        //panel.setBounds(100,100,50,80);//X,Y距离，宽，高
        panel.setPreferredSize(new Dimension(50,80));//宽，高

        //给Panel注册鼠标Mouse事件，设置事件监听EventsListener来监听用户User点击[释放Released]鼠标右键动作，显示菜单
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //调用方法来判断是左键还是右键释放
                boolean flag = e.isPopupTrigger();
                //如果是true，就是右键Released,否则false
                if (flag){//如果flag是true，右键单击就显示PopupMenu，
                    //调用show方法显示popupMenu菜单,参数分别是panel容器，X，Y坐标
                    popupMenu.show(panel,e.getX(),e.getY());//X,Y坐标会跟随鼠标点击的位置show出现

                }

            }
        });

        //最后，把文本域TextArea和Panel组装到Frame当中即可
       frame.add(ta);
       frame.add(panel,BorderLayout.SOUTH);

       //------------------------------
        //设置WindowListener，监听用户点击x关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序,退出JAVA虚拟机
                System.exit(0);
            }
        });
       //------------------------------

        //设置frame最佳大小和可见
        frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new p491PopupMenu().method();

    }
}
