package awt_zz1Game_Day722.p500Image;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/*
* 如果仅仅绘制一些简单的几何图形, 程序的图形效果依然比较单调。AWT 也允许在组件上绘制位图，
Graphics提供了drawImage image)方法用于绘制位图,该方法需要一个Image参数一代表位图 ,通过
该访法就可以绘制出指定的位图。

* 位图使用步骤:
    1.创建Image的子类对象BufferedImage(int width,int height,int ImageType)，创建时需要指定位图的宽高及类型
        属性;此时相当于在内存中生成了一张图片;
    2.调用BufferedImage对象的getGraphics(方法获取画笔,此时就可以往内存中的这张图片上绘图了,绘图的方法
        和之前学习的一模一样;
    3.调用组件paint方法中提供的Graphics对象的drawImage(方法, --次性的内存中的图片BufferedImage绘 制到
        特定的组件上。
*/
public class p501Demo1 {

    private Frame frame = new Frame("简单手绘程序");

    //定义画图区的宽&高
    private final int AREA_WIDTH = 500;
    private final int AREA_HEIGHT = 400;

    //定义一个右键菜单，用于设置画笔的颜色
    private PopupMenu colorMenu = new PopupMenu();
    private MenuItem redItem = new MenuItem("红色");
    private MenuItem greenItem = new MenuItem("绿色");
    private MenuItem blueItem = new MenuItem(" 蓝色");

    //定义一个变量，记录当前画笔的颜色,默认颜色为Black
    private Color currentColor = Color.BLACK;



    //1.创建Image的子类对象BufferedImage(int width,int height,int ImageType)
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);//图片类型为RGB

    // 2.调用BufferedImage对象的getGraphics
    Graphics g = image.getGraphics();


    //再来额外定义2个变量，用来记录鼠标拖动过程中，上一次拖动的鼠标坐标
    private int preX = -1;//默认为-1，那么意思就是第一个点是没有上一个点的
    private int preY = -1;


    //自定义类创建一块画布，extends Canvas,重写paint方法--------------------------
    public class myCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //调用组件paint方法中提供的Graphics对象的drawImage
            /*  boolean b =*/
            g.drawImage(image, 0, 0, null);
        }

    }
    //创建自定义类的对象，用来调用类里面的方法
    myCanvas drawArea = new myCanvas();
//----自定义的类完成-------------------------------------------------------

    private void methodInit() {//方法内部来组装视图(从小螺丝到大组装)&&逻辑控制

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ac = e.getActionCommand();
                //判断 颜色类别 switch case break;
                switch (ac) {
                    case "红色":
                        currentColor = Color.RED;
                        break;
                    case "绿色":
                        currentColor = Color.GREEN;
                        break;
                    case "蓝色":
                        currentColor = Color.blue;
                        break;
                }
            }
        };

        //用户监听器设置好之后，注册监听，把这个监听器作为参数分别add传给对应的事件源
        redItem.addActionListener(listener);
        greenItem.addActionListener(listener);
        blueItem.addActionListener(listener);

        //搞定上面的Events之后，【开始组装】，先从简单的PopupMenu,鼠标右键显示菜单栏，（在此组装之前要先用到Event Listener）
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        //然后把colorMenu添加到drawArea里面
        drawArea.add(colorMenu);


//--鼠标右键菜单的组装--------------------------------------------------
        //接下来还得给drawArea注册MouseEvents & Listener : 鼠标右键显示菜单栏
        drawArea.addMouseListener(new MouseAdapter() {
           @Override
            //Released表示释放鼠标，意思是当鼠标不再点击，而是抬起移动的时候调用该方法
            public void mouseReleased(MouseEvent e) {
                boolean pt = e.isPopupTrigger();//是否点击鼠标

                if (pt) { //菜单坐标e.getX(),e.getY()是跟随鼠标右键的坐标，显示show这个菜单栏
                    colorMenu.show(drawArea, e.getX(), e.getY());
                }

                //当鼠标不再点击，而是当抬起移动的时候，重置第1个点的坐标，
                preX = -1;
                preY = -1;
            }
        });
//--鼠标右键菜单的组装--------------------------------------------------


        //设置位图的背景为白色
        g.setColor(Color.white);
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);//填充满白色到整个画布

        //监听鼠标的移动画画，来完成线条的绘制 [是在画布里面监听鼠标的移动]
        /*drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
*//*
                if (preX > 0 && preY > 0) {//当坐标拖动过了才去画线条
                    //调画笔的颜色
                    g.setColor(currentColor);
                    //画线条，一条线需要2个点，也就是2组坐标，分别代表线条的起点和终点坐标
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //当是第一个点的时候，修正preX和preY的值
                preX = e.getX();
                preY = e.getY();

                //重绘组件，刷新flush
                drawArea.repaint();*//*
            }
        });*/

        //监听鼠标的移动画画，来完成线条的绘制 [是在画布里面监听鼠标的移动]

        drawArea.addMouseListener(new MouseAdapter() {//TMD竟然没有new MouseMotionAdapter
            @Override
            public void mouseDragged(MouseEvent e) {

                if (preX > 0 && preY > 0) {//当坐标拖动过了才去画线条
                    //调画笔的颜色
                    g.setColor(currentColor);
                    //画线条，一条线需要2个点，也就是2组坐标，分别代表线条的起点和终点坐标
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                //当是第一个点的时候，修正preX和preY的值
                preX = e.getX();
                preY = e.getY();

                //重绘组件，刷新flush
                drawArea.repaint();
            }
        });

        //最后设置好画布drawArea的大小，然后把画布组装一下到Frame中显示
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH,AREA_HEIGHT));
        frame.add(drawArea);


        //设置Frame最佳大小&可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new p501Demo1().methodInit();
    }

}
