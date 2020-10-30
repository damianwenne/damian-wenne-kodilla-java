package com.kodilla.patterns.factory.tasks;

public final class ShoppingTask implements Task {
    final String taskName;
    final String whatToBuy;
    final double quantity;

    public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }


    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public String executeTask() {
        return "Buy: " + whatToBuy + " qty: " + quantity;
    }

    @Override
    public boolean isTaskExecuted() {
        if (whatToBuy != null && quantity > 0) {
            return true;
        } else {
            return false;
        }
    }
}
