package awt_ZuJian_Day721.p490Menu;

import java.awt.*;
import java.awt.event.*;


/*
* p489API下表中给出常见的菜单相关组件:

菜单组件名称 :         功能：
    MenuBar                 菜单条，菜单的容器。
    Menu                    菜单组件，菜单项的容器。它也是MenuItem的子类 , 所以可作为菜单项使用
    MenuItem                菜单项组件。
    PopupMenu               上下文菜单组件(右键菜单组件)
    CheckboxMenuItem        复选框菜单项组件
    *
 小技巧:
    1.如果要在某个菜单的菜单项之间添加分割线,那么只需要调用Menu的add ( new MenuItem("-"))即可。
    2.如果要给某个菜单项关联快捷键功能,那么只需要在创建菜单项对象时设置即可,例如给菜单项关联
        ctrl+shift+Q快捷键r只需要: new MenuItem("菜单项名字" ,new MenuShortcut(KeyEvent.VK Q,true);
*/
public class p490API {
    //创建窗口
    private Frame frame = new Frame("这是测试菜单组件的窗口");

    //创建菜单条MenuBar,用来装菜单Menu【有点类似是菜单的集合】
    MenuBar menuBar = new MenuBar();
    //创建菜单组件Menu，添加到菜单条MenuBar,用来装MenuItem
    Menu menuFile = new Menu("文件");
    Menu menuEdit = new Menu("编辑");
    //子菜单”格式“
    Menu menuSonFormat = new Menu("格式");

    //创建菜单项组件MenuItem
    MenuItem autoLine = new MenuItem("自动换行");
    MenuItem copy = new MenuItem("复制");
    MenuItem paste = new MenuItem("粘贴");
    //子菜单”格式“也要添加MenuItem   其中“注释”添加快捷键Ctrl+Shift+Q
    MenuItem comment = new MenuItem("注释",new MenuShortcut(KeyEvent.VK_Q,true));
    MenuItem cancelComment = new MenuItem("取消注释");

    //创建文本框
    TextArea ta = new TextArea("这里是5列，30行文本框",5,30);

//    ------------------------
    //在init方法内组装视图,从小到大组装，一个一个螺丝来
    public  void init(){
        //只演示一个监听器在控制台输出
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /*  String ac = e.getActionCommand();//这个是修改文本内容
                System.out.println("您点击了菜单项："+ac);*/
                ta.append("您点击了菜单项："+e.getActionCommand()+"\n");//这是在后面添加文本内容，不修改前文
            }
        });

        //先组装子菜单“格式”,里面包含“注释”和“取消注释”
        menuSonFormat.add(comment);//组装注释
        menuSonFormat.add(cancelComment);//组装取消注释

        //接下来把这4个菜单，组装成一个"编辑"菜单
        menuEdit.add(autoLine);//添加"自动换行"
        menuEdit.add(copy);//添加"复制"
        menuEdit.add(paste);//添加"粘贴"
        menuEdit.add(menuSonFormat);//添加"格式"

        //把"文件"和"编辑"组装到菜单条MenuBar里面
        menuBar.add(menuFile);//组装"文件"到菜单条MenuBar
        menuBar.add(menuEdit);//组装"编辑"到菜单条MenuBar

        //把MenuBar和文本框FileArea组装到Frame窗口内
        frame.setMenuBar(menuBar);//组装菜单条MenuBar
        frame.add(ta);//组装文本框FileArea


        //----------
        //设置WindowListener，监听用户点击x关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //停止当前程序,退出JAVA虚拟机
                System.exit(0);
            }
        });

        //-------------------------下面是固定写法
        //设置窗口内容最佳大小和可见
        frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) {
        new p490API().init();//调构造方法
//菜单相关组件使用4个步骤:
//1.准备菜单项组件,这些组件可以是MenuItem及其子类对象
//2.准备菜单组件Menu或者PopupMenu(右击弹出子菜单) ,把第一步中准备好的菜单项组件添加进来 ;
//3.准备菜单条组件MenuBar,把第二步中准备好的菜单组件Menu添加进来;
//4.把第三步中准备好的菜单条组件添加到窗口对象中显示。



    }
}
