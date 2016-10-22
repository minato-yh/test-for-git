package lifegame;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Main extends JFrame{
	private final LifeGame lifegame;
	public Main(int rows, int cols){
		lifegame = new LifeGame(rows, cols);
		new Thread(lifegame).start();
		add(lifegame);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main frame = new Main(40, 50);//界面
		JMenuBar menu = new JMenuBar();//菜单栏
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");//两个选择
        menu.add(options);
        
        JMenuItem star = options.add("Star");
        star.addActionListener(frame.new StarActionListener());//事件监听器
        
        JMenuItem Moon = options.add("Moon");
        Moon.addActionListener(frame.new MoonActionListener());//事件监听器        
        
        JMenu help = new JMenu("Help");//帮助        
        menu.add(help);
        
        JMenuItem about = help.add("About");//关于
        about.addActionListener(frame.new AboutActionListener());//事件监听器
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("Life Game");
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	
	class StarActionListener implements ActionListener//消息响应“star”
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		lifegame.setStar();
    	}
    }
    
	
    class MoonActionListener implements ActionListener//消息响应“moon”
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		lifegame.setMoon();
    	}
    }    
    
    
    class AboutActionListener implements ActionListener//消息响应“about”
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		JFrame frame = new JFrame("About");//创建“关于”信息窗口，显示程序信息
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		JLabel textLabel = new JLabel("生命游戏        v1.0",SwingConstants.CENTER);
    		textLabel.setPreferredSize(new Dimension(300, 100));
    		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
    		frame.setLocationRelativeTo(null);
    		frame.pack();
    		frame.setVisible(true);
    	}
    	
    }
    

}
