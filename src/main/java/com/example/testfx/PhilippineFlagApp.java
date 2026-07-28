package com.example.testfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Simple PhilippineFlag class creates a drawing of the Philippine flag on a
 * JavaFX Canvas.
 * The flag consists of a white triangle on the left with a sun and three stars,
 * and blue and red horizontal stripes on the right.
 */
public class PhilippineFlagApp {

    // Canvas where the flag will be drawn
    private final Canvas canvas;
    // Graphics context used for drawing shapes and colors
    private GraphicsContext graphics;

    // Official Flag Colors
    private static final Color ROYAL_BLUE = Color.web("#0038A8");
    private static final Color CRIMSON_RED = Color.web("#CE1126");
    private static final Color GOLDEN_YELLOW = Color.web("#FCD116");

    /**
     * Constructor creates a new canvas with specified dimensions.
     *
     * @param canvasWidth  The width of the canvas in pixels
     * @param canvasHeight The height of the canvas in pixels
     */
    public PhilippineFlagApp(int canvasWidth, int canvasHeight) {
        // Create the canvas where we'll draw the flag
        this.canvas = new Canvas(canvasWidth, canvasHeight);
    }

    /**
     * Creates and draws the complete Philippine flag on the canvas.
     *
     * @param width  Width of the flag
     * @param height Height of the flag
     * @param x      X-coordinate where flag starts (left edge)
     * @param y      Y-coordinate where flag starts (top edge)
     * @return The canvas with the drawn flag
     */
    public Canvas drawFlag(int width, int height, int x, int y) {
        // Get the graphics context to start drawing
        graphics = canvas.getGraphicsContext2D();

        // Draw the main components of the flag
        drawBlueStripe(x, y, width, height);
        drawRedStripe(x, y, width, height);
        drawWhiteTriangle(x, y, width, height);
        drawSun(x, y, width, height);
        drawThreeStars(x, y, width, height);

        return canvas;
    }

    /**
     * Draws the blue horizontal stripe (top half of flag).
     */
    private void drawBlueStripe(int x, int y, int width, int height) {
        graphics.setFill(ROYAL_BLUE);
        graphics.fillRect(x, y, width, height / 2.0);
    }

    /**
     * Draws the red horizontal stripe (bottom half of flag).
     */
    private void drawRedStripe(int x, int y, int width, int height) {
        graphics.setFill(CRIMSON_RED);
        graphics.fillRect(x, y + (height / 2.0), width, height / 2.0);
    }

    /**
     * Draws the white equilateral triangle on the left side of the flag.
     */
    private void drawWhiteTriangle(int x, int y, int width, int height) {
        graphics.setFill(Color.WHITE);

        // An equilateral triangle height is (sqrt(3)/2) * side_length
        double triangleWidth = height * (Math.sqrt(3) / 2.0);

        double[] xPoints = { x, x + triangleWidth, x };
        double[] yPoints = { y, y + (height / 2.0), y + height };

        graphics.fillPolygon(xPoints, yPoints, 3);
    }

    /**
     * Draws the sun symbol in the white triangle.
     * The sun consists of a circle with rays extending from it.
     */
    private void drawSun(int x, int y, int width, int height) {
        // Calculate sun size and position (centroid of the triangle)
        double triangleWidth = height * (Math.sqrt(3) / 2.0);
        double sunCenterX = x + (triangleWidth / 3.0);
        double sunCenterY = y + (height / 2.0);
        double sunRadius = height * 0.08;

        // Set ray properties
        graphics.setStroke(GOLDEN_YELLOW);
        graphics.setLineWidth(height * 0.025);

        // Draw horizontal ray (left to right)
        graphics.strokeLine(sunCenterX - (sunRadius * 2.0), sunCenterY, sunCenterX + (sunRadius * 2.0), sunCenterY);

        // Draw vertical ray (top to bottom)
        graphics.strokeLine(sunCenterX, sunCenterY - (sunRadius * 2.0), sunCenterX, sunCenterY + (sunRadius * 2.0));

        // Draw diagonal rays
        drawDiagonalRays(sunCenterX, sunCenterY, sunRadius);

        // Draw the main sun central circle
        graphics.setFill(GOLDEN_YELLOW);
        graphics.fillOval(sunCenterX - sunRadius, sunCenterY - sunRadius, sunRadius * 2, sunRadius * 2);
    }

    /**
     * Draws the diagonal rays of the sun.
     */
    private void drawDiagonalRays(double sunCenterX, double sunCenterY, double sunRadius) {
        double offset = (sunRadius * 2.0) * Math.cos(Math.toRadians(45));

        // Top-left to bottom-right diagonal ray
        graphics.strokeLine(sunCenterX - offset, sunCenterY - offset, sunCenterX + offset, sunCenterY + offset);

        // Bottom-left to top-right diagonal ray
        graphics.strokeLine(sunCenterX - offset, sunCenterY + offset, sunCenterX + offset, sunCenterY - offset);
    }

    /**
     * Draws all three stars on the flag.
     * Two stars are positioned in the corners of the triangle,
     * and one star is at the right vertex of the triangle.
     */
    private void drawThreeStars(int x, int y, int width, int height) {
        double triangleWidth = height * (Math.sqrt(3) / 2.0);
        double starSize = height * 0.035; // Outer radius of stars
        double margin = height * 0.12;

        // Draw top-left star
        drawSingleStar(starSize, x + margin, y + (margin * 0.8));

        // Draw bottom-left star
        drawSingleStar(starSize, x + margin, y + height - (margin * 0.8));

        // Draw right-corner star
        drawSingleStar(starSize, x + triangleWidth - (margin * 1.1), y + (height / 2.0));
    }

    /**
     * Draws a single 5-pointed star at the specified position.
     *
     * @param size    The size (radius) scaling factor for the star
     * @param centerX X-coordinate for star center
     * @param centerY Y-coordinate for star center
     */
    private void drawSingleStar(double size, double centerX, double centerY) {
        double[] xPoints = new double[10];
        double[] yPoints = new double[10];

        double innerRadius = size * 0.4; // Ratio for standard 5-point star

        // Calculate 10 points (5 outer vertices, 5 inner vertices)
        for (int i = 0; i < 10; i++) {
            double angle = Math.toRadians(i * 36 - 90); // -90 deg points the star upward
            double radius = (i % 2 == 0) ? size : innerRadius;

            xPoints[i] = centerX + radius * Math.cos(angle);
            yPoints[i] = centerY + radius * Math.sin(angle);
        }

        // Set color and draw filled polygon
        graphics.setFill(GOLDEN_YELLOW);
        graphics.fillPolygon(xPoints, yPoints, 10);
    }
}