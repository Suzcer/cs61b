public class Planet {
    private static final double G=6.67*Math.pow(10,-11);
    public double xxPos;
    public double yyPos;
    public double yyVel;
    public double xxVel;
    public double mass;

    public String imgFileName;

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
        return this.calcForceExertedBy(p)*((p.xxPos-this.xxPos))/this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        return this.calcForceExertedBy(p)*((p.yyPos-this.yyPos))/this.calcDistance(p);
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

    public void update(double dt,double fX,double fY){
        double ax=fX/this.mass;
        double ay=fY/this.mass;
        this.xxVel+=ax*dt;
        this.yyVel+=ay*dt;
        this.xxPos+=xxVel*dt;
        this.yyPos+=yyVel*dt;
    }

//    public double readRadius(String path) {
//        In in = new In(path);
//
//        /* Each line has the rank of a country, then its
//         * name, then its production in metric tons, and
//         * finally the fraction of world salt output it produces. */
//        int count = in.readInt();
//
//        return in.readDouble();
//    }

    public void draw(){
//        System.out.println("images/"+this.imgFileName);
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }


}
