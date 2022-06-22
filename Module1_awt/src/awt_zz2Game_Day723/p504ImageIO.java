package awt_zz2Game_Day723;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
* 2.8.4 ImageIO的使用
在实际生活中,很多软件都支持打开本地磁盘已经存在的图片,然后进行编辑,编辑完毕后,再重新保存到本地磁
盘。如果使用awt要完成这样的功能,那么需要使用到ImageIO这个类,可以操作本地磁盘的图片文件。

* 方法名称:                 方法功能:

static BufferedImage read(File input)           读取本地磁盘图片文件
static BufferedImage read(InpUutStream input)   读取本地磁盘图片文件
static boolean write(RenderedImage im, String formatName, File output)  往本地磁盘中输出图片文件
*/
public class p504ImageIO{
    Frame frame = new Frame("图片查看器");

    //创建菜单条MenuBar，往里面添加菜单Menu组件
    MenuBar menuBar = new MenuBar();

    Menu menu = new Menu("文件");
    MenuItem open = new MenuItem("打开");
    MenuItem save = new MenuItem("另存为");

    //声明一个BufferedImage对象，记录本地存取到内存中的图片
    BufferedImage image;

    //自定义一个类extends Canvas用来画图，重写paint方法用来画图
    public class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            g.drawImage(image,0,0,null);//设置观察者为null
        }
    }
    MyCanvas drawArea = new MyCanvas();//根据自定义的类，创建画布对象


//-----下面在init方法里开始组装视图----由小到大组装--------------
    private void init() throws Exception{

        //这里是监听打开open,后面还有监听save----------------------------
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                e.getActionCommand();
                //创建对象，打开文件对话框
                FileDialog fd = new FileDialog(frame,"打开图片",FileDialog.LOAD);//0就代表FileDialog.LOAD
                fd.setVisible(true);//设置对话框可见

                //选择完毕之后，接下来是获取用户选择的图片路径path以及名称name，为了下面的读取
                String dirPath = fd.getDirectory();//文件路径
                String fileName = fd.getFile();//文件名字

                //然后使用ImageIO来读取文件
             /*   try {
                    //根据上上面得到的路径，输入进去做参数，就可以读取文件，然后把读取的内容赋值给image
                    image = ImageIO.read(new File(dirPath, fileName));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }*/
                BufferedImage read = null;
                try {
                    read = ImageIO.read(new File(dirPath, fileName));//格式不是【jpg,JPEG】有可能报错
                    //需要重绘repaint
                    drawArea.repaint();//重绘了就可以展示当前读取的图片了
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                image =read;//赋值给image


            }
        });
        //------监听open完毕----下面是保存save----------------------
        save.addActionListener(e -> {//除了内部类，这里也可以采用Lambda
            //创建文件对话框对象
            FileDialog fd = new FileDialog(frame,"保存图片",FileDialog.SAVE);
            fd.setVisible(true);//设置对话框可见

            //获取用户user保存的路径path和文件名称name
            String dirPath = fd.getDirectory();
            String fileName = fd.getFile();

            try {//只能打开图片格式为【JPEG,jpg】，否则报错 *********亲自测试，其他格式的如PNG也都可以打开，保存，还能修改保存格式
                ImageIO.write(image,"PNG",new File(dirPath,fileName));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        //-----监听save也处理完毕，点击行为完毕，点击后真的可以打开和保存图片------------------------



       //先把打开和另外村组装到菜单里 //---看上面，-----先得有Event监听Listener----
        menu.add(save);
        menu.add(open);
        //再把菜单组装到菜单条里
        menuBar.add(menu);

        //再把menuBar添加到frame
//        frame.add(menuBar);错误，不能直接添加
        frame.setMenuBar(menuBar);

        //把画布也添加到frame
        frame.add(drawArea);


        //-------------------------前置代码----------------
        frame.setBounds(500,500,750,550);
        frame.setBackground(Color.pink);
        frame.pack();
        frame.setVisible(true);
        //关闭窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        new p504ImageIO().init();
    }
}
