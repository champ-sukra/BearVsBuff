package model.unit;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Bear implements Unit {
	protected int hp;
	protected int damage;
	protected Point point;
	protected boolean defending;
	
	public Bear(Point aPoint) {
		this.point = aPoint;
	}

	@Override
	public List<Point> getMoveRange() {
		List<Point> ranges = new ArrayList<Point>();
		int currentX = this.point.x; 
		int currentY = this.point.y;

		//for upper row
		for (int i = 0; i < 7; i++) {
			if (i == currentY || i == currentY + 1 || i == currentY - 1)
				ranges.add(new Point(currentX + 1, i));
		}
		//for current row
		for (int i = 0; i < 7; i++) {
			if (i == currentY + 1 || i == currentY - 1) {		
				Point point = new Point(currentX, i);
				ranges.add(point);	
			}						
		}
		//for lower row
		for (int i = 0; i < 7; i++) {
			if (i == currentY || i == currentY + 1 || i == currentY - 1)
				ranges.add(new Point(currentX - 1, i));
		}
		return ranges;
	}

	@Override
	public List<Point> getAttackRange() {
		return this.getMoveRange();
	}

	@Override
	public boolean deal(int aDamage) {
		//Half the damage if defending
		if(defending){
			aDamage /= 2;
			
			//Stop defending after taking a hit
			defending = false;
		}
		
		this.hp -= aDamage;
		if (this.hp <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public int getHp() {
		return this.hp;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public void setDamage(int damage) {
		this.damage = damage;
	}

	@Override
	public Point getCurrentPoint() {
		return this.point;
	}

	@Override
	public void setCurrentPoint(Point aPoint) {
		this.point = aPoint;
	}

	@Override
	public String getImage() {
		return null;
	}

	@Override
	public String toString() {
		return null;		
	}
	
	@Override
	public void enableDefensiveMode(boolean enable) {
		 defending = enable;
		
	}
}
