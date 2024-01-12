package com.akshar.roomdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity for creating a new course or editing an existing one.
 * It extends AppCompatActivity and handles the user interaction for course creation or editing.
 */
public class NewCourseActivity extends AppCompatActivity {

    /**
     * EditText fields for the course name, description, and duration.
     */
    private EditText courseNameEdt, courseDescEdt, courseDurationEdt;

    /**
     * Button for saving the course.
     */
    private Button courseBtn;

    /**
     * Constants for the extras in the intent.
     */
    public static final String EXTRA_ID = "com.akshar.roomdatabase.EXTRA_ID";
    public static final String EXTRA_COURSE_NAME = "com.akshar.roomdatabase.EXTRA_COURSE_NAME";
    public static final String EXTRA_DESCRIPTION = "com.akshar.roomdatabase.EXTRA_COURSE_DESCRIPTION";
    public static final String EXTRA_DURATION = "com.akshar.roomdatabase.EXTRA_COURSE_DURATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course);

        // Initialize the EditText fields and the Button.
        courseNameEdt = findViewById(R.id.idEdtCourseName);
        courseDescEdt = findViewById(R.id.idEdtCourseDescription);
        courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        courseBtn = findViewById(R.id.idBtnSaveCourse);

        // If the intent has the EXTRA_ID, set the EditText fields with the course data.
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)) {
            courseNameEdt.setText(intent.getStringExtra(EXTRA_COURSE_NAME));
            courseDescEdt.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            courseDurationEdt.setText(intent.getStringExtra(EXTRA_DURATION));
        }

        // Set the onClickListener for the Button.
        courseBtn.setOnClickListener(v -> {
            // Get the course data from the EditText fields.
            String courseName = courseNameEdt.getText().toString();
            String courseDesc = courseDescEdt.getText().toString();
            String courseDuration = courseDurationEdt.getText().toString();

            // If any of the course data is empty, show a Toast message and return.
            if (courseName.isEmpty() || courseDesc.isEmpty() || courseDuration.isEmpty()) {
                Toast.makeText(NewCourseActivity.this, "Please enter the valid course details.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save the course.
            saveCourse(courseName, courseDesc, courseDuration);
        });
    }

    /**
     * Save the course.
     * It creates a new intent with the course data and sets the result.
     *
     * @param courseName The name of the course.
     * @param courseDescription The description of the course.
     * @param courseDuration The duration of the course.
     */
    private void saveCourse(String courseName, String courseDescription, String courseDuration) {
        // Create a new intent and put the course data.
        Intent data = new Intent();
        data.putExtra(EXTRA_COURSE_NAME, courseName);
        data.putExtra(EXTRA_DESCRIPTION, courseDescription);
        data.putExtra(EXTRA_DURATION, courseDuration);

        // If the intent has the EXTRA_ID, put the id in the intent.
        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        // Set the result and show a Toast message.
        setResult(RESULT_OK, data);
        Toast.makeText(this, "Course has been saved to Room Database. ", Toast.LENGTH_SHORT).show();
    }
}