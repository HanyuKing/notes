public class SingleObject {
    private static class SingleObjectConst {
        public static final SingleObject ISTANCE = new SingleObject();
    }
    private SingleObject(){};

    public static SingleObject getInstance() {
        return SingleObjectConst.ISTANCE;
    }
}
