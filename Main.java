import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public  class Main extends JFrame {

    private static int count = 0,max = 0;
    static int eliminado = 0;
    static ArrayList<Jogador> pessoas = new ArrayList<Jogador>();
    static String[] names = new String[]{
            "Alane Dias",
            "Beatriz Reis",
            "Davi Brito",
            "Deniziane Ferreira",
            "Fernanda Bande",
            "Giovanna Lima",
            "Giovanna Pitel",
            "Isabelle Nogueira",
            "Juninho",
            "Leidy Elin",
            "Lucas Henrique",
            "Lucas Luigi",
            "Lucas Pizane",
            "Marcus Vinicius",
            "Matteus Amaral",
            "Maycon Cosmer",
            "MC Bin Laden",
            "Michel Nogueira",
            "Nizam",
            "Raquele Cardozo",
            "Rodriguinho",
            "Thalyta Alves",
            "Vanessa Lopes",
            "Vinicius Rodrigues",
            "Wanessa Camargo",
            "Yasmin Brunet"
    };
    static void cadastrar() {

        for(var name : names) pessoas.add(new Jogador(name));
    }
    static void votar(String name){
        pessoas.forEach(pessoa -> {
            if(pessoa.name.equals(name)) pessoa.incrementaUmVoto();
        });
    }
    static int result(){
        pessoas.forEach(pessoa -> {
            if(pessoa.getVotos()>max) {
                eliminado=count;
                max=pessoa.getVotos();
            }
            ++count;
        });
        return eliminado;
    }
    private JPanel panel = new JPanel();
    JFrame frame = new JFrame("****Eliminação BBB****");
    JButton votar() {
        JButton btn = new JButton("Votar");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String voto = "";
                max=0;
                count=0;
                while(!voto.equals("sair")){

                    voto= JOptionPane.showInputDialog(null,"Em quem voce vota para sair da casa, digite \"sair\" para encerrar:");
                    votar(voto);
                }
            }
        });
        return btn;
    }

    JButton apurar(){
        JButton btn = new JButton("Apurar resultado");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = result();
                JOptionPane.showMessageDialog(null,
                        "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami,\n se eu conseguir domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se\n eu conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu vou\n conseguir te eliminar com alegria. Com "+pessoas.get(i).getVotos()+" votos, é você quem sai "+pessoas.get(i).name
                );
            }
        });
        return btn;
    }
    Main(){

        panel.setLayout(new GridLayout(4,1,10,10));
        panel.setBackground(Color.WHITE);
        Font buttonFont = new Font("Times New Roman", Font.BOLD,20);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBounds(100,200, 250, 70);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setContentPane(panel);
        panel.add(votar());
        panel.add(apurar());
        setVisible(true);
    }


    public static void main(String[] args) {
        cadastrar();
        new Main();
    }
}
