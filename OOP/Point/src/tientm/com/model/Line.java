package tientm.com.model;

/**
 * They are two ways to reuse a class in your applications:
 * composition and inheritance.
 * Let us begin with composition with the statement "a line composes of two points".
 * In this exercises, we use composition
 * @author tientm
 *
 */
public class Line {
	private MyPoint begin;
	private MyPoint end;

	public Line(MyPoint begin, MyPoint end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public Line(int beginX, int beginY, int endX, int endY) {
		begin = new MyPoint(beginX, beginY);
		end = new MyPoint(endX, endY);
	}

	public MyPoint getBegin() {
		return begin;
	}

	public void setBegin(MyPoint begin) {
		this.begin = begin;
	}

	public MyPoint getEnd() {
		return end;
	}

	public void setEnd(MyPoint end) {
		this.end = end;
	}

	public int getBeginX() {
		return begin.getX();
	}

	public int getBeginY() {
		return begin.getY();
	}

	public int getEndX() {
		return end.getX();
	}

	public int getEndY() {
		return end.getY();
	}

	public void setBeginX(int beginX) {
		begin.setX(beginX);
	}

	public void setBeginY(int beginY) {
		begin.setY(beginY);
	}

	public void setEndX(int endX) {
		end.setX(endX);
	}

	public void setEndY(int endY) {
		end.setY(endY);
	}

	public void setBeginXY(int beginX, int beginY) {
		begin.setX(beginX);
		begin.setY(beginY);
	}

	public void setEndXY(int endX, int endY) {
		end.setX(endX);
		end.setY(endY);
	}

	public double getLength() {
		return begin.distance(end);
	}
	
	public String toString() {
		return "Line [begin=" + begin + ", end=" + end + "]";
	}
	
	
}
