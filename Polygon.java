public class Polygon {
    //* Tests RegularPolygon class */
    public static void main(String[] args)
    {
        // Settup polygons
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);

        // Print polygon data, Perimeter then Area, Polygons 1 to 3
        System.out.println(polygon1.getPerimeter());
        System.out.println(polygon1.getArea());
        System.out.println(polygon2.getPerimeter());
        System.out.println(polygon2.getArea());
        System.out.println(polygon3.getPerimeter());
        System.out.println(polygon3.getArea());
    }
}

class RegularPolygon 
{
    int n = 3; // Sides
    double side = 1; // Side length
    double x = 0; // X coordinate
    double y = 0; // y coordinate

    // Construct default polygon
    RegularPolygon() {
    }

    // Construct custom polygon
    RegularPolygon(int newN, double newSide) {
        n = newN;
        side = newSide;
    }

    // Construct custom polygon at custom location
    RegularPolygon(int newN, double newSide, double newX, double newY) {
        n = newN;
        side = newSide;
        x = newX;
        y = newY;
    }

    //** Returns number of sides */
    int getN() {
        return n;
    }

    //** Returns length of sides */
    double getSide() {
        return side;
    }

    //** Returns x coordinate */
    double getX() {
        return x;
    }

    //** Returns y coordinate */
    double getY() {
        return y;
    }

    //** Changes number of sides */
    void setN(int newN) {
        n = newN;
    }

    //** Changes length of sides */
    void setSide(double newSide) {
        side = newSide;
    }

    //** Changes x coordinate */
    void setX(double newX) {
        x = newX;
    }

    //** Changes y coordinate */
    void setY(double newY) {
        y = newY;
    }

    //** Returns the perimeter */
    double getPerimeter()
    {
        return n * side;
    }

    //** Returns the area */
    double getArea()
    {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }
}