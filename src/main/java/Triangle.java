import java.awt.*;

public class Triangle {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    Color color;

    Triangle(Vertex v1, Vertex v2, Vertex v3, Color color){
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.color = color;
    }
    public Vertex getNormal() {
        // Create two edge vectors
        Vertex ab = new Vertex(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
        Vertex ac = new Vertex(v3.x - v1.x, v3.y - v1.y, v3.z - v1.z);

        // Cross product: ab × ac
        Vertex norm = new Vertex(
                ab.y * ac.z - ab.z * ac.y,
                ab.z * ac.x - ab.x * ac.z,
                ab.x * ac.y - ab.y * ac.x
        );

        // Normalize (make length = 1)
        double normalLength = Math.sqrt(norm.x * norm.x + norm.y * norm.y + norm.z * norm.z);
        norm.x /= normalLength;
        norm.y /= normalLength;
        norm.z /= normalLength;

        return norm;
    }

    public double getLightingIntensity() {
        Vertex norm = getNormal();
        double angleCos = Math.abs(norm.z);
        return angleCos;
    }

    public static Color getShadeSimple(Color color, double shade) {
        int red = (int) (color.getRed() * shade);
        int green = (int) (color.getGreen() * shade);
        int blue = (int) (color.getBlue() * shade);
        return new Color(red, green, blue);
    }

    public static Color getShade(Color color, double shade) {
        double redLinear = Math.pow(color.getRed(), 2.4) * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;

        int red = (int) Math.pow(redLinear, 1/2.4);
        int green = (int) Math.pow(greenLinear, 1/2.4);
        int blue = (int) Math.pow(blueLinear, 1/2.4);

        return new Color(red, green, blue);
    }
}
