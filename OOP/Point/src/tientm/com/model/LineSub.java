package tientm.com.model;

/**
 * LineSub class using inheritence.
 * @author tientm
 *
 */
public class LineSub extends MyPoint {
	// The begin point is inherited form MyPoint superclass
	private MyPoint end;

	public LineSub(MyPoint begin, MyPoint end) {
		super(begin.getX(), begin.getY());
		this.end = end;
	}

	public LineSub(int beginX, int beginY, int endX, int endY) {
		super(beginX, beginY);
		end = new MyPoint(endX, endY);
	}

	public MyPoint getBegin() {
		return new MyPoint(super.getX(), super.getY());
	}

	public void setBegin(MyPoint begin) {
		super.setXY(begin.getX(), begin.getY());
	}

	public MyPoint getEnd() {
		return end;
	}

	public void setEnd(MyPoint end) {
		this.end = end;
	}

	public int getBeginX() {
		return super.getX();
	}

	public int getBeginY() {
		return super.getY();
	}

	public int getEndX() {
		return end.getX();
	}

	public int getEndY() {
		return end.getY();
	}

	public void setBeginX(int beginX) {
		super.setX(beginX);
	}

	public void setBeginY(int beginY) {
		super.setY(beginY);
	}

	public void setEndX(int endX) {
		end.setX(endX);
	}

	public void setEndY(int endY) {
		end.setY(endY);
	}

	public void setBeginXY(int beginX, int beginY) {
		super.setX(beginX);
		super.setY(beginY);
	}

	public void setEndXY(int endX, int endY) {
		end.setX(endX);
		end.setY(endY);
	}

	public double getLength() {
		return super.distance(end);
	}

	public String toString() {
		return "Line [begin=" + new MyPoint(super.getX(), super.getY())
				+ ", end=" + end + "]";
	}

}
