package com.nextasksolution.activities.tasksActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nextasksolution.R;
import com.nextasksolution.views.TaskItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nextasksolution.utils.Utils.CONFIRMED_BO_INVOLVED_CLOSED;
import static com.nextasksolution.utils.Utils.CONFIRMED_BO_INVOLVED_STAY;
import static com.nextasksolution.utils.Utils.REQUEST_RESOLVED;
import static com.nextasksolution.utils.Utils.SUSPENDED;

public class TasksActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.all_tasks_tv)
    TextView allTasksTV;
    @BindView(R.id.tasks_layout)
    View tasksLayout;
    @BindView(R.id.tasks_count)
    TextView tasksCountTV;

    @BindView(R.id.recycler_view)
    RecyclerView tasksRecyclerView;

    @BindString(R.string.placeholder_date)
    String DATE;
    @BindString(R.string.placeholder_id)
    String ID;
    @BindString(R.string.placeholder_title)
    String TITLE;
    @BindString(R.string.cm)
    String CM;
    @BindString(R.string.pmr)
    String PMR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }


    @OnClick(R.id.all_tasks_tv)
    void onClickAttTasksTV() {
        setTasksRecyclerView();
        allTasksTV.setSelected(true);
        tasksLayout.setSelected(true);
        tasksLayout.setSelected(true);
    }

    public void setTasksRecyclerView() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        TasksAdapter tasksAdapter = new TasksAdapter();
        tasksAdapter.setTask(getTaskList());
        tasksRecyclerView.setLayoutManager(layoutManager);
        tasksRecyclerView.setAdapter(tasksAdapter);
        tasksRecyclerView.setHasFixedSize(true);
    }

    // TODO: 6/6/2021 to get Tasks from backend
    private List<TaskItem> getTaskList() {
        List<TaskItem> taskItemList = new ArrayList<>();
        taskItemList.add(new TaskItem(TITLE, ID, DATE, SUSPENDED, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_CLOSED, PMR));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_STAY, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, REQUEST_RESOLVED, PMR));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, SUSPENDED, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_CLOSED, PMR));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_STAY, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, REQUEST_RESOLVED, PMR));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, SUSPENDED, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_CLOSED, PMR));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, CONFIRMED_BO_INVOLVED_STAY, CM));
        taskItemList.add(new TaskItem(TITLE, ID, DATE, REQUEST_RESOLVED, PMR));
        return taskItemList;
    }
}