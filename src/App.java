import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String user, worker;
        int scelta, priority, inizio, fine, id;
        double workerCost, duration, cmSand, cmCement, cmCost, mCable, mCableDiameter, cableCost;
        Scanner sc = new Scanner(System.in);
        Tuttofare t = new Tuttofare();
        t.addConstructionService ("Marco", 3, 12.5, 44.25, 25.2, 5.5);
        t.addConstructionService ("Andrea", 7, 35, 133.0, 105.1, 9.2);
        t.addElectricityService ("Giovanni", 10, 2.5, 4.25, 1.5, 15.0);
        t.addElectricityService ("Romeo", 4, 22.5, 34.75, 2.5, 18.5);
        t.serveService(0, "Arturo", 10.5);
        t.serveService(2, "Aldo", 15.75);
        do {
            System.out.println("Cosa vuoi fare?" +
                    "\n\t1)Mostra la lista dei servizi da assegnare" +
                    "\n\t2)Mostra la lista dei servizi assegnati" +
                    "\n\t3)Aggiungi un servizio edile chiedendo i valori all’utente a terminale" +
                    "\n\t4)Aggiungi un servizio elettrico chiedendo i valori all’utente a terminale" +
                    "\n\t5)Stampa lista dei servizi con priorità inclusa in due valori" +
                    "\n\t6)Stampa costo che chiede un identificativo e stampa il costo relativo" +
                    "\n\t7)Assegna un servizio ad un operaio, che chiede l’identificativo univoco di un servizio e il nome dell’operaio"+
                    "\n\t8)Esci dal programma");
            scelta = sc.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println(t.printAvailable());
                    break;
                case 2:
                    System.out.println(t.printServered());
                    break;
                case 3:
                    System.out.println("inserire i valori:\nUser:");
                    sc.nextLine();
                    user = sc.nextLine();
                    System.out.println("Priority:");
                    priority = sc.nextInt();
                    System.out.println("Duration:");
                    duration = sc.nextDouble();
                    System.out.println("Sabbia per il cemento:");
                    cmSand = sc.nextDouble();
                    System.out.println("Cemento per il cemento:");
                    cmCement = sc.nextDouble();
                    System.out.println("Costo del cemento:");
                    cmCost = sc.nextDouble();
                    t.addConstructionService(user, priority, duration, cmSand, cmCement, cmCost);
                    break;
                case 4:
                    System.out.println("inserire i valori:\nUser:");
                    sc.nextLine();
                    user = sc.nextLine();
                    System.out.println("Priority:");
                    priority = sc.nextInt();
                    System.out.println("Duration:");
                    duration = sc.nextDouble();
                    System.out.println("Metri di cavo:");
                    mCable = sc.nextDouble();
                    System.out.println("Diametro del cavo:");
                    mCableDiameter = sc.nextDouble();
                    System.out.println("Costo del cavo al metro:");
                    cableCost = sc.nextDouble();
                    t.addElectricityService(user, priority, duration, mCable, mCableDiameter, cableCost);
                    break;
                case 5:
                    System.out.println("inserire il range di priorità: \npriorità minore");
                    inizio = sc.nextInt();
                    System.out.println("priorità maggiore");
                    fine = sc.nextInt();
                    ArrayList<Service> ris = t.getAllWithin(inizio, fine);
                    String s = "";
                    for (Service service : ris) {
                        s += "\n\t" + service.toString();
                    }
                    System.out.println(s);
                    break;
                case 6:
                    System.out.println("inserire l'identificativo");
                    id = sc.nextInt();
                    System.out.println("il prezzo è: " + t.getCost(id));
                    break;
                case 7:
                    System.out.println("inserire l'identificativo");
                    id = sc.nextInt();
                    System.out.println("inserire il nome dell'operatore");
                    sc.nextLine();
                    worker=sc.nextLine();
                    System.out.println("inserire il costo orario dell'operatore");
                    workerCost=sc.nextDouble();
                    if(t.serveService(id, worker, workerCost)){
                        System.out.println("Operatore inserito con successo");
                    }else{
                        System.out.println("Inserimento NON avvenuto con successo, riprova");
                    }
                    break;
                case 8:
                    System.out.println("Grazie e arrivederci!");
                    break;
                default:
                    System.out.println("valore errato, riprova");
            }
        } while (scelta != 8);
    }
}
