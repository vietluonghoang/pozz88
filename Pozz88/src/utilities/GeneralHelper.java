/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Rypon
 */
public class GeneralHelper {

    public void setLog(String log) {
        System.out.println("\n-- " + log);
    }

    public void showDialog(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message);
    }
}
