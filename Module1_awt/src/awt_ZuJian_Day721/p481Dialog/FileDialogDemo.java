package awt_ZuJian_Day721.p481Dialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
* 方法名称:               方法功能:
    1、String getDirectory()       获取被打开或保存文件的绝对路径
    2、String getFile()            获取被打开或保存文件的文件名
    3、FileDialog(Frame parent,String title, int mode)
  参数的含义如下：
        创建一个文件对话框: <br/>
       Frame parent:指定父窗口<br/>
       String title:对话框标题<br/>
       int mode:文件对话框类型,如果指定为FileDialog.LOAD ,用于打开文件,如果指定为FileDialog.SAVE,用于保存文件

*/
public class FileDialogDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();
//1.创建两个FileDialog对象
        FileDialog fd1 = new FileDialog(frame,"选择要打开的文件",FileDialog.LOAD);//打开LOAD是 ： 0
        FileDialog fd2 = new FileDialog(frame,"选择要保存的路径",FileDialog.SAVE);//保存SAVE是 ： 1

//2.创建两个按钮
        /*fd1.add(new Button("打开文件Open"));
        fd2.add(new Button("保存文件Save")); 【建议别这样用匿名对象，因为后续要拿对象名有用，不用匿名】*/
        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

//3.给这两个按钮设置点击后的行为:获取打开或者保存的路劲文件名
        /*new Button()*/ b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd1.setVisible(true);//代码会阻塞到这里
                //获取选择的路径和文件
                String directory = fd1.getDirectory();
                String file = fd1.getFile();
                System.out.println("打开的文件路径为："+directory);
                System.out.println("打开的文件名称为："+file);
            }
        });

        /*new Button()*/b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fd2.setVisible(true);//代码会阻塞到这里
                //获取选择的路径和文件
                String directory = fd2.getDirectory();
                String file = fd2.getFile();
                System.out.println("保存的文件路径为："+directory);
                System.out.println("保存的文件名称为："+file);
            }
        });


//4.把[按钮/对话框]添加到Frame中,  【不能是对话框，是按钮】
      /*  frame.add(fd1,BorderLayout.NORTH);
        frame.add(fd2); 【不能添加对话框到Frame，要添加按钮】
*/
        //Button添加到Frame
        frame.add(b1,BorderLayout.NORTH);
        frame.add(b2);

        //最佳大小和可见
        frame.pack();
        frame.setVisible(true);
    }
}
