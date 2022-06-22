package awt_ZuJian_Day721.p492Paint;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
  在AWT中,真正提供绘图功能的是Graphics对象
    * 【问题】：那么Component组件和Graphics对象存在什么关系,才能让Component绘制自身图形呢?
    * 【答案】：在Component类中,提供了下列三个方法来完成组件图形的绘制与刷新:

     绘图3个方法：
        Paint(Graphics g):绘制组件的外观;【系统自动】
        update(Graphics g):内部调用paint方法,刷新组件外观;【系统自动】
        repaint():调用update方法,刷新组件外观; 【手动】
        ------------------------
程序中绘图也一样,也需要画布,画笔,颜料等等。
AWT中提供了Canvas类充当画布,提供了Graphics类来充当画笔，
 通过调用Graphics对象的setColor(方法可以给画笔设置颜色)

画图的步骤:
    1.自定义类,继承Canvas类,重写paint(Graphics g)方法完成画图;
    2.在paint方法内部,真正开始画图之前调用Graphics对象的setColor)、setFont()等方法设置画笔的颜色、字体等属性;
    3.调用Graphics画笔的drawXxx(方法开始画图。


-----------画图具体方法------------------------
方法名称:               方法功能:

//绘图
setColor(Color C)       设置颜色
setFont(Font font)      设置字体
drawLine()              绘制直线
drawRect()              绘制矩形
drawRoundRect()         绘制圆角矩形
drawOval()              绘制椭圆形
drawPolygon()           绘制多边形
drawArc()               绘制圆弧
drawPolyline()          绘制折线

//填充
fillRect()              填充矩形区域
fillRoundRect()         填充圆角矩形区域
fillOval()              填充椭圆区域
fllPolygon()            填充多边形区域
fllArc()                填充圆弧对应的扇形区域
drawImage()             绘制位图

*/
public class p492Graphics {
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";
    private Frame frame = new Frame("这里是测试绘图窗口");

    //创建按钮
    Button buttonRect = new Button("绘制矩形");
    Button buttonOval = new Button("绘制椭圆");
    //创建文本框
    TextArea ta = new TextArea("这是文本域",5,10);

//---------------------------
    //定义一个变量,记录当前要绘制rect or oval
    private String shape ="";//空字符串

    // 1.自定义类,继承Canvas类,重写paint(Graphics g)方法完成画图;【准备画布工作】
    private class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g) {
            //条件判断，绘制不同图形
            if (shape.equals(RECT_SHAPE)){
                //绘制矩形
                g.setColor(Color.PINK);//粉色
                g.drawRect(100,100,150,150);//矩形的坐标和大小
            }else if (shape.equals(OVAL_SHAPE)) {
                //绘制椭圆
                g.setColor(Color.RED);//红色
                g.drawOval(100, 100, 150, 150);//椭圆的坐标和大小
            }
        }
    }
    //创建自定义的画布对象，用来调用方法
    MyCanvas drawArea = new MyCanvas();
//-------------------

    public void init(){//【组装视图，从小到大】

        //【事件监听】先监听按钮,让点击按钮后有反应
        buttonRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //点一下，修改空字符串标记的值
                shape= RECT_SHAPE;//赋值
                //然后画图对象调用repaint方法，重画
                drawArea.repaint();
            }
        });

        //监听椭圆按钮
        buttonOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape= OVAL_SHAPE;//赋值
                drawArea.repaint();//重画
            }
        });
        //组装， 把2个按钮组装到Panel，然后把Panel放到Frame南部
        Panel panel = new Panel();
        panel.add(buttonOval);
        panel.add(buttonRect);

        frame.add(panel, BorderLayout.SOUTH);//这一步为止，已经把底部组装完了，接下来是组Frame中间


        //设置画布DrawArea大小,画布大小要比图形大//这个长宽不能小于坐标，不然不在drawArea区域，看不见,
        drawArea.setPreferredSize(new Dimension(500,500));
        //然后把drawArea放到Frame中间
        frame.add(drawArea);
        frame.add(ta,BorderLayout.NORTH);//文本框放在北部


        //大小&可见
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        new p492Graphics().init();
    }
}
