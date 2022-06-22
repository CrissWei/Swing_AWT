package awt_containerAPI;
//滚动条。
import java.awt.*;

public class p469ScrollPane {
    public static void main(String[] args) {

methodScrollPane();//调用方法
    }
    private static void methodScrollPane(){
        Frame frame = new Frame("这里是窗口名字");
//1. 创建-个ScrollPane对象
        //ScrollPane sp = new ScrollPane();//由于内容比较少，能装得下，所以没有出现滚动条ScrollPane
        ScrollPane sp = new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);//always有滚动条

//2.往ScrollPane中添加内容
        sp.add(new TextField("这是文本框"));
        sp.add(new Button("这是测试键钮"));

//3.把ScrollPane添加到Frame中
        frame.add(sp);

        frame.setBounds(100,100,500,300);
        frame.setVisible(true);
    }
}
