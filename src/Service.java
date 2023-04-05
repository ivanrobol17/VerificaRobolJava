public class Service implements Comparable,  Cloneable {
    private static int id = -1;
    private String user,  worker;
    private int serviceId,  priority;
    private double workerCost,  duration;

    public Service() {
        serviceId=++id;
    }


    public Service(String user,  int priority,  double duration) {
        this.user = user;
        this.worker = "";
        this.priority = priority;
        this.workerCost = -1;
        this.duration = duration;
        serviceId=++id;
    }


    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getWorker() {
        return this.worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getWorkerCost() {
        return this.workerCost;
    }

    public void setWorkerCost(double workerCost) {
        this.workerCost = workerCost;
    }
    

    @Override
    public String toString() {
        return "ID: "+serviceId+", User: "+user+", Worker: "+worker+", Priority: "+priority+", Worker Cost: "+workerCost+", Duration: "+duration;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Service) {
            Service b = (Service) o;
            return user.equals(b.getUser()) && worker.equals(b.getWorker()) && priority == b.getPriority() && duration == b.getDuration();
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Service) {
            Service s = (Service) o;
            return (int) (user.compareTo(s.getUser()) + worker.compareTo(s.getWorker()) + (priority - s.getPriority()) + (duration- s.getDuration()));
        } else {
            return -1;
        }
    }
    @Override
    public Service clone() throws CloneNotSupportedException {
        return (Service) super.clone();  
    } 

}
