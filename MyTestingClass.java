class MyTestingClass{
    private int val;
    public MyTestingClass(int val) {
        this.val = val;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(val);
    }
}