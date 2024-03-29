package utility.abstractFactory;

import java.awt.Point;

import model.unit.*;
import utility.abstractFactory.BuffaloFactory.TypeBuff;

public class BearFactory extends AbstractFactory {
	public enum TypeBear
	{
		TypeBearBoss, TypeBearLeft, TypeBearRight 
	};
	
	@Override
	public Bear getBear(TypeBear aType) {
		Bear bear = null;
		if (aType == TypeBear.TypeBearBoss) {
			bear = new BearBoss(new Point(6, 3));
		}
		else if (aType == TypeBear.TypeBearLeft) {
			bear = new BearLeft(new Point(6, 2));
		}
		else if (aType == TypeBear.TypeBearRight) {
			bear = new BearRight(new Point(6, 4));
		}
		return bear;
	}
	
	@Override
	public Buff getBuffalo(TypeBuff aType) {
		return null;
	}
}
