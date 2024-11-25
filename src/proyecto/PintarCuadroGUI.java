package proyecto;

import java.util.*;
import javax.swing.*;
import java.awt.*;
public class PintarCuadroGUI extends JFrame {
    public static void main(String[] args) {
        
    }
    //variabeles
    private Cuadro cuadro;
    private JPanel paintPanel;
    private JSpinner ClosterJSpinner;
    private JComboBox<String> colorComboBox;
    private JButton paintButton;
    private final Map<String, Color> COLORS = new LinkedHashMap<>() {{
        put("Blanco", Color.WHITE);
        put("Rojo", Color.RED);
        put("Verde", Color.GREEN);
        put("Azul", Color.BLUE);
        put("Amarillo", Color.YELLOW);
        put("Naranja", Color.ORANGE);
        put("Magenta", Color.MAGENTA);
        put("Cyan", Color.CYAN);
        put("Rosado", Color.PINK);
        put("Morado", new Color(128, 0, 128));
    }};
    public PintarCuadroGUI(){
        super("Pintar Cuadro de locos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);
        this.cuadro= new Cuadro("Matriz.txt");
        this.paintPanel=new JPanel(){
            /*@Override
            protected void paintComponetn(Graphics g){
                super.paintComponent(g);
                drawCuadro(g);
            };*/

        };
        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10,50,10,50));
        JPanel formPanel =new JPanel();
        formPanel.setBorder(BorderFactory.createTitledBorder("Control Panel"));
        formPanel.setLayout(new GridBagLayout());
        JLabel closterLab= new JLabel("Closter");
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(closterLab,gbc);
        gbc.gridx = 1;
        ClosterJSpinner = new JSpinner(new SpinnerNumberModel(0,0,cuadro.buscarClusters().size(),1));
        
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel colorLabel = new JLabel("Color:");
        colorLabel.setPreferredSize(new Dimension(80, 25));
        formPanel.add(colorLabel, gbc);
        
        gbc.gridx = 1;
        colorComboBox = new JComboBox<String>(COLORS.keySet().toArray(new String[0]));
        colorComboBox.setPreferredSize(new Dimension(100, 25));
        colorComboBox.setSelectedIndex(5);
        formPanel.add(colorComboBox, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        paintButton = new JButton("Paint");
        paintButton.setPreferredSize(new Dimension(100, 30));
        paintButton.addActionListener(e -> paintCuadro());
        formPanel.add(paintButton, gbc);

        controlPanel.add(formPanel);
        add(paintPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

    }
    private void paintCuadro(){
        int closter=(int) ClosterJSpinner.getValue();
        int color= colorComboBox.getSelectedIndex();
        cuadro.pintarCuadro(closter, color);
    }
    
}