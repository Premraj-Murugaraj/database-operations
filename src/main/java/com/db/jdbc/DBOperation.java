package com.db.jdbc;

import java.util.HashMap;
import java.util.Map;

public enum DBOperation {

    INSERT(1),
    SELECT(2),
    UPDATE(3),
    DELETE(4);

    private int operationIndex;

    DBOperation (int index) {
        this.operationIndex = index;
    }

    public int getOperationIndex() {
        return operationIndex;
    }

    private static final Map<Integer, DBOperation> dbOperationIndex = new HashMap<>();

    static {
        for (DBOperation pizzaStatus : DBOperation.values()) {
            dbOperationIndex.put(
                    pizzaStatus.getOperationIndex(),
                    pizzaStatus
            );
        }
    }

    public static DBOperation castIntToEnum(int operationIndex) {
        return dbOperationIndex.get(operationIndex);
    }
}
