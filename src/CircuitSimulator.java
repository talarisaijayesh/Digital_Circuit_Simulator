import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircuitSimulator extends JFrame {
    private JComboBox<String> gateSelector;
    private JTextField input1Field, input2Field;
    private JLabel outputLabel;

    public CircuitSimulator() {
        setTitle("Digital Circuit Simulator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Dropdown for selecting logic gates
        String[] gates = {"AND", "OR", "NOT", "XOR", "NAND", "NOR"};
        gateSelector = new JComboBox<>(gates);

        input1Field = new JTextField(5);
        input2Field = new JTextField(5);
        JButton simulateButton = new JButton("Simulate");
        outputLabel = new JLabel("Output: ");

        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simulateGate();
            }
        });

        add(new JLabel("Select Gate:"));
        add(gateSelector);
        add(new JLabel("Input 1:"));
        add(input1Field);
        add(new JLabel("Input 2:"));
        add(input2Field);
        add(simulateButton);
        add(outputLabel);

        setVisible(true);
    }

    private void simulateGate() {
        String selectedGate = (String) gateSelector.getSelectedItem();
        boolean input1 = input1Field.getText().equals("1");
        boolean input2 = input2Field.getText().equals("1");

        LogicGate gate = null;
        switch (selectedGate) {
            case "AND": gate = new ANDGate(); break;
            case "OR": gate = new ORGate(); break;
            case "NOT": gate = new NOTGate(); break;
            case "XOR": gate = new XORGate(); break;
            case "NAND": gate = new NANDGate(); break;
            case "NOR": gate = new NORGate(); break;
        }

        if (gate != null) {
            boolean output = gate.compute(input1, input2);
            outputLabel.setText("Output: " + (output ? "1" : "0"));
        }
    }
}
