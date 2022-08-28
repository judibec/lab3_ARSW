/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arst.concprg.prodcons;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartProduction {
    
    private static int stock;
    public static void main(String[] args) {
        stock = 100;
        
        Queue<Integer> queue=new LinkedBlockingQueue<>(stock);
        
        
        Producer producer = new Producer(queue,stock);
        producer.start();
        
        //let the producer create products for 5 seconds (stock).
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StartProduction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        new Consumer(queue).start();
//        while(queue.size()>0){
//            if(queue.size()==stock-1){
////                System.out.println(queue.size());
//                producer.reaudar();
//            }
//        }
    }
    

}