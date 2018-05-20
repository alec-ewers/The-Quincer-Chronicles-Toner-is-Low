/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is the main class and is the one that houses the world
 * @author alber
 */
public class MainFrame extends JFrame{
    
    JPanel mainPanel;
    
    World world;
    TextBox box;
    SideBar bar;
    
    public MainFrame(){
        super();
        
        mainPanel = new JPanel();
        world = new World(this);
        box = new TextBox(this);
        bar = new SideBar(this);
        
        init();
    }
    
    public void init(){
        world.setFocusable(true);
        world.addKeyListener(new Listener(this));

        box.setFocusable(false);
        bar.setFocusable(false);
        
        //TODO work needs to be done to figure out how to lay these components out properly
        
        getContentPane().add(world, BorderLayout.CENTER);
        getContentPane().add(box, BorderLayout.SOUTH);
        getContentPane().add(bar, BorderLayout.WEST);
        
//        GroupLayout g = new GroupLayout(mainPanel);
//        g.setHorizontalGroup(g.createSequentialGroup()
//            .addComponent(bar)
//            .addGroup(g.createParallelGroup()
//                .addComponent(world)
//                .addComponent(box)));
//        g.setVerticalGroup(g.createParallelGroup()
//            .addComponent(bar)
//            .addGroup(g.createSequentialGroup()
//                .addComponent(world)
//                .addComponent(box)));
//        mainPanel.setLayout(g);
//        getContentPane().add(mainPanel);
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);
        //setFocusable(true);
        //getContentPane().setBackground(new Color(204, 255, 0));
        setVisible(true);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void handleKeyPush(KeyEvent ke){
        int key = ke.getKeyCode();
        
        // Checks whether the user is currently in an NPC interaction
        if (!box.active()){
            //Movement
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_A
                    || key == KeyEvent.VK_S || key == KeyEvent.VK_D){
                world.handleMovementKey(key);
            }

            //Combat
            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT 
                    || key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
                //TODO handling combat
            }

            // Beginning an interaction
            if (!box.active() && key == KeyEvent.VK_SPACE){
                //TODO code to begin an interaction
            }
        // what to do if the user is in an npc interaction.
        }else{
            //interaction
            if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_Z
                || key == KeyEvent.VK_X){
                //TODO handle interactions
            }
        }
        
    }
    
    /**
     * If you can't figure out this method's function
     * you probably should have taken world religions
     */
    public void updateWorld(){
        world.update();
    }
    
    public World getWorld(){
        return world;
    }
}
