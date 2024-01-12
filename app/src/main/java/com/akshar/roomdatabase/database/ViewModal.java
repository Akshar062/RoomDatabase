package com.akshar.roomdatabase.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * ViewModel for the Course database.
 * It extends AndroidViewModel and handles the data operations.
 * It communicates with the repository to interact with the data.
 */
public class ViewModal extends AndroidViewModel {

    /**
     * The repository for the Course database.
     */
    private CourseRepository repository;

    /**
     * LiveData list of all courses.
     */
    private LiveData<List<CourseModal>> allCourses;

    /**
     * Constructor for the ViewModel.
     *
     * @param application Application context.
     */
    public ViewModal(@NonNull Application application) {
        super(application);
        repository = new CourseRepository(application);
        allCourses = repository.getAllCourses();
    }

    /**
     * Insert a course into the database.
     *
     * @param courseModal The course to be inserted.
     */
    public void insert(CourseModal courseModal) {
        repository.insert(courseModal);
    }

    /**
     * Update a course in the database.
     *
     * @param courseModal The course to be updated.
     */
    public void update(CourseModal courseModal) {
        repository.update(courseModal);
    }

    /**
     * Delete a course from the database.
     *
     * @param courseModal The course to be deleted.
     */
    public void delete(CourseModal courseModal) {
        repository.delete(courseModal);
    }

    /**
     * Delete all courses from the database.
     */
    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    /**
     * Get all courses from the database.
     *
     * @return LiveData list of all courses.
     */
    public LiveData<List<CourseModal>> getAllCourses() {
        return allCourses;
    }
}