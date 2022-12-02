package com.db.jdbc;

import com.github.tomaslanger.chalk.Chalk;

import java.util.Scanner;

import static com.db.jdbc.DBOperation.castIntToEnum;

public class DbActivity {

    public static void main(String[] args) {
        System.out.println(Chalk.on("Welcome to the Database Activity !!!!!").inverse().bold().underline().bgCyan());

        Scanner clientScan = new Scanner(System.in);
        System.out.println();
        System.out.println(Chalk.on("Are you Ready to begin?, Press  \"ENTER\" to begin").inverse());
        clientScan.nextLine();

        System.out.println("Enter the DB operation trying to perform: 1. Insert, 2. Select, 3. Update, 4. Delete");
        System.out.println("#Enter the number to perform DB operation here :");

        int operation = Integer.parseInt(clientScan.nextLine());

        System.out.println("You have selected operation :: "+operation);

       DBOperation dbOperation =  castIntToEnum(operation);

        System.out.println(dbOperation.toString());

        DataBase db = DBFactory.performDBOperation(dbOperation);

        db.executeDB();

    }
}
