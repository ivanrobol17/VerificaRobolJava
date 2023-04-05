    public class Construction extends Service{
    public double cmSand, cmCement, cmCost;

    public Construction() {
    }

    public Construction(String user, int priority, double duration, double cmSand, double cmCement, double cmCost) {
        super(user, priority, duration);
        this.cmSand = cmSand;
        this.cmCement = cmCement;
        this.cmCost = cmCost;
    }

    public double getCmSand() {
        return this.cmSand;
    }

    public void setCmSand(double cmSand) {
        this.cmSand = cmSand;
    }

    public double getCmCement() {
        return this.cmCement;
    }

    public void setCmCement(double cmCement) {
        this.cmCement = cmCement;
    }

    public double getCmCost() {
        return this.cmCost;
    }

    public void setCmCost(double cmCost) {
        this.cmCost = cmCost;
    }

    @Override
    public String toString() {
        return "Construction: \n\t"+super.toString()+", Sabbia per il cemento: " + cmSand +", Cemento per il cemento: " + cmCement+", Costo del cemento: " + cmCost+"; ";
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Construction) {
            Construction c = (Construction) o;
            return super.equals(c) && cmCement == c.getCmCement() && cmSand == c.getCmSand() && cmCost ==c.getCmCost();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Construction) {
            Construction c = (Construction) o;
            return  (int) (super.compareTo(c) + (cmCement - c.getCmCement()) + (cmSand - c.getCmSand()) + (cmCost - c.getCmCost()));
        } else {
            return -1;
        }
    }


}
