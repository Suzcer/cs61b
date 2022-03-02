public class Planet {
    static final double G=6.67*Math.pow(10,-11);
    double xxPos;
    double yyPos;
    double yyVel;
    double xxVel;
    double mass;

    String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {

        this.xxPos = xP;
        this.yyPos = yP;
        this.yyVel = yV;
        this.xxVel = xV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt(Math.pow(this.xxPos-p.xxPos,2)+Math.pow(this.yyPos-p.yyPos,2));
    }

    public double calcForceExertedBy(Planet p){
        return G*p.mass*this.mass/Math.pow(this.calcDistance(p),2);
    }

    public double calcForceExertedByX(Planet p){
        return this.calcForceExertedBy(p)*(Math.abs(p.xxPos-this.xxPos))/this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return this.calcForceExertedBy(p)*(Math.abs(p.yyPos-this.yyPos))/this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allp){
        double sum=0;
        for(Planet p :allp){
            if(p.equals(this))
                continue;
            sum+=calcForceExertedByX(p);
        }
        return sum;
    }
    public double calcNetForceExertedByY(Planet[] allp){
        double sum=0;
        for(Planet p :allp){
            if(p.equals(this))
                continue;
            sum+=calcForceExertedByY(p);
        }
        return sum;
    }

}
