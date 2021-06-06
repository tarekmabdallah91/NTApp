package com.nextasksolution.activities.tasksActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.nextasksolution.R;
import com.nextasksolution.views.TaskItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nextasksolution.utils.Utils.CONFIRMED_BO_INVOLVED_CLOSED;
import static com.nextasksolution.utils.Utils.CONFIRMED_BO_INVOLVED_STAY;
import static com.nextasksolution.utils.Utils.REQUEST_RESOLVED;
import static com.nextasksolution.utils.Utils.SUSPENDED;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    List<TaskItem> taskItemList;

    void setTask(List<TaskItem> taskItemList) {
        this.taskItemList = taskItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        Context context = viewGroup.getContext();
        View root = LayoutInflater.from(context).inflate(R.layout.task_item, viewGroup, false);
        return new TaskViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        TaskItem taskItem = taskItemList.get(position);
        holder.type.setText(taskItem.getType());
        holder.title.setText(taskItem.getTitle());
        holder.id.setText(taskItem.getId());
        holder.date.setText(taskItem.getDate());
        holder.status.setText(taskItem.getStatus());
        setStatusBackground(taskItem.getStatus(), holder.status);
    }

    private void setStatusBackground(String status, TextView statusTV) {
        switch (status) {
            case SUSPENDED:
                statusTV.setBackground(ContextCompat.getDrawable(statusTV.getContext(), R.drawable.status_bg_red));
                break;
            case CONFIRMED_BO_INVOLVED_CLOSED:
                statusTV.setBackground(ContextCompat.getDrawable(statusTV.getContext(), R.drawable.status_bg_gray));
                break;
            case CONFIRMED_BO_INVOLVED_STAY:
                statusTV.setBackground(ContextCompat.getDrawable(statusTV.getContext(), R.drawable.status_bg_yellow));
                break;
            case REQUEST_RESOLVED:
            default:
                statusTV.setBackground(ContextCompat.getDrawable(statusTV.getContext(), R.drawable.status_bg_green));
        }
    }


    @Override
    public int getItemCount() {
        return taskItemList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.type)
        TextView type;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.id)
        TextView id;
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.status)
        TextView status;

        TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
