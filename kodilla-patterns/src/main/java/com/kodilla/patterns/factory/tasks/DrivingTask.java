package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {
    final String taskName;
    final String where;
    final String using;

    public DrivingTask(final String taskName, final String where, final String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String executeTask() {
        return "Driving to " + where + " by " + using + ".";
    }

    @Override
    public boolean isTaskExecuted() {
        if (where != null && using != null) {
            return true;
        } else {
            return false;
        }
    }
}
