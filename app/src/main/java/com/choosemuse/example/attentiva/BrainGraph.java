package com.choosemuse.example.attentiva;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BrainGraph extends View {
    private Paint linePaint;
    private float[] dataPoints;
    private float offset = 0f;  // Controls how much the graph moves

    // Parameters for simulating brain waves
    private float frequencyAlpha = 0.03f;
    private float frequencyBeta = 0.05f;
    private float frequencyTheta = 0.02f;
    private float frequencyDelta = 0.01f;

    public BrainGraph(Context context) {
        super(context);
        init();
    }

    public BrainGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setColor(Color.BLUE);  // Graph line color
        linePaint.setStrokeWidth(5);
        linePaint.setStyle(Paint.Style.STROKE);

        // Initialize the data points array to store values
        dataPoints = new float[100];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Generate brain wave-like data (sinusoidal waves of different frequencies)
        for (int i = 0; i < dataPoints.length; i++) {
            // Sum of sinusoids to mimic different brain waves
            float alphaWave = (float) Math.sin(i * frequencyAlpha + offset) * 100 + 500;
            float betaWave = (float) Math.sin(i * frequencyBeta + offset) * 50 + 500;
            float thetaWave = (float) Math.sin(i * frequencyTheta + offset) * 30 + 500;
            float deltaWave = (float) Math.sin(i * frequencyDelta + offset) * 20 + 500;

            // Combine the waves
            dataPoints[i] = alphaWave + betaWave + thetaWave + deltaWave;
        }

        // Draw the graph line
        for (int i = 1; i < dataPoints.length; i++) {
            canvas.drawLine(i - 1 + offset, dataPoints[i - 1], i + offset, dataPoints[i], linePaint);
        }

        // Increment the offset to move the graph to the left (mimicking real-time data)
        offset -= 2;  // Adjust the speed of the movement

        // Redraw the view
        invalidate();  // This will call onDraw() again to animate the graph
    }
}

