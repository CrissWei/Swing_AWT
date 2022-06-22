package awt_zz1Game_Day722.p496Game;
//可以修改小球初始速度，和100毫秒repaint刷新一次
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Game2 {
    //----------------------------------【声明一些成员变量】---------------------
    //窗口对象
    private Frame frame = new Frame("弹球小游戏");

    //设置桌面【高度&宽度】
    private final int TABLE_WIDTH = 300; //桌面宽度
    private final int TABLE_HEIGHT = 400;//桌面高度

    //设置球拍【高度&宽度】
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //设置小球的大小
    private int BALL_SIZE = 16;//小球的直径是16个像素

    //定义变量，记录球拍的【初始坐标】
    private int racket_X = 120; //没有final修饰，X坐标是可变的，球拍要移动
    private final int racket_Y = 340;//被final修饰，球拍的Y轴方法不变

    //定义变量，记录小球的【初始坐标】，//【注意】因为小球坐标会变动，不能被final修饰
    private int ball_X = 120;
    private int ball_Y = 20;

    //定义变量，记录小球在x和y方向上分别移动的【初始速度】
    private int speed_X = 10;//一次移动10个像素
    private int speed_Y = 5;//一次移动5个像素

    //因为游戏有可能结束，所以需要定义一个变量，【来判断游戏是否结束】
    private boolean isOver = false;//默认是false没有结束,当isOver=true,那么游戏结束

    //声明一个【定时器Timer】（在swing类中）,100毫秒重绘repaint一次
    //private Timer timer;不是util包下的Timer，是swing包下的
    //private javax.swing.Timer timer;
    private Timer timer;
//----------------------------------【声明一些成员变量】---------------------

    //需要【创建一块画布】，用来画画， 这个画布可以自定义一个类【内部类】去继承extends Canvas并重写paint方法，来充当画布
    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            //【绘制内容】是重点 ，【绘制2个部分：1.游戏结束 2.正在游戏】
//--1.游戏结束---------------------------------------
            if (isOver) {//如果isOver = true
                //游戏结束的绘制如下
                g.setColor(Color.GREEN);//设置颜色
                g.setFont(new Font("Times", Font.BOLD, 30));//设置字体
                g.drawString("游戏结束!!!", 50, 200);//设置这4个字的出现坐标
//--1.游戏结束---------------------------------------

//----2.正在游戏-----------------------------------
            } else {//默认是isOver = false,正在游戏
                //正在游戏的绘制如下：需要绘制2个部分【绘制小球】和【绘制球拍】

                //【绘制小球】
                g.setColor(Color.RED);//小球的颜色
                //这个不是drawOval绘制一个空心的小球，而是要fillOval填充满小球，实心
                g.fillOval(ball_X, ball_Y, BALL_SIZE, BALL_SIZE);//等效于g.fillOval(120,20,16,16);

                //【绘制球拍】
                g.setColor(Color.PINK);
                //g.fillOval(120,340,300,300);和下面等效
                g.fillRect(racket_X, racket_Y, RACKET_WIDTH, RACKET_HEIGHT);//120,340,300,300
            }
        }
    }
//----2.正在游戏-----------------------------------


    //【创建绘画的区域】根据刚自定义的类来创建对象，以便后面用对象名drawArea来调用方法
    MyCanvas drawArea = new MyCanvas();


    private void init() {//在方法内【组装视图，以及游戏的逻辑的控制】

//---监听用户按键----------------------------------------
        //【监听器】完成球拍的坐标变化repaint
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获取用户当前按下的键keyCode
                int keyCode = e.getKeyCode();

                //判断用户是按键左方向<- 还是按 右方向->键，
                if (keyCode == KeyEvent.VK_LEFT) {//如果当前按键==左键<-
                    //<-具体如何向左移动？？
                    if (racket_X > 0) {//到达左侧边界//如果球拍的【左上角那一点的】X坐标大于0，才能左移
                        racket_X -= 10;//x-=2-->x=x-2;
                    }
                }
                if (keyCode == KeyEvent.VK_RIGHT) {//如果当前按键==右键->
                    //->具体如何向右移动？？
                    if (racket_X < (TABLE_WIDTH - RACKET_WIDTH)) {//到达右侧边界，球拍X坐标>(桌面宽度-球拍宽度)
                        racket_X += 10;//一次移动10个像素
                    }
                }
            }
        };
        //上面的【监听器Listener】写完后，不会自动运行，得和【事件源Event】绑定才行
        //事件源可以是Frame，也可以是drawArea，干脆一起绑定，都去注册监听器
        frame.addKeyListener(keyListener);
        drawArea.addKeyListener(keyListener);
//---监听用户按键----------------------------------------

//--【小球坐标的控制】--------------------------------------------
        ActionListener task = new ActionListener() {
            @Override
            //根据边界范围，修正X和Y坐标的速度，改为反向运动，速度大小不变，方向相反
            public void actionPerformed(ActionEvent e) {
                //修改小球 X 轴方向的速度
                if (ball_X <= 0 || ball_X >= (TABLE_WIDTH - BALL_SIZE)) {
                    speed_X = -speed_X;//速度大小不变，方向相反
                }
                //修改小球 Y 轴方向的速度【当小球落在球拍上的时候才修改小球Y轴速度】
                if (ball_Y <= 0 || ball_Y > racket_Y - BALL_SIZE && ball_X > racket_X && ball_X < racket_X + RACKET_WIDTH) {
                    speed_Y = -speed_Y;
                }
                //当小球没落在球拍上，游戏结束  //[感觉是或者||]
                if (ball_Y > racket_Y-BALL_SIZE && (ball_X < racket_X || ball_X>racket_X+RACKET_WIDTH)) {
                    //停止计时器
                    timer.stop();
                    //修改标记为true
                    isOver = true;
                    //重绘界面
                    drawArea.repaint();
                }
                //更新小球的坐标，重绘repaint界面
                ball_X += speed_X;//+10个像素
                ball_Y += speed_Y;//+5个像素

                //刷新重绘界面repaint
                drawArea.repaint();
            }
        };

//--【小球坐标的控制】---------------------------------------------

        //100毫秒重新绘制repaint刷新一次界面
        /*timer = new Timer(100,task);
        timer.start();//启动时间*/
        timer = new Timer(50,task);
        timer.start();


        //设置画布的长和宽
        drawArea.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));
        //最后把绘图的桌面添加到frame中显示即可
        frame.add(drawArea);


        //设置颜色，大小，可见
        frame.setBackground(Color.WHITE);
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

    public static void main(String[] args) {
        new Game2().init();//调用构造方法init
    }
}
