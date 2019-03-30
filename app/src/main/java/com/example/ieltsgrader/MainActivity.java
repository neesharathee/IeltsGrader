package com.example.ieltsgrader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_marks_entered)
    EditText etMarksEntered;
    @BindView(R.id.tv_done)
    TextView tvDone;
    @BindView(R.id.bar_chart)
    BarChart barChart;
    ArrayList<BarEntry> barEntry;
    ArrayList<String> labels;
    BarDataSet dataSet;
    BarData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        barEntry = new ArrayList<>();
        labels = new ArrayList<>();

    }

    @OnClick(R.id.tv_done)
    public void onClick() {
        etMarksEntered.setVisibility(View.GONE);
        tvDone.setVisibility(View.GONE);
        barChart.setVisibility(View.VISIBLE);

        barEntry.add(new BarEntry(1, 33));
        barEntry.add(new BarEntry(2, 36));
        barEntry.add(new BarEntry(3, 35));
        barEntry.add(new BarEntry(4, 39));
        barEntry.add(new BarEntry(5, 36));

         dataSet = new BarDataSet(barEntry, "Projects");

        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        data = new BarData(dataSet);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barChart.setData(data);

    }
}
