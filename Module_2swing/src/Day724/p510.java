package Day724;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p510 {

    JFrame jFrame = new JFrame();

    //�����˵���������
    JMenuBar menuBar = new JMenuBar();//�˵���

    JMenu menuFile = new JMenu("�ļ�");
    JMenu menuEdit = new JMenu("�༭");

    JMenuItem auto = new JMenuItem("�Զ�����");
    //�������new ImageIcon�ǣ�����ť�Աߴ�һ��ͼ��,����ͼ��̫����
    JMenuItem copy = new JMenuItem("����",new ImageIcon("Module1_awt\\image\\black.jpg"));
    JMenuItem paste = new JMenuItem("ճ��",new ImageIcon("Module1_awt\\image\\box.jpg"));

    JMenu formatMenu = new JMenu("��ʽ");//�����һֱ�Ӳ˵�

    JMenuItem comment = new JMenuItem("ע��");
    JMenuItem cancelComment = new JMenuItem("ȡ��ע��");

    //�����ı���TextArea
    JTextArea ta = new JTextArea(8, 20);

    //�����б��(RGB��ɫ)
    String[] colors = {"��ɫ", "��ɫ", "��ɫ"};
    JList<String> colorList = new JList<>(colors);

    //�������ѡ��������
    JComboBox<String> colorSelect = new JComboBox<>();//����ѡ���

    //������ťgroup��������male & female��ť
    ButtonGroup bg = new ButtonGroup();

    //������Ů��ѡ��ѡ���Radio //�к�Ůֻ�ܶ�ѡһ
    JRadioButton male = new JRadioButton("��", false);//false��Ĭ�ϲ�ѡ
    JRadioButton female = new JRadioButton("Ů", true);//true��Ĭ����ѡ

    JCheckBox isMarried = new JCheckBox("�Ƿ��ѻ�", true);//true��Ĭ���Ѿ������ѡ���ϴ���

    //�����ײ���ť
    JTextField tf = new JTextField(40);//�ı���40����ô��

    //�������new ImageIcon�ǣ�����ť�Աߴ�һ��ͼ��,����ͼ��̫����
    JButton ok = new JButton("ȷ��",new ImageIcon("Module1_awt\\image\\white.jpg"));

    //��������Ҽ���ʾ�Ĳ˵�
    JPopupMenu jPopupMenu = new JPopupMenu();

    //����һ��ֻ�ܵ�ѡ��ButtonGroup,����װ����ĸ��ַ��Ĭ��ѡ��Windows���
    ButtonGroup popupButtonBg = new ButtonGroup();

    //ֻ��ѡһ����ѡ����Radio
    JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal ���");
    JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus ���");
    JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows ���");
    JRadioButtonMenuItem windowsClassicItem = new JRadioButtonMenuItem("Windows ������");
    JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif ���");


    //���ķ������档����װ��ͼ--�ɼ���-----------------------------------
    private void init() {
        //��װ�ײ�----------------------------
        JPanel jPanel = new JPanel();
        jPanel.add(tf);//�ײ��ı���
        jPanel.add(ok);//�ײ���ť
        jFrame.add(jPanel, BorderLayout.SOUTH);//-----�ײ���װ���--------------

        //��װѡ���----��Ů���ѻ��-----------------

        //����JPanel����,������װ
        JPanel jPaneSelect = new JPanel();

//        colorSelect.add("��ɫ",colorList);
        colorSelect.addItem("��ɫ");
        colorSelect.addItem("��ɫ");
        colorSelect.addItem("��ɫ");
        jPaneSelect.add(colorSelect);

        //�Ȱ�male & female��ӵ�ButtonGroup-->Ȼ����ӵ�JPanel����
        bg.add(male);
        bg.add(female);
        jPaneSelect.add(male);
        jPaneSelect.add(female);
        //�Ƿ��飬
        jPaneSelect.add(isMarried);


        //���ı���JTextArea��ѡ���  ��װ���� ��ѡ�����TextArea��ֱ�·�
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);//����ı���
        topLeft.add(jPaneSelect);//���JPanel����

        //topLeft���ú�ˮƽ�ұߵ���ɫ��װһ��
        Box top = Box.createHorizontalBox();
        top.add(topLeft);//ˮƽ��ϵ��topLeft�����
        top.add(colorList);

        //Ȼ�����װ�õ�top��ӵ�Frame
        jFrame.add(top);

        //------�м�����װ��ϣ���󻹲���Ĳ˵�û��װ-----------------------------------

        //��װ�����˵����------------------
        formatMenu.add(comment);
        formatMenu.add(cancelComment);

        //��װ�༭�˵�
        menuEdit.add(auto);
        menuEdit.addSeparator();//���һ����ָܷ���
        menuEdit.add(copy);
        menuEdit.add(paste);
        menuEdit.add(formatMenu);

        //�ѱ༭edit�˵����ļ�file�˵�����װ���˵���JMenuBar����
        menuBar.add(menuEdit);
        menuBar.add(menuFile);

        //���Ѳ˵���menuBar��װ��JFrame����
//        jFrame.add(menuBar);
        jFrame.setJMenuBar(menuBar);

        //------------��һ������װ��ϣ�������������Ҽ�jPopup��ʾ�����Ĳ˵�����װ--------------

        //Ϊ��ʵ�ֵ�ѡЧ��������Щѡ����ӵ�һ��ButtonGroup�������
        popupButtonBg.add(metalItem);
        popupButtonBg.add(nimbusItem);
        popupButtonBg.add(windowsItem);
        popupButtonBg.add(windowsClassicItem);
        popupButtonBg.add(motifItem);

        //�����������Ч��-->Listener ����¼�Event
        //����һ���¼�������
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  //��ǰѡ�������һ�����
                String actionCommand = e.getActionCommand();
                //����ѡ��ķ���
                try {
                    changeFlavor(actionCommand);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        };
        //��������������֮�󣬵�һ��һ��ע���5����ť
        metalItem.addActionListener(listener);
        nimbusItem.addActionListener(listener);
        windowsClassicItem.addActionListener(listener);
        windowsItem.addActionListener(listener);
        motifItem.addActionListener(listener);

        //�������5����ť����ӵ��Ҽ�Popup�˵�����
        jPopupMenu.add(metalItem);
        jPopupMenu.add(nimbusItem);
        jPopupMenu.add(windowsItem);
        jPopupMenu.add(windowsClassicItem);
        jPopupMenu.add(motifItem);

        //����swing�����һ�������������������¼�
        ta.setComponentPopupMenu(jPopupMenu);
//--------------------ȫ����װ���-------------------------------------


        //���������Ѵ�С�Ϳɼ���
        jFrame.pack();
        jFrame.setVisible(true);
        //�رմ���
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);



    }

    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal ���":
                UIManager.setLookAndFeel(" javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus ���":
                UIManager.setLookAndFeel(" javax.swing.plaf.nimbus. NimbusLookAndFeel2");
                break;
            case "Windows ���":
                UIManager.setLookAndFeel(" com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows ������":
                UIManager.setLookAndFeel(" com.sun.java. swing.plaf.windows.WindowsClassicLookAndFeel") ;
                break;
            case "Motif ���":
                UIManager.setLookAndFeel(" com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }
        //ˢ���������ۣ����ܿ������ĺ�ķ�� ��TMD��Щ������Ҳ���ᰡ��Ҳô���ܣ�ֱ�����ˡ�
        SwingUtilities.updateComponentTreeUI(jFrame.getContentPane());//���������������ˢ�¶�������jFrame�������е����
        SwingUtilities.updateComponentTreeUI(menuBar);//ˢ�²˵���
        SwingUtilities.updateComponentTreeUI(jPopupMenu);//ˢ���Ҽ�

    }

    public static void main(String[] args) {
        new p510().init();
    }
}
