package com.descent.roller;

public class Dice {

	int range, damage, surge;
	boolean miss;

	public Dice(int color, int roll) {
		// RED
		if (color == 0) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				damage = 4;
				break;
			case 2:
				range = 1;
				damage = 3;
				break;
			case 3:
				range = 1;
				damage = 3;
				surge = 1;
				break;
			case 4:
				range = 2;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 2;
				damage = 2;
				break;
			default:
				break;
			}
		}
		// BLUE
		if (color == 1) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				range = 1;
				damage = 2;
				break;
			case 2:
				range = 2;
				damage = 2;
				break;
			case 3:
				range = 3;
				damage = 1;
				surge = 1;
				break;
			case 4:
				range = 3;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 4;
				surge = 1;
				break;
			default:
				break;
			}
		}
		// WHITE
		if (color == 2) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				damage = 4;
				break;
			case 2:
				range = 1;
				damage = 3;
				break;
			case 3:
				range = 1;
				damage = 3;
				surge = 1;
				break;
			case 4:
				range = 2;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 2;
				damage = 2;
				break;
			default:
				break;
			}
		}
		// YELLOW
		if (color == 3) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				damage = 4;
				break;
			case 2:
				range = 1;
				damage = 3;
				break;
			case 3:
				range = 1;
				damage = 3;
				surge = 1;
				break;
			case 4:
				range = 2;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 2;
				damage = 2;
				break;
			default:
				break;
			}
		}
		// GREEN
		if (color == 4) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				damage = 4;
				break;
			case 2:
				range = 1;
				damage = 3;
				break;
			case 3:
				range = 1;
				damage = 3;
				surge = 1;
				break;
			case 4:
				range = 2;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 2;
				damage = 2;
				break;
			default:
				break;
			}
		}
		// BLACK
		if (color == 5) {
			switch (roll) {
			case 0:
				miss = true;
				break;
			case 1:
				damage = 4;
				break;
			case 2:
				range = 1;
				damage = 3;
				break;
			case 3:
				range = 1;
				damage = 3;
				surge = 1;
				break;
			case 4:
				range = 2;
				damage = 1;
				surge = 1;
				break;
			case 5:
				range = 2;
				damage = 2;
				break;
			default:
				break;
			}
		}

	}

}
