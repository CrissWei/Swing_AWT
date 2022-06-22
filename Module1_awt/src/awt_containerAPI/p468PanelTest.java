package awt_containerAPI;

import java.awt.*;

public class p468PanelTest {

    public static void main(String[] args) {
/*//1.创建frame容器对象
        Frame frame = new Frame("这里在测试Panel");
//2.创建Panel容器对象
        Panel panel = new Panel();
//3.往Panel容器中添加组件
        panel.add(new TextField("这是一 个测试文本"));
        panel.add(new Button("这是一个测试按钮"));*/

        //调方法
        methodPanel();//【一定在File encoding里面设置GBK编码和解码这个程序，否则乱码】

    }
    private static void methodPanel(){
//1.创建一个window对象，因为， panel以及其 他的容器，都不能独立存在， 必须依附window存在
        Frame frame = new Frame("这里演示Panel");
//2.创建一个Panel对象
        Panel panel = new Panel();//这个Panel容器不能单独存在，只能依附Frame
//3.创建一个文本框和 一个按钮，并且把他们放入到Panel容器中
        panel.add(new TextField("这里是一个测试文本"));
        panel.add(new Button("这是一个测试按钮"));

//4. 把panel放入到window中，[因为Panel既可以做容器Container来添加其他组件，本身也可作为组件添加到Frame里面]
        frame.add(panel);
//6.设置window的位置以及大小
        frame.setBounds(300,300,500,800);

//6. 设置window可见
        frame.setVisible(true);


    }
}
