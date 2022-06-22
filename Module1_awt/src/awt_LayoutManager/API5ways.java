package awt_LayoutManager;

public class API5ways {
    /*
   Component作为基类,提供了如下常用的方法来设置组件的大小、位置、可见性等。

方法签名:                                          方法功能:
    setLocation(int X, int y)                           设置组件的位置。
    setSize(int width, int height)                      设置组件的大小。
    setBounds(int x, int y, int width, int height)      同时设置组件的位置、大小。
    setVisible(Boolean b):                              设置该组件的可见性。
---------------------------------------------
Container作为容器根类,提供了如下方法来访问容器中的组件
方法签名:                                方法功能:
    Component add(Component corp)           向容器中添加其他组件(该组件既可以是普通组件,也可以是容器) ,并返回被添加的组件.
    Component getComponentAt(int X, int y): 返回指定点的组件。
    int getComponentCount):                 返回该容器内组件的数量。
    Component[] getComponents():            返回该容器内的所有组件。

*/

    /*--------------------------------------------------
    =========================================================
* 接口 : LayoutManager
    GridLayout  网格布局
    FlowLayout  流式布局  (Panel的默认布局管理类型是 FlowLayout )

* 接口:LayoutManager2
    CardLayout      卡片布局
    GridBagLayout   网格包布局  （包含了的功能，而且还可以给每一个网格自定义占几行几列）-->之后到swing里面去学
    BorderLayout    边界布局  (Frame默认的布局管理器是 BorderLayout )
*/
}
