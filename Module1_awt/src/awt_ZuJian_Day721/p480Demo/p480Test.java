package awt_ZuJian_Day721.p480Demo;

import javax.swing.*;
import java.awt.*;

/*
* 2.5.1基本组件
组件名:   功能:
* Button      按钮
* Canvas    用于绘图的画布 【单独讲解】
* Checkbox  复选框组件(也可当做单选框组件使用)用于将多个Checkbox组件组合成一组，一组Checkbox组件将只有一个可以 被选中，
* CheckboxGroup 即全部变成单选框组件
* Choice 下拉选择框
* Frame 窗口，  在GUI程序里通过该类创建窗口
* Label 标签类,用于放置提示性文本
* List  列表框组件，可以添加多项条目
* Panel 不能单独存在基本容器类,必须放到其他容器中
* Scrollbar  滑动条组件。如果需要用户输入位于某个范围的值， 就可以使用滑动条组件, 比如调色板中设置RGB的三个值所用的滑动条。
当创建一个滑动条时 ,必须指定它的方向、初始值、滑块的大小、 最小值和最大值。
* ScrollPane  带水平及垂直滚动条的容器组件【不重要】
* TextArea   多行文本域
* TextField  单行文本框
*/
public class p480Test {
    Frame frame = new Frame("这里是测试基本组件");
    //文本框。5行10列
    TextArea ta = new TextArea(5, 10);
    //下拉选择域，并添加颜色
    Choice Colors = new Choice();
    //局部不能写方法，必须在方法里面才能添加方法
//        choiceColor.add("红");
//        choiceColor.add("绿");
//        choiceColor.add("蓝");
    //性别单选
    CheckboxGroup cbg = new CheckboxGroup();//创建一个组对象
    Checkbox male = new Checkbox("男", cbg, true);//男，当前组是cbg,true是默认已选?
    Checkbox female = new Checkbox("女", cbg, false);//女,默认没选
    //是否已婚
    Checkbox isMarried = new Checkbox("是否已婚？");
    //一行文本
    TextField tf = new TextField(50);//50列文本
    //按钮
    Button sure = new Button("确认");//这个按钮在50列文本的右侧
    //列表框list【放颜色】
    List listColor = new List(6, true);//6行，是否多选:true
//        choiceColor.add("红");
//        choiceColor.add("绿");
//        choiceColor.add("蓝");

    private void method1() {//别写static
        //组装界面，分析从整体到局部细节，具体的组装操作由局部细节到整体拼接--------

        //【1、组装底部】使用Box来组装底部的单列文本【最简单】，水平方向
        Box hBox = Box.createHorizontalBox();
        hBox.add(tf);//添加底部文本框
        hBox.add(sure);//添加确认按钮
        //把bBox放到Frame的南部区域
        frame.add(hBox, BorderLayout.SOUTH);

        //【2、组装选择内容框】，也是创建一个在水平方向的Box
        Box hBox2 = Box.createHorizontalBox();

        //添加颜色到选择框里
        Colors.add("红");
        Colors.add("绿");
        Colors.add("蓝");
        //把选择框添加到hBox2, 最后还要把hBox2添加到Frame窗口里面
        hBox2.add(Colors);

        //添加男女选择框,和是否已婚
        hBox2.add(male);
        hBox2.add(female);
        hBox2.add(isMarried);

        //【3、组装选择框和上面的文本框】把上面第2部分的Choice选择内容框和文本区域Area在垂直Vertical方向上组合起来
        Box topLeftBox = Box.createVerticalBox();
        //Box里面添加其他的Box
        topLeftBox.add(ta);//添加文本域
        topLeftBox.add(hBox2);//添加另一个装着选择内容的Box
/*
        //最后还要把topLeft添加到Frame窗口里面
        //frame.add(toLeft,BorderLayout.CENTER);
        frame.add(topLeft);//默认就是中间区域CENTER
【暂时别这样,因为还得把右边添加进来,等把右边的颜色文本框一起add后,然后再整体一起添加到Frame的CENTER】
*/
        //【组装顶部】在水平Box内组装toLeft和右边的文本框
        Box topBox = Box.createHorizontalBox();//创建topBox

        topBox.add(topLeftBox);//添加topLeftBox到topBox里面

        //添加颜色
        listColor.add("红色");
        listColor.add("绿色");
        listColor.add("蓝色");
        topBox.add(listColor);//添加右侧颜色文本框



        //把TopBox添加到的Frame中间区域
        frame.add(topBox);//默认就是中间区域

        //设置内容最佳大小和可见
        frame.pack();
        frame.setVisible(true);



    }

    public static void main(String[] args) {
        new p480Test().method1();//类名.方法名称，调用本类的static方法
    }
}