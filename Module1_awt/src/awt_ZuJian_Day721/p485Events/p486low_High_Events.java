package awt_ZuJian_Day721.p485Events;

/*
* AWT把事件分为了两大类:
1.低级事件:这类事件是基于某个特定动作的事件。比如进入、点击、拖放等动作的鼠标事件

* 事件:             触发时机:
    ContainerEvent    容器事件，当容器里发生添加组件、删除组件时触发该事件。
    WindowEvent       窗口事件，当窗口状态发生改变(如打开、关闭、最大化、最小化时触发该事件。
    FocusEvent        焦点事件，当组件得到焦点或失去焦点时触发该事件。
    KeyEvent          键盘事件 ，当按键被按下、松开、单击时触发该事件。
    MouseEvent        鼠标事件，当进行单击、按下、松开、移动鼠标等动作时触发该事件。
    PaintEvent        组件绘制事件，该事件是-个特殊的事件类型，当 GUI组件调用update/paint方
        法来呈现自身时触发该事件,该事件并非专用于事件处理模型。
---------------------
*
* 2.高级事件:这类事件并不会基于某个特定动作,而是根据功能含义定义的事件。

* 事件 :             触发时机:
    ActionEver          动作事件,当按钮、菜单项被单击,在TextField中按Enter 键时触发
    AjustmentEvent      调节事件,在滑动条上移动滑块以调节数值时触发该事件。
    ItemEvent           选项事件,当用户选中某项，或取消选中某项时触发该事件。
    TextEvent           文本事件，当文本框、文本域里的文本发生改变时触发该事件。
*-------------------------------------------
* 事件监听器
*
* 事件类别:      描述信息:        监听器接口名:
    ActionEvent     激活组件              ActionListener
    ItemEvent       选择了某些项目          ItemListener
    MouseEvent      鼠标移动               MouseMotionListener
    MouseEvent      鼠标点击等              MouseListener
    KeyEvent        键盘输入                 KeyListener
    FocusEvent      组件收到或失去焦点         FocusListener
    AdjustmentEvent 移动了滚动条等组件         AdjustmentListener
    ComponentEvenT  对象移动缩放显示隐藏等      ComponentListener
    WindowEvent     窗口收到窗口级事件          WindowListener
    ContainerEvent  容器中增加删除了组件         ContainerListener
    TextEvent       文本字段或文本区发生改变      TextListener

*
*  */
public class p486low_High_Events {
}
