public class Electricity extends Service{
    public double mCable, mCableDiameter, cableCost;

    public Electricity() {
    }

    public Electricity(String user,int priority, double duration, double mCable, double mCableDiameter, double cableCost) {
        super(user, priority, duration);
        this.mCable = mCable;
        this.mCableDiameter = mCableDiameter;
        this.cableCost = cableCost;
    }

    public double getMCable() {
        return this.mCable;
    }

    public void setMCable(double mCable) {
        this.mCable = mCable;
    }

    public double getMCableDiameter() {
        return this.mCableDiameter;
    }

    public void setMCableDiameter(double mCableDiameter) {
        this.mCableDiameter = mCableDiameter;
    }

    public double getCableCost() {
        return this.cableCost;
    }

    public void setCableCost(double cableCost) {
        this.cableCost = cableCost;
    }

    @Override
    public String toString() {
        return "Electricity: \n\t"+super.toString()+", Metri di cavo: " + mCable +", Diametro del cavo: " + mCableDiameter+", Costo del cavo al metro: "+cableCost+";";
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Electricity) {
            Electricity e = (Electricity) o;
            return super.equals(e) && mCable == e.getMCable() && mCableDiameter == e.getMCableDiameter() && cableCost == e.getCableCost();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Electricity) {
            Electricity e = (Electricity) o;
            return  (int) (super.compareTo(e) + (mCable - e.getMCable()) + (mCableDiameter - e.getMCableDiameter()) + (cableCost - e.getCableCost()));
        } else {
            return -1;
        }
    }

}
