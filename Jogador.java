import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogador {
        public final String name;
        private int votos = 0;
        Jogador(String name) {
           this.name = name;
    }
    public int getVotos() {
        return votos;
    }
    public void incrementaUmVoto() {
        this.votos = getVotos() + 1;
    }
}
