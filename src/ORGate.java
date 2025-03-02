public class ORGate extends LogicGate {
    @Override
    public boolean compute(boolean input1, boolean input2) {
        return input1 || input2;
    }
}
