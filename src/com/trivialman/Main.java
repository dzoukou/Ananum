package com.trivialman;

import com.trivialman.function.Constant;
import com.trivialman.function.Unit;
import com.trivialman.function.X_cubed;
import com.trivialman.function.X_squared;
import com.trivialman.schema.Schema;

public class Main {

    public static void main(String[] args) {
	// write your code here

        try {
            new Schema(new X_squared(),4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
