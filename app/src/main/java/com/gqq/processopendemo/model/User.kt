package com.gqq.processopendemo.model

import java.io.Serializable

/**
 * Created by gqq on 2018/4/18.
 */
class User : Serializable {
    companion object {
        // 为了保证当序列化类结构等发生常规变化（增加删除成员变量等）时，依然可以最大程度的反序列化成功
        private const val serialVersionUID = 5990939387657237756L
    }

    var userId = 0
    var userName = ""
    var isMale = false

    constructor(userId: Int, userName: String, isMale: Boolean) {
        this.userId = userId
        this.userName = userName
        this.isMale = isMale
    }

    override fun toString(): String {
        return "User(userId=$userId, userName='$userName', isMale=$isMale)"
    }

}