package com.db.jdbc;

import com.db.jdbc.operation.Delete;
import com.db.jdbc.operation.Insert;
import com.db.jdbc.operation.Select;
import com.db.jdbc.operation.Update;

public class DBFactory {
    public static DataBase performDBOperation(DBOperation dbOperation) {
        switch(dbOperation) {
            case INSERT : {
                return new Insert();
            }

            case SELECT : {
                return new Select();
            }

            case UPDATE:{
                return new Update();
            }
            case DELETE:{
                return new Delete();
            }

            default : {
                throw new RuntimeException("Operation not supported !!!");
            }
        }
    }
}
