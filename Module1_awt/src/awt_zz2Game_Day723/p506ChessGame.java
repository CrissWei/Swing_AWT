package awt_zz2Game_Day723;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class p506ChessGame {

    JFrame frame = new JFrame("五子棋游戏");

    //声明4个成员变量BufferedImage，分别表示4张图片
    BufferedImage table;
    BufferedImage black;
    BufferedImage white;
    BufferedImage select;

    //声明2个成员变量，代表棋盘的高height839&&宽width835
    final int TABLE_WIDTH = 835;
    final int TABLE_HEIGHT = 839;

    //声明棋盘最多可以下多少棋子
    final int BOARD_SIZE = 15;

    //声明每一个棋子占棋盘的大小尺寸
    final int RATE = TABLE_WIDTH / BOARD_SIZE;//835/15,后面会把棋盘大小误差抹掉，变成正方形

    //声明成员变量，记录棋子在X&Y方向上的偏移量
    final int X_OFFSET = 5;
    final int Y_OFFSET = 9;//消除偏移量误差

    //声明一个二维数组，记录棋子，如果索引[i][j]处的值为: 0-没有棋子,1-白棋,2-黑棋
    int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    //声明成员变量，记录选择框的初始坐标（之后会修改的），该选择框坐标其实就是二维数组board中的索引值
    int select_X = -1;
    int select_Y = -1;

    //----上面是成员变量的声明-------------------------------------------
    //----下面是自定义类，作为画布-------------------------------------------
    public class ChessBoard extends Canvas{
        @Override
        public void paint(Graphics g) { //绘图逻辑
            //绘制棋盘
            g.drawImage(table,0,0,null);

            //绘制选择框
            if (select_X>0&&select_Y>0){
                g.drawImage(select,select_X*RATE+X_OFFSET,select_Y*RATE+Y_OFFSET,null);
            }
            //绘制黑白棋子
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    //绘制黑棋
                    if (board[i][j]==2){
                        g.drawImage(black,i*RATE+X_OFFSET,j+RATE+Y_OFFSET,null);
                    }
                    //绘制白棋
                    if (board[i][j]==1){
                        g.drawImage(white,i*RATE+X_OFFSET,j+RATE+Y_OFFSET,null);
                    }

                }
            }


        }
    }
    //创建自定义类的棋盘对象，用来调用里面的方法
    ChessBoard cb= new ChessBoard();//为了后面的组装棋盘：【1、设置棋盘大小；2、添加到frame中间CENTER】

    //声明变量。用来记录当前下棋的颜色
    int board_type = 2;//默认是黑色，2代表black,1是white,0代表没棋。到时候可以改颜色


    //声明底部要用到的组件
    Panel panel = new Panel();
    Button whiteButton = new Button("白棋");
    Button blackButton = new Button("黑棋");
    Button deleteButton = new Button("删除");




    //-----------------------------------------------
    public void refreshButtonColor (Color white, Color black, Color delete) {
        whiteButton.setBackground (white) ;
        blackButton.setBackground (black) ;
        deleteButton.setBackground (delete);
    }

    //-----------------------------------------------

//----//先设置3个按钮点击后的行为Listener-----------------------------
    private void init() throws Exception {//先设置3个按钮点击后的行为Listener，组装视图

        whiteButton.addActionListener(e -> {//当点击白棋按钮的时候，需要完全2件事
            //修改当前要下的棋子的标志为1 ,因为白棋设置是1，黑棋设置为2
            board_type=1;

            //刷新按钮的颜色【因为3个按钮都要刷新，所以为了代码简洁，在外面封装成一个方法来调用即可】
            refreshButtonColor(Color.GREEN,Color.gray,Color.gray);//当按下白棋按钮，白棋按钮变绿，其他变灰
        });
        blackButton.addActionListener(e -> {//当点击白棋按钮的时候，需要完全2件事
            //修改当前要下的棋子的标志为1 ,因为白棋设置是1，黑棋设置为2
            board_type=2;

            //刷新按钮的颜色【因为3个按钮都要刷新，所以为了代码简洁，在外面封装成一个方法来调用即可】
            refreshButtonColor(Color.gray,Color.GREEN,Color.gray);//当按下黑棋按钮，黑棋按钮变绿，其他变灰
        });
        deleteButton.addActionListener(e -> {//当点击白棋按钮的时候，需要完全2件事
            //修改当前要下的棋子的标志为1 ,因为白棋设置是1，黑棋设置为2
            board_type=0;

            //刷新按钮的颜色【因为3个按钮都要刷新，所以为了代码简洁，在外面封装成一个方法来调用即可】
            refreshButtonColor(Color.gray,Color.gray,Color.GREEN);//当按下删除按钮，删除按钮变绿，其他变灰
        });
//----3个按钮点击后的行为， 设置完毕----------------------------

        //组装底部按钮到Panel，再次之前先设置点击后的行为，也就是先得Listener
        panel.add(whiteButton);
        panel.add(blackButton);
        panel.add(deleteButton);

        //添加panel到frame的南部
        frame.add(panel,BorderLayout.SOUTH);

//----组装棋盘开始----------------------------
        //加载棋盘的图片
        
        table= ImageIO.read(new File("Module1_awt\\image\\chess.jpg"));
        white= ImageIO.read(new File("Module1_awt\\image\\white.jpg"));
        black= ImageIO.read(new File("Module1_awt\\image\\black.jpg"));
        select= ImageIO.read(new File("Module1_awt\\image\\box.jpg"));



        //处理鼠标在棋盘上移动时的行为
        cb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                select_X = (e.getX()-X_OFFSET)/RATE;   //计算好之后赋值给select_X
                select_Y = (e.getY()-Y_OFFSET)/RATE;   //计算好之后赋值给select_X

                //重绘repaint
                cb.repaint();
            }
        });

        //处理鼠标在棋盘上点击后的行为
        cb.addMouseListener(new MouseAdapter() {
            //当鼠标点击后调用该方法
            @Override
            public void mouseClicked(MouseEvent e) {
                int xPos = (e.getX()-X_OFFSET)/RATE;
                int yPos = (e.getY()-Y_OFFSET)/RATE;

                //点击后，有棋子在棋盘上面了
                board[xPos][yPos]=board_type;
                //重绘
                cb.repaint();
            }

            @Override//当鼠标移出去，不再棋盘界面的时候，选择框消失，也就是重绘界面即可
            public void mouseExited(MouseEvent e) {
                select_X=-1;
                select_Y=-1;
                cb.repaint();
            }
        });

        //组装棋盘：【1、设置棋盘大小；2、添加到frame中间CENTER】
        cb.setPreferredSize(new Dimension(TABLE_WIDTH,TABLE_HEIGHT));//1、设置棋盘大小
        frame.add(cb);//2、把棋盘（drawArea画布）添加到frame中间CENTER
//---组装棋盘完毕-----------------------------



        //设置最佳大小&可见
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
        new p506ChessGame().init();
    }

}
