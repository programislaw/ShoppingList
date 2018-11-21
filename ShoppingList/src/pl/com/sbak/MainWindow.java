package pl.com.sbak;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow
{

  private JFrame frame;
  private JPanel mainPanel;

  /**
   * Launch the application.
   */
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          MainWindow window = new MainWindow();
          window.frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MainWindow()
  {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize()
  {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panel = new JPanel();
    //FlowLayout flowLayout = (FlowLayout) panel.getLayout();
    frame.getContentPane().add(panel, BorderLayout.NORTH);
    
    JButton btnGeneruj = new JButton("Generuj");
    btnGeneruj.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainPanel.add(new JButton("sdadasdsad"));
        //if(listaArtykolow != null) {
        //  panel.add(new JButton("sdadasdsad"));
        //}
      }
    });
    panel.add(btnGeneruj);
    
    mainPanel = new JPanel();
    frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
    //mainPanel.add(new JButton("sdadasdsad"));
  }

}
