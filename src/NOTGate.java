public class NOTGate extends LogicGate {
    @Override
    public boolean compute(boolean input1, boolean input2) {
        return !input1; // Ignores input2 for NOT gate
    }
}
