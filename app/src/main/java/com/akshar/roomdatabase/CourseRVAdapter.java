package com.akshar.roomdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.akshar.roomdatabase.database.CourseModal;

/**
 * Adapter for the RecyclerView that displays the courses.
 * It extends ListAdapter and provides the functionality for item display and interaction.
 */
public class CourseRVAdapter extends ListAdapter<CourseModal, CourseRVAdapter.ViewHolder> {

    /**
     * Listener for item click events.
     */
    private OnItemClickListener listener;

    /**
     * Constructor for the CourseRVAdapter.
     */
    CourseRVAdapter() {
        super(DIFF_CALLBACK);
    }

    /**
     * Callback for calculating the diff between two non-null items in a list.
     */
    private static final DiffUtil.ItemCallback<CourseModal> DIFF_CALLBACK = new DiffUtil.ItemCallback<CourseModal>() {
        @Override
        public boolean areItemsTheSame(CourseModal oldItem, CourseModal newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(CourseModal oldItem, CourseModal newItem) {
            return oldItem.getCourseName().equals(newItem.getCourseName()) &&
                    oldItem.getCourseDescription().equals(newItem.getCourseDescription()) &&
                    oldItem.getCourseDuration().equals(newItem.getCourseDuration());
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_rv_item, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CourseModal model = getCourseAt(position);
        holder.courseNameTV.setText(model.getCourseName());
        holder.courseDescTV.setText(model.getCourseDescription());
        holder.courseDurationTV.setText(model.getCourseDuration());
    }

    /**
     * Get the CourseModal at a specific position.
     *
     * @param position The position of the item in the list.
     * @return The CourseModal at the specified position.
     */
    public CourseModal getCourseAt(int position) {
        return getItem(position);
    }

    /**
     * ViewHolder for the RecyclerView items.
     * It holds the views that will be populated with the Course data.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseNameTV, courseDescTV, courseDurationTV;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseDescTV = itemView.findViewById(R.id.idTVCourseDescription);
            courseDurationTV = itemView.findViewById(R.id.idTVCourseDuration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(getItem(position));
                    }
                }
            });
        }
    }

    /**
     * Interface for handling item click events.
     */
    public interface OnItemClickListener {
        void onItemClick(CourseModal model);
    }

    /**
     * Set the OnItemClickListener, which will be triggered when an item is clicked.
     *
     * @param listener The listener that will be triggered when an item is clicked.
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}