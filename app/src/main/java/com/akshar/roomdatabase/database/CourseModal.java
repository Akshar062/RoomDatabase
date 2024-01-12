package com.akshar.roomdatabase.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a course with a unique ID, name, duration, and description.
 * This class is an entity in the Room database with a table name "course_table".
 */
@Entity(tableName = "course_table")
public class CourseModal {

    /**
     * Unique ID for the course.
     * It is the primary key in the database and is auto-generated.
     */
    @PrimaryKey(autoGenerate = true)
    private int id;

    /**
     * Name of the course.
     */
    private String courseName;

    /**
     * Duration of the course.
     */
    private String courseDuration;

    /**
     * Description of the course.
     */
    private String courseDescription;

    /**
     * Constructor for the CourseModal class.
     *
     * @param courseName        Name of the course.
     * @param courseDuration    Duration of the course.
     * @param courseDescription Description of the course.
     */
    public CourseModal(String courseName, String courseDuration, String courseDescription) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
    }

    /**
     * Returns the ID of the course.
     *
     * @return The current course ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the course.
     *
     * @param id The ID to be set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the course.
     *
     * @return The current course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName The name to be set.
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Returns the duration of the course.
     *
     * @return The current course duration.
     */
    public String getCourseDuration() {
        return courseDuration;
    }

    /**
     * Sets the duration of the course.
     *
     * @param courseDuration The duration to be set.
     */
    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    /**
     * Returns the description of the course.
     *
     * @return The current course description.
     */
    public String getCourseDescription() {
        return courseDescription;
    }

    /**
     * Sets the description of the course.
     *
     * @param courseDescription The description to be set.
     */
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
}