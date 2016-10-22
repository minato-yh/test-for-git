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
		Main frame = new Main(40, 50);//����
		JMenuBar menu = new JMenuBar();//�˵���
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");//����ѡ��
        menu.add(options);
        
        JMenuItem star = options.add("Star");
        star.addActionListener(frame.new StarActionListener());//�¼�������
        
        JMenuItem Moon = options.add("Moon");
        Moon.addActionListener(frame.new MoonActionListener());//�¼�������        
        
        JMenu help = new JMenu("Help");//����        
        menu.add(help);
        
        JMenuItem about = help.add("About");//����
        about.addActionListener(frame.new AboutActionListener());//�¼�������
        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("Life Game");
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	
	class StarActionListener implements ActionListener//��Ϣ��Ӧ��star��
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		lifegame.setStar();
    	}
    }
    
	
    class MoonActionListener implements ActionListener//��Ϣ��Ӧ��moon��
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		lifegame.setMoon();
    	}
    }    
    
    
    class AboutActionListener implements ActionListener//��Ϣ��Ӧ��about��
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		JFrame frame = new JFrame("About");//���������ڡ���Ϣ���ڣ���ʾ������Ϣ
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		JLabel textLabel = new JLabel("������Ϸ        v1.0",SwingConstants.CENTER);
    		textLabel.setPreferredSize(new Dimension(300, 100));
    		frame.getContentPane().add(textLabel, BorderLayout.CENTER);
    		frame.setLocationRelativeTo(null);
    		frame.pack();
    		frame.setVisible(true);
    	}
    	
    }
    

}
