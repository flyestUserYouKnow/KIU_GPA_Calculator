public class Subject {
    //private String name;
    private int creds;
    private double GP;
    private double kula;
    private double gamravlebuli;

    public Subject( double kula,int creds) {
        //this.name = name;
        this.creds = creds;
        this.kula = kula;
        this.GP = GPcalc(kula);
        this.gamravlebuli = multiplication(this.creds, this.GP);
    }

    public int getCreds(){
        return creds;
    }

    public double getKula() {
        return kula;
    }

    public double getGamravlebuli() {
        return gamravlebuli;
    }

    private double multiplication(int creds, double GP){
        return GP * creds;
    }

    private double GPcalc(double kula){
        double gp = 0;
        if(kula >= 94 && kula <= 100){
            gp = 4.0;
        }else if(kula >= 91 && kula <= 93){
            gp = 3.7;
        } else if(kula >= 88 && kula <= 90) {
            gp = 3.4;
        }else if(kula >= 85 && kula <= 87){
            gp = 3.1;
        }else if(kula >= 81 && kula <= 84){
            gp = 2.8;
        }else if(kula >= 78 && kula <= 80){
            gp = 2.5;
        }else if(kula >= 74 && kula <= 77){
            gp = 2.2;
        }else if(kula >= 71 && kula <= 73){
            gp = 1.9;
        }else if(kula >= 68 && kula <= 70){
            gp = 1.6;
        }else if(kula >= 64 && kula <= 67){
            gp = 1.3;
        }else if(kula >= 61 && kula <= 63){
            gp = 1.0;
        }else if(kula >= 56 && kula <= 60){
            gp = 0.8;
        }else if(kula >= 51 && kula <= 55){
            gp = 0.5;
        }else if(kula < 51){
            gp = 0.0;
        }

        return gp;
    }



}
