package Day724;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p510 {

    JFrame jFrame = new JFrame();

    //声明菜单的相关组件
    JMenuBar menuBar = new JMenuBar();//菜单条

    JMenu menuFile = new JMenu("文件");
    JMenu menuEdit = new JMenu("编辑");

    JMenuItem auto = new JMenuItem("自动换行");
    //后面参数new ImageIcon是：给按钮旁边传一个图标,但是图标太大了
    JMenuItem copy = new JMenuItem("复制",new ImageIcon("Module1_awt\\image\\black.jpg"));
    JMenuItem paste = new JMenuItem("粘贴",new ImageIcon("Module1_awt\\image\\box.jpg"));

    JMenu formatMenu = new JMenu("格式");//这个是一直子菜单

    JMenuItem comment = new JMenuItem("注释");
    JMenuItem cancelComment = new JMenuItem("取消注释");

    //声明文本域TextArea
    JTextArea ta = new JTextArea(8, 20);

    //声明列表框(RGB颜色)
    String[] colors = {"红色", "绿色", "蓝色"};
    JList<String> colorList = new JList<>(colors);

    //声明相关选择题的组件
    JComboBox<String> colorSelect = new JComboBox<>();//下拉选择框

    //创建按钮group，用来存male & female按钮
    ButtonGroup bg = new ButtonGroup();

    //创建男女单选的选择框Radio //男和女只能二选一
    JRadioButton male = new JRadioButton("男", false);//false是默认不选
    JRadioButton female = new JRadioButton("女", true);//true是默认已选

    JCheckBox isMarried = new JCheckBox("是否已婚", true);//true是默认已经在这个选项上打勾了

    //声明底部按钮
    JTextField tf = new JTextField(40);//文本框，40列那么长

    //后面参数new ImageIcon是：给按钮旁边传一个图标,但是图标太大了
    JButton ok = new JButton("确定",new ImageIcon("Module1_awt\\image\\white.jpg"));

    //声明鼠标右键显示的菜单
    JPopupMenu jPopupMenu = new JPopupMenu();

    //创建一个只能单选的ButtonGroup,用来装下面的各种风格，默认选择Windows风格
    ButtonGroup popupButtonBg = new ButtonGroup();

    //只能选一个的选择框叫Radio
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格");
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows 经典风格");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格");


    //来的方法里面。来组装视图--由简到难-----------------------------------
    private void init() {
        //组装底部----------------------------
        JPanel jPanel = new JPanel();
        jPanel.add(tf);//底部文本框
        jPanel.add(ok);//底部按钮
        jFrame.add(jPanel, BorderLayout.SOUTH);//-----底部组装完毕--------------

        //组装选择框----男女，已婚等-----------------

        //创建JPanel对象,用来组装
        JPanel jPaneSelect = new JPanel();

//        colorSelect.add("红色",colorList);
        colorSelect.addItem("红色");
        colorSelect.addItem("绿色");
        colorSelect.addItem("蓝色");
        jPaneSelect.add(colorSelect);

        //先把male & female添加到ButtonGroup-->然后添加到JPanel里面
        bg.add(male);
        bg.add(female);
        jPaneSelect.add(male);
        jPaneSelect.add(female);
        //是否结婚，
        jPaneSelect.add(isMarried);


        //将文本域JTextArea和选择框  组装起来 ，选择框在TextArea垂直下方
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);//添加文本域
        topLeft.add(jPaneSelect);//添加JPanel进来

        //topLeft还得和水平右边的颜色组装一下
        Box top = Box.createHorizontalBox();
        top.add(topLeft);//水平关系，topLeft在左边
        top.add(colorList);

        //然后把组装好的top添加到Frame
        jFrame.add(top);

        //------中间栏组装完毕，最后还差顶部的菜单没组装-----------------------------------

        //组装顶部菜单组件------------------
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        //组装编辑菜单
        menuEdit.add(auto);
        menuEdit.addSeparator();//添加一条横杠分割线
        menuEdit.add(copy);
        menuEdit.add(paste);
        menuEdit.add(formatMenu);

        //把编辑edit菜单和文件file菜单，组装到菜单条JMenuBar里面
        menuBar.add(menuEdit);
        menuBar.add(menuFile);

        //最后把菜单条menuBar组装到JFrame窗口
//        jFrame.add(menuBar);
        jFrame.setJMenuBar(menuBar);

        //------------这一部分组装完毕，接下来是鼠标右键jPopup显示出来的菜单的组装--------------

        //为了实现单选效果，把这些选择添加到一个ButtonGroup组件里面
        popupButtonBg.add(metalItem);
        popupButtonBg.add(nimbusItem);
        popupButtonBg.add(windowsItem);
        popupButtonBg.add(windowsClassicItem);
        popupButtonBg.add(motifItem);

        //添加鼠标点击后的效果-->Listener 添加事件Event
        //创建一个事件监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  //当前选择的是哪一个风格？
                String actionCommand = e.getActionCommand();
                //调用选择的方法
                try {
                    changeFlavor(actionCommand);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        //监听器创建好了之后，得一个一个注册给5个按钮
        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        //把上面的5个按钮，添加到右键Popup菜单里面
        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(windowsClassicItem);
        jPopupMenu.add(motifItem);

        //调用swing里面的一个方法，无需监听鼠标事件
        ta.setComponentPopupMenu(jPopupMenu);
//--------------------全部组装完毕-------------------------------------


        //这个窗口最佳大小和可见，
        jFrame.pack();
        jFrame.setVisible(true);
        //关闭窗口
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);



    }

    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal 风格":
                UIManager.setLookAndFeel(" javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel(" javax.swing.plaf.nimbus. NimbusLookAndFeel2");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel(" com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel(" com.sun.java. swing.plaf.windows.WindowsClassicLookAndFeel") ;
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel(" com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        //刷新组件的外观，才能看到被改后的风格 【TMD这些方法我也不会啊，也么介绍，直接用了】
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());//参数是让这个方法刷新顶层容器jFrame里面所有的组件
        SwingUtilities.updateComponentTreeUI(menuBar);//刷新菜单条
        SwingUtilities.updateComponentTreeUI(jPopupMenu);//刷新右键

    }

    public static void main(String[] args) {
        new p510().init();
    }
}
