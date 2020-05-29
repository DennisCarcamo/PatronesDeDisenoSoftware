
import java.util.ArrayList;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HeadHunter hehu = new HeadHunter();
        hehu.regisObserver(new JobSeeker("Dennis"));
        hehu.regisObserver(new JobSeeker("Ilich"));
        hehu.regisObserver(new JobSeeker("Andres"));
        
        //Every time we add a Job everybody will be notify.

        hehu.addJob("Developer");
        hehu.addJob("IT Specialist");
        hehu.addJob("QA");
    }
    
}



class HeadHunter implements Subject{

    private ArrayList<String> jobs;
    private ArrayList<Observer> userList;
    // Es más sencillo definir usuarios. 
    
    public HeadHunter(){
        jobs = new ArrayList<String>();
	userList = new ArrayList<Observer>();
    }
 
    public void regisObserver(Observer o) {
	userList.add(o);
    }
 
    public void remObserver(Observer o) {}
 
    @Override
    public void notifyAllObservers() {
	for(Observer o: userList){
	o.update(this);
	}
    }
 
    public void addJob(String job) {
	this.jobs.add(job);
	notifyAllObservers();
    }
 
    public ArrayList<String> getJobs() {
	return jobs;
    }
 
    public String toString(){
        return jobs.toString();
    }

   
    @Override
    public void registerObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(Observer o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

class JobSeeker implements Observer{

    private String name;
    
    public JobSeeker(String name){
		this.name = name;
	}
    
    @Override
    public void update(Subject s) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(this.name + " notificado.");
		//print jobs availables
		System.out.println(s);
                System.out.println("");
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(JobSeeker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

interface Observer {
    public void update(Subject s);
}

interface Subject {
    //Lista de opciones que llevará a cabo el objeto. 
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyAllObservers();
}
