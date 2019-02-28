package com.jadedpacks.jadedmenu.utils;

public enum Position {
	BOTTOM_LEFT,
	TOP_LEFT,
	TOP_RIGHT,
	BOTTOM_RIGHT,
	CENTER,
	BUTTON,
	TOP_CENTER,
	LEFT_CENTER,
	BOTTOM_CENTER,
	RIGHT_CENTER;

	public int modX(final int width, final int posX) {
		switch(this) {
			case BOTTOM_LEFT:
				return posX;
			case BOTTOM_RIGHT:
				return width + posX;
			case CENTER:
				return width / 2 + posX;
			case BUTTON:
				return width / 2+ posX;
			case TOP_LEFT:
				return posX;
			case TOP_RIGHT:
				return width + posX;
			case TOP_CENTER:
				return width / 2 + posX;
			case BOTTOM_CENTER:
				return width / 2 + posX;
			case LEFT_CENTER:
				return posX;
			case RIGHT_CENTER:
				return width + posX;
			default:
				return posX;
		}
	}

	public int modY(final int height, final int posY) {
		switch(this) {
			case BOTTOM_LEFT:
				return height + posY;
			case BOTTOM_RIGHT:
				return height + posY;
			case CENTER:
				return height / 2 + posY;
			case BUTTON:
				return height / 4 + posY;
			case TOP_LEFT:
				return posY;
			case TOP_RIGHT:
				return posY;
			case TOP_CENTER:
				return posY;
			case BOTTOM_CENTER:
				return height + posY;
			case LEFT_CENTER:
				return height / 2 + posY;
			case RIGHT_CENTER:
				return height / 2 + posY;
			default:
				return posY;
		}
	}
}