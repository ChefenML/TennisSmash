package Member;

public enum MemberType {
    JUNIOR(800),
    SENIOR(1500),
    VETERAN(1125),
    PASSIVE(250);

    private final double fee;

    MemberType(double x){
        this.fee = x;
    }

    public double getFee(){
        return fee;
    }
}
