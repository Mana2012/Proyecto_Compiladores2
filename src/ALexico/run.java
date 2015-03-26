/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ALexico;

import java.io.File;

/**
 *
 * @author Agile HN
 */
public class run {
    public static void main(String[] args) {
        JFlex.Main.generate(new File("src\\ALexico\\ALexico_GUI.flex"));
    }
}
