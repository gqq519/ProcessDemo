package com.gqq.processopendemo.model;

import java.io.Serializable;

/**
 * Created by gqq on 2018/4/18.
 */

public class UserModel implements Serializable{

    private static final long serialVersionUID = 5990939387657237756L;

    int userId;
    String userName;
    boolean isMale;

    public UserModel(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }
}
