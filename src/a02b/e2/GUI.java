package a02b.e2;

import javax.swing.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final List<JButton> cells = new ArrayList<>();
    private int counter = 0;
    private final Controller controller;
    
    public GUI(int size, Controller controller) {
        this.controller = controller;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(50*size, 50*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(panel);
        
        ActionListener al = e -> {
        	this.cells.get(counter).setText(String.valueOf(counter++));
            this.controller.buttonClicked();
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
            	var pos = new Pair<>(j,i);
                final JButton jb = new JButton(" ");
                this.cells.add(jb);
                jb.addActionListener(al);
                panel.add(jb);
            }
        }
        Random random = new Random();
        int startingCell = random.nextInt(size);
        cells.get((size-1) * size + startingCell).setText("*");
        
        this.setVisible(true);
    }

    public updateState() {
        var position = controller.getAsteriskPosition();
        this.cells.get()
    }
    
}
