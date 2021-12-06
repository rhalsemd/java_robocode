package KMU;
import robocode.Robot;
import robocode.*;
import java.awt.*;
public class MyRobots extends Robot {	
    public void run() {
		MyGunColor();
		MyBodyColor();
    	if(true){
			NormalMove();
		}
		while (true) {
			if(true){
				noHitWall();
       	 	}
   		 }
	}
	public double MyPositionX(){
		return getX();
	}
	public double MyPositionY(){
		return getY();
	}
	public double MaxArea(){
		double MaxArea;
		MaxArea = Math.max(getBattleFieldWidth()-18-MyPositionX(), getBattleFieldHeight()-18-MyPositionY());
		return MaxArea;
	}
	public void NormalMove(){
		double move;
		move = MaxArea();
		turnLeft(getHeading() % 90);
        ahead(move);
        turnRight(90);
	}
    public void onHitRobot(HitRobotEvent e) {
    	if (e.getBearing() > -90 && e.getBearing() < 90) {
        		back(100);
		}
        else {
			ahead(100);
        }
	}
	public double MyTankHp(){
		return getEnergy();
	}
	public void onScannedRobot(ScannedRobotEvent e) {
		if(e.getDistance() > 300&&e.getEnergy()>MyTankHp()){
			fire(2);
		}
		else if(e.getDistance() > 300&&e.getEnergy()<MyTankHp()){
			fire(3);
		}
		else {
			fire(1);
		}
    }
	public void onHitWallEvent(HitWallEvent e){
		turnLeft(90);
		ahead(100);
	}
	public void onWin(WinEvent e){
		wins();
	}
	public void onDeath(DeathEvent e){
		deaths();
	}
	public void deaths(){
		System.out.print("huk");
	}
	public void wins(){
		System.out.printf("yeah!");
	}
	public void noHitWallMove1(){
		ahead(1200-MyPositionY()-18);
        turnRight(90);
	}
	public void noHitWallMove2(){
		ahead(1200-MyPositionX()-18);
		turnRight(90);
	}
	public void noHitWallMove3(){
		ahead(MyPositionY()-18);
        turnRight(90);
	}
	public void noHitWallMove4(){
		ahead(MyPositionX()-18);
       	turnRight(90);
	}
	public void noHitWall(){
		if(getX()<=30&&getY()<=30){
        	noHitWallMove1();
       	}
		else if(getX()<=30&&getY()>=1170){
			noHitWallMove2();
       	}
       	else if(getX()>=1170&&getY()>=1170){
          	noHitWallMove3();
       	}
		else if(getX()>=1170&&getY()<=30){
      		noHitWallMove4();
       	}
       	else if(getY()<=30){
       		noHitWallMove4();
       	}
       	else if(getX()<=30){
           	noHitWallMove1();
       	}
       	else if(getY()>=1170){
           	noHitWallMove2();
       	}
		else if(getX()>=1170){
			noHitWallMove3();
       	}
        else{
			NormalMove();   
       	}
	}
	public void onHitByBullet(HitByBulletEvent e) {
		System.out.printf(e.getName());
    }
	public void MyBodyColor(){
		setBodyColor(Color.blue);
	}
	public void MyGunColor(){
		setGunColor(Color.blue);
		setBulletColor(Color.blue);
	}
}