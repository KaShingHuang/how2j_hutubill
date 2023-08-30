package gui.panel;

import gui.listener.ToolBarListener;
import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    //这个Jpanel采用水晶皮肤，其他Panel也是如此，放在最前面默认执行
    static {
        GUIUtil.useLNF();
    }
    //固定的Mainpanel对象，方便其他文件进行获取
    public static MainPanel instance =  new MainPanel();
    //创建一个工具栏对象
    public JToolBar tb = new JToolBar();
    //创建对应的按键，后面采用构造方法进行初始化的时候进行设置和加入
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    //定义一个后面会放在中间的工作面板，用来放我们每个部分对应的功能显示
    public CenterPanel workingPanel;

    //构造方法私有化，这里有点偷懒，可以理解为饿汉式单例化，我就不写getinstance方法了
    private MainPanel(){
        GUIUtil.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUtil.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "config.png", "设置");
        GUIUtil.setImageIcon(bBackup, "backup.png", "备份");
        GUIUtil.setImageIcon(bRecover, "restore.png", "恢复");
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);

        //中心部分是放每部分对应的工作面板，因为如果不进行设置，最终的面板是垂直和水平居中的，不好看
        workingPanel = new CenterPanel(0.8);
        //其实是当前Mainpanel对象的的layout并在当前对象进行add
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }
    //给对应的按钮增加监听器
    private void addListener() {
        ToolBarListener listener = new ToolBarListener();

        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bCategory.addActionListener(listener);
        bReport.addActionListener(listener);
        bConfig.addActionListener(listener);
        bBackup.addActionListener(listener);
        bRecover.addActionListener(listener);
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance, 1);  //Jpanel不能单独显示要借助Jframe
    }

}
