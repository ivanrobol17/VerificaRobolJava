import java.util.*;

public class Tuttofare {
    ArrayList<Service> serviziAssegnati;
    ArrayList<Service> serviziErogati;

    public Tuttofare() {
        serviziAssegnati = new ArrayList<Service>();
        serviziErogati = new ArrayList<Service>();
    }

    public void addConstructionService(String user, int priority, double duration, double cmSand, double cmCement,
            double cmCost) {
        Construction c = new Construction(user, priority, duration, cmSand, cmCement, cmCost);
        serviziAssegnati.add(c);
    }

    public void addElectricityService(String user, int priority, double duration, double mCable, double mCableDiameter,
            double cableCost) {
        Electricity e = new Electricity(user, priority, duration, mCable, mCableDiameter, cableCost);
        serviziAssegnati.add(e);
    }

    public Service findNewService(int id) {
        int i = 0;
        Service ret = null;
        do {
            if (id == serviziAssegnati.get(i).getServiceId()) {
                ret = serviziAssegnati.get(i);
            }
            i++;
        } while (i < serviziAssegnati.size() && ret == null);
        return ret;
    }

    public Service findFinishedService(int id) {
        int i = 0;
        Service ret = null;
        do {
            if (id == serviziErogati.get(i).getServiceId()) {
                ret = serviziErogati.get(i);
            }
            i++;
        } while (i < serviziErogati.size() && ret == null);
        return ret;
    }

    public ArrayList<Service> getAllWithin(int inizio, int fine) {
        ArrayList<Service> ret = new ArrayList<Service>();
        for (Service service : serviziAssegnati) {
            if (service.getPriority() >= inizio && service.getPriority() <= fine) {
                ret.add(service);
            }
        }
        for (Service service : serviziErogati) {
            if (service.getPriority() >= inizio && service.getPriority() <= fine) {
                ret.add(service);
            }
        }
        return ret;
    }

    public boolean serveService(int id, String worker, double workerCost) {
        if (id < serviziAssegnati.size()) {
            Service s = findNewService(id);
            if (s != null) {
                serviziAssegnati.remove(s);
                s.setWorker(worker);
                s.setWorkerCost(workerCost);
                serviziErogati.add(s);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public double getCost(int id) {
        double ret = 0;
        if (id < serviziErogati.size()) {
            Service s = findFinishedService(id);
            if (s != null) {
                ret += s.getDuration() * s.getWorkerCost();
                if (s instanceof Construction) {
                    Construction c = (Construction) s;
                    ret += c.getCmCost();
                } else if (s instanceof Electricity) {
                    Electricity e = (Electricity) s;
                    ret += e.getCableCost();
                } else {
                    ret = -1;
                }
            } else {
                ret = -1;
            }
        } else {
            ret = -1;
        }
        return ret;
    }

    public String printAvailable() {
        ordina();
        String s = "";
        for (Service service : serviziAssegnati) {
            s += "\n\t" + service.toString();
        }
        return s;
    }

    public String printServered() {
        ordina();
        String s = "";
        for (Service service : serviziErogati) {
            s += "\n\t" + service.toString();
        }
        return s;
    }
    private void ordina(){
        Collections.sort(serviziAssegnati);
        Collections.sort(serviziErogati);
    }

}
