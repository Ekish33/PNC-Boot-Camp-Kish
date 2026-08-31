public class WoraProbe {
    public static void main(String[] args) {
        // TODO: print the OS name (hint: System.getProperty("os.name"))
        System.getProperty("os.name");
        // TODO: print "Bytecode runs on: " + that OS name
        System.out.println("ByteCode runs on: " + (System.getProperty("os.name")));
    }
}
