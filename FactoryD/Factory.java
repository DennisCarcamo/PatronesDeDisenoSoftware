class Factory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(CarFactory.buildCar(CarType.SMALL));
        System.out.println("");
        System.out.println(CarFactory.buildCar(CarType.SEDAN));
        System.out.println("");
        System.out.println(CarFactory.buildCar(CarType.LUXURY));
    }
    
}

class CarFactory {
    public static Car buildCar(CarType model) {
        Car car = null;
        switch (model) {
        case SMALL:
            car = new SmallCar();
            break;
 
        case SEDAN:
            car = new SedanCar();
            break;
 
        case LUXURY:
            car = new LuxuryCar();
            break;
 
        default:
            break;
        }
        return car;
    }
}

abstract class Car {
    public Car(CarType model) {
        this.model = model;
     
    }
    
    // Realiza el procesamiento de nivel de subclase en este método
    protected abstract void construct();
 
    private CarType model = null;
 
    public CarType getModel() {
        return model;
    }
 
    public void setModel(CarType model) {
        this.model = model;
    }
}

enum CarType {
    SMALL, SEDAN, LUXURY
}

class LuxuryCar extends Car{
    LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }

    protected void construct() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         System.out.println("I'm a Luxury Car");
    }
}

class SedanCar extends Car{
    SedanCar() {
        super(CarType.SEDAN);
        construct();
    }

    protected void construct() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("I'm a Sedan Car");
    }
}

class SmallCar extends Car{
    SmallCar() {
       super(CarType.SMALL);
       construct();
   }

   protected void construct() {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       System.out.println("I'm a Small Car");
   }
}

